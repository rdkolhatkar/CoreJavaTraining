import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * =====================================================================================
 *                    JAVA EXECUTOR FRAMEWORK : BASIC THEORY
 * =====================================================================================
 *
 * The Executor framework (package java.util.concurrent, added in Java 5 via JSR-166,
 * designed by Doug Lea) separates WHAT work should be done (a task: Runnable/Callable)
 * from HOW and WHEN it is run (thread creation, reuse, scheduling, shutdown).
 *
 * Core interfaces / classes:
 *   Executor                  -> void execute(Runnable)            (the minimal contract)
 *   ExecutorService           -> submit(), invokeAll(), shutdown() (lifecycle + results)
 *   ScheduledExecutorService  -> schedule(), scheduleAtFixedRate() (delayed / periodic)
 *   ThreadPoolExecutor        -> the main implementation (worker threads + task queue)
 *   ForkJoinPool              -> work-stealing pool (parallel streams, recursive tasks)
 *   Future / CompletableFuture-> handle to a result that will be available later
 *   Executors                 -> factory methods (newFixedThreadPool, etc.)
 *
 * -------------------------------------------------------------------------------------
 * 1. WHY WAS IT INTRODUCED?
 * -------------------------------------------------------------------------------------
 * Before Java 5, the usual pattern was:   new Thread(task).start();   for every task.
 * This had serious problems:
 *
 *   a) Thread creation is expensive.
 *      A Java platform thread maps 1:1 to an OS (kernel) thread. Creating one means a
 *      system call, allocating a stack (often 512KB - 1MB reserved), kernel data
 *      structures, and JVM bookkeeping. Creating/destroying one per short task wastes
 *      more time than the task itself.
 *
 *   b) No upper bound on threads.
 *      A burst of 10,000 requests -> 10,000 threads -> memory exhaustion
 *      ("OutOfMemoryError: unable to create native thread") or a system that spends
 *      all its time context switching.
 *
 *   c) No lifecycle management.
 *      No standard way to wait for all tasks, cancel them, or shut down cleanly.
 *
 *   d) No return values / exception handling.
 *      Runnable.run() returns void and cannot throw checked exceptions.
 *      Callable + Future solved this.
 *
 *   e) Tight coupling.
 *      Code that submitted work also decided the threading policy. Changing from
 *      "one thread per task" to "a pool of 8" meant rewriting code.
 *
 * -------------------------------------------------------------------------------------
 * 2. ADVANTAGES
 * -------------------------------------------------------------------------------------
 *   + Thread reuse       : a fixed set of worker threads runs many tasks, so the
 *                          creation cost is paid once.
 *   + Resource control   : max threads and queue size are bounded and configurable.
 *   + Decoupling         : submission code does not change when the policy changes.
 *   + Results & errors   : Callable/Future return values and propagate exceptions
 *                          (wrapped in ExecutionException).
 *   + Lifecycle          : shutdown(), shutdownNow(), awaitTermination(), cancel().
 *   + Scheduling         : delayed and periodic tasks without hand-written timers.
 *   + Backpressure       : bounded queue + RejectedExecutionHandler can slow
 *                          producers down instead of crashing.
 *   + Better throughput  : fewer context switches, better CPU cache locality.
 *   + Composition        : CompletableFuture allows chaining async steps.
 *
 * -------------------------------------------------------------------------------------
 * 3. LIMITATIONS
 * -------------------------------------------------------------------------------------
 *   - Sizing is manual. Wrong pool size = idle CPUs (too small) or contention
 *     (too large). A common rule of thumb:
 *         CPU-bound : threads ~= number of cores (or cores + 1)
 *         I/O-bound : threads ~= cores * (1 + waitTime / computeTime)
 *
 *   - Some Executors factory methods are dangerous defaults:
 *         newFixedThreadPool      -> UNBOUNDED LinkedBlockingQueue (memory can grow
 *                                    without limit if tasks arrive faster than processed)
 *         newCachedThreadPool     -> UNBOUNDED number of threads (Integer.MAX_VALUE)
 *     In production, prefer constructing ThreadPoolExecutor explicitly.
 *
 *   - Blocking tasks still occupy a platform thread. If all workers block on I/O,
 *     the pool stalls (thread starvation), even though the CPU is idle.
 *
 *   - Deadlock risk: a task that submits a sub-task to the SAME bounded pool and
 *     waits for it can deadlock if all workers are waiting.
 *
 *   - Lost exceptions: exceptions thrown inside execute()'d tasks go to the
 *     thread's UncaughtExceptionHandler; in submit()'d tasks they are stored in the
 *     Future and silently lost if nobody calls get().
 *
 *   - Must be shut down explicitly, or non-daemon workers keep the JVM alive.
 *
 *   - ThreadLocal values leak between tasks because threads are reused.
 *
 *   - No task priorities by default (FIFO queue) and no built-in fairness guarantees.
 *
 *   - Note (Java 21+): Virtual threads (Executors.newVirtualThreadPerTaskExecutor())
 *     address the "blocking I/O wastes a platform thread" limitation, because the JVM
 *     unmounts a virtual thread from its carrier thread while it blocks.
 *
 * -------------------------------------------------------------------------------------
 * 4. HOW IT WORKS, AND HOW IT INTERACTS WITH OS SCHEDULING
 * -------------------------------------------------------------------------------------
 * Internal structure of ThreadPoolExecutor:
 *
 *        submit(task)
 *             |
 *             v
 *   [ running threads < corePoolSize ] --yes--> create new worker, run task
 *             | no
 *             v
 *   [ queue.offer(task) succeeds ] -----yes--> task waits in BlockingQueue
 *             | no (queue full)
 *             v
 *   [ running threads < maxPoolSize ] --yes--> create extra worker, run task
 *             | no
 *             v
 *   RejectedExecutionHandler (Abort / CallerRuns / Discard / DiscardOldest)
 *
 * Each worker thread runs a loop roughly like:
 *     while (task != null || (task = queue.take()) != null) { task.run(); task = null; }
 * Extra (non-core) workers use queue.poll(keepAliveTime) and exit when idle too long.
 *
 * Relationship to the OS scheduler:
 *   * The JVM does NOT schedule platform threads itself. Each Java worker is a real
 *     kernel thread (pthread on Linux / Windows thread), and the OS scheduler
 *     (e.g. Linux CFS / EEVDF) decides which thread runs on which core, for how long,
 *     and when it is preempted.
 *   * What the Executor controls is HOW MANY threads exist and are runnable.
 *     It acts as an application-level scheduler sitting ABOVE the OS scheduler:
 *         - the Executor decides which TASK runs next (queue order),
 *         - the OS decides which THREAD gets a CPU next.
 *   * Idle workers block in queue.take(). Internally this calls LockSupport.park(),
 *     which becomes a futex wait (Linux) or similar. The kernel moves the thread to a
 *     WAITING state, so it is removed from the run queue and consumes ZERO CPU.
 *     It is woken (unpark -> futex wake) only when a task is enqueued.
 *   * Therefore, with N workers, at most N threads compete in the OS run queue for
 *     this pool, no matter how many tasks (thousands or millions) are pending.
 *     Pending tasks are just objects in a Java queue; the OS never sees them.
 *   * Context switch cost stays predictable, and if N ~= cores, each thread can stay
 *     on a core long enough to keep its CPU caches warm.
 *   * ForkJoinPool adds work-stealing: each worker has its own deque, and idle workers
 *     steal from others, which balances load without a single contended queue.
 *
 * -------------------------------------------------------------------------------------
 * 5. HOW IT PREVENTS THRASHING
 * -------------------------------------------------------------------------------------
 * "Thrashing" = the system spends more time managing resources than doing useful work.
 * Two kinds are relevant to threads:
 *
 *   a) CPU / scheduler thrashing
 *      Too many runnable threads -> the OS constantly context switches (saving and
 *      restoring registers, flushing TLB entries, cold caches). Throughput collapses.
 *      Executor fix: a fixed upper bound on worker threads keeps the run queue short.
 *
 *   b) Memory thrashing (paging)
 *      Every thread needs a stack plus kernel structures. Thousands of threads ->
 *      working set exceeds RAM -> the OS pages memory to disk -> everything slows down
 *      massively.
 *      Executor fix: bounded thread count = bounded stack memory. Excess work waits
 *      as small task objects in a queue instead of as heavy threads.
 *
 *   c) Overload protection (backpressure)
 *      A BOUNDED queue (e.g. ArrayBlockingQueue) caps memory used by pending tasks.
 *      When full, the RejectedExecutionHandler kicks in:
 *          AbortPolicy         -> throw RejectedExecutionException (fail fast)
 *          CallerRunsPolicy    -> submitting thread runs the task itself, which
 *                                 naturally SLOWS DOWN the producer (self-throttling)
 *          DiscardPolicy       -> drop the task silently
 *          DiscardOldestPolicy -> drop the oldest queued task, retry
 *
 * IMPORTANT: The Executor framework only prevents thrashing when it is configured with
 * bounds. newCachedThreadPool (unbounded threads) can still cause CPU/memory thrashing,
 * and newFixedThreadPool (unbounded queue) can still exhaust heap memory.
 * =====================================================================================
 */
