package com.concepts.threading;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * =====================================================================================
 *                  FAIR LOCK vs UNFAIR LOCK IN JAVA
 * =====================================================================================
 *
 * ReentrantLock supports two types of locking policies:
 *
 *      1) Unfair Lock
 *      2) Fair Lock
 *
 *
 * =====================================================================================
 * 1) UNFAIR LOCK
 * =====================================================================================
 *
 * Syntax:
 *
 *      Lock lock = new ReentrantLock();
 *
 * OR
 *
 *      Lock lock = new ReentrantLock(false);
 *
 *
 * By default, ReentrantLock is UNFAIR.
 *
 * In an unfair lock, Java does NOT guarantee that the thread which has been
 * waiting for the longest time will acquire the lock next.
 *
 * A newly arriving thread may sometimes acquire the lock before threads
 * that were already waiting. This behavior is called "barging".
 *
 *
 * Example:
 *
 * Suppose Thread-1 currently owns the lock:
 *
 *                  LOCK
 *                   |
 *               Thread-1
 *
 * Waiting:
 *
 *              Thread-2
 *              Thread-3
 *              Thread-4
 *
 * A new Thread-5 arrives.
 *
 * When Thread-1 releases the lock, there is NO strict guarantee that
 * Thread-2 will acquire it next.
 *
 * For example, the order could potentially be:
 *
 *      Thread-1
 *          |
 *          v
 *      Thread-3
 *          |
 *          v
 *      Thread-5
 *          |
 *          v
 *      Thread-2
 *          |
 *          v
 *      Thread-4
 *
 *
 * IMPORTANT:
 *
 * Unfair does NOT mean the threads will always execute randomly.
 *
 * You may sometimes get:
 *
 *      Thread-1
 *      Thread-2
 *      Thread-3
 *      Thread-4
 *      Thread-5
 *
 * even with an unfair lock.
 *
 * It simply means that FIFO ordering is NOT GUARANTEED.
 *
 *
 * Advantages:
 *
 *      -> Usually better performance/throughput.
 *      -> Less overhead associated with maintaining fairness.
 *
 * Disadvantages:
 *
 *      -> Lock acquisition order is unpredictable.
 *      -> A thread could theoretically wait for a long time.
 *      -> Starvation is possible in highly contended situations.
 *
 *
 * =====================================================================================
 * 2) FAIR LOCK
 * =====================================================================================
 *
 * Syntax:
 *
 *      Lock lock = new ReentrantLock(true);
 *
 *
 * Passing true enables the fairness policy.
 *
 * A fair ReentrantLock generally grants the lock to the thread that has
 * been waiting for the longest time.
 *
 * Therefore, it approximately behaves like FIFO:
 *
 *      First In -> First Out
 *
 *
 * Example:
 *
 * Suppose:
 *
 *      Thread-1 currently owns the lock.
 *
 * Other threads arrive:
 *
 *      Thread-2
 *      Thread-3
 *      Thread-4
 *      Thread-5
 *
 *
 * Waiting queue:
 *
 *      +-----------------------+
 *      |      FAIR LOCK        |
 *      +-----------------------+
 *                 |
 *             Thread-1
 *             executing
 *                 |
 *                 v
 *      +-----------------------+
 *      | Waiting Queue         |
 *      +-----------------------+
 *      | Thread-2              |
 *      | Thread-3              |
 *      | Thread-4              |
 *      | Thread-5              |
 *      +-----------------------+
 *
 *
 * Expected acquisition order:
 *
 *      Thread-1
 *          |
 *          v
 *      Thread-2
 *          |
 *          v
 *      Thread-3
 *          |
 *          v
 *      Thread-4
 *          |
 *          v
 *      Thread-5
 *
 *
 * Advantages:
 *
 *      -> More predictable lock acquisition.
 *      -> Reduces the possibility of thread starvation.
 *      -> Threads waiting longer are generally given priority.
 *
 * Disadvantages:
 *
 *      -> Fair locking generally has lower throughput.
 *      -> Maintaining fairness introduces additional scheduling overhead.
 *
 *
 * =====================================================================================
 *                  FAIR vs UNFAIR SUMMARY
 * =====================================================================================
 *
 * UNFAIR LOCK:
 *
 *      new ReentrantLock()
 *
 *          |
 *          +---- Default behavior
 *          |
 *          +---- No guaranteed FIFO order
 *          |
 *          +---- Barging is possible
 *          |
 *          +---- Usually better performance
 *          |
 *          +---- Starvation theoretically possible
 *
 *
 * FAIR LOCK:
 *
 *      new ReentrantLock(true)
 *
 *          |
 *          +---- Fairness enabled
 *          |
 *          +---- Prefers longest-waiting thread
 *          |
 *          +---- Approximately FIFO under contention
 *          |
 *          +---- Reduces starvation
 *          |
 *          +---- Usually lower throughput
 *
 *
 * =====================================================================================
 */
