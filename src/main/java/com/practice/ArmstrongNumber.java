package com.practice;

import java.util.Scanner;

public class ArmstrongNumber {
    // An Armstrong number is a number whose sum of its digits each raised to the power of the total number of digits equals the number itself. Example: 153 = 1³ + 5³ + 3³.
    /*
    Here are 4-digit and 5-digit Armstrong numbers:
    4-digit Armstrong numbers :
    1) 1634 = 1⁴ + 6⁴ + 3⁴ + 4⁴,
    2) 8208 = 8⁴ + 2⁴ + 0⁴ + 8⁴,
    3) 9474 = 9⁴ + 4⁴ + 7⁴ + 4⁴
    5-digit Armstrong numbers :
    1) 54748 = 5⁵ + 4⁵ + 7⁵ + 4⁵ + 8⁵,
    2) 92727 = 9⁵ + 2⁵ + 7⁵ + 2⁵ + 7⁵,
    3) 93084 = 9⁵ + 3⁵ + 0⁵ + 8⁵ + 4⁵.
    */

    public static void armstrongNumber(int num){
        int cube = 0;
        int remainder;
        int temp;
        temp = num;
        int length = (int) Math.log10(num) + 1;
        while (num > 0){
            remainder = num % 10;
            num = num / 10;
            cube = (int) (cube + (Math.pow(remainder, length)));
        }
        if(temp == cube){
            System.out.println(temp+" This is an Armstrong Number");
        }else {
            System.out.println(temp+" This is not an Armstrong Number");
        }
    }
    public static void main(String[] args) {
        System.out.println("Type any positive whole number");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        armstrongNumber(value);

    }
}
