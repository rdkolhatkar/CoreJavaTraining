package com.assessment;

public class CompileAndRunJavaProgramWithoutMainMethod {
    // Compile and run Java Code without writing the main method
    static int value = 100;

    static {
        System.out.println("Inside the class CompileAndRunJavaProgramWithoutMainMethod, first static block 1 ....");
    }
    static {
        System.out.println("Inside the class CompileAndRunJavaProgramWithoutMainMethod, second static block 2 ....");
    }
    static {
        System.out.println("Inside the class CompileAndRunJavaProgramWithoutMainMethod, third static block 3 ....");
    }
}
class TestCompileAndRunJavaProgramWithoutMainMethod{
    public static void main(String[] args) {
        // We don't have the main method in the class CompileAndRunJavaProgramWithoutMainMethod
        // but we have the main method in class "TestCompileAndRunJavaProgramWithoutMainMethod"
        // by creating the static block we can run the code from class CompileAndRunJavaProgramWithoutMainMethod without main method
        CompileAndRunJavaProgramWithoutMainMethod obj = new CompileAndRunJavaProgramWithoutMainMethod();
        // We can also call the value because it is static variable
        System.out.println(CompileAndRunJavaProgramWithoutMainMethod.value); // it will print 100
    }
}
