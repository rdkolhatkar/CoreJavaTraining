package com.practice;

public class StarPatternProblems_01 {
    public static void main(String[] args) {
    /*
      ===================== PROBLEM STATEMENT ONE =====================
      Write a Java program to print the following star (*) pattern:
      *
      **
      ***
      ****
      *****
      ******
      -------------------------------------------------------------
      Each new line should contain one more star (*) than
      the previous line.
      Total number of rows = 6
    */
        for(int i = 0; i<=5; i++){
            for(int j = 0; j<=i; j++){
                System.out.print("*"); // Print star without moving to the next line
            }
            System.out.println(); // After printing stars for one row, move to the next line.
        }
    System.out.println("##########################################################################");
    /*
      ===================== PROBLEM STATEMENT TWO =====================
      Write a Java program to print the following reverse star pattern:
      *****
      ****
      ***
      **
      *
      -------------------------------------------------------------
      The program should:
      1. Start by printing 5 stars (*) in the first row.
      2. Reduce the number of stars by 1 in each next row.
      3. Stop when only 1 star is printed.
      Total number of rows = 5
      =============================================================
    */
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    System.out.println("##########################################################################");
        System.out.println("Same above problem but with different approach");
        for (int i = 0; i <= 5; i++) {
            for (int j = 5; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    System.out.println("##########################################################################");
    /*
      ============================ PROBLEM STATEMENT THREE ============================
      Write a Java program to print the following star (*) pattern:
      *
      **
      ***
      ****
      *****
      ******
      ****
      ***
      **
      *
      ----------------------------------------------------------------------------
      The pattern is divided into TWO logical parts:
      PART 1: Increasing Star Pattern
      - Start with 1 star in the first row.
      - Increase the number of stars by 1 in each next row.
      - Continue until 6 stars are printed.
      PART 2: Decreasing Star Pattern
      - Immediately after Part 1, start printing stars in reverse order.
      - Start with 4 stars.
      - Decrease the number of stars by 1 in each next row.
      - Stop when only 1 star is printed.
      ----------------------------------------------------------------------------
      Important Points:
      - Use nested loops.
      - Do not hard-code the pattern using strings.
      - Use System.out.print() to print stars on the same line.
      - Use System.out.println() to move to the next line.
       ===========================================================================
    */
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 4; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    System.out.println("##########################################################################");
    /*
      ============================ PROBLEM STATEMENT ============================
      Write a Java program to print the following FULL DIAMOND star (*) pattern:
         *
        ***
       *****
      *******
     *********
      *******
       *****
        ***
         *
      ----------------------------------------------------------------------------
      The pattern should be symmetric from left to right and top to bottom.
      The total number of rows in the upper half (including middle) is 5.
      ----------------------------------------------------------------------------
      Pattern Rules:
      1. First part prints the upper half of the diamond (including middle row).
      2. Second part prints the lower half of the diamond.
      3. Spaces are printed before stars to keep the diamond shape.
      4. The number of stars increases by 2 in each row in the upper half.
      5. The number of stars decreases by 2 in each row in the lower half.
      ============================================================================
     */
        int rows = 5; // Number of rows for upper half (middle included)
        for (int i = 1; i <= rows; i++) {
            for (int space = rows - i; space >= 1; space--) {
                System.out.print(" ");
            }
            for (int star = 1; star <= (2 * i - 1); star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = rows - 1; i >= 1; i--) {
            for (int space = rows - i; space >= 1; space--) {
                System.out.print(" ");
            }
            for (int star = 1; star <= (2 * i - 1); star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