public class FairUnfairLockThreading {

        /*
         * =================================================================================
         *                          UNFAIR LOCK
         * =================================================================================
         *
         * ReentrantLock() creates an UNFAIR lock by default.
         *
         * Same as:
         *
         *      new ReentrantLock(false);
         */
        private final Lock unfairLock = new ReentrantLock();


        /*
         * Method used by multiple threads to demonstrate an unfair lock.
         */
        public void unfairResource() {

            /*
             * lock() attempts to acquire the lock.
             *
             * If another thread already owns the lock,
             * the current thread has to wait.
             */
            unfairLock.lock();

            try {

                System.out.println(
                        Thread.currentThread().getName()
                                + " acquired the UNFAIR lock"
                );

                /*
                 * Simulate some work.
                 *
                 * The current thread keeps the lock for 500 milliseconds.
                 *
                 * During this time, other threads calling this method
                 * must wait for the lock.
                 */
                Thread.sleep(500);

            } catch (InterruptedException e) {

                /*
                 * Restore the interrupt flag because sleep() clears it
                 * when InterruptedException is thrown.
                 */
                Thread.currentThread().interrupt();

            } finally {

                /*
                 * Always release a lock inside finally.
                 *
                 * This ensures the lock gets released even if an
                 * exception occurs inside the try block.
                 */
                unfairLock.unlock();

                System.out.println(
                        Thread.currentThread().getName()
                                + " released the UNFAIR lock"
                );
            }
        }


        /*
         * =================================================================================
         *                            FAIR LOCK
         * =================================================================================
         *
         * Passing true enables fairness.
         *
         * Threads waiting longer are generally given preference.
         */
        private final Lock fairLock = new ReentrantLock(true);


        /*
         * Method used by multiple threads to demonstrate a fair lock.
         */
        public void fairResource() {

            fairLock.lock();

            try {

                System.out.println(
                        Thread.currentThread().getName()
                                + " acquired the FAIR lock"
                );

                /*
                 * Simulate some work.
                 *
                 * Keep the lock for 500 milliseconds so that other
                 * threads get enough time to enter the waiting queue.
                 */
                Thread.sleep(500);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

            } finally {

                fairLock.unlock();

                System.out.println(
                        Thread.currentThread().getName()
                                + " released the FAIR lock"
                );
            }
        }


