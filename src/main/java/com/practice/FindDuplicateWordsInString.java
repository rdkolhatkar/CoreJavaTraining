package com.practice;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateWordsInString {

    // Remove punctuation marks
    public static String cleanString(String inputOriginalString) {
        String newCleanString = inputOriginalString.replaceAll("[^\\w\\s]", "");
        System.out.println("New String without punctuation is : " + newCleanString);
        return newCleanString;
    }

    public static void findDuplicateWords(String inputString) {

        // Convert to lower case and split into words
        String[] words = cleanString(inputString).toLowerCase().split("\\s+");

        Map<String, Integer> wordCount = new HashMap<>();

        // Count occurrences
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Print duplicates
        System.out.println("\nDuplicate Words:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("'" + entry.getKey() + "' -> " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        findDuplicateWords("Java is best programming language, Java makes programming easy, Java is popular coding language");
    }
}
