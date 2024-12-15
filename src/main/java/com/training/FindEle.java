package com.training;
import java.util.*;

/**
 Write a Java program for finding the index of the first as well as the last occurrence of an element
 in the array using linear time without using any extra space. Consider one indexing.
 */

public class FindEle {
    public static int[] findIndexOfReqEle(int inputArr[], int tar)
    {
// size of the input array.
        int size = inputArr.length;

// array for storing the first and the last index
        int ansArr[] = new int[2];
        ansArr[0] = -1;
        ansArr[1] = -1;

// flag for checking whether the target element
// exists or not
        boolean isEleFound = false;

// loop for searching the required element
        for(int k = 0; k < size; k++)
        {
            if(inputArr[k] == tar)
            {
                if(!isEleFound)
                {
                    // k + 1 because of the one indexing
                    ansArr[0] = k + 1;
                    ansArr[1] = k + 1;

                    // required element found for the first time
                    isEleFound = true;
                }

                else
                {
                    // required element is present in the array at least twice.
                    ansArr[1] = k + 1;
                }
            }
        }

        return ansArr;
    }

    // main method
    public static void main(String argvs[])
    {
        System.out.println("Enter size of the input array");
        Scanner scnr = new Scanner(System.in);
        int num = scnr.nextInt();
        int[] intArr = new int[num];

        System.out.println("Enter elements of the input array");

// input the array
        for(int k = 0; k < num; k++)
        {
            intArr[k] = scnr.nextInt();
        }

        System.out.println("Enter target element to be searched.");
        int targetEle = scnr.nextInt();

        int ansArr[] = findIndexOfReqEle(intArr, targetEle);



        if(ansArr[0] == -1)
        {
            System.out.println("In the input array, the element " + targetEle + " does not exist.");
        }

        else
        {
            System.out.println("For the target element: " + targetEle + ", First Index = " + ansArr[0] + " Last Index = " + ansArr[1]);
        }
    }
}
