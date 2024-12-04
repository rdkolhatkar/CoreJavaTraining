package com.training;
import java.util.Scanner;
/**
 * Calculate how many times a digit D occurs in the number N. One has to ask the user to give the values of N and D.
 */
public class OccurrenceOfDigitsInGivenNumber {
    // method for counting the number of digits in number n
    public static int cntDig(int n, int d)
    {
    // if d and n both are single digit number
    // and d and n both are having value 0.
        if(n == 0 && d == 0)
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
            int dig = n % 10;
            if(dig == d)
            {
                cnt = cnt + 1;
            }
            n = n / 10;

        }

        return cnt;

    }
    // main method
    public static void main(String argvs[])
    {
        Scanner scnr = new Scanner(System.in);
        int N = scnr.nextInt();
        int D = scnr.nextInt();

        System.out.println("The total count of digit " + D + " occurring in the number " + N + " is: " + cntDig(N,D));
    }
}
