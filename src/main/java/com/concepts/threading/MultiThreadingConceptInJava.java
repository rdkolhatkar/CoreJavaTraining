package com.concepts.threading;

public class MultiThreadingConceptInJava {
    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne(); // Creating the object of ThreadOne class and invoking the start() method.
        threadOne.start();
        System.out.println("Hello World !");
        // Printing the name of current running thread
        System.out.println(Thread.currentThread().getName()); // Output of this line is : main
        // To create a new thread in Java, you have to either extend the Thread class or implement the Runnable interface.
        // Right now we are printing the "Hello World !" String inside the main thread
        // Now we have to create a new thread and inside that thread we will print "My name is Ratnakar"
        // We will create the new class called 'ThreadOne' and inside that class we will create a new thread for printing "My name is Ratnakar"
        // Here we will create one infinite loop and print the "Good Morning !" in the console to see the actual 'Context switching' in Runtime Execution.
        for(; ;){ // This loop will keep on running until you forcefully stop the code execution from console
            System.out.println("Good Morning !");
            System.out.println(Thread.currentThread().getName());
        }
        // Now to print the "My name is Ratnakar" we have to create the object of ThreadOne class and then we have to run the 'start()' method
        // "start()"
        // As we are running the infinite loop "for (;;)" Once the JVM enters this loop, It never comes out, Any code written after this loop is unreachable
        /*
        We cannot create the object of Thread class after infinite loop Because Java is smart enough to know:
        -> for(;;) will run forever
        -> So the statements after it will never execute
        -> And Java does not allow unreachable statements
        -> This is a compile-time error, not a runtime error.
         */
        // As "ThreadOne" and "MultiThreadingConceptInJava" are two independent processes,
        // "Good Morning !" and "My name is Ratnakar" will get printed randomly in the console
    }
}
