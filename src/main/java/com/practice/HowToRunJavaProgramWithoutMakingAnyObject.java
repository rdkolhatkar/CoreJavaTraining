package com.practice;

public class HowToRunJavaProgramWithoutMakingAnyObject {
    // How can we run the java program without making any object
    // We can achieve the above condition using the static block and static method
    // for static method we don't need to create the object we can call it directly using class name

    // static block will run by default before the main method
    static {
        System.out.println("Inside the static block ...");
    }

    public static void test(){
        System.out.println("Inside the static method *** ");
    }

    public static void main(String[] args) {
        System.out.println("Inside the main method -----");
        test();
        HowToRunJavaProgramWithoutMakingAnyObject.test();
    }
    /*
        A static block runs automatically once when the class is loaded and is mainly used for static initialization.
        A static method is executed only when explicitly called and is used to perform operations.
        Static blocks cannot be called, while static methods can be called using the class name.
    */
}
