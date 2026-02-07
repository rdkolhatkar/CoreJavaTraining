package com.concepts.threading;
// To do any kind of work in a new thread, we have to create new class and we have to extend it with Thread class
public class ThreadOne extends Thread{
    // Thread class provides us lot of inbuilt methods which we can override as per our requirement
    // To run any new thread we have to override the "run()" method from Thread.class
    @Override
    public void run() {
        /*
        for(int i = 0; i < 100000; i++){
            System.out.println("My name is Ratnakar");
        }
        */
        for(; ;){
            // Here we are using infinite loop to see the context switching inside the class where we have our main thread which is nothing but our main method.
            // Main clss : MultiThreadingConceptInJava
            System.out.println("My name is Ratnakar");
        }
    }
}
