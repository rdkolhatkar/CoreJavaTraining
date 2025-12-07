package com.practice;

import java.util.Scanner;

public class CheckStringContainsTheDigits {

    // Method 1: Check if string is NULL, EMPTY, or only WHITESPACE
    public static boolean checkIfStringIsEmpty(CharSequence input) {

        // input == null → No string object exists
        // input.length() == 0 → empty string ""
        // input.toString().trim().isEmpty() → only spaces "   "
        if (input == null || input.length() == 0 || input.toString().trim().isEmpty()) {
            System.out.println("String is null or empty. Please enter a valid non-empty string.");
            return true; // Return true → String is invalid
        }

        return false; // Return false → String is valid
    }

    // Method 2: Analyze numeric characters in the string
    public static void isNumericValuePresentInsideTheString(CharSequence input) {

        String str = input.toString();

        // Step 1: Check if the entire string is numeric

        boolean isFullyNumeric = true;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isFullyNumeric = false;
                break;
            }
        }

        if (isFullyNumeric) {
            System.out.println("The entire string contains only numeric values.");
            System.out.println("Original String: " + str);
            return;
        }

        // Step 2: Check for digits at specific indexes
        boolean containsNumeric = false;
        StringBuilder numericIndexes = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                containsNumeric = true;
                numericIndexes.append(i).append(" "); // store indexes
            }
        }

        // Step 3: Print result based on which condition is true

        if (containsNumeric) {
            System.out.println("In the given string \"" + str + "\", numeric values are present at these indexes:");
            System.out.println(numericIndexes.toString());
        } else {
            System.out.println("There are no numeric characters present in the given string.");
            System.out.println("Original String: " + str);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        CharSequence input = sc.nextLine(); // User input as CharSequence

        // METHOD 1: First check if the string is null/empty/blank
        if (checkIfStringIsEmpty(input)) {
            // If this condition is true, method already printed message
            return;
        }else {
            // METHOD 2: Check numeric conditions inside the string
            isNumericValuePresentInsideTheString(input);
        }
        sc.close();
    }
}
