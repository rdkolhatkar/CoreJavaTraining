package com.concepts.threading;


import java.util.concurrent.*;

public class ThreadPools {

    /*
     * ================================================================
     *                       WHAT IS A THREAD POOL?
     * ================================================================
     *
     * 1. A Thread Pool is a collection of reusable worker threads
     *    that execute multiple tasks.
     *
     * 2. Instead of creating a new Thread object for every task,
     *    we create a pool of threads and submit tasks to it.
     *
     * 3. The Thread Pool manages the creation, scheduling, reuse,
     *    and lifecycle of worker threads.
     *
     * Example:
     *
     * Suppose we have 10 tasks and a Fixed Thread Pool of 3 threads.
     *
     * Thread-1 -> Task-1 -> Task-4 -> Task-7 -> Task-10
     * Thread-2 -> Task-2 -> Task-5 -> Task-8
     * Thread-3 -> Task-3 -> Task-6 -> Task-9
     *
     * Note: The actual execution order may vary.
     *
     * Only 3 tasks can execute simultaneously in this example.
     * Remaining tasks wait in the queue.
     *
     * ================================================================
     *                    WHY ARE THREAD POOLS USED?
     * ================================================================
     *
     * 1. Creating a new thread for every task is expensive.
     *
     * 2. Creating too many threads may cause:
     *    -> High memory consumption
     *    -> Increased CPU context switching
     *    -> Performance degradation
     *    -> Resource exhaustion
     *
     * 3. Thread Pools allow us to reuse existing worker threads.
     *
     * 4. Thread Pools help control the number of concurrent threads.
     *
     * 5. They make asynchronous and concurrent task execution easier.
     *
     * ================================================================
     *                     ADVANTAGES OF THREAD POOLS
     * ================================================================
     *
     * 1. Better Performance:
     *    -> Threads are reused instead of being recreated.
     *
     * 2. Resource Management:
     *    -> Controls thread count (depending on pool configuration).
     *
     * 3. Reduced Overhead:
     *    -> Reduces frequent thread creation and destruction.
     *
     * 4. Improved Responsiveness:
     *    -> Tasks can be processed by available worker threads.
     *
     * 5. Task Queue Management:
     *    -> Pending tasks can wait until a thread becomes available.
     *
     * 6. Scalability:
     *    -> Pool configuration can be adjusted based on workload.
     *
     * 7. Simplified Thread Management:
     *    -> Developers submit tasks rather than manually managing
     *       individual Thread objects.
     *
     * ================================================================
     *                  IMPORTANT JAVA CONCEPTS
     * ================================================================
     *
     * Executor:
     * -> Interface providing execute(Runnable).
     *
     * ExecutorService:
     * -> Interface extending Executor.
     * -> Supports submit(), shutdown(), Future, etc.
     *
     * Executors:
     * -> Utility class containing factory methods for creating
     *    common executor implementations.
     *
     * Runnable:
     * -> Functional interface containing run().
     * -> Represents a task without a returned result.
     *
     * Callable<V>:
     * -> Functional interface containing call().
     * -> Represents a task that returns a result.
     * -> Can throw checked exceptions.
     *
     * Future<V>:
     * -> Represents the result of an asynchronous computation.
     * -> get() waits until the result is available.
     *
     * ================================================================
     *                       TYPES OF THREAD POOLS
     * ================================================================
     *
     * 1. FixedThreadPool:
     *    -> Uses a fixed number of worker threads.
     *    -> Additional tasks wait in an unbounded queue.
     *
     * 2. CachedThreadPool:
     *    -> Creates threads as needed.
     *    -> Reuses available idle threads.
     *    -> Can create many threads when demand is high.
     *
     * 3. SingleThreadExecutor:
     *    -> Uses one worker thread at a time.
     *    -> Executes tasks sequentially.
     *
     * 4. ScheduledThreadPool:
     *    -> Executes tasks after a delay or periodically.
     *
     * ================================================================
     */

    public static void main(String[] args) {

        System.out.println("========== THREAD POOL EXAMPLES ==========");

        fixedThreadPoolExample();

        cachedThreadPoolExample();

        singleThreadExecutorExample();

        scheduledThreadPoolExample();

        callableAndFutureExample();
    }

    /*
     * ================================================================
     * EXAMPLE 1: FIXED THREAD POOL
     * ================================================================
     *
     * Executors.newFixedThreadPool(3):
     *
     * -> Creates a Thread Pool with 3 worker threads.
     * -> At most 3 tasks execute simultaneously.
     * -> Additional tasks wait in a queue.
     * -> Existing threads are reused.
     *
     * Here:
     * Total Tasks = 6
     * Pool Size   = 3
     *
     * First 3 tasks can start concurrently.
     * Remaining tasks wait for available worker threads.
     *
     * BEST USED FOR:
     * -> A controlled number of concurrent operations.
     * -> Small, bounded workloads.
     * -> Parallel processing with limited worker threads.
     *
     * Important:
     * The default fixed pool has an unbounded task queue.
     * For large production workloads, consider a bounded
     * ThreadPoolExecutor with an appropriate rejection policy.
     */

