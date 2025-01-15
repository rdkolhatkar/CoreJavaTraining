package com.training;

/**
 * Two binary strings are given to us.
 * Write a Java program to add the given binary string as per the binary addition rules
 * and display the resulting binary string.
 * Note that input strings only contain 0s and 1s and nothing else.
 * Rules for the binary addition are mentioned below.
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * 0 + 0 = 0
 * 0 + 1 = 1
 * 1 + 0 = 1
 * 1 + 1 = 0 & c = 1
 * It is evident by looking at the fourth rule that whenever the result exceeds 1,
 * the answer of addition becomes zero, and carry is 1.
 * shows that whenever the result exceeds 1,
 * the answer of addition becomes 0 and carry becomes 1.
 * Using these four rules,
 * we will do the addition starting from the rightmost index and will move towards the first or the leftmost index.
 * The illustration of it is mentioned in the following program.
 */

import java.util.*;
public class AddBinaryStrings
{

    // adding the binary strings
    public static String addStrings(String s1, String s2)
    {
        String resultantStr = "";

        if(s1.equals("0") && s2.equals("0"))
        {
            return "0";
        }

// size of the input strings
        int p = s1.length() - 1;
        int q = s2.length() - 1;

        int cary = 0;

// loop that does the binary addition
// by addiing digits from right to left
        while(p >= 0 || q >= 0 || cary > 0)
        {

            int dig1 = (p >= 0) ? (s1.charAt(p) - '0') : 0;
            int dig2 = (q >= 0) ? (s2.charAt(q) - '0') : 0;

            int digit = 0;
            if(dig1 + dig2 + cary >= 2)
            {
                digit = (dig1 + dig2 + cary) % 2;

                // handling carry
                cary = (dig1 + dig2 + cary) / 2;
            }
            else
            {
                digit = dig1 + dig2 + cary;
                cary = 0;
            }

            p = p - 1;
            q = q - 1;
            resultantStr  = digit + resultantStr;
        }

    // returning the final string
        return resultantStr;
    }

    // main method
    public static void main(String argvs[])
    {
// taking input from the user
        Scanner scnr = new Scanner(System.in);
        String s1 = scnr.nextLine();
        String s2 = scnr.nextLine();

        System.out.println("The addition of binary strings is: " + addStrings(s1, s2));
    }
}
