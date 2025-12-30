package com.practice;

public class AdditionOfPrimitiveDataTypes {
    public static void main(String[] args) {
/*
    What will be the out put of the following expression
    (byte) + (char) - (int) + (long) -1
*/
        int i = (byte) + (char) - (int) + (long) -1; // Here answer is 1
        System.out.println("Addition of the expression { int i = (byte) + (char) - (int) + (long) -1;} is " + i);
        System.out.println("*********************************************");
        float j = (byte) + (char) - (int) + (long) -1; // Here answer is 1.0
        System.out.println("Addition of the expression { float i = (byte) + (char) - (int) + (long) -1;} is " + j);
        System.out.println("*********************************************");
        double k = (byte) + (char) - (int) + (long) -1; // Here answer is 1.0
        System.out.println("Addition of the expression { double i = (byte) + (char) - (int) + (long) -1;} is " + k);
        System.out.println("*********************************************");
        long l = (byte) + (char) - (int) + (long) -1; // Here answer is 1
        System.out.println("Addition of the expression { long i = (byte) + (char) - (int) + (long) -1;} is " + l);

        // In all of the above expressions conversion will start from Right to left
        // First -1 will be converted to long and then it will become the int -1 but we have - (int) in above expression so it will become +1
        System.out.println("*********************************************");
/*
    Question:
    ---------
    What will be the output of the following expression?

    byte  b = 1;
    char  c = 1;
    int   i = 1;
    long  l = 1;

    int result = b + c - i + l - 1;
*/

            byte b = 1;
            char c = 1;
            int d = 1;
            long e = 1;

        /*
        Step-by-step type promotion:

        Expression:
        b + c - d + e - 1

        1️⃣ byte + char
            → both promoted to int
            → 1 + 1 = 2 (int)

        2️⃣ int - int
            → 2 - 1 = 1 (int)

        3️⃣ int + long
            → int promoted to long
            → 1 + 1 = 2 (long)

        4️⃣ long - int
            → int promoted to long
            → 2 - 1 = 1 (long)

        Final result type = long
        */

            long result = b + c - d + e - 1;
            System.out.println("Result = " + result); // 1

            // ❌ This would NOT compile without casting
            // int x = b + c - i + l - 1;

            // ✅ Correct
            int x = (int)(b + c - d + e - 1);
            System.out.println("Result as int = " + x);

    }
}