    public static void fixedThreadPoolExample() {

        System.out.println("\n--- Fixed Thread Pool ---");

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        // Submitting 6 independent tasks.
        for (int i = 1; i <= 6; i++) {

            final int taskId = i;

            // execute() accepts Runnable and returns void.
            executor.execute(() -> {

                System.out.println(
                        "Task " + taskId +
                                " started by " +
                                Thread.currentThread().getName()
                );

                sleepTask(1000);

                System.out.println(
                        "Task " + taskId +
                                " completed by " +
                                Thread.currentThread().getName()
                );
            });
        }

        // Stops accepting new tasks.
        // Already submitted tasks are allowed to complete.
        executor.shutdown();

        // Wait for the current example to finish.
        waitForTermination(executor);
    }

    /*
     * ================================================================
     * EXAMPLE 2: CACHED THREAD POOL
     * ================================================================
     *
     * Executors.newCachedThreadPool():
     *
     * -> Creates worker threads when required.
     * -> Reuses previously created idle threads.
     * -> Idle threads normally terminate after 60 seconds.
     * -> Does not have a fixed upper limit on thread count.
     *
     * Example:
     *
     * Task-1 -> Thread-1
     * Task-2 -> Thread-2
     * Task-3 -> Thread-3
     *
     * The pool may create new threads when no idle thread exists.
     *
     * BEST USED FOR:
     * -> Many short-lived asynchronous tasks,
     *    when concurrency is already controlled.
     *
     * WARNING:
     * -> A cached pool can create a large number of threads.
     * -> Avoid using it blindly for unpredictable workloads.
     */

    public static void cachedThreadPoolExample() {

        System.out.println("\n--- Cached Thread Pool ---");

        ExecutorService executor =
                Executors.newCachedThreadPool();

        for (int i = 1; i <= 5; i++) {

            final int taskId = i;

            executor.execute(() -> {

                System.out.println(
                        "Cached Task " + taskId +
                                " executing on " +
                                Thread.currentThread().getName()
                );

                sleepTask(500);
            });
        }

        executor.shutdown();
        waitForTermination(executor);
    }

    /*
     * ================================================================
     * EXAMPLE 3: SINGLE THREAD EXECUTOR
     * ================================================================
     *
     * Executors.newSingleThreadExecutor():
     *
     * -> Creates an ExecutorService using one worker thread.
     * -> Tasks execute one at a time.
     * -> Tasks execute sequentially in submission order.
     * -> If the worker fails, a replacement may be created.
     *
     * Example:
     *
     * Thread-1 -> Task-1 -> Task-2 -> Task-3
     *
     * BEST USED FOR:
     * -> Sequential background processing.
     * -> Ordered task execution.
     * -> Avoiding concurrent execution of related tasks.
     */

    public static void singleThreadExecutorExample() {

        System.out.println("\n--- Single Thread Executor ---");

        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 3; i++) {

            final int taskId = i;

            executor.execute(() -> {

                System.out.println(
                        "Single Task " + taskId +
                                " executing on " +
                                Thread.currentThread().getName()
                );

                sleepTask(500);
            });
        }

