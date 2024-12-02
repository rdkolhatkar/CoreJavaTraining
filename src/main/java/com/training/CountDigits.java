package com.training;

import java.util.Scanner;

/**
 Write a Java program for counting the digits present in a number.
If we take a number 5647, we find that the number consists of 4 digits that are 5, 6, 4, and 7.
When can find the total number of digits present in a number by consistently dividing the given number by 10
using a loop, till it becomes zero. In the loop, we keep incrementing a counter in each iteration.

Observe the implementation in the following code.
*/
public class CountDigits {

    // method for counting the number of digits in number n
    public static int cntDig(int n)
    {
    // The number 0 has the 1 dig.
        if(n == 0)
        {
            return 1;
        }

        if(n < 0)
        {
            n = -n;
        }
        int cnt = 0;
        while(n != 0)
        {
            n = n / 10;
            cnt = cnt + 1;
        }

        return cnt;

    }
    // main method
    public static void main(String argvs[])
    {
        System.out.println("Write The number for which you want to count digits present in it: ");
        Scanner scnr = new Scanner(System.in);
        int N = scnr.nextInt();

        System.out.println("The total digits in number " + N + " are: " + cntDig(N));
    }
}
