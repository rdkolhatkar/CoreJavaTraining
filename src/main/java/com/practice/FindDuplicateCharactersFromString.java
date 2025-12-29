package com.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindDuplicateCharactersFromString {
    /*
        Write Java code to print the duplicate characters in the String
        Consider capital letters and small letters in the String are not same
        if our String is "Java" then duplicate character is 'a'
        if our String is "Naveen" then duplicate character is e.
        As "n" is also duplicate in "Naveen" but First 'N' is in capital letter and second 'n' is in small so this will not be considered as duplicate
        if our String is "Tom" then here no character is duplicate
        We also have to check if our String is null or empty
        And if length of String is 1 then we should return a message that String contains only one character
    */
    public static void printDuplicateCharactersInString(String str){
        if(str == null){
            System.out.println("NULL String");
            return;
        }
        if(str.isBlank() || str.isEmpty()){
            System.out.println("Blank or Empty String");
            return;
        }
        if(str.length() == 1){
            System.out.println("Single character String");
            return;
        }
        System.out.println(str.toCharArray());
        System.out.println("Character Array Conversion :");
        char[] letters = str.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        for(Character ch : letters){
            if(charMap.containsKey(ch)){
                charMap.put(ch, charMap.get(ch)+1);
            }else {
                charMap.put(ch, 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
        for(Map.Entry<Character, Integer> entry : entrySet){
            if (entry.getValue() > 1){
                System.out.println("Duplicate elements are : "+ entry.getKey() + " : " + entry.getValue());
            }
        }
    }
    public static void main(String[] args) {
        printDuplicateCharactersInString("HBieibhbfuahasjnasquH");
    }
}
