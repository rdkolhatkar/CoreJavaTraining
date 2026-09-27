package com.concepts.threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
================================================================================
                  IMPORTANT LOCK / REENTRANTLOCK METHODS
================================================================================

+-----------------------------+--------------------------------------------------+
| METHOD                      | FUNCTIONAL BEHAVIOR                              |
+-----------------------------+--------------------------------------------------+
| lock.lock()                 | Waits until the lock becomes available and       |
|                             | then acquires it.                                |
|                             |                                                  |
|                             | If another thread owns the lock, the current     |
|                             | thread waits.                                    |
|                             |                                                  |
|                             | Example:                                         |
|                             | lock.lock();                                     |
+-----------------------------+--------------------------------------------------+
| lock.unlock()               | Releases a lock owned by the current thread.     |
|                             |                                                  |
|                             | After releasing it, another waiting thread may   |
|                             | acquire the lock.                                |
|                             |                                                  |
|                             | Usually called inside finally.                   |
|                             |                                                  |
|                             | Example:                                         |
|                             | finally {                                        |
|                             |     lock.unlock();                               |
|                             | }                                                |
+-----------------------------+--------------------------------------------------+
| lock.tryLock()              | Attempts to acquire the lock immediately.        |
|                             |                                                  |
|                             | Returns true  -> lock acquired                   |
|                             | Returns false -> lock unavailable                |
|                             |                                                  |
|                             | It does NOT wait for the lock.                   |
|                             |                                                  |
|                             | Example:                                         |
|                             | if (lock.tryLock()) { ... }                      |
+-----------------------------+--------------------------------------------------+
| lock.tryLock(time, unit)    | Waits up to the specified amount of time for     |
|                             | the lock.                                        |
|                             |                                                  |
|                             | Returns true if lock is acquired.                |
|                             | Returns false if timeout expires.                |
|                             |                                                  |
|                             | Can throw InterruptedException.                  |
|                             |                                                  |
|                             | Example:                                         |
|                             | lock.tryLock(1, TimeUnit.SECONDS);               |
+-----------------------------+--------------------------------------------------+
| lock.lockInterruptibly()    | Waits for the lock like lock(), but allows the   |
|                             | waiting thread to respond to interruption.       |
|                             |                                                  |
|                             | Can throw InterruptedException.                  |
+-----------------------------+--------------------------------------------------+
| lock.newCondition()         | Creates a Condition associated with the lock.    |
|                             |                                                  |
|                             | Conditions allow threads to wait and be          |
|                             | signalled, similar to wait()/notify().           |
|                             |                                                  |
|                             | Example:                                         |
|                             | Condition condition = lock.newCondition();       |
+-----------------------------+--------------------------------------------------+


================================================================================
                       lock() VS tryLock()
================================================================================

lock.lock();

    Thread-1 ------> [LOCK AVAILABLE] ------> Acquires Lock

    Thread-2 ------> [LOCK BUSY]
                         |
                         |
                         V
                       WAITS
                         |
                         |
                  Lock becomes available
                         |
                         V
                    Acquires Lock


lock.tryLock();

    Thread-1 ------> [LOCK AVAILABLE] ------> true

    Thread-2 ------> [LOCK BUSY] -----------> false
                     Does NOT wait


lock.tryLock(1, TimeUnit.SECONDS);

    Thread-2 ------> [LOCK BUSY]
                         |
                         V
                    Wait up to 1 sec
                         |
             +-----------+-----------+
             |                       |
       Lock available           Still locked
             |                       |
             V                       V
           true                    false


================================================================================
                        IMPORTANT RULE FOR unlock()
================================================================================

The safest common pattern is:

lock.lock();

try {

    // Critical section
    // Access shared resources here.

} finally {

    lock.unlock();
}

WHY?

Because finally executes even when an exception occurs.

BAD:

lock.lock();

doSomething();       // Exception occurs here

lock.unlock();       // <-- May never execute!


