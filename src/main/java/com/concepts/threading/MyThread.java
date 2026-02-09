package com.concepts.threading;

public class MyThread extends Thread{
    // Here we have a class in which we are going to create a custom thread, but our main method is also present in this same class.

    @Override
    public void run() {
        System.out.println("Thread is RUNNING");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        // As this is an override method we cannot write the throws declaration for exception.
    }

    public static void main(String[] args) throws InterruptedException {
        // Creating object of the same class inside the main method.
        MyThread t1 = new MyThread();
        System.out.println(t1.getState()); // It will print output as : NEW
        // In above case only main thread is running and that's why we are only seeing the NEW as the state of output thread.
        // Now we will initialize our 't1' thread
        t1.start();
        System.out.println(t1.getState()); // This time output will be : RUNNABLE
        // Here our 'main' thread is responsible for running the 't1' thread
        System.out.println(Thread.currentThread().getName()); // Output :  main
        System.out.println("***************************************************************************");
        // Creating the Second Object of MyThread Class
        MyThread t2 = new MyThread();
        System.out.println(t2.getState()); // It will print output as : NEW
        t2.start(); // Initialize the t2 thread
        Thread.sleep(1000);
        System.out.println(t2.getState()); // Output : TIMED_WAITING
        // As our thread is sleeping, we call this state of Thread as "TIMED_WAITING"
        t2.join(); // This method will wait for this thread to die.
        // In this scenario our 'main' thread is calling this 't2' thread and 'main' thread will wait till 't2' thread finishes it's execution.
        System.out.println(t2.getState()); // Output : TERMINATED
        // Here output will be TERMINATED because main method will execute after t2 is dead.
    }
}
