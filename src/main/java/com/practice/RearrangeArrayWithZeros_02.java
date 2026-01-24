package com.practice;

import java.util.Arrays;

public class RearrangeArrayWithZeros_02 {
        /*
        Question:
        Given an integer array, shift all zeros to the FRONT (left side)
        while maintaining the order of non-zero elements.

        Example:
        Input  : {1, 0, 2, 0, 3, 0, 0, 0}
        Output : {0, 0, 0, 0, 0, 1, 2, 3}
    */

    // ------------------ First Solution ------------------
    // Using a new array
    public static int[] shiftZeroToFront(int[] array) {

        // Edge case: if array has only one element
        if (array.length == 1) {
            return array;
        }

        int zeroCount = 0;

        // Step 1: Count number of zeros
        for (int value : array) {
            if (value == 0) {
                zeroCount++;
            }
        }

        // Step 2: Create a new array (default values are 0)
        int[] newArray = new int[array.length];

        int index = zeroCount; // Non-zero values start after all zeros

        // Step 3: Insert non-zero values after zeros
        for (int value : array) {
            if (value != 0) {
                newArray[index] = value;
                index++;
            }
        }

        return newArray;
    }

    // ------------------ Second Solution ------------------
    // In-place without extra array
    public static void shiftZeroToFrontInPlace(int[] arr) {

        int index = arr.length - 1;

        // Step 1: Move non-zero elements from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index--;
            }
        }

        // Step 2: Fill remaining positions with zero
        while (index >= 0) {
            arr[index] = 0;
            index--;
        }
    }

    // ------------------ Third Solution ------------------
    // Using swap method
    public static void shiftZeroToFrontBySwap(int[] arr) {

        int j = arr.length - 1;

        // Traverse from right side
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    // ------------------ Main Method ------------------
    public static void main(String[] args) {

        int[] input = {1, 0, 2, 0, 3, 0, 0, 0};

        // First Solution
        System.out.println("Using New Array:");
        System.out.println(Arrays.toString(shiftZeroToFront(input)));

        System.out.println("****************************************");

        // Second Solution
        int[] arrOne = {1, 0, 2, 0, 3, 0, 0, 0};
        shiftZeroToFrontInPlace(arrOne);
        System.out.println("Using In-Place Method:");
        System.out.println(Arrays.toString(arrOne));

        System.out.println("****************************************");

        // Third Solution
        int[] arrTwo = {1, 0, 2, 0, 3, 0, 0, 0};
        shiftZeroToFrontBySwap(arrTwo);
        System.out.println("Using Swap Method:");
        System.out.println(Arrays.toString(arrTwo));
    }
}
