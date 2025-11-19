package com.practice;

public class MainMethodOverloading {
    /*
    Question: Can we overload the main method in java?
    Answer: Yes — we can overload the main method in Java, but only one specific signature is used as the program entry point.
    You are allowed to create multiple methods named main with different parameter lists. This is just normal method overloading.
    JVM will try to search the main method with signature "String[] args" or "String args[]" this is by default
    So to run the overloaded main methods we have to call them inside the original main method which contains String[] args

    Question: What is method Overloading?
    Answer: Method overloading is when multiple methods in the same class have the same name but different parameter lists, allowing them to perform similar operations with different inputs.
    */
    public static void main(String[] args) {
        System.out.println("Inside the original main method...........");
        // Calling the First Main method with String argument
        main("Ratnakar");
        // Calling the Second Main method with One Integer argument
        main(2);
        // Calling the Third Main method with Two Integer arguments
        main(10, 20);
        // We can also call the main method from another class as well
        ReverseTheGivenString.main(args);
    }
    public static void main(String a){
        System.out.println("First -> Main method with String argument " + a);
    }
    public static void main(int a){
        System.out.println("Second -> Main method with One Integer argument " + a);
    }
    public static void main(int a, int b){
        System.out.println("Third -> Main method with Two Integer arguments " + a + " " + b);
    }
}
