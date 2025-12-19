package com.assessment;

/*
================================================================================
 TOPIC: Why static block executes / does NOT execute with static variables
================================================================================

This example demonstrates a VERY IMPORTANT Java concept:

👉 "Class loading" and "Class initialization"
👉 Difference between:
   1. static final compile-time constants
   2. normal static variables

Java behaves DIFFERENTLY in both cases.

--------------------------------------------------------------------------------
 KEY RULE (VERY IMPORTANT FOR FRESHERS):

 ▶ A class is INITIALIZED only when it is actively used.
 ▶ Accessing a "compile-time constant" DOES NOT trigger class initialization.
 ▶ Accessing a normal static variable DOES trigger class initialization.

================================================================================
*/

public class FinalStaticBlockAndFinalStaticVariable {

    public static void main(String[] args) {

        System.out.println(
                "**** Execution result of TestFinalStaticVariable class object in Main method ****"
        );

        /*
        ------------------------------------------------------------------------
        IMPORTANT:
        x is:
           - static
           - final
           - primitive
           - assigned with a constant value (100)

        Because of this, x is a COMPILE-TIME CONSTANT.

        WHAT JAVA DOES:
        ----------------
        1. During compilation, Java REPLACES:
               TestFinalStaticVariable.x
           WITH:
               100

        2. JVM DOES NOT load or initialize TestFinalStaticVariable class.

        3. Since class is NOT initialized:
               ➜ static block does NOT execute

        PROOF:
        -------
        If static block had executed, you would see:
            "TestFinalStaticBlock Class --- Static Block code"

        But it is NOT printed.
        ------------------------------------------------------------------------
        */
        System.out.println(TestFinalStaticVariable.x);

        System.out.println(
                "#### Execution result of TestFinalStaticBlock class object in Main method ####"
        );

        /*
        ------------------------------------------------------------------------
        IMPORTANT:
        y is:
           - static
           - NOT final

        Because y is NOT final, it is NOT a compile-time constant.

        WHAT JAVA DOES:
        ----------------
        1. JVM must LOAD and INITIALIZE the class to get value of y
        2. During class initialization:
               a) static variables are prepared
               b) static blocks are executed IN ORDER

        ORDER OF EXECUTION:
        -------------------
        Step 1 → Class loading
        Step 2 → Static variable default initialization (y = 0)
        Step 3 → Static block execution
        Step 4 → Static variable assignment (y = 100)
        Step 5 → main() prints y

        That is why STATIC BLOCK runs FIRST before accessing y.
        ------------------------------------------------------------------------
        */
        System.out.println(TestFinalStaticBlock.y);
    }
}

/*
================================================================================
 CLASS 1: static final variable (compile-time constant)
================================================================================
*/
class TestFinalStaticVariable {

    /*
    x is a COMPILE-TIME CONSTANT.

    JVM RULE:
    ---------
    If a static final variable is:
        - primitive OR String
        - assigned with a constant value

    THEN:
        ➜ Value is stored directly in the calling class
        ➜ Class is NOT initialized
        ➜ Static block does NOT execute
    */
    public static final int x = 100;

    static {
        /*
        THIS CODE WILL NOT RUN
        ----------------------
        Because the class is never initialized.

        You can PROVE it:
        -----------------
        Change x to:
            public static final int x = new Integer(100);

        OR
            public static int x = 100;

        Then this static block WILL execute.
        */
        System.out.println("TestFinalStaticVariable Class --- Static Block code");
    }
}

/*
================================================================================
 CLASS 2: normal static variable
================================================================================
*/
class TestFinalStaticBlock {

    /*
    y is a NORMAL static variable (NOT final).

    JVM RULE:
    ---------
    Accessing ANY non-final static variable
        ➜ triggers class initialization
    */
    public static int y = 100;

    static {
        /*
        THIS CODE WILL ALWAYS RUN
        -------------------------
        Because accessing y requires JVM to initialize the class.

        Execution Order Proof:
        ----------------------
        1. JVM initializes class
        2. Executes static block
        3. Assigns y = 100
        4. Prints y in main()
        */
        System.out.println("TestFinalStaticBlock Class --- Static Block code");
    }
}

/*
================================================================================
 QUICK SUMMARY (VERY IMPORTANT FOR INTERVIEWS)
================================================================================

Case 1: static final primitive / String constant
------------------------------------------------
✔ Stored at compile time
✔ Class NOT initialized
✔ Static block NOT executed

Case 2: static (non-final) variable
-----------------------------------
✔ Runtime access
✔ Class initialized
✔ Static block executed FIRST

================================================================================
 FINAL INTERVIEW LINE:
 "Accessing a compile-time constant does not trigger class initialization,
  but accessing a normal static variable does."
================================================================================
*/
