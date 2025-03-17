package com.training;

/**
 * Demonstrate the Diamond Problem using a Java program.
 * A diamond problem is a problem of multiple inheritances where one class extends two or more classes.
 * In other words, when a child class has more than one parent class, then an error occurs.
 * The diamond problem using a Java program is discussed below.
*/
/*
/DiamondProblem.java:28: error: '{' expected
class GC1 extends C1,C2
^
1 error
Explanation: The problem with the above code is when we override the display() method in class GC1 which method is overridden,
the compiler does not know whether the class C1 display() method is overridden or of the class C2 display() method is overridden.
*/
class P1
{
    public void display()
    {
        System.out.println("Inside the display method of the class P1.");
    }
}

class C1 extends P1
{
    @Override
    public void display()
    {
        System.out.println("Inside the display method of the class C1.");
    }
}

class C2 extends P1
{
    @Override
    public void display()
    {
        System.out.println("Inside the display method of the class C2.");
    }
}

// In Java, multiple inheritance is prohibited
class GC1 extends C1,C2
{
    @Override
    public void display()
    {
        System.out.println("Inside the display method of the class GC1.");
    }
}

public class DiamondProblem
{

    // main method
    public static void main(String argvs[])
    {
// creating an object of the class
// GC1
        GC1 obj = new GC1();
        obj.display(); // display() method of the class GC1 is invoked
    }
}

