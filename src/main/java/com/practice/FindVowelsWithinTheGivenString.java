package com.practice;

import com.google.common.base.CharMatcher;

import java.util.function.IntPredicate;

public class FindVowelsWithinTheGivenString {
    /*
        Find the total number of Vowels present within the given String
        Use java, java 8 and Google guava technique
        List of Vowels : A, E, I, O, U
    */
    // Creating a custom Java method
    public static boolean isVowelCustomMethod(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
        c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    public static void main(String[] args) {
        // 1st Solution is creating custom Java method
        String str = "testing";
        int vowelCount = 0;
        for(int i = 0; i < str.length(); i++){
            if(isVowelCustomMethod(str.charAt(i))){
                System.out.println("Vowel '"+str.charAt(i)+"' is present at index : "+i);
                vowelCount++;
            }
        }
        System.out.println("Total Number of Vowels present in the given String are: "+vowelCount);
        System.out.println("************************************************************************");
        // 2nd Solution is using java Streams
        IntPredicate vowel = new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value == 'a' || value == 'e' || value == 'i' || value == 'o' || value == 'u' ||
                        value == 'A' || value == 'E' || value == 'I' || value == 'O' || value == 'U';
            }
        };
        String test = "My name is Ratnakar Kolhatkar";
        long count = test.chars().filter(vowel).count();
        System.out.println(count);
        System.out.println("************************************************************************");
        // 3rd solution is using google guava library
        String st = "Java Examples";
        // CharMatcher is imported from "com.google.common.base"
        int myVowelCount = CharMatcher.anyOf("aeiouAEIOU").countIn(st);
        System.out.println("Vowel count using the google guava library method is : "+myVowelCount);
    }
}
