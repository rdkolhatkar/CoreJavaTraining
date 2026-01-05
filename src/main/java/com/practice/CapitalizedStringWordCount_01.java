package com.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalizedStringWordCount_01 {
    /*
        Get the count of total words in a given Capitalized String
    */
    public static void main(String[] args) {
        // A capitalized String is a string in which First Letter of Every Word is Capital
        String str = "RatnakarDigvijayKolhatkarPuneMaharashtraIndia";
        // Here String Doesn't have any spaces between the words, But we know new word Starts with Capital letter
        // First Solution is using for loop
        int count = 0;
        for(int i =0; i<str.length(); i++){
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                count++;
            }
        }
        System.out.println("Number of Words in Given String are : "+count);
        System.out.println("******************************************************************************");
        // Second Solution is using ASCII values
        // We know the ASCII value of 'A' is 65 and 'Z' is 90
        int counter = 0;
        for(int i =0; i<str.length(); i++){
            if(str.charAt(i) >= 65 && str.charAt(i) <= 90){
                counter++;
            }
        }
        System.out.println("Number of Words in Given String are : "+counter);
        System.out.println("******************************************************************************");
        // Third Solution is Using Character class to check if the letter is Uppercase or not
        int countOne = 0;
        for(int i = 0; i<str.length(); i++){
            if(Character.isUpperCase(str.charAt(i))){
                countOne++;
            }
        }
        System.out.println("Number of Words in Given String are : "+countOne);
        System.out.println("******************************************************************************");
        // Fourth Solution is using Java Streams
        long countTwo = str.chars().filter(e -> e >= 'A' && e <= 'Z').count();
        System.out.println("Number of Words in Given String are : "+countTwo);
        System.out.println("******************************************************************************");
        // Fifth Solution is using Java Streams and Character class
        long countThree = str.chars().filter(e -> Character.isUpperCase(e)).count();
        System.out.println("Number of Words in Given String are : "+countThree);
        System.out.println("******************************************************************************");
        // Sixth solution is using regular expressions
        String regularExpression = "[A-Z]+";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(str);
        int countFour = 0;
        while(matcher.find()){
            countFour += matcher.group(0).length();
        }
        System.out.println("Number of Words in Given String are : "+countFour);
        System.out.println("******************************************************************************");
    }
}
