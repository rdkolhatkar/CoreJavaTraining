package com.practice;

public class ReverseTheNumberUsingRecursion {
    public static void reverseNumberUsingRecursion(int number){
        if(number < 10){
            System.out.print(number);
            return;
        } else {
            System.out.print(number%10); // 123 % 10 = 3
            reverseNumberUsingRecursion(number/10);
            // 123 / 10 = 12.3 but as our data type is int it will skip the value after decimal.
            // When this 'reverseNumberUsingRecursion' function will call itself again then this time input will be 12.
        }
    }

    public static void reverseNumberWithRecursion(long number){
        if(number < 10){
            System.out.print(number);
            return;
        } else {
            System.out.print(number%10); // 123 % 10 = 3
            reverseNumberWithRecursion(number/10);
            // 123 / 10 = 12.3 but as our data type is long it will skip the value after decimal.
            // When this 'reverseNumberWithRecursion' function will call itself again then this time input will be 12.
        }
    }
    public static void main(String[] args) {
        reverseNumberUsingRecursion(123);
        System.out.println();
        reverseNumberWithRecursion(8346284009911204760l);
    }
}