        executor.shutdown();
        waitForTermination(executor);
    }

    /*
     * ================================================================
     * EXAMPLE 4: SCHEDULED THREAD POOL
     * ================================================================
     *
     * Executors.newScheduledThreadPool(2):
     *
     * -> Creates a pool of 2 core worker threads.
     * -> Supports delayed and periodic task execution.
     *
     * Important methods:
     *
     * 1. schedule()
     *    -> Executes a task once after a delay.
     *
     * 2. scheduleAtFixedRate()
     *    -> Executes a task periodically based on scheduled
     *       start times.
     *
     * 3. scheduleWithFixedDelay()
     *    -> Executes the next task after a fixed delay
     *       following the previous execution's completion.
     *
     * BEST USED FOR:
     * -> Periodic cleanup.
     * -> Health checks.
     * -> Background maintenance.
     * -> Scheduled monitoring operations.
     */

    public static void scheduledThreadPoolExample() {

        System.out.println("\n--- Scheduled Thread Pool ---");

        ScheduledExecutorService executor =
                Executors.newScheduledThreadPool(2);

        /*
         * schedule(Runnable, delay, TimeUnit)
         *
         * This task starts approximately 1 second
         * after being scheduled.
         */

        executor.schedule(() -> {

            System.out.println(
                    "Delayed Task executed by " +
                            Thread.currentThread().getName()
            );

        }, 1, TimeUnit.SECONDS);

        /*
         * scheduleAtFixedRate():
         *
         * Parameters:
         * 1. Task
         * 2. Initial delay = 0 seconds
         * 3. Period = 1 second
         * 4. Time unit = SECONDS
         *
         * The same periodic task never executes concurrently
         * with itself, even when multiple workers exist.
         *
         * If execution takes longer than the period,
         * later executions may start late.
         */

        ScheduledFuture<?> periodicTask =
                executor.scheduleAtFixedRate(() -> {

                    System.out.println(
                            "Periodic Task executed by " +
                                    Thread.currentThread().getName()
                    );

                }, 0, 1, TimeUnit.SECONDS);

        // Allow the scheduled pool to run briefly.
        sleepTask(3200);

        // Cancel future executions of this periodic task.
        // false = Do not interrupt an execution already running.
        periodicTask.cancel(false);

        executor.shutdown();
        waitForTermination(executor);
    }

    /*
     * ================================================================
     * EXAMPLE 5: CALLABLE AND FUTURE
     * ================================================================
     *
     * Runnable:
     * -> Contains run().
     * -> Does not return a computed value.
     *
     * Callable:
     * -> Contains call().
     * -> Returns a computed value.
     * -> Can throw checked exceptions.
     *
     * Future:
     * -> Stores a handle to the asynchronous computation.
     * -> get() returns the result once available.
     * -> get() blocks the calling thread until completion,
     *    cancellation, interruption, or failure.
     *
     * submit():
     * -> Submits a task to the ExecutorService.
     * -> Returns a Future object.
     *
     * BEST USED FOR:
     * -> Parallel calculations.
     * -> Fetching results from background tasks.
     * -> Independent operations producing return values.
     */

    public static void callableAndFutureExample() {

        System.out.println("\n--- Callable and Future ---");

        ExecutorService executor =
                Executors.newFixedThreadPool(2);

        /*
         * Callable<Integer> returns an Integer.
         *
         * The lambda expression below represents
         * the implementation of Callable.call().
         */

        Callable<Integer> task = () -> {

            System.out.println(
                    "Calculating result using " +
                            Thread.currentThread().getName()
            );

            sleepTask(1000);

            return 10 + 20;
        };

        // submit() returns Future<Integer>.
        Future<Integer> future = executor.submit(task);

        try {

            /*
             * future.get():
             *
             * -> Waits until the task completes.
             * -> Returns the Integer result.
             * -> May throw ExecutionException if the task fails.
             */

            Integer result = future.get();

            System.out.println("Callable Result: " + result);

        } catch (InterruptedException e) {

            // Restore the thread's interrupted status.
            Thread.currentThread().interrupt();

        } catch (ExecutionException e) {

            System.out.println(
                    "Task execution failed: " + e.getCause()
            );
        } finally {

            executor.shutdown();
            waitForTermination(executor);
        }
    }

    /*
     * ================================================================
     * HELPER METHOD: SIMULATE TASK PROCESSING
     * ================================================================
     *
     * Thread.sleep():
     * -> Pauses the currently executing thread.
     * -> Does not release any locks held by that thread.
     * -> Here it simulates work such as API processing
     *    or database operations.
     *
     * InterruptedException:
     * -> Occurs when a sleeping thread is interrupted.
     *
     * interrupt():
     * -> Restores the interrupted status so that higher-level
     *    code can recognize the interruption.
     */

    private static void sleepTask(long milliseconds) {

        try {

            Thread.sleep(milliseconds);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }

    /*
     * ================================================================
     * HELPER METHOD: PROPER THREAD POOL TERMINATION
     * ================================================================
     *
     * shutdown():
     * -> Rejects new tasks.
     * -> Allows previously submitted tasks to finish.
     * -> Does not wait for those tasks.
     *
     * awaitTermination():
     * -> Waits for pool termination until the timeout.
     * -> Returns true if the pool terminated.
     * -> Returns false if the timeout expired.
     *
     * shutdownNow():
     * -> Attempts to interrupt actively executing tasks.
     * -> Stops processing waiting tasks.
     * -> Does not guarantee that running tasks will stop.
     *
     * WHY IS SHUTDOWN IMPORTANT?
     *
     * -> Worker threads normally keep the JVM alive.
     * -> Forgetting to shut down an executor may prevent
     *    the application from terminating.
     */

    private static void waitForTermination(
            ExecutorService executor) {

        try {

            // Wait up to 10 seconds for the pool to terminate.
            if (!executor.awaitTermination(
                    10, TimeUnit.SECONDS)) {

                System.out.println(
                        "Timeout reached. Requesting shutdownNow()."
                );

                executor.shutdownNow();
            }

        } catch (InterruptedException e) {

            // Request cancellation when waiting is interrupted.
            executor.shutdownNow();

            // Restore the calling thread's interrupted status.
            Thread.currentThread().interrupt();
        }
    }
}

