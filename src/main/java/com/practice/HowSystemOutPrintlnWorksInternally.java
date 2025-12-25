package com.practice;

public class HowSystemOutPrintlnWorksInternally {
    /*
        Explain how System.out.println("Hello Word"); Works internally in Java?
            System   →   out   →   println()
            (class)     (object)   (method)
    */
    public static void main(String[] args) {
        System.out.println("Hello World !"); // This will print Hello World ! in console
        System.err.println("Hello World Error Ratnakar"); // This will print Hello World Error Ratnakar in console

        // Here the System class has a Static Constructor so we cannot create the object of System class
        // out is the public static final variable in System class:  public static final PrintStream out = null;
        /*
         * System -> A built-in final class from java.lang package
         * out    -> A static object of PrintStream class
         * println() -> A method of PrintStream used to print data
         */
        /*
         * Step 1: JVM loads System class
         * Step 2: JVM accesses static variable 'out'
         * Step 3: 'out' points to PrintStream object
         * Step 4: println() method is called
         * Step 5: Message is printed on console
         */
        /*
        ===================== THE BIG CONFUSION =====================

        System.out is declared like this inside System class:

            public static final PrintStream out;

        Freshers think:
        - It is declared but not assigned
        - So its default value should be null
        - Calling out.println() should throw NullPointerException

        BUT that assumption is WRONG at runtime.
     */
        /*
            ===================== KEY TRUTH =====================

            System.out IS NOT null when your program runs.

            WHY?
            Because JVM initializes it BEFORE main() starts.
         */

        // Proof: If System.out were null, this line itself would throw NPE
        System.out.println("System.out is NOT null, that's why this line works");

        /*
            ===================== WHAT ACTUALLY HAPPENS =====================

            1) JVM starts
            2) JVM loads core classes (Object, Class, System, etc.)
            3) JVM executes System class static initialization
            4) JVM assigns a REAL PrintStream object to System.out
            5) ONLY AFTER THAT, main() method is executed
         */

        /*
            ===================== SIMPLIFIED INTERNAL VIEW =====================

            This is NOT real source code, but a conceptual idea:

            class System {
                public static final PrintStream out;

                static {
                    // Native (C/C++) code inside JVM
                    out = new PrintStream(consoleOutputStream);
                }
            }

            So by the time we reach main(), out already points
            to a valid PrintStream object.
         */

        /*
            ===================== WHY NO NULL POINTER EXCEPTION? =====================

            NullPointerException happens ONLY when:

                reference == null
                AND
                reference.method() is called

            But here:

                System.out != null

            So calling:

                System.out.println()

            is totally safe.
         */

        /*
            ===================== CHECK IT YOURSELF =====================
         */

        // This will always print false
        System.out.println("Is System.out null? -> " + (System.out == null));

        /*
            ===================== WHY IS 'out' FINAL THEN? =====================

            final means:
            - You cannot reassign the reference

            NOT that the value is null
         */

        // ❌ NOT allowed (compile-time error)
        // System.out = null;

        // ❌ NOT allowed
        // System.out = new PrintStream(System.in);

        /*
            ===================== BUT THIS IS ALLOWED =====================
         */

        // Calling methods on the object is perfectly fine
        System.out.println("Calling println() on System.out works fine");

        /*
            ===================== WHY JVM DOES THIS? =====================

            - System.out depends on OS, console, IDE, terminal
            - Java source code must stay platform-independent
            - JVM knows how to connect output correctly

            So Java designers let JVM initialize System.out,
            not Java code.
         */

        /*
            ===================== REAL-LIFE ANALOGY =====================

            System.out is like:
            - A microphone already connected by the event organizer (JVM)
            - You don't connect it
            - You just speak (println)

            Since mic is already connected,
            your voice comes out without error.
         */

        /*
            ===================== FINAL CONCLUSION =====================

            - System.out is declared without assignment in Java code
            - JVM assigns it a real PrintStream object internally
            - This happens BEFORE main() executes
            - Therefore, out is NOT null
            - Hence, out.println() does NOT throw NullPointerException
         */
    }
}
