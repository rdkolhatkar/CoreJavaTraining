package com.practice;

public class IdentifyValidNumberTest {
    /*
        How to validate if given number is valid or not?
        Check given number is valid or not?
            -> Check given number is valid phone number (10 digits)
            -> Check given number is valid credit card number (16 digits)
    */
    // Creating General Utilities
    public static boolean isNumber(String number){
        try{
            Long.parseLong(number); // If there is any other character except for numeric values in the given String then this "parseLong" method will throw the 'Number Format Exception'
            System.out.println("This is a Valid Number" + number);
        } catch (NumberFormatException e){
            System.out.println("Not a valid number " + number + "\n" + e.getMessage());
            return false;
        }
        return true;
    }
    public static boolean checkValidPhoneNumber(String value){
        if(value.length() == 10 && isNumber(value)){
            System.out.println("This is a Valid Phone Number: "+ value);
            return true;
        }
        System.out.println("This is Not a Valid Phone Number: "+ value);
        return false;
    }
    public static boolean checkValidCreditCardNumber(String value){
        if(value.length() == 16 && isNumber(value)){
            System.out.println("This is a Valid Phone Number: "+ value);
            return true;
        }
        System.out.println("This is Not a Valid Phone Number: "+ value);
        return false;
    }
    // Creating Utilities with Regular Expression
    public static boolean isCorrectPhoneNumber(String number){
        return number.matches("[0-9]{10}");
    }
    public static boolean isCorrectMobileNumber(String number){
        return number.matches("\\d{10}");
    }
    public static boolean isCorrectNumber(String number){
        return number.matches("^(-?\\d+\\.)?-?\\d+$");
    }
    public static void main(String[] args) {
        System.out.println(isNumber("123")); // true
       // System.out.println(isNumber("123a")); // false + Exception message
        System.out.println(checkValidPhoneNumber("1234567890")); // true
        System.out.println(checkValidPhoneNumber("12345678901")); // false
        System.out.println(checkValidCreditCardNumber("1234567890987654")); // true
        System.out.println(isCorrectPhoneNumber("1234567890"));// true
        System.out.println(isCorrectMobileNumber("1234567890")); //true
        System.out.println(isCorrectNumber("1234567890")); //true
        System.out.println(isCorrectNumber("1234567890ABC")); //false
        System.out.println(isCorrectNumber("-0.4567")); //true
        System.out.println(isCorrectNumber("0.4")); //true
        System.out.println(isCorrectNumber("-2")); //true
    }
}
