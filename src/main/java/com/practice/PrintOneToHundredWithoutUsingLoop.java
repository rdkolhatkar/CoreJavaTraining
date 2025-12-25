package com.practice;

import java.util.stream.IntStream;

public class PrintOneToHundredWithoutUsingLoop {
    /*
        Print 1 to 100 numbers without using any loop
        There are two ways to achieve it first is using recursive function and second is using java stream
    */

    // Using recursive function
    public static void printNumbers(int num){
        if(num <= 100){
            System.out.println(num);
            num ++;
            printNumbers(num); // Here function is calling itself
        }
    }
    // Print numbers within the given range
    public static void printNumbersWithinTheRange(int startingNumber, int endingNumber){
       if(startingNumber <= endingNumber){
           System.out.println(startingNumber);
           startingNumber++;
           printNumbersWithinTheRange(startingNumber, endingNumber);
       }
    }
    // Second approach using Java Stream
    public static void printOneToHundredUsingJavaStream(int a, int b){
        IntStream.range(a, b).forEach(e -> System.out.println(e));
    }
    public static void main(String[] args) {
        printNumbers(1);
        System.out.println("********************************************************");
        printNumbersWithinTheRange(22, 67);
        System.out.println("********************************************************");
        printOneToHundredUsingJavaStream(1, 101);
        // Here we have to give the upper limit as 101 because IntStream.range(a, b) will only print the values which are less than upper limit b
    }
}
