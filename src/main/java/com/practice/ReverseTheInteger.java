package com.practice;

public class ReverseTheInteger {
    public static void main(String[] args){

        // Solution 1
        long num = 123456789;
        long reverseNumber = 0;
        while(num != 0){
            reverseNumber = reverseNumber * 10 + num % 10;
            num = num / 10;
        }
        System.out.println("Reverse Number is :: "+ reverseNumber);

        // Solution 2
        long number = 123456789;
        System.out.println(new StringBuffer(String.valueOf(number)).reverse());
    }
}
