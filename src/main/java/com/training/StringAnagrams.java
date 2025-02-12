package com.training;

/**
 * Two strings are given as input.
 * Write a Java program to check whether they are anagrams or not.
 * Two strings are considered anagrams if they have the same characters occurring the same number of times.
 * However, the order in which they occur may or may not be different.
 * For example: "javatpoint", and "ttaaniojvp" are considered as anagrams.
 * Each character presents in "javatpoint" are also there in "ttaaniojvp".
 * Also, the characters which are not present in "javatpoint" are also not there "ttaaniojvp".
 * We will be using HashMap to store the number of times the characters occur in the first string.
 * Note that character will be the key, and the number of times it occurs is its value.
 * After that, we will traverse the second string and start reducing the frequency of occurrence of characters stored in the HashMap.
 * If the frequency is already zero or the character is absent in the HashMap, we can say that the strings are not anagrams; else, they are anagrams.
 */
import java.util.*;
public class StringAnagrams
{

    // the following method checks whether string a1 and a2 are anagrams
    // or not. If yes, a true value is returned. Otherwise, a false value is returned
    public static boolean isStringsAnagram(String a1, String a2)
    {
// size is not the same. Hence, a false value is returned
        if(a1.length() != a2.length())
        {
            return false;
        }

// hashmap for storing the frequency of occurrence of characters
// present in the string s1
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();

        for(int g = 0; g < a1.length(); g++)
        {
            int ordrFreq = hashMap.getOrDefault(a1.charAt(g), 0);
            hashMap.put(a1.charAt(g), ordrFreq + 1);
        }

        for(int g = 0; g < a2.length(); g++)
        {
            if(!hashMap.containsKey(a2.charAt(g)) || hashMap.get(a2.charAt(g)) == 0)
            {
                return false;
            }
            else
            {
                int ordrFreq = hashMap.get(a2.charAt(g));
                hashMap.put(a2.charAt(g), ordrFreq - 1);
            }
        }

        return true;
    }

    // main method
    public static void main(String argvs[])
    {
    // taking user input
        Scanner scnr = new Scanner(System.in);
        String a1 = scnr.nextLine();
        String a2 = scnr.nextLine();

        if(isStringsAnagram(a1, a2))
        {
            System.out.println("Strings '" + a1 + "' & '" + a2 + "' are anagrams.");
        }
        else
        {
            System.out.println("Strings '" + a1 + "' & '" + a2 + "' are not anagrams.");
        }
    }
}
