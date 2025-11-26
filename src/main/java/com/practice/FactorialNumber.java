package com.practice;

import java.util.Scanner;

public class FactorialNumber {
    // Factorial of a number n (written as n!) is the product of all positive integers from 1 to n. Example: 5! = 5×4×3×2×1 = 120.
    // There are two solutions for this, One is with recursion and other is without recursion
    // Recursion in Java is a technique where a method calls itself to solve a problem by breaking it into smaller sub problems. It continues until it reaches a base condition that stops the calls.
    // Factorial of Zero is One

    // Non Recursive
    public static int findFactorialWithoutRecursion(int num){
        int factorial =1;
        if(num == 0){
            return 1;
        }else{
            for(int i =1; i<=num; i++){
                factorial = factorial * i;
            }
            return factorial;
        }
    }
    // With Recursive Function
    // Recursive is a function which calls itself inside the function body to solve the problem
    public static int findFactorialWithRecursion(int num){
        if(num == 0){
            return 1;
        }else {
            return (num * findFactorialWithRecursion(num - 1));
        }
    }
    public static void main(String[] args) {
        System.out.println("Type any positive real whole number");
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
//        int factorialValue = findFactorialWithoutRecursion(value);
//        System.out.println("Factorial is : "+factorialValue);
        System.out.println("Factorial is : "+findFactorialWithRecursion(value));

    }
}
