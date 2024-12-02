package com.training;

import java.util.Scanner;

/**
 In a Fibonacci series, the value of any term is the sum of the values of the last two terms.
 For example, if we want to compute the 3rd term of the series, then it is the sum of the 1st and the 2nd term.
 Note that the first two terms of the Fibonacci series are defined as 0 and 1. Thus, the 3rd term will be 0 + 1 = 1.
 The 4th term will be the sum of the 3rd and the 2nd terms, 1 + 1 = 2.
 The 5th term will be the sum of the 4th and the 3rd term, which is 2 + 1 = 3.
 Thus the Fibonacci series looks like the following.
 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, … (considering 1 - indexing)
 Therefore, in general, the nth term of the series can be written as
 F(n) = F(n - 1) + F(n - 2)

 Now, we can write the program for computing the nth term of the Fibonacci series as follows.
 Note that the value of n will be provided by the user.
 */

public class FibonacciSeries {

    public static void main(String args[])
    {
        System.out.println("Please enter the position (order) of the Fibonacci number you want to find:");

        Scanner scnr = new Scanner(System.in);
        int N = scnr.nextInt();
        int first = 0; // first fibonacci number
        int second = 1; // second fibonacci number

        // handling the corner cases when the N is 0 or negative. Note that we are treating this series with 1-indexing.

        if(N <= 0)
        {
            System.out.println("N can never be zero or negative");
            return;
        }

        // if the user input is either 1 or 2
        if(N == 1)
        {
            System.out.println(first);
        }
        else if(N == 2)
        {
            System.out.println(second);
        }
        else
        {
            // loop for the Nth fibonacci numbers
            int curr = 0;
            for(int j = 3; j <= N; j++)
            {
                curr = first + second;
                first = second;
                second = curr;
            }

            System.out.println("The " + N + "th Fibonacci number is: " + curr);
        }
    }

}