GOOD:

lock.lock();

try {

    doSomething();   // Even if exception occurs...

} finally {

    lock.unlock();   // ...lock is released.
}


================================================================================
              IMPORTANT: Thread.sleep() DOES NOT RELEASE LOCK
================================================================================

lock.lock();

try {

    Thread.sleep(5000);

} finally {

    lock.unlock();
}

During those 5 seconds the thread is sleeping BUT STILL OWNS THE LOCK.

Sleeping != releasing the lock.


================================================================================
*/
public class ReentrantLockExample {
    private final Lock lock = new ReentrantLock();
    // Here outerMethod is calling innerMethod
    public void outerMethod(){

//       lock.lockInterruptibly();
       lock.lock();
       try{
           System.out.println("Outer Method");
           innerMethod();
       }
       finally {
           lock.unlock();
       }
    }
    public void innerMethod(){
        lock.lock();
        try{
          System.out.println("Inner Method");
        }
        finally {
            lock.unlock();
        }
    }
    // Here both inner and outer methods are dependent on each other, so this situation is called deadlock, because both threads are waiting for each other to get finished.
    // Hence here we are using "ReentrantLock" with which we can reenter inside a deadlock situation and close the thread
}


/*
================================================================================
                    REENTRANTLOCK AND DEADLOCK EXAMPLE
================================================================================

IMPORTANT:

The code below DOES NOT actually cause a deadlock.

WHY?

Because we are using ReentrantLock.

A ReentrantLock allows the SAME THREAD that already owns the lock
to acquire the SAME LOCK again.

"Reentrant" basically means:

        "The thread can enter the same lock again."


================================================================================
                         BASIC EXECUTION FLOW
================================================================================

Suppose Thread-1 calls:

        outerMethod();

Execution:

Thread-1
   |
   V
outerMethod()
   |
   V
lock.lock()
   |
   |  Thread-1 acquires the lock
   |
   |  Lock Hold Count = 1
   |
   V
System.out.println("Outer Method")
   |
   V
innerMethod()
   |
   V
lock.lock()
   |
   |  SAME Thread-1 tries to acquire SAME lock
   |
   |  Since this is ReentrantLock:
   |
   |  Thread-1 IS ALLOWED to acquire it again.
   |
   |  Lock Hold Count = 2
   |
   V
System.out.println("Inner Method")
   |
   V
lock.unlock()
   |
   |  Hold Count = 1
   |
   V
Return to outerMethod()
   |
   V
lock.unlock()
   |
   |  Hold Count = 0
   |
   |  Lock is completely released
   |
   V
Method Finished


Therefore:

    NO DEADLOCK OCCURS.

================================================================================
*/

