package com.concepts.threading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockingInJava {
    // In java there are tw types of Locking mechanisms. Intrinsic and Explicit
    // 1) Intrinsic : These are built into every object in Java. You don't see them, but they are there. When you use a synchronized keyword, you're using these automatic locks.
    // 2) Explicit : These are more advanced locks you can control yourself using the Lock class from 'java.util.concurrent.locks.' You explicitly say when to lock and unlock, giving more control over how and when people can write in the notebook

    private int balance = 100;

    // This method is the Example of Intrinsic Lock in java using synchronized keyword
    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw "+ amount);
        if(balance >= amount){
            System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal ");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " Completed Withdrawal and Remaining Balance is = "+balance);
        }else {
            System.out.println(Thread.currentThread().getName() + " insufficient balance ");
        }
    }

    // This method is the Example of Explicit Lock in java using Lock Interface in Java

    private final Lock lock = new ReentrantLock();
    public  void withdrawMoney(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw "+ amount);
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if(balance >= amount){
                    try{
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal ");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " Completed Withdrawal and Remaining Balance is = "+balance);
                    } catch (RuntimeException e) {
                        Thread.currentThread().interrupt();
                    }
                    finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance ");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try again later ");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void withdrawCash(int amount) {

        // Thread.currentThread()
        // -> Returns the Thread object that is currently executing this method.
        //
        // getName()
        // -> Returns the name of that thread.
        //
        // Example:
        // Thread-1 attempting to withdraw 500
        System.out.println(
                Thread.currentThread().getName()
                        + " attempting to withdraw " + amount
        );

        try {

            /*
             * lock.tryLock(1000, TimeUnit.MILLISECONDS)
             *
             * tryLock() tries to acquire the ReentrantLock.
             *
             * Here the current thread will wait for a MAXIMUM of 1000 milliseconds
             * (1 second) to acquire the lock.
             *
             * Possible results:
             *
             * 1. Lock is available immediately
             *      -> Thread acquires the lock.
             *      -> Returns true.
             *
             * 2. Lock is currently held by another thread, but becomes available
             *    within 1 second
             *      -> Thread acquires the lock.
             *      -> Returns true.
             *
             * 3. Lock remains unavailable for the entire 1 second
             *      -> Thread stops waiting.
             *      -> Returns false.
             *
             * 4. Thread is interrupted while waiting
             *      -> InterruptedException is thrown.
             */
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {

                // IMPORTANT:
                // At this point, the current thread OWNS the lock.
                //
                // Other threads trying to acquire this same lock cannot enter
                // the protected section until this thread calls:
                //
                // lock.unlock();

                /*
                 * Check whether enough money is available.
                 *
                 * This check is performed AFTER acquiring the lock.
                 * This is important because balance is shared data.
                 *
                 * Only one thread should check/update the balance at a time.
                 */
                if (balance >= amount) {

                    try {

                        System.out.println(
                                Thread.currentThread().getName()
                                        + " proceeding with withdrawal"
                        );

                        try {

                            /*
                             * Sleep the CURRENT thread for 3000 ms = 3 seconds.
                             *
                             * IMPORTANT:
                             * Thread.sleep() DOES NOT release the ReentrantLock.
                             *
                             * Therefore, during these 3 seconds:
                             *
                             * Current thread:
                             *      -> sleeping
                             *      -> still owns the lock
                             *
                             * Other threads:
                             *      -> cannot acquire this lock
                             *
                             * Since other threads only wait 1 second because of
                             * tryLock(1000, ...), they will probably fail to
                             * acquire the lock while this thread sleeps for 3 sec.
                             */
                            Thread.sleep(3000);

                        } catch (InterruptedException e) {

                            /*
                             * sleep() can throw InterruptedException.
                             *
                             * Your original code converts it into RuntimeException.
                             */
                            throw new RuntimeException(e);
                        }


                        /*
                         * Deduct the withdrawal amount.
                         *
                         * Example:
                         *
                         * balance = 1000
                         * amount  = 400
                         *
                         * balance -= amount;
                         *
                         * balance = 600
                         *
                         * Because the current thread owns the lock,
                         * another thread cannot simultaneously modify this
                         * protected balance section.
                         */
                        balance -= amount;


                        System.out.println(
                                Thread.currentThread().getName()
                                        + " Completed Withdrawal and Remaining Balance is = "
                                        + balance
                        );

                    } catch (RuntimeException e) {

                        /*
                         * If a RuntimeException occurs above, this block executes.
                         *
                         * Thread.currentThread().interrupt()
                         *
                         * sets the interrupt status of the current thread.
                         *
                         * This is useful when the RuntimeException was created
                         * because Thread.sleep() was interrupted.
                         */
                        Thread.currentThread().interrupt();

                    } finally {

                        /*
                         * lock.unlock()
                         *
                         * Releases the ReentrantLock currently owned by this thread.
                         *
                         * This is extremely important.
                         *
                         * The finally block executes whether:
                         *
                         *      -> withdrawal succeeds
                         *      -> RuntimeException occurs
                         *      -> code exits the try block abnormally
                         *
                         * Therefore it helps guarantee that the lock is released.
                         *
                         * Once unlock() is executed, another waiting thread
                         * can acquire the lock.
                         *
                         *
                         * BEFORE unlock():
                         *
                         * Thread-1
                         *     |
                         *     | owns
                         *     V
                         *   [ LOCK ]
                         *
                         * Thread-2 ---- waiting
                         * Thread-3 ---- waiting
                         *
                         *
                         * AFTER Thread-1 calls unlock():
                         *
                         * Thread-1
                         *     |
                         *     +---- releases lock
                         *
                         *   [ LOCK ] ---- available
                         *
                         * Thread-2 or Thread-3 may now acquire it.
                         */
                        lock.unlock();
                    }

                } else {

                    /*
                     * PROBLEM IN YOUR ORIGINAL CODE
                     * =============================
                     *
                     * The thread has ALREADY acquired the lock before reaching here.
                     *
                     * But this else block does NOT call:
                     *
                     *      lock.unlock();
                     *
                     * Therefore, if balance < amount, the thread can leave this
                     * method while STILL OWNING THE LOCK.
                     *
                     * Other threads may then continuously fail to acquire it.
                     *
                     * This is why unlock() should normally be placed in a finally
                     * block immediately associated with successful lock acquisition.
                     */
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " insufficient balance"
                    );
                }

            } else {

                /*
                 * This executes when the thread could not acquire the lock
                 * within 1000 milliseconds.
                 *
                 * IMPORTANT:
                 * Since this thread NEVER acquired the lock, it must NOT call
                 * lock.unlock().
                 */
                System.out.println(
                        Thread.currentThread().getName()
                                + " could not acquire the lock, will try again later"
                );
            }

        } catch (InterruptedException e) {

            /*
             * tryLock(timeout, unit) can throw InterruptedException
             * if the thread is interrupted while waiting for the lock.
             *
             * Calling interrupt() again restores the thread's interrupt status.
             */
            Thread.currentThread().interrupt();
        }
    }
}
