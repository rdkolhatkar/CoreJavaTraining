package com.practice;

public class InitializeTheVariableInStaticBlock {
    // Can we initialize the member variables in static block ?
    // Yes we can initialize the member variables in static block but for that we have to create the object of class
    String name;
    static int age;
    // But we can directly call the static variable in static block without object creation

    static {
        InitializeTheVariableInStaticBlock obj = new InitializeTheVariableInStaticBlock();
        obj.name = "Ratnakar";
        age = 25;
        System.out.println(obj.name); // This will print "Ratnakar"
        System.out.println(age); // This will print 25
    }

    public static void main(String[] args) {

    }
}