public class ExecutorFrameworkTheory {

    public static void main(String[] args) throws Exception {

        int cores = Runtime.getRuntime().availableProcessors();

        // ---------------------------------------------------------------------------
        // A properly BOUNDED pool: limited threads + limited queue + backpressure.
        // This is the configuration that actually protects against thrashing.
        // ---------------------------------------------------------------------------
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                cores,                                  // corePoolSize: always-alive workers
                cores * 2,                              // maximumPoolSize: hard thread cap
                30, TimeUnit.SECONDS,                   // keepAlive for non-core workers
                new ArrayBlockingQueue<>(100),          // BOUNDED queue of pending tasks
                new NamedThreadFactory("worker"),       // readable thread names for debugging
                new ThreadPoolExecutor.CallerRunsPolicy() // backpressure: producer runs task
        );

        // ---------------------------------------------------------------------------
        // Callable + Future: returning a result from another thread.
        // ---------------------------------------------------------------------------
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            final int n = i;
            futures.add(pool.submit(() -> {
                // Simulated CPU work. Only 'cores..cores*2' of these run at the same
                // time; the rest wait in the queue, invisible to the OS scheduler.
                return n * n;
            }));
        }

        int sum = 0;
        for (Future<Integer> f : futures) {
            try {
                sum += f.get(5, TimeUnit.SECONDS); // blocks until result is ready
            } catch (ExecutionException e) {
                // Exceptions thrown inside the task surface here, wrapped.
                System.err.println("Task failed: " + e.getCause());
            }
        }
        System.out.println("Sum of squares 1..20 = " + sum);

        // ---------------------------------------------------------------------------
        // ScheduledExecutorService: delayed and periodic execution.
        // ---------------------------------------------------------------------------
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> ticker = scheduler.scheduleAtFixedRate(
                () -> System.out.println("tick on " + Thread.currentThread().getName()),
                0, 200, TimeUnit.MILLISECONDS);
        Thread.sleep(650);
        ticker.cancel(false);

        // ---------------------------------------------------------------------------
        // CompletableFuture: composing asynchronous steps on our own pool.
        // ---------------------------------------------------------------------------
        String result = CompletableFuture
                .supplyAsync(() -> "data", pool)
                .thenApply(String::toUpperCase)
                .thenApply(s -> s + " processed")
                .get();
        System.out.println(result);

        // ---------------------------------------------------------------------------
        // Lifecycle: always shut pools down, or non-daemon workers keep JVM alive.
        // ---------------------------------------------------------------------------
        shutdownGracefully(pool);
        shutdownGracefully(scheduler);
    }

    /** Standard two-phase shutdown pattern. */
    static void shutdownGracefully(ExecutorService es) {
        es.shutdown();                                  // stop accepting new tasks
        try {
            if (!es.awaitTermination(5, TimeUnit.SECONDS)) {
                es.shutdownNow();                       // interrupt running tasks
            }
        } catch (InterruptedException e) {
            es.shutdownNow();
            Thread.currentThread().interrupt();         // preserve interrupt status
        }
    }

    /** Gives threads meaningful names so thread dumps are readable. */
    static class NamedThreadFactory implements ThreadFactory {
        private final String prefix;
        private final AtomicInteger counter = new AtomicInteger(1);

        NamedThreadFactory(String prefix) { this.prefix = prefix; }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, prefix + "-" + counter.getAndIncrement());
            t.setDaemon(false);
            return t;
        }
    }
}
