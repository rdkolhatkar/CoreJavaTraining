package com.practice;

public class WhatIsNotANumberNAN {
    /**
     * ================================================================
     *                  NaN (Not a Number) in Java
     * ================================================================
     *
     * 1 What is NaN?
     * ------------------------------------------------
     * NaN stands for "Not a Number".
     * It is a special floating-point value defined by the IEEE 754 standard.
     *
     * In Java, NaN represents an undefined or unrepresentable numeric result
     * of a floating-point calculation.
     *
     * IMPORTANT:
     * - NaN exists ONLY for floating-point types (float, double)
     * - NaN does NOT exist for integer types (int, long, short, byte)
     *
     * ------------------------------------------------
     * 2 How NaN is defined in Java
     * ------------------------------------------------
     * Java provides predefined constants:
     *
     *   Double.NaN
     *   Float.NaN
     *
     * These constants represent the NaN value explicitly.
     *
     * ------------------------------------------------
     * 3 When does NaN occur in Java?
     * ------------------------------------------------
     * NaN is produced in situations such as:
     *
     * - 0.0 / 0.0
     * - Infinity - Infinity
     * - Math.sqrt(-1)
     * - Math.log(-1)
     * - Invalid floating-point operations
     *
     * NOTE:
     * Integer division by zero throws ArithmeticException
     * Floating-point division by zero may produce NaN or Infinity
     *
     * ------------------------------------------------
     * 4 Most IMPORTANT Rule about NaN
     * ------------------------------------------------
     * NaN is NOT equal to anything, including itself.
     *
     * That means:
     *   NaN == NaN  → false
     *
     * Therefore:
     * - NEVER use == to compare NaN
     * - ALWAYS use Double.isNaN() or Float.isNaN()
     *
     * ------------------------------------------------
     * 5 How to check NaN correctly
     * ------------------------------------------------
     * Use:
     *   Double.isNaN(value)
     *   Float.isNaN(value)
     *
     * ------------------------------------------------
     * 6 NaN Propagation Rule
     * ------------------------------------------------
     * Any arithmetic operation involving NaN results in NaN.
     *
     * Example:
     *   NaN + 10 → NaN
     *   NaN * 5 → NaN
     *
     * ------------------------------------------------
     * 7 Real-world usage
     * ------------------------------------------------
     * NaN is commonly used to:
     * - Represent missing sensor data
     * - Indicate invalid mathematical results
     * - Avoid crashing applications with exceptions
     *
     * ------------------------------------------------
     * 8 Interview Key Points
     * ------------------------------------------------
     * ✔ NaN follows IEEE 754
     * ✔ Only for float and double
     * ✔ NaN != NaN
     * ✔ Must use isNaN() for checking
     *
     * ================================================================
     */
    public static void main(String[] args) {
        // ----------------------------------------------------------
        // Example 1: Creating NaN using division
        // ----------------------------------------------------------

        double a = 0.0;
        double b = 0.0;

        // Dividing zero by zero results in NaN
        double result = a / b;

        // Printing the result
        System.out.println("Result of 0.0 / 0.0 = " + result); // NaN

        // ----------------------------------------------------------
        // Example 2: NaN comparison behavior
        // ----------------------------------------------------------

        // NaN is NOT equal to itself
        System.out.println("Is result == result? " + (result == result)); // false

        // Even comparing with Double.NaN using == is incorrect
        System.out.println("Is result == Double.NaN? " + (result == Double.NaN)); // false

        // ----------------------------------------------------------
        // Example 3: Correct way to check NaN
        // ----------------------------------------------------------

        if (Double.isNaN(result)) {
            System.out.println("Result is NaN (checked correctly using Double.isNaN)");
        }

        // ----------------------------------------------------------
        // Example 4: Generating NaN using Math operations
        // ----------------------------------------------------------

        double sqrtResult = Math.sqrt(-1);

        // Math.sqrt of negative number returns NaN
        System.out.println("Math.sqrt(-1) = " + sqrtResult); // NaN

        // Correct check
        if (Double.isNaN(sqrtResult)) {
            System.out.println("Square root result is NaN");
        }

        // ----------------------------------------------------------
        // Example 5: NaN propagation
        // ----------------------------------------------------------

        double value = 100.0;

        // Any arithmetic with NaN results in NaN
        double propagatedResult = value + result;

        System.out.println("100.0 + NaN = " + propagatedResult); // NaN

        // ----------------------------------------------------------
        // Example 6: Explicit NaN assignment
        // ----------------------------------------------------------

        double explicitNaN = Double.NaN;

        System.out.println("Explicit NaN value = " + explicitNaN); // NaN

        if (Double.isNaN(explicitNaN)) {
            System.out.println("Explicit NaN detected");
        }

        // ----------------------------------------------------------
        // Example 7: Integer vs Floating-point behavior
        // ----------------------------------------------------------

        // Integer division by zero throws exception
        // Uncommenting below line will cause ArithmeticException
        // int x = 0 / 0;

        // Floating-point division by zero does NOT throw exception
        double infinityValue = 10.0 / 0.0;
        System.out.println("10.0 / 0.0 = " + infinityValue); // Infinity

        System.out.println(Float.NaN == Float.NaN); // This will return the False
        System.out.println(Float.NaN != Float.NaN); // This will return the False
        // ----------------------------------------------------------
        // Final Summary Print
        // ----------------------------------------------------------

        System.out.println("\nSUMMARY:");
        System.out.println("NaN represents undefined numeric results");
        System.out.println("NaN is never equal to itself");
        System.out.println("Always use Double.isNaN() to check");
    }
}
