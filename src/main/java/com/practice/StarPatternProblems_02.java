package com.practice;

public class StarPatternProblems_02 {
    public static void main(String[] args) {
/*
    Question:
    Write a Java program to make the mirror image and print the following star (*) pattern:
    *
    **
    ***
    ****
    *****
    ******
    Mirror Image Output:
         *
        **
       ***
      ****
     *****
    ******
*/
        // First solution
        System.out.println("First Solution");
        for(int i = 1; i<= 6; i++){
            for(int j = 5; j>=i; j-- ){
                System.out.print(" ");
            }
            for (int k = 1; k<=i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("Second Solution");
        // Second solution
        int rows = 6;
        // Outer loop for number of rows
        for (int i = 1; i <= rows; i++) {
            // Inner loop to print spaces
            for (int space = 1; space <= rows - i; space++) {
                System.out.print(" ");
            }
            // Inner loop to print stars
            for (int star = 1; star <= i; star++) {
                System.out.print("*");
            }
            // Move to next line
            System.out.println();
        }
        System.out.println("###################################################################");
/*
    Question:
    Write a Java program to print a pyramid star (*) pattern.
    Output:
         *
        ***
       *****
      *******
     *********
*/
        int rowsCount = 5;

        // Outer loop for rows
        for (int i = 1; i <= rowsCount; i++) {

            // Print spaces
            for (int space = 1; space <= rowsCount - i; space++) {
                System.out.print(" ");
            }

            // Print stars (odd number: 2*i - 1)
            for (int star = 1; star <= (2 * i - 1); star++) {
                System.out.print("*");
            }

            // Move to next line
            System.out.println();
        }
        System.out.println("###################################################################");
/*
    Question:
    Write a Java program to print the following star (*) pattern:
          *
         * *
        * * *
       * * * *
      * * * * *
     * * * * * *
*/
        // First Solution for
        System.out.println("First Solution");
        for(int i = 1; i<= 6; i++){
            for(int j = 5; j>=i; j-- ){
                System.out.print(" ");
            }
            for (int k = 1; k<=i; k++){
                System.out.print(" *");
            }
            System.out.println();
        }
        // Second Solution
        System.out.println("Second Solution");
        int rowsNum = 6;

        // Outer loop for rows
        for (int i = 1; i <= rowsNum; i++) {

            // Print leading spaces
            for (int space = 1; space <= rowsNum - i; space++) {
                System.out.print(" ");
            }

            // Print stars with space after each star
            for (int star = 1; star <= i; star++) {
                System.out.print("* ");
            }

            // Move to next line
            System.out.println();
        }

    }


}

