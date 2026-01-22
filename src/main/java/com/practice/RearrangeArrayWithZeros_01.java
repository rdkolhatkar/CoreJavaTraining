package com.practice;

import java.util.Arrays;

public class RearrangeArrayWithZeros_01 {
    /*
        Let say we have one Integer array int[] i = new int[]{1, 0, 2, 0, 3, 0, 0 ,0};
        Then we have to shift all Zeros to right side so that our output can become like this
        // 1, 2, 3, 0, 0, 0, 0, 0
    */
    // First Solution is Creating a Custom Method
    public static int[] shiftZeroToRight(int[] array){
        if(array.length == 1){
            return array;
        }
        int count = 0;
        int[] newArray = new int[array.length];
        for(int value : array){
            if(value != 0){
                newArray[count] = value;
                count++; // Here 'count' variable defines the index value at which 'value' will be inserted
                // For non zero value count will keep on increasing because of if condition
            }
            // When you create an integer array, all elements are automatically initialized to 0 by default.
        }
        return newArray;
    }
    // Second Solution with another custom method
    public static void shiftZeroToRightInPlace(int[] arr) {
        int index = 0;
        // Step 1: Move non-zero elements forward
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }
        // Step 2: Fill remaining positions with zero
        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }
    }
    // Third Solution using SWAP
    public static void shiftZeroBySwap(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
    public static void main(String[] args) {
        // Using first Solution
        // When you create an integer array, all elements are automatically initialized to 0 by default.
        int[] arr = new int[5];
        System.out.println(Arrays.toString(arr)); // For this Output will be like [0, 0, 0, 0, 0]
        int[] i = new int[]{1, 0, 2, 0, 3, 0, 0 ,0};
        System.out.println(Arrays.toString(shiftZeroToRight(i))); //For this Output will be like [1, 2, 3, 0, 0, 0, 0, 0]
        System.out.println("******************************************************************************");
        // Using Second Solution
        int[] arrONE = {1, 0, 2, 0, 3, 0, 0, 0};
        shiftZeroToRightInPlace(arrONE);
        System.out.println(Arrays.toString(arrONE));//For this Output will be like [1, 2, 3, 0, 0, 0, 0, 0]
        System.out.println("******************************************************************************");
        // Using Third Solution with SWAP method
        int[] arrTWO = {1, 0, 2, 0, 3, 0, 0, 0};
        shiftZeroToRightInPlace(arrTWO);
        System.out.println(Arrays.toString(arrTWO));//For this Output will be like [1, 2, 3, 0, 0, 0, 0, 0]
    }
}
