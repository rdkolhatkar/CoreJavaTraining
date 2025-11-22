package com.practice;

import java.util.Scanner;

public class FindPrimeNumbers {
    /*
    A prime number is a number that can only be divided by itself and 1 without remainders.
    The prime numbers from 1 to 100 are: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97.
    1 and 0 are not the prime numbers & 2 is the lowest prime number
    */

    public static boolean isPrimeNumber(int num){
        if(num <= 1){
            return false;
        }
        for(int i = 2; i<num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void getPrimeNumbersFromGivenRange(int a, int b){
        for(int i = a; i <= b; i++){
            if(isPrimeNumber(i)){
                System.out.println(i +" ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a Positive Whole Number");
        int number = scan.nextInt();

        if (isPrimeNumber(number)) {
            System.out.println("The given number " + number + " is a Prime number");
        } else {
            System.out.println("The given number " + number + " is Not a Prime number");
        }
        System.out.println("Enter the first number or starting point of the range of numbers");
        int startingPoint = scan.nextInt();
        System.out.println("Enter the last number or ending point of the range of numbers");
        int endingPoint = scan.nextInt();
        System.out.println("Your range starts from number "+startingPoint+" Your range ends with number "+endingPoint);
        System.out.println("Prime number present inside your given range are : ");
        getPrimeNumbersFromGivenRange(startingPoint, endingPoint);
    }

}
