package com.practice;

public class PrintHelloWorldWithoutSemiColon {
    // Here are 5 different ways to print "Hello World" in Java without using a semicolon (;) in the actual print statement.
    public static void main(String[] args) {

        // Method 1: Using if with System.out.printf
        if (System.out.printf("Hello World") != null) {
        }
        // Method 2: Using for loop
        for (System.out.println("Hello World"); ; ) {
            break;
        }
        // Method 3: Using while loop
        while (System.out.append("Hello World") == null) {
        }
        // Method 4: Using switch statement
        // System.out.append(...) writes the text and returns a PrintStream.
        // calling toString() on that PrintStream gives a String, which is valid for switch.
        switch (System.out.append("Hello World").toString()) {
        }

    }
}
