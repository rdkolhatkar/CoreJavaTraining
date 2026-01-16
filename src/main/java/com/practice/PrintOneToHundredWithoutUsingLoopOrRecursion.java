package com.practice;

import java.util.Arrays;
import java.util.BitSet;

public class PrintOneToHundredWithoutUsingLoopOrRecursion {
    /*
        Print 1 to 100 Numbers without using any loop and recursion
    */
    public static void main(String[] args) {
        // First Solution is using Arrays fill method
        Object[] num = new Object[100];
        Arrays.fill(num, new Object(){
            int count = 0;
            @Override
            public String toString(){
                return Integer.toString(++count);
            }
        });
        System.out.println(Arrays.toString(num));
        System.out.println("**********************************************************************");
        // Second Solution is using concept of BitSet class
        String set = new BitSet(){
            {
                set(1,101);
            }
        }.toString();

        System.out.append(set, 1, set.length());
    }
}
