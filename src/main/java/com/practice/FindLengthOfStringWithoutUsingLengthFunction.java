package com.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindLengthOfStringWithoutUsingLengthFunction {
    /*
        Find the length of String without using the Length method from String Class
        We cannot use this str.length() method from String.class in java
    */
    public static void main(String[] args) {
        // 1st Method for finding the length of String
        String str = "My Name is Ratnakar";
        System.out.println("Give String is : "+str);
        System.out.println("*********************************************************************");
        System.out.println("The length of String 'str' using Length method is : "+str.length());
        System.out.println("*********************************************************************");
        // 2nd Method for finding the length of String using toCharArray()
        System.out.println("The length of String 'str' using 'toCharArray().length' method is : "+str.toCharArray().length);
        System.out.println("*********************************************************************");
        // 3rd Method for finding the length of String using lastIndexOf()
        System.out.println("The length of String 'str' using 'lastIndexOf()' method is : "+str.lastIndexOf(""));
        System.out.println("*********************************************************************");
        // 4th Method for finding the length of String using Regular Expression regex
        Matcher matcher = Pattern.compile("$").matcher(str);
        matcher.find(); // This step is important because it will start the counting
        int lengthOfGivenString = matcher.end(); // This will stop the counting till last index of String str
        System.out.println("The length of String 'str' using 'regex & pattern matcher' method is : "+lengthOfGivenString);
        System.out.println("*********************************************************************");
        // 5th Solution using split method
        System.out.println("The length of String 'str' using 'str.split().length' method is : "+str.split("").length);
        System.out.println("*********************************************************************");
        // 6th Solution is using StringBuilder
        int length = new StringBuilder(str).length();
        System.out.println("The length of String 'str' using 'StringBuilder()' method is : "+length);
        System.out.println("*********************************************************************");
        // 7th Solution is using enhanced for loop
        int counter = 0;
        for(char c : str.toCharArray()){
            counter++;
        }
        System.out.println("The length of String 'str' using 'enhanced for loop' method is : "+counter);
        System.out.println("*********************************************************************");
    }
}
