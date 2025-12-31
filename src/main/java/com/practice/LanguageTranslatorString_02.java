package com.practice;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/*
 ============================================================================
 QUESTION:
 ----------------------------------------------------------------------------
 Write a Java program to create an Automatic Language Translator (Auto Bot).

 The program should automatically translate predefined English sentences
 into another language (for example, Hindi) when printed to the console.

 REQUIREMENTS:
 1. Translation must happen automatically.
 2. Do NOT pass any translator method inside System.out.println().
 3. Do NOT change the existing System.out.println() statements.
 4. Use only ONE Java class.
 5. If a sentence is not found in the dictionary, print it as it is.
 6. Use only Core Java concepts.

 NOTE:
 The program should demonstrate how output can be intercepted and modified
 without changing the original print statements.
 ============================================================================
*/
public class LanguageTranslatorString_02 {
    /*
     * Dictionary to store translations.
     * Key   -> Original English sentence
     * Value -> Translated sentence (Hindi)
     */
    private static final Map<String, String> DICTIONARY = new HashMap<>();

    /*
     * Static block:
     * - Executes once when the class is loaded into memory.
     * - Loads translation data.
     * - Replaces System.out with a custom PrintStream
     *   to enable automatic translation.
     */
    static {

        // Adding predefined translations
        DICTIONARY.put("Hello Ratnakar", "नमस्ते रत्नाकर");
        DICTIONARY.put("Good Morning", "शुभ प्रभात");
        DICTIONARY.put("How are you?", "आप कैसे हैं?");
        DICTIONARY.put("Good bye", "अलविदा");

        /*
         * Replace the default System.out PrintStream.
         * This custom PrintStream intercepts all println(String)
         * calls and translates the text before printing.
         */
        System.setOut(new PrintStream(System.out) {

            /*
             * Overridden println method.
             * This method is called automatically whenever
             * System.out.println(String) is used.
             */
            @Override
            public void println(String text) {

                // Get translated text if available, otherwise return original
                String translatedText = DICTIONARY.getOrDefault(text, text);

                // Print the translated or original text
                super.println(translatedText);
            }
        });
    }

    public static void main(String[] args) {

        /*
         * These statements are NOT modified.
         * Translation happens automatically behind the scenes.
         */
        System.out.println("Hello Ratnakar");
        System.out.println("Good Morning");
        System.out.println("How are you?");
        System.out.println("This will not change");
    }
}
