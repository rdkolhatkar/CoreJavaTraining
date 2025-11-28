package com.assessment;

public class OverloadingAndOverridingOfStaticMethod {
    // No, we cannot override static methods in Java.
    /*
    Because:
        -> Static methods belong to the class, not to the object.
        -> Method overriding is based on runtime polymorphism (deciding which method to call at runtime based on the object).
        -> Static methods use compile-time binding.
    */

    // Yes, we can overload static methods.
    /*
    Method overloading is based on:
        -> Different parameter list
        -> Compile-time binding
        -> No relation with objects / runtime
    */

    // Method Hiding
    /*
    Method hiding in Java occurs when a subclass defines a static method with the same signature as a static method in the parent class.
    Static methods belong to the class, not the object, so they are resolved at compile time.
    Because of this, the method in the child does not override the parent method but simply hides it.
    The method called depends on the reference type, not the actual object type.
    */
}
class Parent {
    // Static method in Parent
    static void display() {
        System.out.println("Parent static method");
    }
}

class Child extends Parent {
    // Looks like overriding, but actually this HIDES the Parent method
    static void display() {
        System.out.println("Child static method");
    }
}

