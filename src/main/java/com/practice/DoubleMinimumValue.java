package com.practice;

public class DoubleMinimumValue {
    /*
        What is the value of double MIN_VALUE?
        Which one is bigger -> Double MIN_VALUE or 0.0d ?
        Which one is bigger -> Double MIN_VALUE or NEGATIVE_INFINITY ?
    */
    public static void main(String[] args) {
        System.out.println(Double.MIN_VALUE); // It will give you positive Value
        System.out.println(Long.MIN_VALUE); // It will give the Negative value
        System.out.println(Integer.MIN_VALUE); // It will also give the Negative number
        System.out.println(Float.MIN_VALUE); // It will give us the positive number
        System.out.println(Math.min(Double.MIN_VALUE, 0.0d)); // Here 0.0d is less than Double.MIN_VALUE
        System.out.println(Math.min(Long.MIN_VALUE, 0.0d)); // Here 0.0d is greater than the Long.MIN_VALUE
        System.out.println(Math.min(Integer.MIN_VALUE, 0.0d)); // Here 0.0d is greater than the Integer.MIN_VALUE
        System.out.println(Math.min(Float.MIN_VALUE, 0.0d));// Here 0.0 is less than Float.MIN_VALUE
        System.out.println(Math.min(Double.MIN_VALUE, Double.NEGATIVE_INFINITY)); // Here Double.NEGATIVE_INFINITY is smaller than Double.MIN_VALUE

         /*
        ======================= IMPORTANT CONCEPT =======================

        MIN_VALUE MEANS DIFFERENT THINGS FOR:
        - Floating-point types (double, float)
        - Integer types (int, long)

        ---------------------------------------------------------------
        Floating-point types (double, float):
        - MIN_VALUE = smallest POSITIVE non-zero value
        - NOT the most negative value ❗

        Integer types (int, long):
        - MIN_VALUE = most NEGATIVE value
        ---------------------------------------------------------------

        This confusion is VERY COMMON in interviews and real projects.
    */

        /*
            ================= DOUBLE.MIN_VALUE =================

            Double.MIN_VALUE = 4.9E-324 (approximately)

            ✔ It is POSITIVE
            ✔ It is the smallest value greater than 0
            ❌ It is NOT negative

            Why?
            Because double follows IEEE 754 floating-point standard.
        */
            System.out.println(Double.MIN_VALUE);

        /*
            ================= LONG.MIN_VALUE =================

            Long.MIN_VALUE = -9223372036854775808

            ✔ It is NEGATIVE
            ✔ It is the smallest possible long value
        */
            System.out.println(Long.MIN_VALUE);

        /*
            ================= INTEGER.MIN_VALUE =================

            Integer.MIN_VALUE = -2147483648

            ✔ It is NEGATIVE
            ✔ It is the smallest possible int value
        */
            System.out.println(Integer.MIN_VALUE);

        /*
            ================= FLOAT.MIN_VALUE =================

            Float.MIN_VALUE = 1.4E-45 (approximately)

            ✔ It is POSITIVE
            ✔ Smallest positive non-zero float value
            ❌ NOT negative
        */
            System.out.println(Float.MIN_VALUE);

        /*
            ================= COMPARISONS =================
        */

        /*
            Comparing Double.MIN_VALUE and 0.0d

            Double.MIN_VALUE = +4.9E-324
            0.0d            = 0

            ✔ 0.0 is SMALLER than Double.MIN_VALUE

            So Math.min returns 0.0
        */
            System.out.println(Math.min(Double.MIN_VALUE, 0.0d));

        /*
            Comparing Long.MIN_VALUE and 0.0d

            Long.MIN_VALUE = -9223372036854775808
            0.0            = 0

            ✔ Long.MIN_VALUE is SMALLER

            So Math.min returns Long.MIN_VALUE
        */
            System.out.println(Math.min(Long.MIN_VALUE, 0.0d));

        /*
            Comparing Integer.MIN_VALUE and 0.0d

            Integer.MIN_VALUE = -2147483648
            0.0               = 0

            ✔ Integer.MIN_VALUE is SMALLER

            So Math.min returns Integer.MIN_VALUE
        */
            System.out.println(Math.min(Integer.MIN_VALUE, 0.0d));

        /*
            Comparing Float.MIN_VALUE and 0.0

            Float.MIN_VALUE = +1.4E-45
            0.0             = 0

            ✔ 0.0 is SMALLER

            So Math.min returns 0.0
        */
            System.out.println(Math.min(Float.MIN_VALUE, 0.0d));

        /*
            Comparing Double.MIN_VALUE and Double.NEGATIVE_INFINITY

            Double.NEGATIVE_INFINITY = infinitely small value

            ✔ NEGATIVE_INFINITY is ALWAYS smaller than any number

            So Math.min returns NEGATIVE_INFINITY
        */
            System.out.println(Math.min(Double.MIN_VALUE, Double.NEGATIVE_INFINITY));
    }
}
