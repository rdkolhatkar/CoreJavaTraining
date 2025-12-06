package com.practice;

public class FindingLengthOfInteger {
    public static void main(String[] args) {

        // 1. Using Mathematical Loop (Division Method) The most common and simplest method.
        int n = 98765;
        int count = 0;

        int temp = Math.abs(n); // handle negative numbers

        if (temp == 0) count = 1;
        else {
            while (temp > 0) {
                temp /= 10;
                count++;
            }
        }
        System.out.println(count); // 5
        System.out.println("*****************************************************************************************************");

        // 2. Using Math.log10() (Fastest Method)
        int m = 98765;

        int digits = (m == 0) ? 1 : (int) Math.floor(Math.log10(Math.abs(m))) + 1;

        System.out.println(digits); // 5
        System.out.println("*****************************************************************************************************");

        // 3. Using Repeated Multiplication, Count digits by increasing powers of 10

        int numValue = 98765;
        int length = 0;
        int multiplier = 1;

        int absolute = Math.abs(numValue);

        while (multiplier <= absolute) {
            length++;
            multiplier *= 10;
        }
        System.out.println(length); // 5
        System.out.println("*****************************************************************************************************");

        // 5. Using Recursion
        System.out.println("Using Recursion");
        System.out.println(countDigitsRec(98765)); // 5

    }
    // 5. Using Recursion
    public static int countDigitsRec(int value) {
        value = Math.abs(value);
        if (value < 10) return 1;
        return 1 + countDigitsRec(value / 10);
    }


}
