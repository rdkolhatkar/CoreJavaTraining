package com.concepts.basics;

/*
 * ============================================================
 *  FILE      : BasicsOfJava.java
 *  PURPOSE   : A complete, beginner-friendly tour of core Java
 *              concepts — structure, data types, operators,
 *              math, bitwise operations, I/O, and more.
 *  AUDIENCE  : Absolute freshers / first-time Java learners
 * ============================================================
 *
 *  HOW TO COMPILE & RUN
 *  ---------------------
 *  1. Open a terminal in the folder that contains this file.
 *  2. Compile :  javac BasicsOfJava.java
 *  3. Run     :  java  BasicsOfJava
 *
 *  ⚠  The "User Input" section will wait for you to type
 *     something and press Enter before continuing.
 * ============================================================
 */

// ─────────────────────────────────────────────────────────────
// IMPORT STATEMENTS
// ─────────────────────────────────────────────────────────────
// "import" brings pre-built Java library classes into scope so
// we can use them without typing the full package path every time.

import java.util.Scanner;   // for reading keyboard input
import java.util.Date;      // legacy date class (still widely seen)
import java.time.*;         // modern date/time API (Java 8+)
import java.time.format.DateTimeFormatter;  // for formatting dates

// ─────────────────────────────────────────────────────────────
// CLASS DECLARATION
// ─────────────────────────────────────────────────────────────
// • Every Java program lives inside at least ONE class.
// • The class name MUST match the filename  →  BasicsOfJava.java
// • "public" means this class is visible to everything.
// ─────────────────────────────────────────────────────────────
public class BasicsOfJava {

    // =========================================================
    // ❶  MAIN METHOD  — The program's entry point
    // =========================================================
    // • JVM (Java Virtual Machine) looks for THIS exact signature
    //   to know where to start execution.
    // • "public"  → accessible from outside the class
    // • "static"  → belongs to the class, not an object instance
    // • "void"    → returns nothing
    // • "String[] args" → command-line arguments array (can be empty)
    // =========================================================
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║        BASICS OF JAVA — Full Tour        ║");
        System.out.println("╚══════════════════════════════════════════╝\n");

