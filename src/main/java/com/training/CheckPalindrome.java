package com.training;

/**
 * A string is given to us.
 * Write a program to check whether the string is a palindrome or not.
 * The string can contain white spaces, small and capital letters, and other characters too.
 * Note that the program should be case-insensitive and should ignore the white space and other special characters.
 * For example, a and A will be considered the same character.
 * Also, "a&* A" is a palindrome because we ignore the &,*, and white spaces.
 * Thus, "a&* A" can be written as "aa" as 'a' and 'A' both are the same as far as this question is concerned.
 * The approach is to traverse the whole string and remove all those characters that are not alphanumeric.
 * Also, remove the white space.
 * Convert all the alphabetical letters to either small or capital letters.
 * After that, with the help of a loop, check whether the updated string is the palindrome or not.
 */
import java.util.*;

public class CheckPalindrome
{

    // a method that checks whether the string stng is a palindrome or not
    public static boolean isStrngPalindrome(String stng)
    {

// for traversing the string
// from beginning and end
        int l = 0;
        int h = stng.length() - 1;

        while(l < h)
        {
            char c1 = stng.charAt(l);
            char c2 = stng.charAt(h);

            if(c1 != c2)
            {
                return false;
            }

            l = l + 1;
            h = h - 1;
        }

        return true;
    }


    // the following method checks whether the sentence is a palindrome
// or not
    public static boolean isSntncePalindrome(String sntnce)
    {
        String reslt = "";

        for(int g = 0; g < sntnce.length(); g++)
        {
            // retrieving character at the index g
            char chr = sntnce.charAt(g);

            // only considering alphanumeric characters and ignoring the other ones
            if((chr >='a' && chr <= 'z') || (chr >= 'A' && chr <= 'Z') || (chr >= '0' && chr <= '9'))
            {
                if(chr >='A' && chr <= 'Z')
                {
                    reslt = reslt + (char)(chr + 32);
                }
                else reslt = reslt + chr;
            }

            else
            {
                // If the control reaches here
                // then it means the character is not alphanumeric
                // and therefore, we should ignore it.
                continue;
            }
        }

        if(isStrngPalindrome(reslt))
        {
            return true;
        }

        return false;
    }

    // main method
    public static void main(String argvs[])
    {

    // taking user input
        Scanner scnr = new Scanner(System.in);
        String sentnce = scnr.nextLine();

        if(isSntncePalindrome(sentnce))
        {
            System.out.println("The string '" + sentnce + "' is a palindrome.");
        }
        else
        {
            System.out.println("The string '" + sentnce + "' is not a palindrome.");
        }
    }
}
