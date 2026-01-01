package com.practice;

import java.util.StringJoiner;

public class StringJoinerClass {
    /*
        What is String Joiner in Java?
        Answer: StringJoiner in Java is a utility class used to join multiple strings with a specified delimiter, and optional prefix and suffix, without manual concatenation.
    */
    public static void main(String[] args) {
        // StringJoiner is used to join multiple strings using a delimiter,
        // with an optional prefix and suffix.
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        // Adding elements to be joined
        joiner.add("Java");
        joiner.add("Spring");
        joiner.add("Hibernate");
        // Output will be: [Java, Spring, Hibernate]
        System.out.println(joiner.toString());
        StringJoiner join = new StringJoiner("/", "{", "]");
        // Adding elements to be joined
        join.add("Java");
        join.add("Spring");
        join.add("Hibernate");
        // Output will be: {Java/Spring/Hibernate]
        System.out.println(join.toString());
    }
}
