package com.practice;

public class ReverseTheInteger {
    public static void main(String[] args){

        int num = 123456789;
        int reverseNumber = 0;
        while(num != 0){
            reverseNumber = reverseNumber * 10 + num % 10;
            num = num / 10;
        }
        System.out.println("Reverse Number is :: "+ reverseNumber);
    }
}
