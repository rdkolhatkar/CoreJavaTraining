package com.practice;

public class StringManipulation {
    public static void main(String[] args){
        String str = "The Rains Have Started Here";
        String str1 = "The Rains have Started Here";
        // Find Length of the string
        System.out.println("The length of given string is "+str.length());
        // Find the character at 7th index in the given string
        System.out.println("The Character at 7th index is "+"'"+str.charAt(7)+"'");
        // Find the index of 'S' in the given string
        System.out.println("The index of "+"'s'"+"is "+str.indexOf("s"));
        // As first s is in the Lower Case, we want to find the index of first s irrespective of the Case. Our Second S is in the Upper case and last s is in lower case again
        System.out.println("The Index of Second Lowe case s is "+str.indexOf('s', str.indexOf("S"))); // str.indexOf("S") => index of Upper case S
        System.out.println("The Index of Second Lowe case s is "+str.indexOf('s', str.indexOf("s")+1)); // str.indexOf("s")+1 => Same with lower case of s
        // Find the index of 'Have'
        System.out.println("The Index of Have is "+str.indexOf("Have"));
        // Find the index of 'Hello' in the given string
        // As 'Hello' is not present in the above string our code will return -1
        System.out.println("The Index of Hello is "+str.indexOf("Hello"));
        // Compare if both strings are equal
        System.out.println("Are the two strings Equal ? => "+ str.equals(str1)); // Strings are case sensitive, as H is in lower case in the second string it will fail
        // Now we want to compare the strings by ignoring the Upper and Lower cases
        System.out.println("Are the two strings Equal (Ignore the case) ? => "+ str.equalsIgnoreCase(str1));
        // Find the substring 'The Rain'
        System.out.println("The sub string is "+"'"+str.substring(0, 9)+"'");
        // Trim the spaces in the given string
        String str2 = " Hello World ";
        // trim() method can remove only before and after space
        System.out.println(str2.trim());
        // Now we want remove all the spaces in the given string for that we will use the replace() method
        System.out.println(str2.replace(" ", ""));
        // Replace String "09-14-1999" with "09/14/1999"
        String str3 = "09-14-1999";
        System.out.println(str3.replace("-", "/"));
        // Split the given string
        String str4 = "Hello_World_Test_Selenium";
        String test[] = str4.split("_"); // Split will convert the string based on regex and convert it into array
        // Printing the Values of Array test[]
        for(int i = 0; i< test.length; i++){
            System.out.println("String Array is : ");
            System.out.println(test[i]);
        }
        // Concat the two strings str5 and character s at the end
        String str5 = "WebDriver";
        System.out.println(str5.concat("s"));
        // Add two strings and two integer values in the same line
        String a = "Hello";
        String b = "World";
        int x = 100;
        int y = 200;
        System.out.println("Addition of two integers is "+(x+y));
        System.out.println("Addition of two Strings is "+(a+b));
        System.out.println("Addition of (Strings) + (integers) "+(a+b+x+y)); // HelloWorld100200
        System.out.println("Addition of (integers) + (String) "+(x+y+a+b)); // 300HelloWorld
        System.out.println("Addition is "+(x+y+(a+b))); // 300HelloWorld
        // Remove all Spaces from the String
        String input = "my test case in java";
        // Remove all spaces
        String result = input.replace(" ", "");
        System.out.println("Original String: " + input);
        System.out.println("After Removing Spaces: " + result);
        String resultTwo = input.replaceAll("\\s+", "");
        System.out.println("After Removing All Spaces: " + resultTwo);
        /*
            replace() → removes only space characters
            replaceAll() → removes all kinds of whitespace using regex
         */
    }
}
