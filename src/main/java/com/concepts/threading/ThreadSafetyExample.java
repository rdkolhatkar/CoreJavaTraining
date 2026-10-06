package com.concepts.threading;

/*
 * THREAD SAFETY IN JAVA
 * ---------------------
 *
 * Thread Safety means:
 * A class, method, or block of code behaves correctly when multiple threads
 * access it at the same time.
 *
 * In a multithreaded application, multiple threads may try to read or modify
 * the same shared resource.
 *
 * Example:
 *
 * Suppose balance = 1000
 *
 * Thread-1 -> withdraws 500
 * Thread-2 -> withdraws 500
 *
 * If both threads read balance = 1000 at the same time, both may try to
 * update the balance independently.
 *
 * This can produce incorrect or inconsistent results.
 *
 * Such a situation is called a:
 *
 * RACE CONDITION
 * --------------
 * A race condition occurs when multiple threads access and modify shared data
 * simultaneously, and the final result depends on the order in which the
 * threads execute.
 *
 *
 * HOW TO ACHIEVE THREAD SAFETY IN JAVA?
 * -------------------------------------
 *
 * Some common techniques are:
 *
 * 1. synchronized methods
 * 2. synchronized blocks
 * 3. Lock / ReentrantLock
 * 4. Atomic classes
 *    Example:
 *      AtomicInteger
 *      AtomicLong
 *      AtomicBoolean
 *
 * 5. Immutable objects
 * 6. Thread-safe collections
 *    Example:
 *      ConcurrentHashMap
 *      CopyOnWriteArrayList
 *
 * 7. Avoiding shared mutable data
 *
 *
 * In this example we will demonstrate:
 *
 * 1. A non-thread-safe counter
 * 2. A thread-safe counter using synchronized
 */

public class ThreadSafetyExample {

    /*
     * ---------------------------------------------------------
     * EXAMPLE 1: NON-THREAD-SAFE CLASS
     * ---------------------------------------------------------
     *
     * The variable 'count' is shared by multiple threads.
     *
     * count++ looks like one operation, but internally it contains
     * approximately three operations:
     *
     * 1. Read count
     * 2. Increment count
     * 3. Write the new value back
     *
     * Example:
     *
     * Suppose count = 10
     *
     * Thread-1 reads count -> 10
     * Thread-2 reads count -> 10
     *
     * Thread-1 calculates -> 11
     * Thread-2 calculates -> 11
     *
     * Thread-1 writes -> 11
     * Thread-2 writes -> 11
     *
     * Expected result = 12
     * Actual result   = 11
     *
     * One update is lost.
     *
     * This problem is called:
     *
     * LOST UPDATE / RACE CONDITION
     */

    static class UnsafeCounter {

        private int count = 0;

        public void increment() {

            // NOT THREAD SAFE
            count++;
        }

        public int getCount() {
            return count;
        }
    }


    /*
     * ---------------------------------------------------------
     * EXAMPLE 2: THREAD-SAFE CLASS USING synchronized
     * ---------------------------------------------------------
     *
     * synchronized ensures that only ONE thread at a time
     * can execute this method for the same object.
     *
     * Every Java object has an intrinsic lock / monitor.
     *
     * When a thread enters a synchronized instance method:
     *
     * Thread acquires lock on:
     *
     *      this
     *
     * Other threads trying to execute synchronized methods on
     * the same object must wait until the lock is released.
     *
     *
     * Example:
     *
     * Thread-1
     *      |
     *      | acquires lock
     *      V
     * increment()
     *      |
     *      | releases lock
     *      V
     *
     * Thread-2 can now enter increment().
     *
     *
     * synchronized provides two important properties:
     *
     * 1. MUTUAL EXCLUSION
     *
     * Only one thread can execute the synchronized section
     * at a time.
     *
     *
     * 2. MEMORY VISIBILITY
     *
     * Changes made by one thread become visible to another
     * thread after the lock is released and acquired.
     */

    static class SafeCounter {

        private int count = 0;

        public synchronized void increment() {

            /*
             * Only one thread at a time can execute this method
             * on the same SafeCounter object.
             */

            count++;
        }

        public synchronized int getCount() {

            /*
             * Synchronizing the getter also ensures that the
             * calling thread sees the latest value of count.
             */

            return count;
        }
    }


