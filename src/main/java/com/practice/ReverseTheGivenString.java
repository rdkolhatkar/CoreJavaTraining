package com.practice;

import java.util.Scanner;

// Reverse the Given String
public class ReverseTheGivenString {
    public static void main(String[] args){
        System.out.println("Write any String for input : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        // 1st Solution
        int inputLength = input.length();
        String reverseString = "";
        for(int i = inputLength-1; i>=0; i--){
            reverseString = reverseString + input.charAt(i);
        }
        System.out.println(reverseString);
        // 2nd Solution
        StringBuffer stringBuffer = new StringBuffer(input);
        System.out.println(stringBuffer.reverse());
    }
}
