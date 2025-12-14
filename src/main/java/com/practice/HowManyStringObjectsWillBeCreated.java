package com.practice;

public class HowManyStringObjectsWillBeCreated {
    /*
    ========================================================
    STRING OBJECT CREATION EXPLANATION IN JAVA
    ========================================================

    Question:
    ---------
    How many String objects are created by the following code?

        String str = new String("New World");
    
    Answer:
    Two String objects are created.

    ========================================================
    STRING OBJECT CREATION — COMPLETE EXPLANATION WITH COMMENTS
    ========================================================

    Question:
    ---------
    How many String objects are created by the following code?

        String s1 = "Hello World";
        String s2 = "Hello World";
        String s3 = s1;

        String n1 = new String("Hello World");
        String n2 = new String("Hello World");

    Answer:
    -------
    Total String objects created = 3

    1 object in String Constant Pool (SCP)
    2 objects in Heap memory


    --------------------------------------------------------
    DETAILED EXPLANATION WITH COMMENTS
    --------------------------------------------------------
    */
    public static void main(String[] args) {

        /*
        ------------------------------------------------
        STEP 1: STRING LITERAL CREATION
        ------------------------------------------------

        "New World" is a String literal.

        When the JVM encounters a String literal, it checks
        the String Constant Pool (SCP).

        - If the literal already exists in SCP:
            -> JVM reuses the existing object
        - If the literal does NOT exist:
            -> JVM creates a new String object in SCP

        In this case, assume "New World" does NOT exist yet.
        So JVM creates ONE String object in the SCP.
        */

        // Object created in String Constant Pool
        String literal = "New World";

        /*
        At this point:
        SCP:
            "New World"
        Heap:
            (empty)
        */

        /*
        ------------------------------------------------
        STEP 2: USING 'new' KEYWORD
        ------------------------------------------------

        The 'new' keyword ALWAYS creates a new object
        in heap memory, even if the same value already
        exists in the String Constant Pool.

        new String("New World") does the following:
        1. Looks up "New World" in SCP
        2. Copies its value
        3. Creates a NEW String object in heap memory
        */

        // New object explicitly created in Heap memory
        String str = new String("New World");

        /*
        At this point:
        SCP:
            "New World"
        Heap:
            new String("New World")  <-- referenced by str
        */

        /*
        ------------------------------------------------
        STEP 3: MEMORY COMPARISON
        ------------------------------------------------

        '==' compares memory addresses (reference comparison)
        'equals()' compares content (value comparison)
        */

        System.out.println(literal == str);     // false
        System.out.println(literal.equals(str)); // true

        /*
        Explanation:
        - literal and str refer to DIFFERENT objects
        - But both objects contain the SAME value
        */

        /*
        ------------------------------------------------
        FINAL OBJECT COUNT
        ------------------------------------------------

        1 String object in String Constant Pool
        1 String object in Heap memory

        Total = 2 String objects
        */

        /*
        ------------------------------------------------
        WHY JAVA WORKS THIS WAY?
        ------------------------------------------------

        1. Memory Optimization
           - String Constant Pool avoids duplicate literals

        2. Immutability
           - Strings cannot be changed once created

        3. Security
           - new String() ensures a separate object

        4. Performance
           - Reusing literals is faster than creating new ones
        */

        /*
        ------------------------------------------------
        BEST PRACTICE
        ------------------------------------------------

        Avoid using 'new String("...")' unless you need
        a distinct object.

        Prefer:
        */

        String bestPractice = "New World";

        /*
        This creates ONLY ONE object (in SCP).
        */

        /*
        ------------------------------------------------
        INTERVIEW ONE-LINER
        ------------------------------------------------

        "Two String objects are created—one in the String
        Constant Pool for the literal and one in heap
        memory due to the 'new' keyword."
        */

        System.out.println("*********************************************************************");
         /*
        ------------------------------------------------
        STEP 1: STRING LITERALS (SCP)
        ------------------------------------------------

        "Hello World" is a String literal.

        When the JVM encounters a String literal:
        - It first checks the String Constant Pool (SCP)
        - If the literal does NOT exist:
            -> A new String object is created in SCP
        - If the literal exists:
            -> The existing object is reused

        Since this is the first time "Hello World" appears,
        ONE String object is created in SCP.
        */

        String s1 = "Hello World";  // SCP object created
        String s2 = "Hello World";  // No new object (reuse SCP)

        /*
        At this point:
        SCP:
            "Hello World"  ← s1, s2
        Heap:
            (empty)
        */

        /*
        ------------------------------------------------
        STEP 2: REFERENCE ASSIGNMENT
        ------------------------------------------------

        s3 is assigned the reference of s1.
        No new object is created here.

        s1, s2, and s3 now point to the SAME object
        in the String Constant Pool.
        */

        String s3 = s1;  // No object creation

        /*
        ------------------------------------------------
        STEP 3: USING 'new' KEYWORD (HEAP OBJECTS)
        ------------------------------------------------

        The 'new' keyword ALWAYS creates a NEW object
        in heap memory, even if the same value exists
        in the String Constant Pool.

        new String("Hello World") does the following:
        1. Finds "Hello World" in SCP
        2. Copies its value
        3. Creates a NEW heap object
        */

        String n1 = new String("Hello World"); // Heap object #1
        String n2 = new String("Hello World"); // Heap object #2

        /*
        At this point:
        SCP:
            "Hello World" ← s1, s2, s3

        Heap:
            new String("Hello World") ← n1
            new String("Hello World") ← n2
        */

        /*
        ------------------------------------------------
        STEP 4: PROOF USING '=='
        ------------------------------------------------

        '==' compares memory references (addresses),
        NOT the content of the String.
        */

        System.out.println(s1 == s2); // true  → same SCP object
        System.out.println(s1 == s3); // true  → same reference
        System.out.println(s1 == n1); // false → SCP vs Heap
        System.out.println(n1 == n2); // false → two heap objects

        /*
        ------------------------------------------------
        STEP 5: PROOF USING equals()
        ------------------------------------------------

        equals() compares String content (characters),
        NOT memory references.
        */

        System.out.println(s1.equals(n1)); // true → same value
        System.out.println(n1.equals(n2)); // true → same value

        /*
        ------------------------------------------------
        FINAL OBJECT COUNT
        ------------------------------------------------

        String Constant Pool:
        - "Hello World" → 1 object

        Heap Memory:
        - n1 → 1 object
        - n2 → 1 object

        TOTAL STRING OBJECTS = 3
        */

        /*
        ------------------------------------------------
        IMPORTANT INTERVIEW RULES
        ------------------------------------------------

        1. String literals are stored in SCP
        2. SCP never allows duplicate literals
        3. 'new String()' always creates a new heap object
        4. '==' compares references
        5. equals() compares content
        */

        /*
        ------------------------------------------------
        BEST PRACTICE
        ------------------------------------------------

        Avoid:
            new String("Hello World");

        Prefer:
            String s = "Hello World";

        This uses SCP and avoids unnecessary heap objects.
        */

        /*
        ------------------------------------------------
        INTERVIEW ONE-LINER
        ------------------------------------------------

        "One String object is created in the String Constant Pool
        and two additional objects are created in heap memory
        using the 'new' keyword, resulting in three String objects."
        */

    }
}

