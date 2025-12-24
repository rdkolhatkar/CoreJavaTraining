package com.practice;

public class CanWeCallOneStaticMethodFromAnotherStaticMethod {
    // Can we call one static method from another static method
    // Yes, one static method can call another static method directly because both belong to the class, not to an object.
    // Static method 1
    static void displayMessage() {
        // This method is static, so it belongs to the class
        System.out.println("Hello from displayMessage()");
    }

    // Static method 2
    static void callAnotherMethod() {
        // Calling another static method directly
        // No object creation is needed
        displayMessage();
    }

    public static void main(String[] args) {
        // main method is also static
        // It can call any static method directly
        callAnotherMethod();
    }
}
