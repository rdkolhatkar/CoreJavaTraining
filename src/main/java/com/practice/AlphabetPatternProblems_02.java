package com.practice;

public class AlphabetPatternProblems_02 {
    public static void main(String[] args) {
/*
    Question:
    ---------
    Write a Java program to print alphabets in a pattern such that:
    - The first line contains 'A' printed 1 time
    - The second line contains 'B' printed 2 times
    - The third line contains 'C' printed 3 times
    - This pattern continues until 'Z' is printed 26 times
    --------------
    Example Output:
    ---------------
    A
    B B
    C C C
    D D D D
    ...
    Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z
*/

        // Loop from character 'A' to 'Z'
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            // Calculate the position of the alphabet (A=1, B=2, ..., Z=26)
            int count = ch - 'A' + 1;
            // Inner loop to print the character 'count' number of times
            for (int i = 1; i <= count; i++) {
                System.out.print(ch + " ");
            }
            // Move to the next line after printing each character pattern
            System.out.println();
        }
        System.out.println("***********************************************************************");
/*
    Question:
    ---------
    Write a Java program to print alphabets in a reverse pattern starting from 'D' to 'A'
    with increasing indentation on each line.
    Rules:
    ------
    - The first line prints 'D' 4 times without indentation
    - The second line prints 'C' 3 times with one level of indentation
    - The third line prints 'B' 2 times with two levels of indentation
    - The fourth line prints 'A' 1 time with three levels of indentation
    ---------------
    Expected Output:
    ----------------
    D D D D
        C C C
            B B
                A
*/
        char startChar = 'Z';
        // Outer loop for characters from D to A
        for (char ch = startChar; ch >= 'A'; ch--) {
            // Print indentation (4 spaces per level)
            int spaces = startChar - ch;
            for (int s = 0; s < spaces; s++) {
                System.out.print("    ");
            }
            // Number of times the character should be printed
            int count = ch - 'A' + 1;
            // Print the character pattern
            for (int i = 1; i <= count; i++) {
                System.out.print(ch + " ");
            }
            // Move to next line
            System.out.println();
        }
        System.out.println("***********************************************************************");
/*
    Question:
    ---------
    Write a Java program to print alphabets in a pattern using ASCII values such that:
    - 'A' is printed 1 time
    - 'B' is printed 2 times
    - 'C' is printed 3 times
    - This continues until 'Z' is printed 26 times
    ------------
    Concept Used:
    -------------
    ASCII values:
    - 'A' = 65
    - 'B' = 66
    - ...
    - 'Z' = 90
    By looping from ASCII 65 to 90 and converting the ASCII value to a character,
    we can print alphabet patterns.
    --------------
    Example Output:
    ---------------
    A
    B B
    C C C
    D D D D
*/
        // ASCII value of 'A' is 65 and 'Z' is 90
        for (int ascii = 65; ascii <= 90; ascii++) {
            // Convert ASCII value to character
            char ch = (char) ascii;
            // Calculate position in alphabet (A=1, B=2, ..., Z=26)
            int count = ascii - 64;
            // Print the character 'count' number of times
            for (int i = 1; i <= count; i++) {
                System.out.print(ch + " ");
            }
            // Move to next line
            System.out.println();
        }
        System.out.println("***********************************************************************");
/*
    Question:
    ---------
    Write a Java program to print alphabets in a reverse pattern using ASCII values
    with increasing indentation on each line.
    Rules:
    ------
    - Start from 'D' (ASCII 68)
    - Print 'D' 4 times with no indentation
    - Print 'C' 3 times with one indentation
    - Print 'B' 2 times with two indentations
    - Print 'A' 1 time with three indentations
    ------------
    Concept Used:
    -------------
    ASCII values:
    - 'A' = 65
    - 'B' = 66
    - 'C' = 67
    - 'D' = 68
    ---------------
    Expected Output:
    ----------------
    D D D D
        C C C
            B B
                A
*/
        int startAscii = 90; // ASCII value of 'D'
        // Loop from ASCII of 'D' to ASCII of 'A'
        for (int ascii = startAscii; ascii >= 65; ascii--) {
            // Print indentation (4 spaces per level)
            int spaces = startAscii - ascii;
            for (int s = 0; s < spaces; s++) {
                System.out.print("    ");
            }
            // Convert ASCII value to character
            char ch = (char) ascii;
            // Calculate how many times the character should be printed
            int count = ascii - 64;
            // Print the character pattern
            for (int i = 1; i <= count; i++) {
                System.out.print(ch + " ");
            }
            // Move to next line
            System.out.println();
        }
    }
}
