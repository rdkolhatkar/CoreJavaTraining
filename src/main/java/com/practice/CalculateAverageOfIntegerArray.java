package com.practice;

import com.google.common.math.DoubleMath;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;

public class CalculateAverageOfIntegerArray {
    /*
        Calculate average of array using :
        1) Simple Loop
        2) Java Streams
        3) Google Guava Library
    */
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        // First Solution is using simple Loop
        System.out.println("First Solution is using enhanced for loop");
        double sumOfAllElementsInIntegerArray = 0;
        for(int e : array){
            sumOfAllElementsInIntegerArray = sumOfAllElementsInIntegerArray + e;
        }
        double average = sumOfAllElementsInIntegerArray/array.length;
        System.out.println("Average of all elements of the Integer array is : "+average);
        System.out.println("***************************************************************");
        // Second Solution is using Java Streams
        System.out.println("Second Solution is using Java Streams");
        OptionalDouble avg = Arrays.stream(array).average();
        System.out.println("Average of all elements of the Integer array is : "+avg.getAsDouble());
        System.out.println("***************************************************************");
        // Third Solution is using Google Guava
        System.out.println("Second Solution is using Google Guava");
        // DoubleMath is imported from com.google.common.math
        double finalAverage = DoubleMath.mean(array);
        System.out.println("Average of all elements of the Integer array is : "+finalAverage);
    }
}
