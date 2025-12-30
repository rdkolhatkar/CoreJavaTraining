package com.practice;

public class SpecialEscapeCharactersInJava {
    public static void main(String[] args) {
/*
    Question:
    ---------
    Print the following Strings in console as it is
    1) /"Hello World"/
    2) /'Hello World'/
    3) I am learning "Java" programming language with "Data Structures & Algorithms"
    4) 'I love to watch 'magical' fantasy "movies"'
*/
        // 1) /"Hello World"/
        System.out.println("/\"Hello World\"/");
        // 2) /'Hello World'/
        System.out.println("/'Hello World'/");
        // 3) I am learning "Java" programming language with "Data Structures & Algorithms"
        System.out.println("I am learning \"Java\" programming language with \"Data Structures & Algorithms\"");
        // 4) 'I love to watch 'magical' fantasy "movies"'
        System.out.println("'I love to watch 'magical' fantasy \"movies\"'");
/*
    Question:
    ---------
    Print the following output:
    "He said, "Java is powerful""
*/
        System.out.println("\"He said, \\\"Java is powerful\\\"\"");
/*
    Question:
    ---------
    Print the following path:
    C:\Program Files\Java\jdk
*/
        System.out.println("C:\\Program Files\\Java\\jdk");
/*
    Question:
    ---------
    Print the output in two lines using only one sysout statement:
    Java
    DSA
*/
        System.out.println("Java\nDSA");
/*
    Question:
    ---------
    Print output with tab space between words:
    Java    DSA
*/
        System.out.println("Java\tDSA");
/*
    Question:
    ---------
    Print the following exactly:
    'I love "Java" programming'
*/

        System.out.println("'I love \"Java\" programming'");
/*
    Question:
    ---------
    What is the output?
    System.out.println("\\\\");
    Answer:
    -------
    \
    Explanation:
    ------------
    Each pair \\ prints a single backslash
*/
        System.out.println("\\\\");
/*
    Question:
    ---------
    What is the output?
    System.out.println("Java\bDSA");
    Answer:
    -------
    JavDSA
    Explanation:
    ------------
    \b removes the character before it
*/
        System.out.println("Java\bDSA");
/*
    Question:
    ---------
    What is the output?
    System.out.println("Java\rDSA");
    Answer:
    -------
    DSAa
    Explanation:
    ------------
    \r moves cursor to beginning of the line
*/
        System.out.println("Java\rDSA");
    }
}
