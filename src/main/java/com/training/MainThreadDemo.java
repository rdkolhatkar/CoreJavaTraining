package com.training;

/**
 * Demonstrate single thread with the help of a Java program.
 * Thread can be referred to as a lightweight process.
 * Thread uses fewer resources to create and exist in the process;
 * thread shares process resources.
 * The main thread of Java is the thread that is started when the program starts.
 * The slave thread is created as a result of the main thread.
 * This is the last thread to complete execution.
 */
public class MainThreadDemo {
    // main method
    public static void main(String[] argvs)
    {
// fetching the current thread
        Thread th = Thread.currentThread();

// setting the name
        th.setName("The Main Thread");
        th.setPriority(7);
        System.out.println(th);
        System.out.println(th.getName());
        System.out.println(th.getPriority());

    }
}
