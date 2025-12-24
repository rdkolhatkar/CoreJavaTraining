package com.practice;

public class InstanceInitializationBlock {
    // Instance Initialization block is nothing but a block of code that has no keyword defined to it.
    static {
        System.out.println("This is static block");
    }
    {
        System.out.println("This is Instance Initialization block");
    }
    InstanceInitializationBlock(){
        System.out.println("This is Constructor of class");
    }
    // Static block will be executed by default before main method initialization
    public static void main(String[] args) {
        System.out.println("This is main method of class InstanceInitializationBlock");
        // Inside this main method if we have to call the Instance Initialization block then we have to create the object of class
        new InstanceInitializationBlock();
        // Between Instance Initialization block and Constructor first preference will be given to Instance Initialization block
        // When we will create the object of class InstanceInitializationBlock then it will first execute the block of Instance Initialization block and then it will execute the Constructor
        // If we have to run the static block code, Instance Initialization block and Constructor in another class then we have to create the object
        // But to call any static method or static variable we can do it through calling the className.MethodName or className.StaticVariableName
    }
}