        // ── Call each topic method in order ──────────────────
        demonstrateLiteralsAndVariables();
        demonstrateDataTypes();
        demonstrateTypeCasting();
        demonstrateUnicodeSystem();
        demonstrateUserInput();
        demonstrateDateAndTime();
        demonstrateArithmeticOperators();
        demonstrateRelationalOperators();
        demonstrateLogicalOperators();
        demonstrateAssignmentOperators();
        demonstrateBitwiseOperators();
        demonstrateMathOperations();
        demonstrateMixedDataTypeMath();
        demonstrateOperatorPrecedence();
    }

    // =========================================================
    // ❷  HELPER : pretty section header printer
    // =========================================================
    static void printSection(String title) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  " + title);
        System.out.println("=".repeat(60));
    }


    // =========================================================
    // ❸  LITERALS & VARIABLES
    // =========================================================
    /*
     * VARIABLE  → a named box that stores a value in memory.
     *             Syntax:  dataType variableName = value;
     *
     * LITERAL   → a hard-coded, fixed value written directly in
     *             source code (e.g. 42, 3.14, 'A', true, "Hi").
     *
     * TYPES OF LITERALS IN JAVA
     * ─────────────────────────
     *  Integer  literal  →  42        (int by default)
     *  Long     literal  →  42L       (suffix L or l)
     *  Float    literal  →  3.14f     (suffix f or F)
     *  Double   literal  →  3.14      (double by default)
     *  Char     literal  →  'A'       (single quotes)
     *  String   literal  →  "Hello"   (double quotes)
     *  Boolean  literal  →  true / false
     *  Hex      literal  →  0x1A      (prefix 0x)
     *  Octal    literal  →  017       (prefix 0)
     *  Binary   literal  →  0b1010    (prefix 0b, Java 7+)
     *  Underscore in numbers → 1_000_000 (Java 7+, readability)
     */
    static void demonstrateLiteralsAndVariables() {
        printSection("❸ LITERALS & VARIABLES");

        // ── Integer literals ─────────────────────────────────
        int decimal = 255;          // regular base-10
        int hex     = 0xFF;         // 0xFF  == 255 in hex
        int octal   = 0377;         // 0377  == 255 in octal
        int binary  = 0b11111111;   // 0b... == 255 in binary (Java 7+)
        int million = 1_000_000;    // underscores for readability

        System.out.println("decimal = " + decimal); // OUTPUT: 255
        System.out.println("hex     = " + hex);     // OUTPUT: 255
        System.out.println("octal   = " + octal);   // OUTPUT: 255
        System.out.println("binary  = " + binary);  // OUTPUT: 255
        System.out.println("million = " + million); // OUTPUT: 1000000

        // ── Floating-point literals ──────────────────────────
        float  pi32 = 3.14f;        // 'f' suffix = float (32-bit)
        double pi64 = 3.141592653589793; // no suffix = double (64-bit)
        double sci  = 1.5e3;        // scientific notation = 1500.0

        System.out.println("pi32 = " + pi32);       // OUTPUT: 3.14
        System.out.println("pi64 = " + pi64);       // OUTPUT: 3.141592653589793
        System.out.println("sci  = " + sci);        // OUTPUT: 1500.0

        // ── Character & String literals ──────────────────────
        char   letter  = 'A';       // single character — single quotes
        char   digit   = '9';
        char   special = '\n';      // escape sequence = newline
        String greeting = "Hello, Java!"; // String — double quotes

        System.out.println("letter  = " + letter);  // OUTPUT: A
        System.out.println("digit   = " + digit);   // OUTPUT: 9
        System.out.println("greeting= " + greeting);// OUTPUT: Hello, Java!

        // ── Boolean literals ─────────────────────────────────
        boolean isJavaFun   = true;
        boolean isBoring    = false;

        System.out.println("isJavaFun = " + isJavaFun);  // OUTPUT: true
        System.out.println("isBoring  = " + isBoring);   // OUTPUT: false

        // ── Long literal ─────────────────────────────────────
        long bigNumber = 9_876_543_210L;  // 'L' suffix needed for long
        System.out.println("bigNumber = " + bigNumber);  // OUTPUT: 9876543210

        // ── null literal (only for reference/object types) ───
        String empty = null;   // means "no object assigned"
        System.out.println("empty = " + empty);  // OUTPUT: null
    }


    // =========================================================
    // ❹  DATA TYPES
    // =========================================================
    /*
     * Java is STRONGLY TYPED — every variable must have a declared type.
     *
     * ┌─────────────────────────────────────────────────────────────────┐
     * │              PRIMITIVE DATA TYPES (8 total)                     │
     * ├──────────┬──────────┬────────────────────┬──────────────────────┤
     * │  Type    │  Size    │    Range / Values   │  Default Value       │
     * ├──────────┼──────────┼────────────────────┼──────────────────────┤
     * │  byte    │  1 byte  │   -128  to  127     │  0                   │
     * │  short   │  2 bytes │ -32768  to  32767   │  0                   │
     * │  int     │  4 bytes │  ~-2.1B to ~2.1B    │  0                   │
     * │  long    │  8 bytes │  very large range   │  0L                  │
     * │  float   │  4 bytes │  ~±3.4 × 10^38      │  0.0f                │
     * │  double  │  8 bytes │  ~±1.8 × 10^308     │  0.0d                │
     * │  char    │  2 bytes │  0 to 65535 (Unicode)│  '\u0000'           │
     * │  boolean │  ~1 bit  │  true / false       │  false               │
     * └──────────┴──────────┴────────────────────┴──────────────────────┘
     *
     * NON-PRIMITIVE (Reference) types → String, Arrays, Classes, etc.
     *   These store the ADDRESS (reference) to an object in heap memory,
     *   not the actual value directly.
     */
    static void demonstrateDataTypes() {
        printSection("❹ DATA TYPES");

        // ── Primitive types ──────────────────────────────────
        byte   b  = 100;            // -128 to 127
        short  s  = 30_000;         // -32768 to 32767
        int    i  = 2_000_000_000;  // ~2.1 billion
        long   l  = 9_000_000_000L; // needs 'L' suffix

        float  f  = 3.14f;          // ~7 decimal digits precision
        double d  = 3.14159265358979323846; // ~15-16 decimal digits

        char   c  = 'Z';            // Unicode character
        boolean flag = true;

        System.out.println("byte    b  = " + b);    // OUTPUT: 100
        System.out.println("short   s  = " + s);    // OUTPUT: 30000
        System.out.println("int     i  = " + i);    // OUTPUT: 2000000000
        System.out.println("long    l  = " + l);    // OUTPUT: 9000000000
        System.out.println("float   f  = " + f);    // OUTPUT: 3.14
        System.out.println("double  d  = " + d);    // OUTPUT: 3.141592653589793
        System.out.println("char    c  = " + c);    // OUTPUT: Z
        System.out.println("boolean flag = " + flag);// OUTPUT: true

        // ── MIN & MAX values of each type ────────────────────
        System.out.println("\n-- Min / Max values --");
        System.out.println("Byte   min=" + Byte.MIN_VALUE    + "  max=" + Byte.MAX_VALUE);
        // OUTPUT: Byte   min=-128  max=127

        System.out.println("Short  min=" + Short.MIN_VALUE   + "  max=" + Short.MAX_VALUE);
        // OUTPUT: Short  min=-32768  max=32767

        System.out.println("Int    min=" + Integer.MIN_VALUE + "  max=" + Integer.MAX_VALUE);
        // OUTPUT: Int    min=-2147483648  max=2147483647

        System.out.println("Long   min=" + Long.MIN_VALUE    + "  max=" + Long.MAX_VALUE);
        // OUTPUT: Long   min=-9223372036854775808  max=9223372036854775807

        System.out.println("Float  max=" + Float.MAX_VALUE);
        // OUTPUT: Float  max=3.4028235E38

        System.out.println("Double max=" + Double.MAX_VALUE);
        // OUTPUT: Double max=1.7976931348623157E308

        // ── Non-primitive / Reference types ──────────────────
        String name  = "Alice";          // String object on heap
        int[]  nums  = {10, 20, 30};     // int array
        System.out.println("\nString name  = " + name);    // OUTPUT: Alice
        System.out.println("Array  nums[1]= " + nums[1]);  // OUTPUT: 20
    }


    // =========================================================
    // ❺  TYPE CASTING
    // =========================================================
    /*
     * CASTING = converting one data type to another.
     *
     * TWO KINDS
     * ──────────────────────────────────────────────────────────
     * 1. WIDENING (Implicit / Automatic)
     *    Smaller  →  Larger type. No data loss. Java does it for you.
     *    byte → short → int → long → float → double
     *
     * 2. NARROWING (Explicit / Manual)
     *    Larger → Smaller type. Risk of DATA LOSS. YOU must write the cast.
     *    Syntax:  (targetType) value
     *    double → float → long → int → short → byte
     */
    static void demonstrateTypeCasting() {
        printSection("❺ TYPE CASTING");

        // ── Widening (Automatic) ─────────────────────────────
        int   intVal    = 100;
        long  longVal   = intVal;    // int  → long   (widening, automatic)
        float floatVal  = longVal;   // long → float  (widening, automatic)
        double dblVal   = floatVal;  // float→ double (widening, automatic)

        System.out.println("-- Widening (no cast needed) --");
        System.out.println("int    intVal  = " + intVal);   // OUTPUT: 100
        System.out.println("long   longVal = " + longVal);  // OUTPUT: 100
        System.out.println("float  floatVal= " + floatVal); // OUTPUT: 100.0
        System.out.println("double dblVal  = " + dblVal);   // OUTPUT: 100.0

        // ── Narrowing (Explicit / Manual) ────────────────────
        double pi       = 3.99999;
        int    piAsInt  = (int) pi;  // (int) is the CAST operator
        // Narrowing TRUNCATES the decimal part — it does NOT round!
        // 3.99999 becomes 3, not 4

        System.out.println("\n-- Narrowing (explicit cast) --");
        System.out.println("double pi      = " + pi);       // OUTPUT: 3.99999
        System.out.println("int    piAsInt = " + piAsInt);  // OUTPUT: 3  (truncated!)

        // ── Byte overflow example ────────────────────────────
        int   bigInt  = 130;          // 130 > byte max (127)
        byte  smallB  = (byte) bigInt;
        // Overflow happens! 130 - 256 = -126
        System.out.println("\nint  bigInt = " + bigInt);    // OUTPUT: 130
        System.out.println("byte smallB = " + smallB);      // OUTPUT: -126  (overflow!)

        // ── char ↔ int casting ───────────────────────────────
        char ch      = 'A';
        int  asciiA  = (int) ch;       // char → int  gives Unicode/ASCII value
        char fromInt = (char) 66;      // int  → char gives the character 'B'

        System.out.println("\nchar 'A' as int  = " + asciiA);  // OUTPUT: 65
        System.out.println("int  66   as char = " + fromInt);  // OUTPUT: B

        // ── String ↔ number conversions ──────────────────────
        String numStr  = "42";
        int    parsed  = Integer.parseInt(numStr);   // String → int
        String back    = String.valueOf(parsed + 1); // int    → String

        System.out.println("\nString \"42\" parsed  = " + parsed); // OUTPUT: 42
        System.out.println("int 43 as String    = " + back);      // OUTPUT: 43
    }


    // =========================================================
    // ❻  UNICODE SYSTEM
    // =========================================================
    /*
     * UNICODE
     * ────────
     * • A universal character encoding standard that assigns a
     *   unique number (code point) to every character in every
     *   language + symbols + emoji.
     * • Java's char type is 16-bit → supports Unicode 0 to 65535.
     * • Unicode literals in Java starts with \ u XXXX  (4 hex digits)
     *
     * EXAMPLES
     *   'A'  = '\u0041'  = 65
     *   'a'  = '\u0061'  = 97
     *   '0'  = '\u0030'  = 48
     *   '©'  = '\u00A9'
     *   '™'  = '\u2122'
     *   '★'  = '\u2605'
     */
    static void demonstrateUnicodeSystem() {
        printSection("❻ UNICODE SYSTEM");

        char A    = '\u0041';   // Unicode escape for 'A'
        char a    = '\u0061';   // 'a'
        char copy = '\u00A9';   // ©
        char tm   = '\u2122';   // ™
        char star = '\u2605';   // ★
        char heart= '\u2764';   // ❤

        System.out.println("\\u0041 = " + A);     // OUTPUT: A
        System.out.println("\\u0061 = " + a);     // OUTPUT: a
        System.out.println("\\u00A9 = " + copy);  // OUTPUT: ©
        System.out.println("\\u2122 = " + tm);    // OUTPUT: ™
        System.out.println("\\u2605 = " + star);  // OUTPUT: ★
        System.out.println("\\u2764 = " + heart); // OUTPUT: ❤

        // ── char arithmetic uses Unicode values ──────────────
        char ch   = 'A';
        int  code = ch;          // widening: char → int gives 65
        char next = (char)(ch + 1); // 65 + 1 = 66 → 'B'

        System.out.println("\nchar 'A' Unicode value = " + code); // OUTPUT: 65
        System.out.println("'A' + 1 = '" + next + "'");           // OUTPUT: B

        // ── Looping through uppercase letters ────────────────
        System.out.print("A to Z: ");
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c + " ");
        }
        // OUTPUT: A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
        System.out.println();

        // ── Digits in Unicode ────────────────────────────────
        System.out.println("'0' to '9' Unicode range: " +
                (int)'0' + " to " + (int)'9');
        // OUTPUT: '0' to '9' Unicode range: 48 to 57
    }


    // =========================================================
    // ❼  USER INPUT (Scanner)
    // =========================================================
    /*
     * Scanner class (java.util.Scanner) reads input from different
     * sources. Here we use System.in (keyboard / stdin).
     *
     * Common Scanner methods:
     *   nextLine()   → reads a full line (String)
     *   next()       → reads one word (String, stops at whitespace)
     *   nextInt()    → reads an int
     *   nextDouble() → reads a double
     *   nextBoolean()→ reads true/false
     *
     * IMPORTANT: Always close the Scanner when done to free resources.
     */
    static void demonstrateUserInput() {
        printSection("❼ USER INPUT (Scanner)");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();   // reads the full line typed

        System.out.print("Enter your age : ");
        int age = scanner.nextInt();        // reads an integer

        System.out.println("\nHello, " + name + "! You are " + age + " years old.");
        // OUTPUT (example): Hello, Alice! You are 25 years old.

        // NOTE: We leave the scanner open so it can be reused in this run.
        // In a real app you would call scanner.close() at the end.
    }


    // =========================================================
    // ❽  DATE AND TIME
    // =========================================================
    /*
     * Java has two date/time APIs:
     *
     * LEGACY  (java.util.Date)       → old, avoid for new code
     * MODERN  (java.time.*)          → Java 8+, preferred
     *
     * Key modern classes:
     *   LocalDate      → date only (year, month, day)
     *   LocalTime      → time only (hour, minute, second, nano)
     *   LocalDateTime  → date + time (no timezone)
     *   ZonedDateTime  → date + time + timezone
     *   DateTimeFormatter → formats/parses date-time strings
     */
    static void demonstrateDateAndTime() {
        printSection("❽ DATE AND TIME");

        // ── Legacy Date (still seen in older codebases) ───────
        Date legacyDate = new Date();
        System.out.println("Legacy Date  : " + legacyDate);
        // OUTPUT: Mon Jun 02 14:30:00 IST 2025  (varies)

        // ── Modern API ───────────────────────────────────────
        LocalDate      today    = LocalDate.now();
        LocalTime      now      = LocalTime.now();
        LocalDateTime  dateTime = LocalDateTime.now();

        System.out.println("LocalDate    : " + today);    // 2025-06-02
        System.out.println("LocalTime    : " + now);      // 14:30:00.123456789
        System.out.println("LocalDateTime: " + dateTime); // 2025-06-02T14:30:00.123

        // ── Specific date/time construction ──────────────────
        LocalDate dob = LocalDate.of(2000, 1, 15); // Jan 15, 2000
        System.out.println("Date of Birth: " + dob);  // OUTPUT: 2000-01-15

        // ── Formatting ───────────────────────────────────────
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        String formatted = dateTime.format(fmt);
        System.out.println("Formatted    : " + formatted);
        // OUTPUT: 02-Jun-2025 14:30:00  (varies)

        // ── Date arithmetic ───────────────────────────────────
        LocalDate nextWeek = today.plusDays(7);
        LocalDate lastYear = today.minusYears(1);
        System.out.println("Next week    : " + nextWeek);  // 7 days from now
        System.out.println("Last year    : " + lastYear);  // same date, -1 year

        // ── Day of week, month, year ─────────────────────────
        System.out.println("Day of week  : " + today.getDayOfWeek());  // e.g. MONDAY
        System.out.println("Month        : " + today.getMonth());       // e.g. JUNE
        System.out.println("Year         : " + today.getYear());        // e.g. 2025

        // ── ZonedDateTime for timezone awareness ─────────────
        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("India (IST)  : " + indiaTime);
        // OUTPUT: 2025-06-02T14:30:00.123+05:30[Asia/Kolkata]
    }


    // =========================================================
    // ❾  ARITHMETIC OPERATORS
    // =========================================================
    /*
     * Operator  Symbol   Description
     * ─────────────────────────────────
     * Addition     +     adds two values
     * Subtraction  -     subtracts right from left
     * Multiplication *   multiplies two values
     * Division     /     divides left by right
     * Modulus      %     remainder of division
     * Increment    ++    adds 1 to variable
     * Decrement    --    subtracts 1 from variable
     *
     * Prefix  (++x)  →  increment FIRST, then use value
     * Postfix (x++)  →  use value FIRST, then increment
     */
    static void demonstrateArithmeticOperators() {
        printSection("❾ ARITHMETIC OPERATORS");

        int a = 17, b = 5;

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a + b  = " + (a + b));  // OUTPUT: 22
        System.out.println("a - b  = " + (a - b));  // OUTPUT: 12
        System.out.println("a * b  = " + (a * b));  // OUTPUT: 85
        System.out.println("a / b  = " + (a / b));  // OUTPUT: 3  (integer division, drops .4)
        System.out.println("a % b  = " + (a % b));  // OUTPUT: 2  (17 = 3×5 + 2)

        // Why a/b = 3?  17 ÷ 5 = 3.4, but both are int → 3 (truncated)
        // For real division use double:
        System.out.println("17.0/5 = " + (17.0 / 5)); // OUTPUT: 3.4

        // ── Increment / Decrement ────────────────────────────
        int x = 10;

        System.out.println("\nPrefix  ++x  : " + (++x)); // OUTPUT: 11  (x becomes 11 first)
        System.out.println("Postfix x++  : " + (x++));  // OUTPUT: 11  (prints 11, THEN x=12)
        System.out.println("x after both : " + x);       // OUTPUT: 12

        int y = 10;
        System.out.println("\nPrefix  --y  : " + (--y)); // OUTPUT: 9
        System.out.println("Postfix y--  : " + (y--));  // OUTPUT: 9   (prints 9, THEN y=8)
        System.out.println("y after both : " + y);       // OUTPUT: 8

        // ── Modulus with negative numbers ────────────────────
        System.out.println("\n-17 % 5  = " + (-17 % 5));  // OUTPUT: -2  (sign follows dividend)
        System.out.println("17 % -5  = " + (17 % -5));   // OUTPUT:  2
    }


    // =========================================================
    // ❿  RELATIONAL (COMPARISON) OPERATORS
    // =========================================================
    /*
     * Compare two values and return a boolean (true / false).
     *
     * Operator   Meaning
     * ─────────────────────────────
     *   ==       equal to
     *   !=       not equal to
     *   >        greater than
     *   <        less than
     *   >=       greater than or equal to
     *   <=       less than or equal to
     */
    static void demonstrateRelationalOperators() {
        printSection("❿ RELATIONAL OPERATORS");

        int a = 10, b = 20;

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a == b  : " + (a == b));  // OUTPUT: false
        System.out.println("a != b  : " + (a != b));  // OUTPUT: true
        System.out.println("a >  b  : " + (a >  b));  // OUTPUT: false
        System.out.println("a <  b  : " + (a <  b));  // OUTPUT: true
        System.out.println("a >= b  : " + (a >= b));  // OUTPUT: false
        System.out.println("a <= b  : " + (a <= b));  // OUTPUT: true

        // ── Common mistake: == vs .equals() for Strings ──────
        String s1 = new String("hello");
        String s2 = new String("hello");

        System.out.println("\ns1 == s2        : " + (s1 == s2));
        // OUTPUT: false  — == compares REFERENCES (memory addresses), not content

        System.out.println("s1.equals(s2)   : " + s1.equals(s2));
        // OUTPUT: true   — .equals() compares actual CHARACTER CONTENT
    }


    // =========================================================
    // ⓫  LOGICAL OPERATORS
    // =========================================================
    /*
     * Combine boolean expressions. Used in if/while conditions.
     *
     * Operator   Symbol  Description
     * ─────────────────────────────────────────────────────────
     * AND          &&    true only if BOTH sides are true
     * OR           ||    true if AT LEAST ONE side is true
     * NOT          !     flips true→false, false→true
     *
     * SHORT-CIRCUIT EVALUATION (important!)
     * ───────────────────────────────────────
     * &&  →  if the LEFT side is FALSE, Java skips the right side entirely
     *        (because false && anything == false, no need to check more)
     * ||  →  if the LEFT side is TRUE,  Java skips the right side entirely
     *        (because true  || anything == true)
     */
    static void demonstrateLogicalOperators() {
        printSection("⓫ LOGICAL OPERATORS");

        boolean t = true, f = false;

        // AND ( && )
        System.out.println("true  && true  = " + (t && t));  // OUTPUT: true
        System.out.println("true  && false = " + (t && f));  // OUTPUT: false
        System.out.println("false && true  = " + (f && t));  // OUTPUT: false
        System.out.println("false && false = " + (f && f));  // OUTPUT: false

        // OR ( || )
        System.out.println("\ntrue  || true  = " + (t || t)); // OUTPUT: true
        System.out.println("true  || false = " + (t || f)); // OUTPUT: true
        System.out.println("false || true  = " + (f || t)); // OUTPUT: true
        System.out.println("false || false = " + (f || f)); // OUTPUT: false

        // NOT ( ! )
        System.out.println("\n!true  = " + !t);   // OUTPUT: false
        System.out.println("!false = " + !f);   // OUTPUT: true

        // ── Practical example ─────────────────────────────────
        int age   = 20;
        boolean hasTicket = true;

        boolean canEnter = (age >= 18) && hasTicket;
        System.out.println("\nage>=18 && hasTicket → canEnter = " + canEnter);
        // OUTPUT: true

        // ── Short-circuit demo ────────────────────────────────
        int[] arr = null;  // null array — accessing arr.length would crash

        // Without short-circuit this would throw NullPointerException:
        // if (arr.length > 0 && arr[0] == 1) ...

        // BUT with &&, if left side is false, right side is NEVER evaluated:
        boolean safe = (arr != null) && (arr.length > 0);
        System.out.println("Short-circuit safe check = " + safe);
        // OUTPUT: false  (arr==null, so right side arr.length is never touched)
    }


    // =========================================================
    // ⓬  ASSIGNMENT OPERATORS
    // =========================================================
    /*
     * Assign a value to a variable. Compound operators combine
     * an arithmetic/bitwise operation with assignment.
     *
     * Operator   Equivalent to     Example
     * ──────────────────────────────────────────
     *   =        a = b             a = 5
     *   +=       a = a + b         a += 3  →  a = a + 3
     *   -=       a = a - b         a -= 2
     *   *=       a = a * b         a *= 4
     *   /=       a = a / b         a /= 2
     *   %=       a = a % b         a %= 3
     *   &=       a = a & b         (bitwise AND assign)
     *   |=       a = a | b         (bitwise OR  assign)
     *   ^=       a = a ^ b         (bitwise XOR assign)
     *   <<=      a = a << b        (left shift assign)
     *   >>=      a = a >> b        (right shift assign)
     *   >>>=     a = a >>> b       (unsigned right shift assign)
     */
    static void demonstrateAssignmentOperators() {
        printSection("⓬ ASSIGNMENT OPERATORS");

        int a = 20;
        System.out.println("Initial a = " + a);   // OUTPUT: 20

        a += 5;  System.out.println("a += 5  → " + a);  // OUTPUT: 25
        a -= 3;  System.out.println("a -= 3  → " + a);  // OUTPUT: 22
        a *= 2;  System.out.println("a *= 2  → " + a);  // OUTPUT: 44
        a /= 4;  System.out.println("a /= 4  → " + a);  // OUTPUT: 11
        a %= 3;  System.out.println("a %= 3  → " + a);  // OUTPUT: 2  (11 % 3 = 2)

        // Bitwise assignment operators
        a  = 0b1010;   // a = 10 in binary
        System.out.println("\na reset to 1010 (10)");
        a &= 0b1100;   // 1010 & 1100 = 1000 = 8
        System.out.println("a &= 1100 → " + a);  // OUTPUT: 8

        a  = 0b1010;
        a |= 0b0101;   // 1010 | 0101 = 1111 = 15
        System.out.println("a |= 0101 → " + a);  // OUTPUT: 15

        a  = 0b1010;
        a ^= 0b1100;   // 1010 ^ 1100 = 0110 = 6
        System.out.println("a ^= 1100 → " + a);  // OUTPUT: 6
    }


    // =========================================================
    // ⓭  BITWISE OPERATORS  (with detailed tables)
    // =========================================================
    /*
     * Bitwise operators work on individual BITS of integer values.
     * Java integers are stored in TWO'S COMPLEMENT binary.
     *
     * OPERATORS OVERVIEW
     * ─────────────────────────────────────────────────────────
     *  &   Bitwise AND            |   Bitwise OR
     *  ^   Bitwise XOR            ~   Bitwise NOT (complement)
     *  <<  Left shift             >>  Signed right shift
     *  >>> Unsigned right shift
     *
     * ═══════════════════════════════════════
     * TRUTH TABLES FOR BIT OPERATIONS
     * ═══════════════════════════════════════
     *
     * AND ( & )            OR  ( | )            XOR ( ^ )
     * ──────────────       ──────────────       ──────────────
     * Bit A | Bit B | Out  Bit A | Bit B | Out  Bit A | Bit B | Out
     *   0   |   0   |  0     0   |   0   |  0     0   |   0   |  0
     *   0   |   1   |  0     0   |   1   |  1     0   |   1   |  1
     *   1   |   0   |  0     1   |   0   |  1     1   |   0   |  1
     *   1   |   1   |  1     1   |   1   |  1     1   |   1   |  0
     * AND = 1 only if BOTH   OR  = 1 if at least  XOR = 1 only if
     *       bits are 1              one is 1             bits DIFFER
     *
     * NOT ( ~ ) — flips every single bit:
     *   ~0 = 1   ~1 = 0
     *   For int n: ~n  =  -(n+1)    (two's complement rule)
     */
    static void demonstrateBitwiseOperators() {
        printSection("⓭ BITWISE OPERATORS");

        // ────────────────────────────────────────────────────
        // EXAMPLE  :  a = 5 (binary 0101)
        //             b = 3 (binary 0011)
        // ────────────────────────────────────────────────────
        //
        //   Bit position:  3  2  1  0
        //   a = 5        : 0  1  0  1
        //   b = 3        : 0  0  1  1
        //                  ─  ─  ─  ─
        //   a & b (AND)  : 0  0  0  1  = 1
        //   a | b (OR)   : 0  1  1  1  = 7
        //   a ^ b (XOR)  : 0  1  1  0  = 6
        //   ~a    (NOT)  : ...1111 1010  = -6  (in 32-bit two's complement)

        int a = 5, b = 3;

        System.out.println("a = " + a + "  binary: " + Integer.toBinaryString(a));
        // OUTPUT: a = 5  binary: 101

        System.out.println("b = " + b + "  binary: " + Integer.toBinaryString(b));
        // OUTPUT: b = 3  binary: 11

        System.out.println("\n-- AND (&) --");
        System.out.println(
                "  0101  (5)\n& 0011  (3)\n------\n  0001  = " + (a & b));
        // OUTPUT: 1

        System.out.println("\n-- OR (|) --");
        System.out.println(
                "  0101  (5)\n| 0011  (3)\n------\n  0111  = " + (a | b));
        // OUTPUT: 7

        System.out.println("\n-- XOR (^) --");
        System.out.println(
                "  0101  (5)\n^ 0011  (3)\n------\n  0110  = " + (a ^ b));
        // OUTPUT: 6

        System.out.println("\n-- NOT (~) --");
        System.out.println("~" + a + " = " + (~a));
        // OUTPUT: ~5 = -6
        // Explanation: ~n = -(n+1)  →  ~5 = -(5+1) = -6
        // In 32-bit binary: 5 = 00000000 00000000 00000000 00000101
        //                  ~5 = 11111111 11111111 11111111 11111010  (= -6)

        // ────────────────────────────────────────────────────
        // SHIFT OPERATORS
        // ────────────────────────────────────────────────────
        /*
         * LEFT SHIFT  (<<)
         * ─────────────────
         * a << n  →  shift all bits n positions LEFT
         *            fill right side with 0s
         *            equivalent to  a × 2^n  (for non-overflow values)
         *
         * Example: 5 << 1
         *   0000 0101  (5)
         *   0000 1010  (10)   ← shifted left by 1, filled 0 on right
         *
         * SIGNED RIGHT SHIFT  (>>)
         * ─────────────────────────
         * a >> n  →  shift bits n positions RIGHT
         *            fill left side with the SIGN BIT (MSB)
         *            positive numbers fill with 0 (no change in sign)
         *            negative numbers fill with 1 (stays negative)
         *            equivalent to  a ÷ 2^n  (floor division)
         *
         * UNSIGNED RIGHT SHIFT  (>>>)
         * ────────────────────────────
         * a >>> n → shift bits n positions RIGHT
         *           ALWAYS fill left side with 0 regardless of sign
         *           so a negative number BECOMES positive!
         */
        System.out.println("\n-- LEFT SHIFT (<<) --");
        int x = 5;
        // 5  = 00000000 00000000 00000000 00000101
        // 5<<1 = 00000000 00000000 00000000 00001010 = 10
        System.out.println(x + " << 1 = " + (x << 1));  // OUTPUT: 10  (5 × 2)
        System.out.println(x + " << 2 = " + (x << 2));  // OUTPUT: 20  (5 × 4)
        System.out.println(x + " << 3 = " + (x << 3));  // OUTPUT: 40  (5 × 8)

        System.out.println("\n-- SIGNED RIGHT SHIFT (>>) with POSITIVE number --");
        int p = 20;
        // 20  = 00000000 00000000 00000000 00010100
        // 20>>1 = 00000000 00000000 00000000 00001010 = 10
        System.out.println(p + " >> 1 = " + (p >> 1));  // OUTPUT: 10  (20 ÷ 2)
        System.out.println(p + " >> 2 = " + (p >> 2));  // OUTPUT: 5   (20 ÷ 4)

        // ────────────────────────────────────────────────────
        // NEGATIVE NUMBER EXAMPLE  (the interesting case!)
        // ────────────────────────────────────────────────────
        /*
         * TWO'S COMPLEMENT REFRESHER
         * ───────────────────────────
         * To represent -5 in 32-bit two's complement:
         *   Step 1: write +5 in binary
         *           00000000 00000000 00000000 00000101
         *   Step 2: flip all bits (one's complement)
         *           11111111 11111111 11111111 11111010
         *   Step 3: add 1
         *           11111111 11111111 11111111 11111011  ← this is -5
         */
        System.out.println("\n-- NEGATIVE NUMBER & SHIFTS --");
        int neg = -5;
        System.out.println("neg = " + neg);
        System.out.println("Binary of -5  : " + Integer.toBinaryString(neg));
        // OUTPUT: 11111111111111111111111111111011
        // (32 bits, leading 1 = negative in two's complement)

        // Signed right shift: fills with 1 (sign bit) on the left
        int c1 = neg >> 2;
        // 11111111 11111111 11111111 11111011   (-5)
        // 11111111 11111111 11111111 11111110   (-2)   (>> 2, filled with 1s)
        System.out.println("-5 >> 2       = " + c1);
        // OUTPUT: -2
        System.out.println("Binary        : " + Integer.toBinaryString(c1));
        // OUTPUT: 11111111111111111111111111111110

        // Unsigned right shift: fills with 0 on the left → POSITIVE result!
        int c2 = neg >>> 2;
        // 11111111 11111111 11111111 11111011   (-5)
        // 00111111 11111111 11111111 11111110   (1073741822)  (>>> 2, filled 0s)
        System.out.println("-5 >>> 2      = " + c2);
        // OUTPUT: 1073741822   (HUGE positive number!)
        System.out.println("Binary        : " + Integer.toBinaryString(c2));
        // OUTPUT: 00111111111111111111111111111110

        // ── Summary table ────────────────────────────────────
        System.out.println("\n-- BITWISE SUMMARY TABLE (a=5, b=3) --");
        System.out.println("┌──────────────┬──────────────────┬────────┐");
        System.out.println("│  Operation   │  Binary Result   │  Dec   │");
        System.out.println("├──────────────┼──────────────────┼────────┤");
        System.out.printf( "│  5  & 3      │      0001        │  %4d  │%n", (a & b));
        System.out.printf( "│  5  | 3      │      0111        │  %4d  │%n", (a | b));
        System.out.printf( "│  5  ^ 3      │      0110        │  %4d  │%n", (a ^ b));
        System.out.printf( "│  ~5           │  (32-bit flip)   │  %4d  │%n", (~a));
        System.out.printf( "│  5  << 1     │      1010        │  %4d  │%n", (a << 1));
        System.out.printf( "│  5  >> 1     │      0010        │  %4d  │%n", (a >> 1));
        System.out.printf( "│ -5  >> 2     │   (sign-filled)  │  %4d  │%n", (neg >> 2));
        System.out.printf( "│ -5  >>> 2    │   (zero-filled)  │  %4d  │%n", (neg >>> 2));
        System.out.println("└──────────────┴──────────────────┴────────┘");
    }


    // =========================================================
    // ⓮  MATH OPERATIONS (java.lang.Math)
    // =========================================================
    /*
     * java.lang.Math is automatically available (no import needed).
     * All methods are static — call as  Math.methodName(args).
     *
     * Common methods:
     *   Math.abs(x)        → absolute value
     *   Math.pow(x, y)     → x raised to the power y
     *   Math.sqrt(x)       → square root
     *   Math.cbrt(x)       → cube root
     *   Math.floor(x)      → round DOWN to nearest integer
     *   Math.ceil(x)       → round UP   to nearest integer
     *   Math.round(x)      → round to NEAREST integer
     *   Math.max(a, b)     → larger  of a and b
     *   Math.min(a, b)     → smaller of a and b
     *   Math.log(x)        → natural log (base e)
     *   Math.log10(x)      → log base 10
     *   Math.sin/cos/tan   → trig functions (angle in RADIANS)
     *   Math.PI            → π ≈ 3.14159...
     *   Math.E             → e ≈ 2.71828...
     *   Math.random()      → pseudo-random double in [0.0, 1.0)
     */
    static void demonstrateMathOperations() {
        printSection("⓮ MATH OPERATIONS (java.lang.Math)");

        System.out.println("Math.abs(-42)      = " + Math.abs(-42));      // OUTPUT: 42
        System.out.println("Math.pow(2, 10)    = " + Math.pow(2, 10));    // OUTPUT: 1024.0
        System.out.println("Math.sqrt(144)     = " + Math.sqrt(144));     // OUTPUT: 12.0
        System.out.println("Math.cbrt(27)      = " + Math.cbrt(27));      // OUTPUT: 3.0

        System.out.println("Math.floor(3.7)    = " + Math.floor(3.7));    // OUTPUT: 3.0
        System.out.println("Math.ceil(3.1)     = " + Math.ceil(3.1));     // OUTPUT: 4.0
        System.out.println("Math.round(3.5)    = " + Math.round(3.5));    // OUTPUT: 4
        System.out.println("Math.round(3.49)   = " + Math.round(3.49));   // OUTPUT: 3

        System.out.println("Math.max(18, 42)   = " + Math.max(18, 42));   // OUTPUT: 42
        System.out.println("Math.min(18, 42)   = " + Math.min(18, 42));   // OUTPUT: 18

        System.out.println("Math.log(Math.E)   = " + Math.log(Math.E));   // OUTPUT: 1.0
        System.out.println("Math.log10(1000)   = " + Math.log10(1000));   // OUTPUT: 3.0

        System.out.println("Math.PI            = " + Math.PI);
        // OUTPUT: 3.141592653589793

        double angleRad = Math.toRadians(90);   // convert 90° to radians
        System.out.println("Math.sin(90°)      = " + Math.sin(angleRad));
        // OUTPUT: 1.0  (sin 90° = 1)
        System.out.println("Math.cos(90°)      = " + Math.cos(angleRad));
        // OUTPUT: 6.123233995736766E-17  (essentially 0, floating point imprecision)

        double rnd = Math.random();
        System.out.println("Math.random()      = " + rnd);
        // OUTPUT: some double like 0.7362... (random, between 0 and 1)

        // Random int in range [1, 100]:
        int randInt = (int)(Math.random() * 100) + 1;
        System.out.println("Random 1-100       = " + randInt); // e.g. 57
    }


    // =========================================================
    // ⓯  MIXED DATA TYPE ARITHMETIC
    // =========================================================
    /*
     * JAVA TYPE PROMOTION RULES (applied automatically by compiler)
     * ─────────────────────────────────────────────────────────────
     * 1. If one operand is double  → entire expression becomes double
     * 2. Else if one operand is float → entire expression becomes float
     * 3. Else if one operand is long  → entire expression becomes long
     * 4. Otherwise (byte, short, char, int mixed) → promoted to int
     *
     * Hierarchy (widest wins):
     *   byte → short → int → long → float → double
     *
     * The RESULT type = the WIDEST type involved in the expression.
     */
    static void demonstrateMixedDataTypeMath() {
        printSection("⓯ MIXED DATA TYPE ARITHMETIC");

        // Our four variables from the problem statement:
        int    iA = 2;
        float  fB = 3.1413456f;
        double dC = 3.2345;
        byte   bD = 5;

        System.out.println("int   a = " + iA);
        System.out.println("float b = " + fB);
        System.out.println("double c= " + dC);
        System.out.println("byte  d = " + bD);

        // ─────────────────────────────────────────────────────
        // EXPRESSION 1:  a + b - c * d
        //
        // Step-by-step type promotion:
        //
        //  1.  c * d
        //      double(c) * byte(d)  → byte promoted to double
        //      Result type: double
        //      Value      : 3.2345 * 5 = 16.1725
        //
        //  2.  a + b
        //      int(a) + float(b)   → int promoted to float
        //      Result type: float
        //      Value      : 2 + 3.1413456f = 5.1413456f
        //
        //  3.  (a + b) - (c * d)
        //      float - double      → float promoted to double
        //      Result type: DOUBLE
        //      Value      : 5.1413456 - 16.1725 ≈ -11.031154...
        //
        // OUTPUT TYPE: double
        // ─────────────────────────────────────────────────────
        double result1 = iA + fB - dC * bD;
        System.out.println("\na + b - c * d");
        System.out.println("= " + iA + " + " + fB + " - " + dC + " * " + bD);
        System.out.println("Step1: c * d  = " + (dC * bD)         + "  (double)");
        System.out.println("Step2: a + b  = " + (iA + fB)         + "  (float)");
        System.out.println("Step3: final  = " + result1            + "  (double)");
        // OUTPUT: -11.031154632568359  (type: double)

        // ─────────────────────────────────────────────────────
        // EXPRESSION 2:  (a % b) - c % d + 3 * 7
        //
        // OPERATOR PRECEDENCE applies (see next method for full detail)
        // All of  * %  have SAME precedence → evaluated LEFT to RIGHT
        // Then    + -  are evaluated LEFT to RIGHT
        //
        // Evaluation order:
        //  Step 1: a % b   → int % float   → float
        //          2 % 3.1413456f = 2.0f    (2 is less than 3.14, remainder is 2)
        //
        //  Step 2: c % d   → double % byte → double
        //          3.2345 % 5 = 3.2345      (3.2345 < 5, remainder is 3.2345)
        //
        //  Step 3: 3 * 7   → int * int     → int
        //          = 21
        //
        //  Step 4: (result of step1) - (result of step2) + (result of step3)
        //          float  - double + int  → everything → double
        //          2.0 - 3.2345 + 21 = 19.7655
        //
        // OUTPUT TYPE: double
        // ─────────────────────────────────────────────────────
        double result2 = (iA % fB) - dC % bD + 3 * 7;
        System.out.println("\n(a % b) - c % d + 3 * 7");
        System.out.println("Step1: a % b  = " + (iA % fB)   + "  (float)");
        System.out.println("Step2: c % d  = " + (dC % bD)   + "  (double)");
        System.out.println("Step3: 3 * 7  = " + (3 * 7)     + "  (int)");
        System.out.println("Final result  = " + result2      + "  (double)");
        // OUTPUT: 19.7655  (type: double)

        // ── More mixed-type examples ──────────────────────────
        System.out.println("\n-- Additional mixed-type combos --");

        int   i = 10;
        long  l = 3L;
        float f = 2.5f;

        // int + long → long
        long r1 = i + l;
        System.out.println("int(10) + long(3)   = " + r1 + "  (long)");
        // OUTPUT: 13  (long)

        // long + float → float
        float r2 = l + f;
        System.out.println("long(3) + float(2.5)= " + r2 + "  (float)");
        // OUTPUT: 5.5  (float)

        // byte + byte → int  (surprise!)
        byte by1 = 10, by2 = 20;
        // byte result = by1 + by2; // COMPILE ERROR — result is int!
        int r3 = by1 + by2;
        System.out.println("byte(10)+ byte(20)  = " + r3 + "  (int — byte+byte=int!)");
        // OUTPUT: 30  (int)

        // char + int → int
        char ch = 'A'; // Unicode value 65
        int r4 = ch + 1;
        System.out.println("char('A'=65)+int(1) = " + r4 + "  (int, not 'B'!)");
        // OUTPUT: 66  (int) — to get 'B', cast back: (char)(ch+1)
    }


    // =========================================================
    // ⓰  OPERATOR PRECEDENCE & ASSOCIATIVITY
    // =========================================================
    /*
     * OPERATOR PRECEDENCE TABLE (higher number = evaluated FIRST)
     * ─────────────────────────────────────────────────────────────
     * Priority │ Operators                      │ Associativity
     * ─────────┼────────────────────────────────┼───────────────
     *   15     │ ()  []  .                      │ Left to Right
     *   14     │ ++x  --x  ~  !  (type)  +x -x │ Right to Left (unary)
     *   13     │ *   /   %                      │ Left to Right
     *   12     │ +   -                          │ Left to Right
     *   11     │ <<  >>  >>>                    │ Left to Right
     *   10     │ <   <=  >   >=  instanceof     │ Left to Right
     *    9     │ ==  !=                         │ Left to Right
     *    8     │ &  (bitwise AND)               │ Left to Right
     *    7     │ ^  (bitwise XOR)               │ Left to Right
     *    6     │ |  (bitwise OR)                │ Left to Right
     *    5     │ &&  (logical AND)              │ Left to Right
     *    4     │ ||  (logical OR)               │ Left to Right
     *    3     │ ?:  (ternary)                  │ Right to Left
     *    2     │ =  +=  -=  *=  /=  %=  etc.   │ Right to Left
     *    1     │ ,  (comma in for loop)         │ Left to Right
     * ─────────────────────────────────────────────────────────────
     *
     * ASSOCIATIVITY tells us evaluation direction when two operators
     * have the SAME precedence.
     *   Left-to-Right:  a - b - c  →  (a - b) - c
     *   Right-to-Left:  a = b = 5  →  a = (b = 5)
     *
     * BODMAS / VBODMAS in Java:
     *   V = Vinculum (brackets inside brackets)
     *   B = Brackets  ( ) → highest priority, evaluated first
     *   O = Order (powers) → Math.pow()
     *   D = Division  /
     *   M = Multiplication *
     *   A = Addition  +
     *   S = Subtraction -
     *   (DM and AS have same precedence → evaluated LEFT to RIGHT)
     */
    static void demonstrateOperatorPrecedence() {
        printSection("⓰ OPERATOR PRECEDENCE & ASSOCIATIVITY");

        // Example 1: Without parentheses
        int r1 = 2 + 3 * 4;
        // * has higher precedence than +
        // → 2 + (3 * 4) = 2 + 12 = 14
        System.out.println("2 + 3 * 4       = " + r1);  // OUTPUT: 14

        // Example 2: Parentheses override precedence
        int r2 = (2 + 3) * 4;
        // () evaluated first → 5 * 4 = 20
        System.out.println("(2 + 3) * 4     = " + r2);  // OUTPUT: 20

        // Example 3: Same precedence → Left to Right
        int r3 = 20 - 5 + 3;
        // left to right: (20 - 5) + 3 = 15 + 3 = 18
        System.out.println("20 - 5 + 3      = " + r3);  // OUTPUT: 18
        // NOT  20 - (5 + 3) = 12  !

        // Example 4: Mixed *  /  %  (same precedence, left to right)
        int r4 = 24 / 4 * 2 % 5;
        // left to right:
        //   24 / 4 = 6
        //   6  * 2 = 12
        //   12 % 5 = 2
        System.out.println("24 / 4 * 2 % 5  = " + r4);  // OUTPUT: 2

        // Example 5: Assignment right-to-left
        int x, y, z;
        x = y = z = 10;
        // right to left: z=10, then y=10, then x=10
        System.out.println("x=y=z=10 → x=" + x + " y=" + y + " z=" + z);
        // OUTPUT: x=10 y=10 z=10

        // Example 6: Unary vs binary
        int a = 5;
        int r5 = -a * 2;
        // unary minus (priority 14) applies to a first → -5
        // then * 2 → -10
        System.out.println("-a * 2 (a=5)    = " + r5);  // OUTPUT: -10

        // Example 7: Complex expression step by step
        // Expression:  3 + 4 * 2 / (1 - 5) * 2
        //
        // Step 1 — Parentheses:  (1 - 5) = -4
        // Step 2 — left to right among * / * :
        //          4 * 2 = 8
        //          8 / -4 = -2
        //          -2 * 2 = -4
        // Step 3 — Addition: 3 + (-4) = -1
        int r6 = 3 + 4 * 2 / (1 - 5) * 2;
        System.out.println("3+4*2/(1-5)*2   = " + r6);  // OUTPUT: -1

        // Example 8: Logical operator precedence (! > && > ||)
        boolean r7 = true || false && false;
        // && has higher precedence than ||
        // → true || (false && false)
        // → true || false
        // → true
        System.out.println("true||false&&false = " + r7); // OUTPUT: true

        boolean r8 = (true || false) && false;
        // () first → true && false = false
        System.out.println("(true||false)&&false=" + r8); // OUTPUT: false

        // ── Ternary operator (right-to-left) ─────────────────
        int score = 75;
        String grade = score >= 90 ? "A" :
                score >= 75 ? "B" :
                        score >= 60 ? "C" : "F";
        // Right-to-left evaluation:
        // score>=60 ? "C" : "F"  →  "C"
        // score>=75 ? "B" : "C"  →  "B"   (75 >= 75 is true)
        // score>=90 ? "A" : "B"  →  "B"
        System.out.println("score=75 → grade = " + grade);  // OUTPUT: B

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║   End of BasicsOfJava tour. Happy coding! ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }

} // ← END of class BasicsOfJava