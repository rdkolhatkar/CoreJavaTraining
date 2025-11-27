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
}
