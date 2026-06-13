package com.concepts.basics;

/*
 * ============================================================================
 * Class Name : JavaFormatSpecifiersDemo
 * Author     : Ratnakar
 *
 * Purpose:
 * Demonstrates all commonly used Java Format Specifiers with detailed comments.
 *
 * Format Syntax:
 *
 * %[argument_index$][flags][width][.precision]conversion
 *
 * Example:
 * %10.2f
 *
 * %      -> Start of format specifier
 * 10     -> Width
 * .2     -> Precision
 * f      -> Floating point conversion
 *
 * ============================================================================
 */

import java.util.Date;

public class JavaFormatSpecifiersDemo {

    public static void main(String[] args) {

        String name = "Ratnakar";
        int age = 26;
        double salary = 123456.789;
        char grade = 'A';
        boolean employed = true;

        Date currentDate = new Date();

        System.out.println("==================================================");
        System.out.println("1. STRING FORMAT SPECIFIERS");
        System.out.println("==================================================");

        // %s -> Prints String as it is
        System.out.printf("%%s  : %s%n", name);

        // %S -> Converts String to uppercase
        System.out.printf("%%S  : %S%n", name);

        System.out.println("\n==================================================");
        System.out.println("2. CHARACTER FORMAT SPECIFIERS");
        System.out.println("==================================================");

        // %c -> Prints character
        System.out.printf("%%c  : %c%n", grade);

        // %C -> Prints character in uppercase
        System.out.printf("%%C  : %C%n", grade);

        System.out.println("\n==================================================");
        System.out.println("3. INTEGER FORMAT SPECIFIERS");
        System.out.println("==================================================");

        // %d -> Decimal integer
        System.out.printf("%%d  : %d%n", age);

        // %+d -> Always display sign
        System.out.printf("%%+d : %+d%n", age);

        // %05d -> Width 5, pad with leading zeros
        System.out.printf("%%05d: %05d%n", age);

        // %10d -> Right-align within width 10
        System.out.printf("%%10d: %10d%n", age);

        // %-10d -> Left-align within width 10
        System.out.printf("%%-10d: %-10d End%n", age);

        // %,d -> Add thousand separators
        System.out.printf("%%,d : %,d%n", 1000000);

        System.out.println("\n==================================================");
        System.out.println("4. FLOATING POINT FORMAT SPECIFIERS");
        System.out.println("==================================================");

        // %f -> Default floating-point number
        System.out.printf("%%f     : %f%n", salary);

        // %.2f -> Display only 2 digits after decimal
        System.out.printf("%%.2f   : %.2f%n", salary);

        // %.3f -> Display only 3 digits after decimal
        System.out.printf("%%.3f   : %.3f%n", salary);

        // %10.2f -> Width 10 and precision 2
        System.out.printf("%%10.2f : %10.2f%n", salary);

        // %-10.2f -> Left aligned
        System.out.printf("%%-10.2f: %-10.2f End%n", salary);

        // %,.2f -> Comma separator + 2 decimal places
        System.out.printf("%%,.2f  : %,.2f%n", salary);

        // %+f -> Show sign
        System.out.printf("%%+f    : %+f%n", salary);

        System.out.println("\n==================================================");
        System.out.println("5. SCIENTIFIC NOTATION");
        System.out.println("==================================================");

        // %e -> Scientific notation
        System.out.printf("%%e : %e%n", salary);

        // %E -> Scientific notation uppercase
        System.out.printf("%%E : %E%n", salary);

        System.out.println("\n==================================================");
        System.out.println("6. GENERAL FORMAT");
        System.out.println("==================================================");

        // %g -> Chooses shorter representation between
        // floating-point and scientific notation
        System.out.printf("%%g : %g%n", salary);

        // %G -> Uppercase version of %g
        System.out.printf("%%G : %G%n", salary);

        System.out.println("\n==================================================");
        System.out.println("7. BOOLEAN FORMAT SPECIFIERS");
        System.out.println("==================================================");

        // %b -> Prints true/false
        System.out.printf("%%b : %b%n", employed);

        // %B -> Prints TRUE/FALSE
        System.out.printf("%%B : %B%n", employed);

        System.out.println("\n==================================================");
        System.out.println("8. HASH CODE FORMAT SPECIFIERS");
        System.out.println("==================================================");

        // %h -> Hexadecimal hash code
        System.out.printf("%%h : %h%n", name);

        // %H -> Uppercase hexadecimal hash code
        System.out.printf("%%H : %H%n", name);

        System.out.println("\n==================================================");
        System.out.println("9. PERCENTAGE AND NEW LINE");
        System.out.println("==================================================");

        // %% -> Print percentage symbol
        System.out.printf("Completed : 95%%%n");

        // %n -> Platform-independent new line
        System.out.printf("Line 1%nLine 2%nLine 3%n");

        System.out.println("\n==================================================");
        System.out.println("10. NUMBER SYSTEM CONVERSIONS");
        System.out.println("==================================================");

        int num = 255;

        // %o -> Octal representation
        System.out.printf("Octal       (%%o) : %o%n", num);

        // %x -> Hexadecimal lowercase
        System.out.printf("Hex Lower   (%%x) : %x%n", num);

        // %X -> Hexadecimal uppercase
        System.out.printf("Hex Upper   (%%X) : %X%n", num);

        System.out.println("\n==================================================");
        System.out.println("11. DATE AND TIME FORMAT SPECIFIERS");
        System.out.println("==================================================");

        // %tH -> Hour (00-23)
        System.out.printf("Hour (24H)         : %tH%n", currentDate);

        // %tI -> Hour (01-12)
        System.out.printf("Hour (12H)         : %tI%n", currentDate);

        // %tM -> Minutes
        System.out.printf("Minutes            : %tM%n", currentDate);

        // %tS -> Seconds
        System.out.printf("Seconds            : %tS%n", currentDate);

        // %tp -> AM/PM
        System.out.printf("AM/PM              : %tp%n", currentDate);

        // %td -> Day of month
        System.out.printf("Day                : %td%n", currentDate);

        // %tm -> Month number
        System.out.printf("Month Number       : %tm%n", currentDate);

        // %tY -> Four digit year
        System.out.printf("Year               : %tY%n", currentDate);

        // %ty -> Two digit year
        System.out.printf("Short Year         : %ty%n", currentDate);

        // %tB -> Full month name
        System.out.printf("Month Name         : %tB%n", currentDate);

        // %tb -> Short month name
        System.out.printf("Short Month Name   : %tb%n", currentDate);

        // %tA -> Full weekday name
        System.out.printf("Day Name           : %tA%n", currentDate);

        // %ta -> Short weekday name
        System.out.printf("Short Day Name     : %ta%n", currentDate);

        // %tF -> ISO Date Format yyyy-MM-dd
        System.out.printf("ISO Date           : %tF%n", currentDate);

        // %tD -> MM/DD/YY
        System.out.printf("US Date            : %tD%n", currentDate);

        // %tT -> HH:mm:ss
        System.out.printf("24 Hour Time       : %tT%n", currentDate);

        // %tr -> 12-hour time format
        System.out.printf("12 Hour Time       : %tr%n", currentDate);

        // %tc -> Complete date and time
        System.out.printf("Complete DateTime  : %tc%n", currentDate);

        System.out.println("\n==================================================");
        System.out.println("12. ARGUMENT INDEXING");
        System.out.println("==================================================");

        /*
         * %1$s -> First argument as String
         * %2$d -> Second argument as Integer
         * %3$.2f -> Third argument as Double with 2 decimals
         */

        System.out.printf(
                "Name=%1$s, Age=%2$d, Salary=%3$.2f%n",
                name,
                age,
                salary
        );

        /*
         * Reusing same argument multiple times
         */

        System.out.printf(
                "%1$s loves Java. %1$s also loves Automation.%n",
                name
        );

        System.out.println("\n==================================================");
        System.out.println("13. STRING.FORMAT()");
        System.out.println("==================================================");

        /*
         * String.format() works same as printf()
         * but returns formatted String instead of printing.
         */

        String employeeInfo = String.format(
                "Employee Name: %s | Age: %d | Salary: %,.2f",
                name,
                age,
                salary
        );

        System.out.println(employeeInfo);

        System.out.println("\n==================================================");
        System.out.println("14. ADVANCED COMBINED EXAMPLES");
        System.out.println("==================================================");

        // Width + Precision + Comma Separator
        System.out.printf("%15,.2f%n", salary);

        // Left Alignment + Width + Precision
        System.out.printf("%-15.2f End%n", salary);

        // Sign + Width + Precision
        System.out.printf("%+15.2f%n", salary);

        // Zero Padding + Width
        System.out.printf("%010d%n", age);

        // Multiple formatting options together
        System.out.printf(
                "Name:%-15s Age:%05d Salary:%+,15.2f%n",
                name,
                age,
                salary
        );
    }
}
