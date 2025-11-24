package com.practice;

import java.util.Scanner;

public class PalindromeNumber {
    // A palindrome number is a number which can remain same if you read it from left to write or right to left.
    // A Palindrome Number is a number that reads the same forwards and backwards (e.g., 121, 1331). Its digits mirror perfectly, so reversing it gives the exact same number.

    public static void isPalindromeNumber(int num){
        int reverse = 0;
        int sum = 0;
        int temp;
        temp = num;
        while (num > 0){
            reverse = num % 10; // getting remainder
            sum = (sum * 10) + reverse;
            num = num / 10;
        }
        System.out.println("Reversing the given number & printing it's value : "+ sum);
        if(temp == sum){
            System.out.println(temp+" This is Palindrome number");
        }else {
            System.out.println(temp+" This is not a Palindrome Number");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        System.out.println(value + " : This is your input number");
        isPalindromeNumber(value);

    }
}