//public class ReentrantLockExample {
//
//    /*
//     * Create one ReentrantLock object.
//     *
//     * Both outerMethod() and innerMethod() use the SAME lock.
//     */
//    private final Lock lock = new ReentrantLock();
//
//
//    /*
//     * outerMethod() first acquires the lock and then calls innerMethod().
//     */
//    public void outerMethod() {
//
//        /*
//         * Acquire the lock.
//         *
//         * Suppose Thread-1 executes this method.
//         *
//         * Before:
//         *
//         *      Lock Hold Count = 0
//         *
//         * After:
//         *
//         *      Lock Owner      = Thread-1
//         *      Lock Hold Count = 1
//         */
//        lock.lock();
//
//        try {
//
//            System.out.println("Outer Method");
//
//            /*
//             * IMPORTANT:
//             *
//             * Thread-1 STILL owns the lock.
//             *
//             * Now Thread-1 calls innerMethod().
//             *
//             * innerMethod() will again execute:
//             *
//             *      lock.lock();
//             *
//             * Normally, we might think:
//             *
//             * "The lock is already locked, so Thread-1 will wait."
//             *
//             * But that does NOT happen with ReentrantLock.
//             *
//             * Because Thread-1 itself already owns the lock,
//             * ReentrantLock allows Thread-1 to acquire it again.
//             */
//            innerMethod();
//
//        } finally {
//
//            /*
//             * This is the SECOND unlock().
//             *
//             * When innerMethod() returns:
//             *
//             *      Hold Count = 1
//             *
//             * This unlock() changes:
//             *
//             *      Hold Count:
//             *
//             *          1 -> 0
//             *
//             * When Hold Count becomes 0, Thread-1 completely
//             * releases the lock.
//             *
//             * Another waiting thread can now acquire it.
//             */
//            lock.unlock();
//        }
//    }
//
//
//    public void innerMethod() {
//
//        /*
//         * Thread-1 reaches this line while it ALREADY owns the lock
//         * from outerMethod().
//         *
//         * Because this is ReentrantLock, the SAME thread is allowed
//         * to acquire the SAME lock again.
//         *
//         * Before:
//         *
//         *      Lock Owner      = Thread-1
//         *      Hold Count      = 1
//         *
//         * After lock.lock():
//         *
//         *      Lock Owner      = Thread-1
//         *      Hold Count      = 2
//         *
//         * Thread-1 DOES NOT block itself.
//         */
//        lock.lock();
//
//        try {
//
//            System.out.println("Inner Method");
//
//        } finally {
//
//            /*
//             * Release ONE acquisition of the lock.
//             *
//             * Hold Count:
//             *
//             *      2 -> 1
//             *
//             * IMPORTANT:
//             *
//             * The lock is NOT completely free yet.
//             *
//             * Thread-1 still owns it because outerMethod()
//             * acquired it once.
//             */
//            lock.unlock();
//        }
//    }
//}


