package com.practice;

public class StaticBlockInJava {
    // Explain static block in java

    // A static block in Java is used to initialize static data and is executed once when the class is loaded, before the main() method.
    // We can have multiple static blocks
    // Static block will run before main method
    // We can write it anywhere inside our java class
    // cannot write a static block inside any method in Java.

    static {
        System.out.println("Inside the first static block 1 ....");
    }
    static {
        System.out.println("Inside the second static block 2 ....");
    }static {
        System.out.println("Inside the third static block 3 ....");
    }

    public static void main(String[] args) {
        System.out.println("Inside the main method ....");
    }

    static {
        System.out.println("Inside the fourth static block  4....");
    }

    /*
    Above code will show us the output like this :
        Inside the first static block 1 ....
        Inside the second static block 2 ....
        Inside the third static block 3 ....
        Inside the fourth static block  4....
        Inside the main method ....
    */
}
