package com.practice;

public class PrintOneToHundredWithoutUsingNumbers {
    /*
        1) Print numbers from 1 to 100 Sequentially without using any integer value in your code
        2) Do not use numbers in your code, but we can use the integer datatype
    */

    public static void main(String[] args) {
        // 1) First Solution
        int one = 'A'/'A'; // As we are dividing the same letter by itself then result will be 1
        String str = ".........."; // Giving the 10 dots for length of 10 in the string
        for(int i = one; i <= (str.length() * str.length()); i++){ // Multiplying 10 * 10 by str.length() * str.length()
            System.out.println(i);
        }
        System.out.println("******************************************************");
        // 2) Second Solution is Using ASCII values
        /*
        In Java, ASCII values are simply the numeric codes used to represent characters.
        Every character has an integer value internally, and Java can print or convert these using char ↔ int conversion.
        Java uses Unicode, but for English letters and digits, their values match ASCII.
        */
        // ASCII values of letter small d i.e 'd' is 100
        for(int i = one; i <= 'd'; i+=one){
            System.out.println(i);
        }

    }
}
