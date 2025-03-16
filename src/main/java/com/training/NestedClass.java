package com.training;

/**
 * Demonstrate nesting of classes using a Java program.
 * Defining a class inside another class is known as nesting of classes.
 * Usually, in Java, the inner class is the static class.
 * Observe the following program.
*/

public class NestedClass
{

    // main method
    public static void main(String argvs[])
    {
// instantiating the outer class
        OuterClass ob1 = new OuterClass(10, 20);

// instating the second inner class
        OuterClass.InnerClass2 ob2 = new OuterClass.InnerClass2(40);
        ob2.displayData();

        OuterClass.InnerClass3.z1 = 101;
        System.out.println(OuterClass.InnerClass3.z1);

// instating the third inner class
        OuterClass.InnerClass3 ob3 = new OuterClass.InnerClass3(409);
        ob3.displayData();
    }

}

class OuterClass
{

    private int x1;
    private int y1;

    // parameterless constructor
    OuterClass()
    {
        System.out.println("The default constructor of the Outer class is invoked.");
    }

    // parameterized constructor
    OuterClass(int x1, int y1)
    {
        this.x1 = x1;
        this.y1 = y1;
        System.out.println("The parameterized constructor of the Outer class is invoked.");
    }

    void displayData()
    {
        System.out.println("X = " + x1 + " and Y = " + y1);
    }

    class InnerClass1
    {

        int z1 = 0;

        InnerClass1()
        {
            System.out.println("The default constructor invoked of the first inner class.");
        }

        // parameterized constructor of the
        // first inner class
        InnerClass1(int z1)
        {
            this.z1 = z1;
        }

        void displayData()
        {
            System.out.println("X = " + x1 + " Y = " + y1 + " and Z = " + z1);
        }
    }

    // the second inner class
    static class InnerClass2
    {

        int z1 = 0;

        InnerClass2()
        {
            System.out.println("The default constructor invoked of the second inner class.");
        }

        // parameterized constructor of the
// second inner class
        InnerClass2(int z1)
        {
            this.z1 = z1;
            System.out.println("The parameterized constructor invoked of the second inner class.");
        }

        void displayData()
        {
            System.out.println("Z = " + z1);
        }
    }

    // the third inner class
    static class InnerClass3
    {

        static int z1 = 0;

        InnerClass3()
        {
            System.out.println("The default constructor invoked of the third inner class.");
        }

        // parameterized constructor of the
// third inner class
        InnerClass3(int a1)
        {
            z1 = a1;
            System.out.println("The parameterized constructor invoked of the third inner class.");
        }

        void displayData()
        {
            System.out.println("Z = " + z1);
        }
    }
}
