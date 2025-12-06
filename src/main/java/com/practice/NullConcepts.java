package com.practice;

public class NullConcepts {
    // "null" is a keyword in java and it is a case sensitive
    // For any type of object or reference variable in java the default value will be "null"
    // Java Compiler will throw the null pointer exception if you assign the "null" value to the "Primitive Data Type"

    // 1) Defining null Object
    Object obj = null;
    // 2) Defining the default reference value which always be null even if you don't mentioned it
    static String str;
    static NullConcepts nullConcepts;

    public static void sum(){
        System.out.println("Inside the Static method called sum() ..........");
    }
    public void send(){
        System.out.println("Inside the Non Static method called send() ..........");
    }
    public static void main(String[] args) {
        System.out.println(str);
        System.out.println(nullConcepts);
        // 3) If any instance variable is pointing to null then it's instance to the return type will be false
        // To check this we will be using "instanceof" keyword in java
        Integer i = null;
        Integer j = 10;
        System.out.println(j instanceof  Integer); // This line will print True
        System.out.println(i instanceof  Integer); // This line will print False even though i is instance for Integer because i is null
        // 4) == And != operator for null comparison
        System.out.println(null == null); // This will return true
        System.out.println(null != null); // This will return the false
        // 5) TypeCasting null point variable
        String s1 = (String) null;
        System.out.println(s1 + " This is a null typecast string 123"); // This will return result like this "null This is a null typecast string 123"
        // We can append the null because String object will treat it as empty value but we cannot perform the any kind of String manipulation operation
        // System.out.println(s1.length()); // This will give null pointer exception because "length()" method will not check the null values
        // 6) Accessing the static method by null references or null reference object
        NullConcepts nullConcept = null;
        nullConcept.sum(); // This method will not give us the null point exception because "sum" is static method and we can access the static method even though NullConcepts nullConcept = null
        nullConcept.send(); // This method will give us the null point exception because object of NullConcepts class is null

    }
}
