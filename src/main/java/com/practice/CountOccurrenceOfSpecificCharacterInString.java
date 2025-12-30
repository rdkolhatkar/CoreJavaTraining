package com.practice;

import org.apache.commons.lang3.StringUtils;

public class CountOccurrenceOfSpecificCharacterInString {

    // Creating a generic method or function 2nd Solution
    public static int getCharacterCount(String a, char b){
        int countOfCharacterA = 0;
        for(char ch : a.toCharArray()){
            if(ch == b){
                countOfCharacterA++;
            }
        }
        return countOfCharacterA;
    }
    // Creating a generic method or function 3rd Solution
    public static void getCharCount(String a, char b){
        int charCount = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == b){
                charCount++;
            }
        }
        System.out.println("Count of the character '"+b+"' in the given String \""+a+"\" is : "+charCount);
    }
    // Creating a generic method or function 5th Solution
    public static long getCharCountUsingJavaStreams(String a, String b){
        return a.chars()
                .mapToObj(s -> String.valueOf((char) s))
                .filter(e -> e.equals(b)).count();
    }
    public static void main(String[] args) {
        String str = "automation testing is awsom";
        System.out.println("Given String is : "+str);
        // In this above String count the occurrence of the character 'a'
        // First Solution is using For Loop and CharArray method
        int countOfCharacterA = 0;
        for(char ch : str.toCharArray()){
            if(ch == 'a'){
                countOfCharacterA++;
            }
        }
        System.out.println("Count of character 'a' in given String is : "+countOfCharacterA);
        System.out.println("************************************************");
        // Second solution is using generic method or function
        String strOne = "My name is Ratnakar";
        System.out.println("Given String is : "+strOne);
        int charCountValue = getCharacterCount(strOne, 'a');
        System.out.println("Count of character 'a' is : " + charCountValue);
        System.out.println("************************************************");
        // Third solution is using "charAt(i)"
        String strTwo = "Once upon a time";
        getCharCount(strTwo, 'n');
        System.out.println("************************************************");
        // Fourth solution is using Java Streams
        String strThree = "The sky whispers peace where the earth learns to breathe";
        long count = strThree.chars()
                .mapToObj(s -> String.valueOf((char) s))
                .filter(e -> e.equals("r")).count();
        System.out.println("Occurrence of character 'r' in the given String is : "+count);
        System.out.println("************************************************");
        // Fifth solution is using Java Stream function
        long countVal;
        countVal = getCharCountUsingJavaStreams("Sunlight falls like a blessing on everything that dares to grow", "s");
        System.out.println("Occurance of Character 's' is: "+countVal);
        System.out.println("************************************************");
        // Sixth solution is using "Apache Common String Utils"
        // To use 'Apache Common String Utils' we have to add this dependency ("org.apache.commons:commons-lang3:3.20.0")
        // Then e have to use a specific class called "StringUtils"
        String strFour = "The wind remembers stories the mountains never forget";
        int value = StringUtils.countMatches(strFour, 'm');
        System.out.println("Occurrence of character 'm' in the given String is : "+ value);
    }
}
