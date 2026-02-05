package com.practice;

import java.util.HashMap;
import java.util.Map;

public class FindTheCountOfEachAndEveryCharacterInTheString {
    /*
        Find the total count of each and every character in the given String
        For Example:
        In String "test" => Character 't' is coming 2 times, Character 'e' is 1 time and Character 's' is 1 time.
        If there is a space between the two words then that should also be counted
        For example:
        In String "test case" => Character 't' is coming 2 times, Character 'e' is 2 times, Character 's' is 2 times, Character 'c' is 1 time, Character a is 1 time and Space ' ' is coming 1 time.
    */
    // To solve this we have to use the HashMap
    // Creating a custom method
    public static void getCharacterCount(String str){
        // Defining one HashMap
        Map<Character, Integer> charMap = new HashMap<>();
        // Converting String into Character Array
        char[] charArray = str.toCharArray();
        for(char value : charArray){
            if(charMap.containsKey(value)){
                charMap.put(value, charMap.get(value)+1);
            }else {
                charMap.put(value, 1);
            }
        }
        System.out.println(str+" : "+charMap);
    }
    // Get the count of each character without spaces
    // Here we have to remove the spaces from our String
    public static void getCharacterCountWithoutSpaces(String str){
        // Defining one HashMap
        Map<Character, Integer> charMap = new HashMap<>();
        // Converting String into Character Array
        char[] charArray = str.toCharArray();
        for(char value : charArray){
            if(!String.valueOf(value).isBlank()) { // Here we are using "isBlank()" method to exclude the spaces from the String
                if (charMap.containsKey(value)) {
                    charMap.put(value, charMap.get(value) + 1);
                } else {
                    charMap.put(value, 1);
                }
            }
        }
        System.out.println(str+" : "+charMap);
    }



    public static void main(String[] args) {
        // Getting the Character count with Spaces
        System.out.println("Below is the Character count in the Given String with Spaces");
        getCharacterCount("test case in java");
        System.out.println("******************************************************");
        // Getting the Character count without spaces
        System.out.println("Below is the Character count in the Given String without Spaces");
        getCharacterCountWithoutSpaces("test case in java");

    }
}
