package com.practice;

public class LongNumberWithAndWithoutSuffixL {

    /*
        GOAL:
        -----
        Explain why the SAME multiplication gives DIFFERENT results
        when we use:
            1) without 'L' suffix
            2) with 'L' suffix

        IMPORTANT RULE IN JAVA (VERY IMPORTANT FOR FRESHERS):
        ------------------------------------------------------
        ➤ By DEFAULT, all integer numbers (like 100, 50, 60) are of type int
        ➤ int range = -2,147,483,648 to 2,147,483,647
        ➤ If calculation exceeds this range → INTEGER OVERFLOW occurs
        ➤ Overflow happens BEFORE assigning the result to a long variable
    */

    public static void main(String[] args) {

        /*
            CASE 1: WITHOUT 'L' SUFFIX
            --------------------------
            Expression:
                100 * 50 * 60 * 24 * 43 * 72 * 13 * 365

            STEP-BY-STEP EXPLANATION:
            -------------------------
            1. All numbers are int literals
            2. Entire calculation is done using int arithmetic
            3. The multiplication result becomes VERY LARGE
            4. int cannot store such a large value
            5. Integer OVERFLOW happens
            6. The WRONG (wrapped) value is produced
            7. That WRONG value is then assigned to long
        */
        long longNumberWithoutSuffixL = 100 * 50 * 60 * 24 * 43 * 72 * 13 * 365;

        /*
            Output explanation:
            -------------------
            Even though variable type is long,
            the DAMAGE is already done during int calculation.

            Result printed:
                -415598592  (WRONG due to overflow)
        */

        System.out.println(
                "Multiplication Result of Long number without suffix L is: "
                        + longNumberWithoutSuffixL
        );

        System.out.println("************************************************************************************");

        /*
            CASE 2: WITH 'L' SUFFIX
            -----------------------
            Expression:
                100 * 50 * 60 * 24 * 43 * 72 * 13 * 365L

            STEP-BY-STEP EXPLANATION:
            -------------------------
            1. 365L is a long literal
            2. Presence of ONE long makes ENTIRE expression long
            3. All calculations happen using long arithmetic
            4. long has a VERY LARGE range
            5. No overflow occurs
            6. Correct result is produced
        */
        long longNumberWithSuffixL = 100 * 50 * 60 * 24 * 43 * 72 * 13 * 365L;

        /*
            Output explanation:
            -------------------
            Since calculation is done using long,
            the correct value is preserved.

            Result printed:
                738318776320  (CORRECT)
        */

        System.out.println(
                "Multiplication Result of Long number with suffix L is: "
                        + longNumberWithSuffixL
        );

        /*
            FINAL TAKEAWAY (REMEMBER THIS RULE):
            -----------------------------------
            ✔ Variable type DOES NOT control calculation type
            ✔ Literal type controls calculation type
            ✔ Use 'L' when numbers can exceed int range

            BEST PRACTICE:
            --------------
            Always add 'L' early in the expression:

            Example:
                long result = 100L * 50 * 60 * 24 * 43 * 72 * 13 * 365;
        */
    }
}