    public static void main(String[] args) throws InterruptedException {

        System.out.println("========== NON-THREAD-SAFE EXAMPLE ==========");

        UnsafeCounter unsafeCounter = new UnsafeCounter();

        /*
         * Both threads will use the SAME UnsafeCounter object.
         *
         * Therefore:
         *
         * unsafeCounter.count
         *
         * becomes a shared resource.
         */

        Runnable unsafeTask = () -> {

            /*
             * Each thread increments the counter 100,000 times.
             */

            for (int i = 0; i < 100_000; i++) {
                unsafeCounter.increment();
            }
        };


        Thread unsafeThread1 = new Thread(
                unsafeTask,
                "Unsafe-Thread-1"
        );

        Thread unsafeThread2 = new Thread(
                unsafeTask,
                "Unsafe-Thread-2"
        );


        /*
         * start()
         *
         * Starts a new thread and JVM internally calls
         * the run() method.
         */

        unsafeThread1.start();
        unsafeThread2.start();


        /*
         * join()
         *
         * The main thread waits until both worker threads
         * finish their execution.
         *
         * Without join(), main may print the counter before
         * the worker threads complete.
         */

        unsafeThread1.join();
        unsafeThread2.join();


        System.out.println(
                "Expected Unsafe Counter: 200000"
        );

        System.out.println(
                "Actual Unsafe Counter: " + unsafeCounter.getCount()
        );


        /*
         * Possible Output:
         *
         * Expected Unsafe Counter: 200000
         * Actual Unsafe Counter: 147532
         *
         * OR
         *
         * Actual Unsafe Counter: 183421
         *
         * OR sometimes even:
         *
         * Actual Unsafe Counter: 200000
         *
         *
         * IMPORTANT:
         *
         * Race conditions are unpredictable.
         *
         * You may get different output every time the program runs.
         */


        System.out.println();

        System.out.println("========== THREAD-SAFE EXAMPLE ==========");


        SafeCounter safeCounter = new SafeCounter();


        Runnable safeTask = () -> {

            for (int i = 0; i < 100_000; i++) {

                /*
                 * increment() is synchronized.
                 *
                 * Therefore only one thread can modify count
                 * at a time.
                 */

                safeCounter.increment();
            }
        };


        Thread safeThread1 = new Thread(
                safeTask,
                "Safe-Thread-1"
        );

        Thread safeThread2 = new Thread(
                safeTask,
                "Safe-Thread-2"
        );


        safeThread1.start();
        safeThread2.start();


        safeThread1.join();
        safeThread2.join();


        System.out.println(
                "Expected Safe Counter: 200000"
        );

        System.out.println(
                "Actual Safe Counter: " + safeCounter.getCount()
        );


        /*
         * Output:
         *
         * Expected Safe Counter: 200000
         * Actual Safe Counter: 200000
         *
         *
         * Because increment() is synchronized,
         * the race condition is prevented.
         */


        /*
         * =========================================================
         * IMPORTANT THREAD SAFETY CONCEPTS
         * =========================================================
         *
         *
         * 1. SHARED RESOURCE
         * ------------------
         *
         * A resource accessed by multiple threads.
         *
         * Example:
         *
         * int count;
         *
         * BankAccount balance;
         *
         * List<String> users;
         *
         *
         * 2. MUTABLE DATA
         * ---------------
         *
         * Data whose value can change.
         *
         * Example:
         *
         * int count = 10;
         *
         * count = 20;
         *
         *
         * Shared mutable data is the main reason synchronization
         * is required.
         *
         *
         * 3. RACE CONDITION
         * -----------------
         *
         * Multiple threads modify shared data simultaneously
         * and the result depends on execution timing.
         *
         *
         * 4. CRITICAL SECTION
         * -------------------
         *
         * The part of code that accesses shared mutable data.
         *
         * Example:
         *
         * count++;
         *
         * This is the critical section in our example.
         *
         *
         * 5. MUTUAL EXCLUSION
         * -------------------
         *
         * Only one thread is allowed to execute a critical
         * section at a time.
         *
         * synchronized provides mutual exclusion.
         *
         *
         * 6. ATOMIC OPERATION
         * -------------------
         *
         * An operation that executes as one indivisible operation.
         *
         * count++ is NOT atomic.
         *
         * Because internally it performs:
         *
         * read -> modify -> write
         *
         *
         * 7. VISIBILITY
         * -------------
         *
         * One thread may update a variable, but another thread
         * may not immediately see the updated value because of
         * CPU caches and JVM optimizations.
         *
         * synchronized guarantees proper memory visibility.
         *
         *
         * 8. INTRINSIC LOCK / MONITOR
         * ---------------------------
         *
         * Every Java object has an internal monitor lock.
         *
         * synchronized methods use this lock.
         *
         * Example:
         *
         * public synchronized void increment()
         *
         * is approximately equivalent to:
         *
         * synchronized (this) {
         *
         *     count++;
         *
         * }
         *
         *
         * 9. THREAD CONFINEMENT
         * ---------------------
         *
         * If data is only used by one thread, synchronization
         * may not be necessary.
         *
         * Local variables are usually thread-confined because
         * each thread gets its own stack.
         *
         *
         * Example:
         *
         * public void calculate() {
         *
         *     int localVariable = 10;
         *
         * }
         *
         * Each thread gets its own localVariable.
         *
         *
         * 10. IMMUTABILITY
         * ----------------
         *
         * Immutable objects cannot change after creation.
         *
         * Therefore they are naturally thread-safe.
         *
         * Example:
         *
         * String
         *
         * Integer
         *
         * LocalDate
         *
         *
         * =========================================================
         * SUMMARY
         * =========================================================
         *
         * Unsafe:
         *
         * Multiple Threads
         *       |
         *       V
         * Shared Mutable Data
         *       |
         *       V
         * No Synchronization
         *       |
         *       V
         * Race Condition
         *       |
         *       V
         * Incorrect Result
         *
         *
         * Thread Safe:
         *
         * Multiple Threads
         *       |
         *       V
         * Shared Mutable Data
         *       |
         *       V
         * synchronized / Lock / Atomic Classes
         *       |
         *       V
         * Controlled Access
         *       |
         *       V
         * Correct Result
         *
         *
         * In simple words:
         *
         * Thread Safety =
         *
         * "Multiple threads can use the same code/resource
         * concurrently without causing incorrect or inconsistent
         * results."
         */
    }
}
