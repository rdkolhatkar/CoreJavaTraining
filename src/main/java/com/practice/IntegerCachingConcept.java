package com.practice;

public class IntegerCachingConcept {
    /*
        Compare two integer numbers (Integer Caching Concept)
        Integer Caching range is from -128 to 127
    */

    /*
        The Integer Caching concept in Java is a performance optimization used by the JVM to reduce memory usage and improve speed when dealing with commonly used integer values.
        Java caches Integer objects for a specific range of values so that the same object instance is reused instead of creating new ones again and again.
        Default Cached Range -128 to +127 This range is defined by the JVM specification because these values are frequently used.
        Why Does Java Cache Integers?
        -> Saves memory
        -> Improves performance
        -> Avoids creating duplicate objects
        -> Makes comparison faster for common numbers
    */


    public static void main(String[] args) {
        Integer num1 = 100;
        Integer num2 = 100;
        if(num1 == num2){
            System.out.println("Both are equal");
        }else {
            System.out.println("Both are not equal");
        }
        int a = 100;
        int b = 100;
        if(a == b){
            System.out.println("Both are equal");
        }else {
            System.out.println("Both are not equal");
        }
        System.out.println("*****************************************************************");
        Integer numOne = 290; // Here it will return that both are not equal because Integer is Wrapper class and it can do caching between range -128 to 128
        Integer numTwo = 290;
        if(numOne == numTwo){
            System.out.println("Both are equal");
        }else {
            System.out.println("Both are not equal");
        }
        int c = 190;
        int d = 190;
        if(c == d){
            System.out.println("Both are equal");
        }else {
            System.out.println("Both are not equal");
        }
        System.out.println("*****************************************************************");

        Integer v = 100;
        Integer w = 100;

        System.out.println(v == w);   // true (same cached object)

        Integer x = 200;
        Integer y = 200;

        System.out.println(x == y);   // false (different objects)

    }
}
