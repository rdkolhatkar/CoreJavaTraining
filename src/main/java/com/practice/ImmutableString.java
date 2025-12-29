package com.practice;

/*
Question: Why Java Strings are Immutable?
Answer: In Java, strings are immutable, meaning their values cannot be changed once created. If you try to modify a string (e.g., using concat() or replace()), a new string object is created instead of altering the original one.
1) Strings are stored in a String Pool, allowing reuse of objects and reducing memory overhead.
2) Multiple threads can safely share the same string object without synchronization.
3) Immutable strings have a consistent hash code, making them reliable for use in collections like HashMap.
*/

// All wrapper classes in Java (Integer, Double, Boolean, Character, etc.) are immutable for the same fundamental reasons as String.
public class ImmutableString {
    public static void main(String[] args) {

        // Both s1 and s2 refer to the same object
        // string literal in the String Pool
        String s1 = "Hello";
        String s2 = "Hello";

        // true, both point to the same object in String Pool
        System.out.println("s1 == s2: " + (s1 == s2)); // true

        // Concatenation creates a new String
        // object in heap, s1 now points to it
        s1 = s1.concat(" World"); // Here s1 will become s1: Hello World

        System.out.println("s1: " + s1); // This will print Hello World
        System.out.println("s2: " + s2); // This will print World
        System.out.println("s1 == s2: " + (s1 == s2)); // Now it will be false because s1 is now Hello World

        // Creating a string using new keyword stores it in the heap
        String s3 = new String("Hello");

        // false, because s2 is from String Pool and s3 is from heap
        System.out.println("s2 == s3: " + (s2 == s3)); // This will be false because s3 is instantiated with "new" keyword

        // true, because equals() compares content
        System.out.println("s2.equals(s3): " + s2.equals(s3)); // This will be true because equals() compares the actual string value which is "Hello"

        String x = "abc";
        String y = "def";
        String z = "abc";
        String j = x.concat(y);
        System.out.println(x); // Here x will still be abc
        System.out.println(j); // Here it will print abcdef
        // if we assign a String variable to x.concat(y) then new String will be as abcdef
        // As String value of x and z is "abc" so in this case only one object will be created in String constant pool
    }
}