        /*
         * =================================================================================
         *                              MAIN METHOD
         * =================================================================================
         */
        public static void main(String[] args) throws InterruptedException {

            /*
             * Create ONE object.
             *
             * All threads will access the locks belonging to this object.
             */
            FairnessLockExample example = new FairnessLockExample();


            /*
             * =================================================================================
             *                          UNFAIR LOCK EXAMPLE
             * =================================================================================
             */

            System.out.println();
            System.out.println("==================================================");
            System.out.println("              UNFAIR LOCK EXAMPLE");
            System.out.println("==================================================");


            /*
             * Runnable is a Functional Interface.
             *
             * It contains only one abstract method:
             *
             *      void run();
             *
             *
             * Traditional Anonymous Class:
             *
             * Runnable unfairTask = new Runnable() {
             *
             *     @Override
             *     public void run() {
             *         example.unfairResource();
             *     }
             * };
             *
             *
             * Since Runnable is a Functional Interface, we can replace
             * the anonymous class with a Lambda Expression:
             */
            Runnable unfairTask = () -> example.unfairResource();


            /*
             * Create five threads.
             *
             * IMPORTANT:
             *
             * Correct:
             *
             *      new Thread(unfairTask, "Thread-1");
             *
             *
             * Here:
             *
             *      unfairTask -> tells the thread WHAT to execute.
             *
             *      "Thread-1" -> gives the thread its NAME.
             *
             *
             * Writing:
             *
             *      new Thread("Thread-1");
             *
             * only creates a thread with a name.
             *
             * It does NOT execute unfairResource().
             */
            Thread thread1 = new Thread(unfairTask, "Thread-1");
            Thread thread2 = new Thread(unfairTask, "Thread-2");
            Thread thread3 = new Thread(unfairTask, "Thread-3");
            Thread thread4 = new Thread(unfairTask, "Thread-4");
            Thread thread5 = new Thread(unfairTask, "Thread-5");


            /*
             * Start all threads close together.
             *
             * We intentionally don't use a large Thread.sleep() between
             * these start() calls.
             *
             * The purpose is to create CONTENTION.
             *
             * Contention means:
             *
             *      Multiple threads are competing for the same lock.
             */
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();


            /*
             * join() causes the MAIN thread to wait until these threads finish.
             *
             * Without join(), the fair-lock example might start before
             * the unfair-lock example has completed.
             *
             * That would mix the output of both examples.
             */
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();


            /*
             * =================================================================================
             *                    POSSIBLE UNFAIR LOCK OUTPUT
             * =================================================================================
             *
             * ==================================================
             *              UNFAIR LOCK EXAMPLE
             * ==================================================
             *
             * Thread-1 acquired the UNFAIR lock
             * Thread-1 released the UNFAIR lock
             * Thread-3 acquired the UNFAIR lock
             * Thread-3 released the UNFAIR lock
             * Thread-2 acquired the UNFAIR lock
             * Thread-2 released the UNFAIR lock
             * Thread-5 acquired the UNFAIR lock
             * Thread-5 released the UNFAIR lock
             * Thread-4 acquired the UNFAIR lock
             * Thread-4 released the UNFAIR lock
             *
             *
             * Threads were started approximately as:
             *
             *      Thread-1
             *      Thread-2
             *      Thread-3
             *      Thread-4
             *      Thread-5
             *
             * But the lock might be acquired as:
             *
             *      Thread-1
             *          |
             *          v
             *      Thread-3
             *          |
             *          v
             *      Thread-2
             *          |
             *          v
             *      Thread-5
             *          |
             *          v
             *      Thread-4
             *
             *
             * IMPORTANT:
             *
             * The above output is only ONE POSSIBLE OUTPUT.
             *
             * You may also see:
             *
             *      Thread-1
             *      Thread-2
             *      Thread-3
             *      Thread-4
             *      Thread-5
             *
             * This does NOT mean the lock became fair.
             *
             * An unfair lock simply does NOT GUARANTEE ordering.
             */


            /*
             * =================================================================================
             *                              FAIR LOCK EXAMPLE
             * =================================================================================
             */

            System.out.println();
            System.out.println("==================================================");
            System.out.println("                FAIR LOCK EXAMPLE");
            System.out.println("==================================================");


            /*
             * Lambda Expression:
             *
             * When this Runnable executes, fairResource() will be called.
             */
            Runnable fairTask = () -> example.fairResource();


            /*
             * Create five threads for the fair-lock example.
             */
            Thread thread6 = new Thread(fairTask, "Thread-1");
            Thread thread7 = new Thread(fairTask, "Thread-2");
            Thread thread8 = new Thread(fairTask, "Thread-3");
            Thread thread9 = new Thread(fairTask, "Thread-4");
            Thread thread10 = new Thread(fairTask, "Thread-5");


            /*
             * Start Thread-1 first.
             *
             * Thread-1 should acquire the fair lock.
             */
            thread6.start();


            /*
             * Small delay is intentionally added.
             *
             * IMPORTANT:
             *
             * We are NOT using 1000 ms here because fairResource()
             * only holds the lock for 500 ms.
             *
             * If we waited 1000 ms, Thread-1 would already release
             * the lock before Thread-2 started.
             *
             * Then there would be NO contention.
             *
             * Instead, we wait only 50 ms.
             */
            Thread.sleep(50);

            thread7.start();

            Thread.sleep(50);

            thread8.start();

            Thread.sleep(50);

            thread9.start();

            Thread.sleep(50);

            thread10.start();


            /*
             * At approximately this point:
             *
             *
             *                  FAIR LOCK
             *                      |
             *                  Thread-1
             *                  executing
             *                      |
             *                      v
             *
             *              WAITING QUEUE
             *
             *              +-----------+
             *              | Thread-2  |
             *              +-----------+
             *                    |
             *                    v
             *              +-----------+
             *              | Thread-3  |
             *              +-----------+
             *                    |
             *                    v
             *              +-----------+
             *              | Thread-4  |
             *              +-----------+
             *                    |
             *                    v
             *              +-----------+
             *              | Thread-5  |
             *              +-----------+
             *
             *
             * Therefore, when Thread-1 releases the lock,
             * Thread-2 should generally acquire it.
             *
             * Then:
             *
             * Thread-3
             * Thread-4
             * Thread-5
             *
             * get their turns according to waiting order.
             */


            /*
             * Wait for all fair-lock threads to finish.
             */
            thread6.join();
            thread7.join();
            thread8.join();
            thread9.join();
            thread10.join();


            /*
             * =================================================================================
             *                       TYPICAL FAIR LOCK OUTPUT
             * =================================================================================
             *
             * ==================================================
             *                 FAIR LOCK EXAMPLE
             * ==================================================
             *
             * Thread-1 acquired the FAIR lock
             * Thread-1 released the FAIR lock
             *
             * Thread-2 acquired the FAIR lock
             * Thread-2 released the FAIR lock
             *
             * Thread-3 acquired the FAIR lock
             * Thread-3 released the FAIR lock
             *
             * Thread-4 acquired the FAIR lock
             * Thread-4 released the FAIR lock
             *
             * Thread-5 acquired the FAIR lock
             * Thread-5 released the FAIR lock
             *
             *
             * Acquisition order:
             *
             *              Thread-1
             *                  |
             *                  v
             *              Thread-2
             *                  |
             *                  v
             *              Thread-3
             *                  |
             *                  v
             *              Thread-4
             *                  |
             *                  v
             *              Thread-5
             *
             *
             * IMPORTANT:
             *
             * Fairness means preference is given to threads that have
             * been waiting longer for the lock.
             *
             * It does NOT mean that the JVM/OS thread scheduler itself
             * becomes perfectly FIFO.
             */


            /*
             * =================================================================================
             *                       FINAL COMPARISON
             * =================================================================================
             *
             *
             *                  ReentrantLock
             *                        |
             *            +-----------+-----------+
             *            |                       |
             *            v                       v
             *
             *      UNFAIR LOCK               FAIR LOCK
             *
             * new ReentrantLock()       new ReentrantLock(true)
             *
             *            |                       |
             *            v                       v
             *
             *     Default behavior          Fairness enabled
             *
             *            |                       |
             *            v                       v
             *
             *     No FIFO guarantee       Approximately FIFO
             *                              under contention
             *
             *            |                       |
             *            v                       v
             *
             *      Barging possible       Longest-waiting thread
             *                              generally preferred
             *
             *            |                       |
             *            v                       v
             *
             *     Better throughput       Lower throughput
             *     in many workloads       in many workloads
             *
             *            |                       |
             *            v                       v
             *
             *      Starvation             Reduces possibility
             *      theoretically          of starvation
             *      possible
             *
             *
             * =================================================================================
             *
             * QUICK INTERVIEW ANSWER:
             *
             * "By default, ReentrantLock is unfair. An unfair lock does not
             * guarantee that the longest-waiting thread will acquire the lock
             * next, which generally provides better throughput but can theoretically
             * cause starvation.
             *
             * A fair ReentrantLock is created using new ReentrantLock(true).
             * It generally grants access to the longest-waiting thread, approximately
             * following FIFO order under contention. This reduces starvation but
             * may have lower throughput because fairness introduces additional
             * scheduling overhead."
             *
             * =================================================================================
             */


            System.out.println();
            System.out.println("==================================================");
            System.out.println("                 TEST COMPLETED");
            System.out.println("==================================================");
        }
}
