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
        // 8th Solution is using the While loop
        // We will create a separate method using while loop
        System.out.println("The length of String 'str' using 'While loop' method is : "+getLengthUsingWhileLoop(str));
        System.out.println("*********************************************************************");
        // 9th Solution is using getBytes method
        System.out.println("The length of String 'str' using 'string.getBytes()' method is : "+getLengthWithBytesMethod(str));
        System.out.println("*********************************************************************");
        // 10th Solution is using array method
        System.out.println("The length of String 'str' using 'Array' method is : "+getStringLenghthWithArray(str));
    }
    public static int getLengthUsingWhileLoop(String string){
        int i = 0;
        try{
            while (true){
                string.charAt(i);
                i++;
            }
        }catch(IndexOutOfBoundsException e){
            return i;
        }
    }
    public static int getLengthWithBytesMethod(String string){
        int l1 = 0;
        try {
            l1 = string.getBytes("UTF-16BE").length/2;
            return l1;
        }catch(Exception e){
            e.printStackTrace();
        }
        return l1;
    }
    public static int getStringLenghthWithArray(String string){
        String[] strArray = string.split("");
        int count = 0;
        for(String s : strArray){
            count += s.toCharArray().length;
        }
        return count;
    }
}
