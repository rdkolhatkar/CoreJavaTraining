package com.practice;

public class AlphabetPatternProblems {
    public static void main(String[] args) {
/*
    Question:
    Write a Java program to print the following alphabet pattern:
    A
    A B
    A B C
    A B C D
    .
    .
    .
    A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
*/
        int rows = 26; // Number of alphabets (A to Z)
        // Outer loop for rows
        for (int i = 1; i <= rows; i++) {
            char ch = 'A';
            // Inner loop to print alphabets
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            // Move to next line
            System.out.println();
        }
        System.out.println("*************************************************************");
/*
    Question:
    Write a Java program to print the reverse alphabet pattern.
    Output:
    A B C
    A B
    A
*/
        int rowsCount = 26;   // change this to 26 for full A-Z pattern
        // Outer loop for rows (reverse order)
        for (int i = rowsCount; i >= 1; i--) {
            char ch = 'A';
            // Inner loop to print alphabets
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
        System.out.println("*************************************************************");
/*
    Question:
    Write a Java program to print the reverse alphabet pattern in mirror image form.
    Output:
        A B C
          A B
            A
*/
        int rowsNum = 3;   // change to 26 if needed

        // Outer loop for rows
        for (int i = rowsNum; i >= 1; i--) {

            // Print leading spaces for mirror image
            for (int space = 1; space <= rowsNum - i; space++) {
                System.out.print("  ");
            }

            char ch = 'A';

            // Print alphabets
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }

            System.out.println();
        }
        System.out.println("*************************************************************");
/*
    Question:
    Write a Java program to print the following alphabet pattern:
    C B A
       B A
          A
*/
        int rowsVal = 26;

        // Outer loop for rows
        for (int i = rowsVal; i >= 1; i--) {
            // Print leading spaces (3 spaces per shift)
            for (int space = 1; space <= rowsVal - i; space++) {
                System.out.print("   ");
            }
            // Print alphabets in reverse order
            char ch = (char) ('A' + i - 1);
            for (int j = i; j >= 1; j--) {
                System.out.print(ch + " ");
                ch--;
            }
            // Move to next line
            System.out.println();
        }
        System.out.println("*************************************************************");
/*
    Question:
    Write a Java program to print the following alphabet pattern using ASCII values:
    C B A
       B A
          A
*/
        int rowsValue = 3;
        // Outer loop for rows
        for (int i = rowsValue; i >= 1; i--) {
            // Print leading spaces (mirror image)
            for (int space = 1; space <= rowsValue - i; space++) {
                System.out.print("   ");
            }
            // ASCII value of 'A' is 65
            int ascii = 65 + i - 1;
            // Print characters using ASCII values
            for (int j = i; j >= 1; j--) {
                System.out.print((char) ascii + " ");
                ascii--; // move to previous alphabet
            }
            System.out.println();
        }
/*
ASCII VALUE EXPLANATION (WITH EXAMPLES):
1. What is ASCII?
   ASCII stands for American Standard Code for Information Interchange.
   It is a standard that assigns a unique numeric value to every character.
   Computers understand only numbers, so characters are stored as numbers.
2. Example ASCII values:
   'A' = 65
   'B' = 66
   'C' = 67
   'Z' = 90

   'a' = 97
   'z' = 122

   '0' = 48
   '9' = 57
3. Why do we use ASCII values in Java?
   - Java stores characters internally as numbers.
   - ASCII values allow us to perform mathematical operations on characters.
   - They are very useful in loops, pattern problems, and character manipulation.
   - We can easily move from one character to another using + or - operations.
4. Important point:
   Java uses Unicode internally, but ASCII values are part of Unicode,
   so ASCII-based logic works correctly in Java.
*/
        // Example 1: Character to ASCII value
        char ch = 'A';
        System.out.println("ASCII value of A: " + (int) ch); // 65

        // Example 2: ASCII value to Character
        int asciiValue = 66;
        System.out.println("Character for ASCII 66: " + (char) asciiValue); // B

        // Example 3: Using ASCII values in a loop to print A to Z
        for (int i = 65; i <= 90; i++) {
            System.out.print((char) i + " ");
        }

        System.out.println();

        // Example 4: Character increment using ASCII logic
        char letter = 'C';
        letter--; // Moves to previous ASCII value
        System.out.println("Previous character of C: " + letter); // B
    }
}