/*
================================================================================
                     WHAT DOES "REENTRANT" MEAN?
================================================================================

Reentrant means that a thread that already owns a lock can acquire
the SAME lock again without blocking itself.


Example:

Thread-1:

lock.lock();                 Hold Count = 1

    lock.lock();             Hold Count = 2

        lock.lock();         Hold Count = 3

        lock.unlock();       Hold Count = 2

    lock.unlock();           Hold Count = 1

lock.unlock();               Hold Count = 0


Only when:

        Hold Count = 0

is the lock completely released.


================================================================================
                  LOCK / UNLOCK COUNT MUST MATCH
================================================================================

Every successful lock() should eventually have a corresponding unlock().

Example:

lock.lock();                 // Hold Count = 1
lock.lock();                 // Hold Count = 2

lock.unlock();               // Hold Count = 1

// PROBLEM:
// One lock() has not been matched by unlock().
//
// Hold Count is still 1.
//
// Therefore the lock is STILL owned by the current thread.
//
// Other threads cannot acquire it.


CORRECT:

lock.lock();                 // Hold Count = 1
lock.lock();                 // Hold Count = 2

lock.unlock();               // Hold Count = 1
lock.unlock();               // Hold Count = 0

// Lock completely released.


================================================================================
                 WHY IS ReentrantLock USEFUL HERE?
================================================================================

Consider:

outerMethod()
     |
     | acquires LOCK
     |
     V
innerMethod()
     |
     | needs SAME LOCK
     |
     V


Without reentrant behavior, we could get:

Thread-1
   |
   V
outerMethod()
   |
   | acquires Lock-A
   |
   V
innerMethod()
   |
   | tries Lock-A again
   |
   V
WAITING...
   ^
   |
   |
Thread-1 itself must release Lock-A

But Thread-1 cannot return to outerMethod() to release the lock
because it is waiting inside innerMethod().

This would be SELF-DEADLOCK.


ReentrantLock prevents this situation:

Thread-1
   |
   V
outerMethod()
   |
   | lock.lock()
   | Hold Count = 1
   |
   V
innerMethod()
   |
   | lock.lock()
   | SAME THREAD -> ALLOWED
   | Hold Count = 2
   |
   V
innerMethod completes
   |
   | unlock()
   | Hold Count = 1
   |
   V
outerMethod completes
   |
   | unlock()
   | Hold Count = 0
   |
   V
LOCK RELEASED


================================================================================
                       WHAT IS A REAL DEADLOCK?
================================================================================

A real deadlock commonly occurs when TWO OR MORE threads wait
indefinitely for resources held by each other.

For example, suppose we have:

        Lock-A
        Lock-B


Thread-1:

        lockA.lock();

        // Thread-1 now owns Lock-A

        lockB.lock();

        // But Lock-B is owned by Thread-2
        // Therefore Thread-1 waits for Thread-2.


Thread-2:

        lockB.lock();

        // Thread-2 now owns Lock-B

        lockA.lock();

        // But Lock-A is owned by Thread-1
        // Therefore Thread-2 waits for Thread-1.


The situation becomes:


             owns
Thread-1 -------------> Lock-A
   ^                       |
   |                       |
   |                       | wants
   |                       V
   +-------------------- Thread-2
                            |
                            |
                            | owns
                            V
                          Lock-B
                            |
                            |
                            | Thread-1 wants
                            V
                         Thread-1


Simplified:

Thread-1 owns Lock-A
Thread-1 waits for Lock-B

            AND

Thread-2 owns Lock-B
Thread-2 waits for Lock-A


Therefore:

Thread-1
   |
   | waiting for Lock-B
   V
Thread-2
   |
   | waiting for Lock-A
   V
Thread-1


Neither thread can continue.

This is a DEADLOCK.


================================================================================
              ReentrantLock DOES NOT PREVENT ALL DEADLOCKS
================================================================================

IMPORTANT:

The name "ReentrantLock" does NOT mean:

        "A lock that prevents deadlocks."

ReentrantLock only solves the specific problem where:

        SAME THREAD
            +
        SAME LOCK

needs to acquire the lock multiple times.


It does NOT automatically prevent situations such as:

Thread-1:
    lockA.lock();
    lockB.lock();

Thread-2:
    lockB.lock();
    lockA.lock();

That situation can still cause deadlock.


================================================================================
               lock() VS lockInterruptibly()
================================================================================

lock.lock();

-> Acquires the lock.
-> If another thread owns it, current thread waits.
-> Normal lock acquisition is not designed to let interruption
   abort that wait in the same way as lockInterruptibly().


lock.lockInterruptibly();

-> Attempts to acquire the lock.
-> If lock is unavailable, thread waits.
-> BUT the waiting thread can be interrupted.
-> Throws InterruptedException.


Example:

try {

    lock.lockInterruptibly();

    try {

        // Critical section

    } finally {

        lock.unlock();
    }

} catch (InterruptedException e) {

    Thread.currentThread().interrupt();
}


This can be useful when we want a thread waiting for a lock
to be cancellable/interrupted.


================================================================================
                        FINAL CONCEPT
================================================================================

Your code:

outerMethod()
      |
      | lock.lock()
      | Hold Count = 1
      |
      V
innerMethod()
      |
      | lock.lock()
      | Hold Count = 2
      |
      | SAME THREAD + SAME ReentrantLock
      | Therefore NO DEADLOCK
      |
      V
inner unlock()
      |
      | Hold Count = 1
      |
      V
outer unlock()
      |
      | Hold Count = 0
      |
      V
LOCK RELEASED


Therefore the comment:

"Both inner and outer methods are dependent on each other,
so this situation is called deadlock."

is INCORRECT.


A better comment is:

"outerMethod() acquires the ReentrantLock and calls innerMethod(),
which attempts to acquire the same lock again. Since ReentrantLock
allows the thread that currently owns the lock to acquire it
repeatedly, the thread does not block itself. The lock maintains
a hold count, and every successful lock() must be matched by an
unlock(). Therefore, this example demonstrates REENTRANCY rather
than DEADLOCK."
================================================================================
*/