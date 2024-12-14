package com.training;
import java.util.*;

/**
 Print reverse array in Java using recursion for the given input array without using any extra space.
 Ignore the implicit stack used in recursion for computing the space complexity.
 */
public class ReverseArrUsingRec {
    public static void revArr(int arr[], int size, int i)
    {
    // handling the base case
        if(i >= size)
        {
            return;
        }

    // recursively printing the input array
    // in the reverse order
        revArr(arr, size, i + 1);
        System.out.print(arr[i] + " ");

    }

    // main method
    public static void main(String argvs[])
    {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int intArr[] = new int[n];

    // user to enter the elements
        for(int i = 0; i < n; i++)
        {
            intArr[i] = scn.nextInt();
        }

        System.out.println("The input array is:");

    // loop for displaying the input array
        for(int it = 0; it < intArr.length; it++)
        {
            System.out.print(intArr[it] + " ");
        }
        System.out.println(" \n");

        System.out.println("The reversed array is:");

        revArr(intArr, intArr.length, 0);

    }
}
