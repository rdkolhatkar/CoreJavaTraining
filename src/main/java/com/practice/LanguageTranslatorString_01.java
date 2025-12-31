package com.practice;

import java.util.HashMap;
import java.util.Map;

public class LanguageTranslatorString_01 {
    /*
        Create a String language Translator
        Also called as Auto Bots
    */

    private static final Map<String, String> translator = new HashMap<>();

    static {
        translator.put("Hello Ratnakar", "नमस्ते रत्नाकर");
        translator.put("Good Morning", "शुभ प्रभात");
        translator.put("Nice to meet you", "आपसे मिलकर अच्छा लगा");
        translator.put("How are you?", "आप कैसे हैं?");
        translator.put("Good bye", "अलविदा");
        translator.put("Get Well Soon", "जल्द स्वस्थ हो जाओ");
    }

    public static String translate(String input) {
        return translator.getOrDefault(input, input);
    }

    public static void main(String[] args) {
        System.out.println(translate("Hello Ratnakar"));
        System.out.println(translate("Get Well Soon"));
    }
}
