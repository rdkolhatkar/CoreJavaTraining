package com.training;

import java.util.Scanner;

/**
 Write a Java program for printing all the unique characters present in a String.
 For instance, for the string "pppdaf", print characters 'd', 'a', and 'f' since they are unique.
 The character 'p' is coming thrice in the program.
 Hence, it is not printed. It is given only small letters are present in the input string.
 We can create an integer array of the size 256 as there are 256 characters present in the input string.
 Now, we count the frequency of occurrence of every character present in the input string and update the integer array accordingly.
 Now iterate over the integer array to check which element has the value 1.
 The character corresponding to that element index is printed on the console.
 Note that the 0th index of the array maps to 'a', the 1st index maps to 'b', and so on.
 */
public class UniqueChar {
    public static String findUniqueChar(String inputStr)
    {
        // integer array for storing the frequency of characters
        int arr[] = new int[256];

        for(int j = 0; j < inputStr.length(); j++)
        {
            // count frequency of characters of the input string
            char ch = inputStr.charAt(j);
            arr[ch - 'a'] = arr[ch - 'a'] + 1;
        }

        String str = "";
        for(int i = 0; i < 256; i++)
        {
            if(arr[i] == 1)
            {
                // creating the string that only contains the unique characters
                str = str + ((char)(i + 'a'));
            }
        }

        // returning the resultant string
        return str;
    }

    // main method
    public static void main(String argvs[])
    {
        // Your code goes here
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        String s = findUniqueChar(str);
        if(s.length() == 0)
        {
            System.out.println("There is no unique characters present in the string: '" + str + "'");
        }
        else
        {
            System.out.println("The unique characters present in the string: '" + str + "' are: ");
            for(int i = 0; i < s.length(); i++)
            {
                System.out.print(s.charAt(i) + " ");
            }
        }
    }
}
