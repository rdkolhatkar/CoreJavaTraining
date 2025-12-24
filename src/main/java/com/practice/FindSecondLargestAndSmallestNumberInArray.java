package com.practice;

import java.util.Arrays;

public class FindSecondLargestAndSmallestNumberInArray {
    public static void main(String[] args){
        int numbers[] = {-10, 24, 5, 50, -58, -88, 100, 2, 4, 28, 8};

        int largest = numbers[0];
        int smallest = numbers[0];

        // Existing logic (UNCHANGED)
        for(int i = 1; i < numbers.length; i++){
            if(numbers[i] > largest){
                largest = numbers[i];
            } else if(numbers[i] < smallest){
                smallest = numbers[i];
            }
        }

        System.out.println("\n Given Array is :: " + Arrays.toString(numbers));
        System.out.println("Largest Number is " + largest);
        System.out.println("Smallest Number is " + smallest);

        // -------- New Logic Starts Here --------

        int secondLargest = Integer.MIN_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for(int i = 0; i < numbers.length; i++){
            // For second largest
            if(numbers[i] != largest && numbers[i] > secondLargest){
                secondLargest = numbers[i];
            }

            // For second smallest
            if(numbers[i] != smallest && numbers[i] < secondSmallest){
                secondSmallest = numbers[i];
            }
        }

        System.out.println("Second Largest Number is " + secondLargest);
        System.out.println("Second Smallest Number is " + secondSmallest);
    }
}
