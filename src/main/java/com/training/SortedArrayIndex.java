package com.training;

/**
 * You are given a sorted array of unique integers.
 * It is given that each element in the array is unique.
 * Also, an element is given.
 * Write a Java program to find the index of the element present in the array.
 * If the element is not present in the array,
 * then find the index where it should be put in the array so that the array remains sorted even after putting the element.
 * Note that the program should be optimized in terms of space and time complexity.
 * Consider zero indexing.
 * It is given in the problem that the array is sorted.
 * So, the best approach is to apply the binary search.
 * The following code is an illustration of it.
*/

public class SortedArrayIndex {
    public static int findIndex(int[] numsArr, int tar)
    {
        int l = 0;
        int h = numsArr.length - 1;

// loop that applies the binary search
        while(l <= h)
        {
            int middle = l + (h - l) / 2;

// if the element is found
// we can return its index
            if(numsArr[middle] == tar)
            {
                return middle;
            }

// if the target element is larger than
// the numsArr[middle] element, consider the right part of the array
// from the index middle
            else if(numsArr[middle] < tar)
            {
                l = middle + 1;
            }

// if the target element is less than
// the numsArr[middle] element, consider the left part of the array
// from the index middle
            else
            {
                h = middle - 1;
            }
        }

        return l; // ceiling index is considered
    }


    // main method
    public static void main(String argvs[])
    {
// input array
        int[] inputArr = {2, 6, 9, 13, 24, 35, 78, 90, 99};
        int size = inputArr.length;

        System.out.println("For the input array: ");
        for(int j = 0; j < size; j++)
        {
            System.out.print(inputArr[j] + " ");
        }

        int tar = 7;
        int ans = findIndex(inputArr, tar);
        System.out.println();

        System.out.println("The index of the target element " + tar + " is: " + ans);

        System.out.println(" \n ");

    // input array
        int[] inputArr1 = {-3, 5, 24, 40, 51, 80, 89, 97};
        size = inputArr1.length;

        System.out.println("For the input array: ");
        for(int j = 0; j < size; j++)
        {
            System.out.print(inputArr1[j] + " ");
        }

        tar = 51;
        ans = findIndex(inputArr1, tar);
        System.out.println();

        System.out.println("The index of the target element " + tar + " is: " + ans);

    }
}
