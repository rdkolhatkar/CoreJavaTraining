package com.practice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConvertArrayToJoint {

    public static String joinString(String separator, String[] values){
        StringBuilder stringBuilder = new StringBuilder();
        int end = 0;
        for(String s : values){
            if(s != null){
                stringBuilder.append(s);
                end = stringBuilder.length();
                stringBuilder.append(separator);
            }
        }
        return stringBuilder.substring(0, end);
        // In substring method if we pass the starting index as 0 and end index as 9 then it will collect up to 8th index, it will skip the 9th value
    }
    public static String joinInteger(String separator, Integer... values){ // We can also define array like this Integer...
        StringBuilder stringBuilder = new StringBuilder();
        int end = 0;
        for(Integer s : values){
            if(s != null){
                stringBuilder.append(s);
                end = stringBuilder.length();
                stringBuilder.append(separator);
            }
        }
        return stringBuilder.substring(0, end);
        // In substring method if we pass the starting index as 0 and end index as 9 then it will collect up to 8th index, it will skip the 9th value
    }
    public static void main(String[] args) {
        String[] arr = {"t","r","v"};
        // Now we have to convert the above array characters to join
        // Example: 1) trv 2) t;r;v 3) t|r|v

        // First Solution is using StringBuilder method
        System.out.println(joinString(";",arr));
        System.out.println(joinString("|",arr));
        System.out.println(joinString("",arr));
        System.out.println("***********************************************************************");
        // Second Solution using direct method
        String a = String.join(";", arr); // ; separator
        String b = String.join("|", arr); // | separator
        String c = String.join("", arr); // No separator
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("***********************************************************************");
        // Third solution using Java Streams
        String one = Arrays.asList("t", "r", "y", "i", "n", "g").stream().collect(Collectors.joining());
        String two = Arrays.asList("t", "r", "y", "i", "n", "g").stream().collect(Collectors.joining(";"));
        String three = Arrays.asList("t", "r", "y", "i", "n", "g").stream().collect(Collectors.joining("|"));
        String joinOne = Arrays.asList(arr).stream().collect(Collectors.joining(";"));
        String joinTwo = Arrays.asList(arr).stream().collect(Collectors.joining(":"));
        String joinThree = Arrays.asList(arr).stream().collect(Collectors.joining("|"));
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(joinOne);
        System.out.println(joinTwo);
        System.out.println(joinThree);
        System.out.println("***********************************************************************");

        // Convert Integer array to join
        Integer[] intArray = {10, 11, 12, 99, 76, 0, 1};
        System.out.println(joinInteger(";", 1,2,3,4,5));
        System.out.println(joinInteger("|", intArray));
        // Use Streams for integer array
        // To convert integer to String we have t use this ".map(e -> String.valueOf(e))" then use Collectors.joining()
        Arrays.asList(intArray).stream().map(e -> String.valueOf(e)).collect(Collectors.joining());
    }
}
