package com.concepts.threading;

/*
================================================================================
                      JAVA THREAD METHODS CHEAT SHEET
================================================================================

METHOD                         DESCRIPTION
--------------------------------------------------------------------------------
start()                                 Starts a new thread; JVM invokes run().
run()                                   Defines the task executed by the thread.
sleep(long millis)                      Pauses the current thread for specified millis.
sleep(long, int nanos)                  Pauses current thread for millis + nanos.
join()                                  Waits until the target thread terminates.
join(long millis)                       Waits for target thread up to specified millis.
join(long, int nanos)                   Waits for target thread for millis + nanos.
yield()                                 Hints scheduler to let another thread execute.
interrupt()                             Requests interruption of the target thread.
isInterrupted()                         Checks interrupt status without clearing it.
interrupted()                           Checks and clears current thread's interrupt status.
isAlive()                               Checks if thread has started and not terminated.
currentThread()                         Returns the currently executing Thread object.
getName()                               Returns the thread name.
setName(String name)                    Sets the thread name.
getId()                                 Returns thread ID (deprecated since Java 19).
getPriority()                           Returns thread priority.
setPriority(int priority)               Sets priority (1 to 10).
getState()                              Returns current thread state.
setDaemon(boolean on)                   Sets daemon status; call before start().
isDaemon()                              Checks whether thread is a daemon.
activeCount()                           Estimates active threads in current thread group.
enumerate(Thread[] tarray)              Copies active threads into the supplied array.
getThreadGroup()                        Returns the thread's ThreadGroup.
toString()                              Returns thread details as a string.
holdsLock(Object obj)                   Checks if current thread owns object's monitor.
getStackTrace()                         Returns stack trace of this thread.
getAllStackTraces()                     Returns stack traces of all live threads.
dumpStack()                             Prints current thread's stack trace.
onSpinWait()                            Performance hint for spin-wait loops.
getContextClassLoader()                 Gets the thread's context class loader.
setContextClassLoader(ClassLoader cl)   Sets the thread's context class loader.
getUncaughtExceptionHandler()           Gets the thread's uncaught exception handler.
setUncaughtExceptionHandler()           Sets a handler for uncaught exceptions.
getDefaultUncaughtExceptionHandler()    Gets the default uncaught exception handler.
setDefaultUncaughtExceptionHandler()    Sets the default uncaught exception handler.

--------------------------------------------------------------------------------
OBJECT METHODS USED IN THREAD COORDINATION
--------------------------------------------------------------------------------
wait()                         Waits and releases the object's monitor.
wait(long millis)              Waits up to specified milliseconds.
wait(long, int nanos)          Waits for millis + nanos.
notify()                       Wakes one thread waiting on the object's monitor.
notifyAll()                    Wakes all threads waiting on the object's monitor.

--------------------------------------------------------------------------------
DEPRECATED THREAD METHODS — DO NOT USE
--------------------------------------------------------------------------------
stop()                         Forcefully stops a thread; unsafe.
suspend()                      Suspends a thread; can cause deadlocks.
resume()                       Resumes a suspended thread; unsafe.
countStackFrames()             Deprecated; intended for suspended threads.
checkAccess()                  Deprecated security check.

--------------------------------------------------------------------------------
THREAD PRIORITY CONSTANTS
--------------------------------------------------------------------------------
Thread.MIN_PRIORITY            Minimum priority (1).
Thread.NORM_PRIORITY           Normal priority (5).
Thread.MAX_PRIORITY            Maximum priority (10).

--------------------------------------------------------------------------------
THREAD STATES (Thread.State)
--------------------------------------------------------------------------------
NEW                            Created but not started.
RUNNABLE                       Ready or executing.
BLOCKED                        Waiting to acquire a monitor lock.
WAITING                        Waiting indefinitely.
TIMED_WAITING                  Waiting for a specified time.
TERMINATED                     Execution completed.

--------------------------------------------------------------------------------
IMPORTANT NOTES
--------------------------------------------------------------------------------
1. start() can be called only once per Thread object.
2. Calling run() directly does not create a new thread.
3. sleep() pauses the current thread and does not release monitor locks.
4. wait() releases the monitor lock and must be called inside synchronized.
5. interrupt() requests interruption; it does not forcibly stop a thread.
6. isInterrupted() does not clear the interrupt status.
7. Thread.interrupted() checks and clears the current thread's status.
8. yield() is only a scheduler hint; execution order is not guaranteed.
9. setDaemon() must be called before start().
10. Thread priority does not guarantee execution order.
11. getState() provides a snapshot, not a synchronization mechanism.
12. Prefer ExecutorService/Future for managing multiple tasks.

================================================================================
*/
public class ThreadMethods extends Thread{
    // First Thread Method is start()
    // Second Thread Method is run()
    // Third Thread Method is sleep() and it is a static method
    // To rename the Thread we have to follow the below constructor approach
    public ThreadMethods(String name){
        super(name);
    }
    @Override
    public void run() {
        System.out.println("Thread is running ...........");
        for(int i = 0; i <= 3; i++){
            System.out.println(i);
            System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority() + "- count: " + i);
            Thread.yield(); // This will give the chance to other threads to get executed in between the current thread
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadMethods t1 = new ThreadMethods("Low Priority Thread");
        ThreadMethods t2 = new ThreadMethods("Medium Priority Thread");
        ThreadMethods t3 = new ThreadMethods("High Priority Thread");
        t1.setPriority(Thread.MIN_PRIORITY); // Setting Priority
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY); // JVM will always give priority to the High Priority Thread
        t1.start(); // When "start()" method executes then JVM will invoke "run()" method
        t2.start();
        // Interrupting thread
        t1.interrupt(); // It will stop t1 thread abruptly
        t3.start();
        t1.join(); // It will wait until t1 thread to finish.

        // DAEMON THREADS -> These are the threads which run in backend of the software or more precisely it runs in background. JVM will not wait for DAEMON THREAD to get finished. If USER THREADS are completed then JVM will terminate the operations
        t1.setDaemon(true);
        t2.start();
        System.out.println("Main Thread Or USER THREAD is Executed successfully .......");

    }
}
