package com.concepts.threading;

public class DeadLockConceptInThreading {
    /*
     Deadlock is a situation in multithreading where two or more threads are blocked forever, waiting for each other to release a resource.
     This typically occurs when two or more threads have circular dependencies on a set of locks.

     Deadlocks typically occur when four conditions are met simultaneously:
     1) Mutual Exclusion: Only one thread can access a resource at a time.
     2) Hold and Wait: A thread holding at least one resource is waiting to acquire additional resources held by other threads.
     3) No Preemption: Resources cannot be forcibly taken from threads holding them.
     4) Circular Wait: A set of threads is waiting for each other in a circular chain.

    */

}
