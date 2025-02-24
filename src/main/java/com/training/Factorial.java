package com.training;

import java.util.Scanner;

/**
 * A factorial of a non-negative integer 𝑛, denoted as 𝑛!, is the product of all positive integers from 1 to 𝑛
 * n!=n×(n−1)×(n−2)×⋯×2×1
 *
 * The factorial of a number is a fundamental concept in mathematics, representing the product of all positive integers up to that number.
 * Calculating the factorial of a given number is a common problem in programming, and Java provides a straightforward way to achieve this using a while loop.
 * A factorial of a particular number (n) is the product of all the numbers from 0 to n (including n) i.e. factorial of the number 5 will be 1*2*3*4*5 = 120.
 *
 * Given a number, write a Java program to calculate the factorial using while loop.
 */
public class Factorial {
    public static void main(String args[]){
        int i =1, factorial=1, number;
        System.out.println("Enter the number to which you need to find the factorial:");
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        while(i <=number) {
            factorial = factorial * i;
            i++;
        }
        System.out.println("Factorial of the given number is: "+factorial);
    }
}
