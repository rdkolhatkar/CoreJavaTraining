package com.practice;

public class PassingNullArgumentWithMethodOverloading {

    /*
        Pass null argument with method overloading with String and Object types
    */

    /*
        We have oe method called test() which is accepting Object parameter and we have overloaded this method with different parameter called String
        Now if we call the test() method inside our main method and pass the null argument like test(null) then which overloaded method will it call?
        As Object and String both can be null values and both accept the null argument then will it call test() method with Object parameter or test() method with String parameter
        Answer is it will call the method which have the String Parameter
        If we overload the test() method with StringBuilder or StringBuffer and we pass the null argument after calling it in main method then we will get the Compile error
    */

    public static void test(Object o){
        System.out.println("Object Argument");
    }

    public static void test(String s){
        System.out.println("String Argument");
    }

    public static void main(String[] args) {

    }

}
