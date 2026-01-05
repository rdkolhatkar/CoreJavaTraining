package com.practice;

public class CapitalizedStringWordCount_02 {
        public static void main(String[] args) {
        /*
        Question 1:
            Get the count of total words in a given Capitalized String
            But the first word of the given String starts with Small letter or first word is lowerCase
        */
            String str = "nameIsRatnakarDigvijayKolhatkarPuneMaharashtra";
            // Here first word 'name' is starting with lower case character
            // From second word onwards new words are starting with UpperCase characters
            // If small word string is at the beginning then we have to count it as word
            int count = 0;
            if(Character.isLowerCase(str.trim().charAt(0))){
                // Here trim() method is used for removing the extra spaces at the beginning
                // Because if any space is present at the beginning then it will be considered as zeroth index
                count++;
            }
            for(int i =0; i<str.length(); i++){
                if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                    count++;
                }
            }
            System.out.println("Number of Words in Given String are : "+count);
            System.out.println("******************************************************************************");
        /*
        Question 2:
            Get the count of total words in a given Capitalized String
            But the last word of the given String starts with Small letter or first character of last word is lowerCase
        */
            String string = "NameIsRatnakarDigvijayKolhatkarPuneMaharashtraindia";
            // Here in this case 'india' is not considered as separate word because there is no UpperCase letter between 'Maharashtra' and 'india'
            // If the last word starts with a lowercase letter, it will not add to the count, which matches your requirement








        }
}
