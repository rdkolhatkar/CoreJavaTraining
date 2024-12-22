package com.training;
import java.util.*;

/**
 Write a Java program to count the consonants and vowels present in the input string.
 The string may contain numeric characters,
 and only lowercase letters are allowed in the input string.
*/

public class CountVowelConst {
    // the following method checks whether the
// character chr is a vowel or a consonant
    public static boolean isVowelChar(char chr)
    {
        // an array that contains only vowels
        char charArr[] = new char[5];
        charArr[0] = 'a';
        charArr[1] = 'e';
        charArr[2] = 'i';
        charArr[3] = 'o';
        charArr[4] = 'u';

        for(int g = 0; g < 5; g++)
        {
            if(chr == charArr[g])
            {
                return true;
            }
        }

        // if the control reaches here then it means
        // the character is not vowel
        return false;
    }

    // main method
    public static void main(String argvs[])
    {

        Scanner scnr = new Scanner(System.in);
        String strng = scnr.nextLine();

        int vCount = 0;
        int cCount = 0;

        for(int i = 0; i < strng.length(); i++)
        {
            char chr = strng.charAt(i);
            if(isVowelChar(chr) == true)
            {
                vCount = vCount + 1;
            }

            // for consonent it is necessary for the character to be an alphabet
            else if(chr >='a' && chr <='z' && (isVowelChar(chr) == false))
            {
                cCount = cCount + 1;
            }
        }

        System.out.println("Count of vowels in the String : '" + strng + "' is: " + vCount);
        System.out.println("Count of consonants in the String : '" + strng + "' is: " + cCount);
        System.out.println("Count of other characters in the String : '" + strng + "' is: " + (int)(strng.length() - vCount - cCount));
    }
}
