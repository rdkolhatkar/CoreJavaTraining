package com.practice;

import org.junit.jupiter.api.Test;

public class SingletonClassInJava {
    /*
    Singleton class is a pattern that restricts the instantiation of a class to one "single" instance.
    This pattern involves a single class which is responsible to create an object while making sure that only single object gets created.
    This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.
    Since there is only one Singleton instance, any instance fields of a Singleton will occur only once per class, just like static fields.
    Singletons often control access to resources, such as database connections or sockets.
    For example, if you have a license for only one connection for your database or your JDBC driver has trouble with multithreading,
    the Singleton makes sure that only one connection is made or that only one thread can access the connection at a time.
    */
    private static SingletonClassInJava singletone_instance = null;
    public String str;
    private SingletonClassInJava() {
        // private constructor to prevent instantiation
        str = "Hello, I am a singleton!";
    }
    // Static method to create and return the single instance of the class
    // Lazy initialization
    public static SingletonClassInJava getInstance() {
        if (singletone_instance == null) {
            singletone_instance = new SingletonClassInJava();
        }
        return singletone_instance;
    }
    public void showMessage() {
        System.out.println(str);
    }
    public static void main(String[] args) {
        // Get the only object available
        SingletonClassInJava x = SingletonClassInJava.getInstance();
        SingletonClassInJava y = SingletonClassInJava.getInstance();
        SingletonClassInJava z = SingletonClassInJava.getInstance();

        // Convert the given string to uppercase
        x.str = x.str.toUpperCase();
        // Show the message
        x.showMessage();
        y.showMessage(); // y and z will show the same message as x
        z.showMessage(); // Even if objects are created multiple times, they will refer to the same instance
        System.out.println("*********************************************************");
        // Convert the given string to lowercase
        y.str = y.str.toLowerCase();
        // Show the message
        x.showMessage();
        y.showMessage();
        z.showMessage();
    }
    @Test
    public void testSingleton() {
        SingletonClassInJava instance1 = SingletonClassInJava.getInstance();
        SingletonClassInJava instance2 = SingletonClassInJava.getInstance();
        assert instance1 == instance2 : "Singleton instances are not the same!";
        System.out.println("Singleton test passed!");
    }
    @Test
    public void testSingletonMessage() {
        SingletonClassInJava instance = SingletonClassInJava.getInstance();
        instance.showMessage();
        assert instance.str.equals("Hello, I am a singleton!") : "Singleton message is incorrect!";
        System.out.println("Singleton message test passed!");
    }

}
