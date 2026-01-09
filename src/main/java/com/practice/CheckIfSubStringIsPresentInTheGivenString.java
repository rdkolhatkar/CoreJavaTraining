package com.practice;

import java.util.regex.Pattern;

public class CheckIfSubStringIsPresentInTheGivenString {
    /*
        Check if SubString is present in the Given String
        Solution:
        1) Using regular Expression & matches
        2) Using Contains method
        3) Method using indexOf()
        4) Pattern Class in Java
        5) Using SubString
    */

    // Using Regular Expression
    public static boolean checkIfSubStringIsPresentWithRegularExpression(String mainString, String subString){
        return mainString.matches("(.*)"+subString+"(.*)");
    }
    // Using Contains method
    public static boolean checkIfSubStringIsPresentUsingContains(String mainString, String subString) {
        return mainString.contains(subString);
    }
    // Method using indexOf()
    public static boolean checkIfSubStringIsPresentUsingIndexOf(String mainString, String subString) {
        if (mainString == null || subString == null) {
            return false;
        }
        return mainString.indexOf(subString) != -1;
    }
    // Using Pattern Class in Java
    public static boolean checkIfSubStringIsPresentWithPatternClass(String mainString, String subString) {
        if (mainString == null || subString == null) {
            return false;
        }
        return Pattern.compile(Pattern.quote(subString))
                .matcher(mainString)
                .find();
    }
    // Using SubString
    public static boolean checkIfSubStringIsPresentUsingSubstring(
         String mainString, String subString) {

        if (mainString == null || subString == null) {
            return false;
        }

        int index = mainString.indexOf(subString);

        if (index == -1) {
            return false;
        }

        String extracted = mainString.substring(index, index + subString.length());
        return extracted.equals(subString);
    }
    public static void main(String[] args) {
        String str = "My name is Ratnakar Kolhatkar And I am a Science Student";
        String strOne = "Selenium Web Test Automation";
        String strTwo = "Testing";
        String strThree = "JSON";
        String strFour = "REST API Automation 1";
        boolean result = checkIfSubStringIsPresentWithRegularExpression(str, "I am a Science Student");
        boolean resultOne = checkIfSubStringIsPresentWithRegularExpression(strOne, "Automation");
        boolean resultTwo = checkIfSubStringIsPresentWithRegularExpression(strTwo, "$#$%");
        boolean resultThree = checkIfSubStringIsPresentWithRegularExpression(strThree, "ON");
        boolean resultFour = checkIfSubStringIsPresentWithRegularExpression(strFour, "11");
        System.out.println(result); // Here it will return true value
        System.out.println(resultOne); // Here it will return true value
        System.out.println(resultTwo); // Here it will return false value
        System.out.println(resultThree); // Here it will return true value
        System.out.println(resultFour); // Here it will return false value
        System.out.println("************************************************************************");
        System.out.println("----- Using contains() -----");
        System.out.println(checkIfSubStringIsPresentUsingContains(str, "I am a Science Student"));// true
        System.out.println(checkIfSubStringIsPresentUsingContains(strOne, "Automation"));// true
        System.out.println(checkIfSubStringIsPresentUsingContains(strTwo, "$#$%"));// false
        System.out.println(checkIfSubStringIsPresentUsingContains(strThree, "ON"));// true
        System.out.println(checkIfSubStringIsPresentUsingContains(strFour, "11"));// false
        System.out.println("************************************************************************");
        System.out.println("\n----- Using indexOf() -----");
        System.out.println(checkIfSubStringIsPresentUsingIndexOf(str, "I am a Science Student"));// true
        System.out.println(checkIfSubStringIsPresentUsingIndexOf(strOne, "Automation"));// true
        System.out.println(checkIfSubStringIsPresentUsingIndexOf(strTwo, "$#$%"));// false
        System.out.println(checkIfSubStringIsPresentUsingIndexOf(strThree, "ON"));// true
        System.out.println(checkIfSubStringIsPresentUsingIndexOf(strFour, "11"));// false
        System.out.println("************************************************************************");
        System.out.println("\n----- Using Pattern Class -----");
        System.out.println(checkIfSubStringIsPresentWithPatternClass(str, "I am a Science Student"));// true
        System.out.println(checkIfSubStringIsPresentWithPatternClass(strOne, "Automation"));// true
        System.out.println(checkIfSubStringIsPresentWithPatternClass(strTwo, "$#$%"));// false
        System.out.println(checkIfSubStringIsPresentWithPatternClass(strThree, "ON"));// true
        System.out.println(checkIfSubStringIsPresentWithPatternClass(strFour, "11"));// false
        System.out.println("************************************************************************");
        System.out.println("\n----- Using substring() -----");
        System.out.println(checkIfSubStringIsPresentUsingSubstring(str, "I am a Science Student"));// true
        System.out.println(checkIfSubStringIsPresentUsingSubstring(strOne, "Automation"));// true
        System.out.println(checkIfSubStringIsPresentUsingSubstring(strTwo, "$#$%"));// false
        System.out.println(checkIfSubStringIsPresentUsingSubstring(strThree, "ON"));// true
        System.out.println(checkIfSubStringIsPresentUsingSubstring(strFour, "11"));// false
    }
}
