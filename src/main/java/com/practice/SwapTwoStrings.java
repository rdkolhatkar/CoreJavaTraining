package com.practice;

public class SwapTwoStrings {
    public static void main(String[] args){
        String a = "Hello";
        String b = "World";
        System.out.println("Before Swapping");
        System.out.println("The value of String a is : "+a);
        System.out.println("The value of String b is : "+b);
        System.out.println("After Swapping");
        // Step 1 append a and b Strings & store it in a
        a = a+b; //HelloWorld
        // Step 2 Store initial string a in string b
        b = a.substring(0, a.length()-b.length());
        // Step 3 Store initial string b in string a
        a = a.substring(b.length());
        System.out.println("The value of String a after swapping is : "+a);
        System.out.println("The value of String b after swapping is : "+b);
    }
}
