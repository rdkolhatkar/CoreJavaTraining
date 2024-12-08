package com.training;

import java.util.Scanner;

/**
 A string is given. Our task is to write a Java program to toggle the characters of the given string.
 For example, for the string "jaVaTpoiNt", the string after the toggle will be "JAvAtPOInT".
 It is a well-known fact that strings are immutable in Java. Therefore, it is required to create a new string.
 For toggling, we can use ASCII value, 'a' can be converted to 'A' by 'A' = 'a' - 32.
 Code For Toggling the Cases.
*/

public class ToggleString {
    // main method
    public static void main(String argvs[])
    {
        // taking input from the user
        Scanner scnnr = new Scanner(System.in);
        String strng = scnnr.nextLine();
        StringBuilder result = new StringBuilder("");

        for(int i = 0; i < strng.length(); i++)
        {
            char chr = strng.charAt(i); //current character

            // make the capital letter, small letter
            if(chr >='A' && chr <= 'Z')
            {
                result.append((char)(chr + 32));
            }
            // make the small letter, the capital letter
            else if(chr >='a' && chr <= 'z')
            {
                result.append((char)(chr - 32));
            }
            // taking care of the cases when the character
            // is not the letter
            else
            {
                result.append(chr);
            }
        }

        String answer = result.toString();

        // displaying the answer on the console
        System.out.println("After toggling, the string " + strng + " becomes: " + answer);
    }
}
