package com.practice;

public class ExecuteCommentsInJava {
    /*
      Q: Is it possible to execute Java code written inside comments?
         If yes, how does it work? Explain with an example.
 */
    public static void main(String[] args) {
        // hi this is my java code(' \u000d System.out.println("Hello World");

        /*
         STEP 1:
         - \u000d represents a NEW LINE character
         - Java compiler replaces \u000d with an actual line break
         - This happens BEFORE comment removal
        */

        /*
         STEP 2 (After Unicode replacement, compiler sees this):

         // hi this is my java code('
         System.out.println("Hello World");

         - Now the println statement is no longer part of the comment
         - So it gets executed
        */

        System.out.println("Java");

        /*
         OUTPUT till now:
         Hello World
         Java
        */

        int num = 10;

        // \u000d num = 20;

        /*
         Same logic here:
         - \u000d breaks the comment
         - num = 20 executes
         - So original value (10) is overwritten
        */

        System.out.println(num); // Output will be 20

        /*
         "\u000d" Unicode value explanation:
         - \u000d = Carriage Return / New Line
         - Treated as line break by Java compiler
        */

        System.out.println("Hello Programming");
        /*
            Java compiler processes Unicode escape sequences before removing comments.
            \u000d is a Unicode escape for a new line (carriage return)
            The compiler replaces \u000d with a real line break
            This happens before comment parsing
            So code written after \u000d may escape the comment and execute
        */
    }
}
