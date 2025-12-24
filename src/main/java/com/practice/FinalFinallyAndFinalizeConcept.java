package com.practice;

public class FinalFinallyAndFinalizeConcept {

    /*
     ==========================================================
     1️⃣ final keyword
     ==========================================================
     👉 final is used to RESTRICT something.

     It can be used with:
     - variable  → value cannot be changed
     - method    → method cannot be overridden
     - class     → class cannot be inherited
    */

    // final variable
    final int speedLimit = 80;

    // final method
    final void showSpeedLimit() {
        // This method cannot be overridden by child classes
        System.out.println("Speed limit is: " + speedLimit);
    }

    /*
     ==========================================================
     2️⃣ finally keyword
     ==========================================================
     👉 finally is used with try-catch blocks.

     - finally block ALWAYS executes
     - Executes whether exception occurs or not
     - Used for cleanup code (closing files, DB connections, etc.)
    */

    static void finallyExample() {
        try {
            int a = 10 / 0; // This will cause ArithmeticException
            System.out.println(a);
        } catch (ArithmeticException e) {
            // This block handles the exception
            System.out.println("Exception occurred: Division by zero");
        } finally {
            // This block ALWAYS executes
            System.out.println("Finally block executed (cleanup code)");
        }
    }

    /*
     ==========================================================
     3️⃣ finalize() method
     ==========================================================
     👉 finalize() is a method of Object class.

     - Called by Garbage Collector (GC)
     - Used before object is destroyed
     - Used for cleanup before memory release

     ⚠️ Note:
     - finalize() is NOT guaranteed to run
     - Deprecated in newer Java versions
    */

    @Override
    protected void finalize() throws Throwable {
        // This method is called by Garbage Collector
        System.out.println("finalize() method called before object destruction");
    }

    public static void main(String[] args) {

        /*
         ==========================================================
         Demonstrating final keyword
         ==========================================================
        */
        FinalFinallyAndFinalizeConcept obj = new FinalFinallyAndFinalizeConcept();
        obj.showSpeedLimit();

        // obj.speedLimit = 100; ❌ Compile-time error (final variable)

        /*
         ==========================================================
         Demonstrating finally keyword
         ==========================================================
        */
        finallyExample();

        /*
         ==========================================================
         Demonstrating finalize() method
         ==========================================================
        */
        FinalFinallyAndFinalizeConcept tempObj = new FinalFinallyAndFinalizeConcept();
        tempObj = null; // Making object eligible for Garbage Collection

        // Requesting Garbage Collector
        System.gc();
    }
}
