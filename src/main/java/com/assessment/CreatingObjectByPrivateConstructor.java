package com.assessment;

public class CreatingObjectByPrivateConstructor {
    // How can we create objects if we make the constructor private?
    int age;
    private CreatingObjectByPrivateConstructor() {
        age = 30;
    }
    // As our constructor is private we cannot create the object of this class outside of the class scope
    // We cannot create the object of this class in another class, but we can create the object of this class inside this class
    // So if we have to create the object of this class in another class to call the methods inside this class then we have to use the static block or static method

    static {
        CreatingObjectByPrivateConstructor object = new CreatingObjectByPrivateConstructor();
        object.age = 50;
    }
    public static int staticMethod(){
        CreatingObjectByPrivateConstructor objOne = new CreatingObjectByPrivateConstructor();
        return objOne.age;
    }
    public static void main(String[] args) {
        CreatingObjectByPrivateConstructor obj = new CreatingObjectByPrivateConstructor();
        System.out.println(obj.age); // Output will be 30 for age
    }
}

class TestCreatingObjectByPrivateConstructor{
    public static void main(String[] args) {
        int k = CreatingObjectByPrivateConstructor.staticMethod();
        System.out.println("The Value of k is : "+k);
        // Here Output value of k is 30 because we are setting k as 30 inside the private constructor of CreatingObjectByPrivateConstructor class
        // If we change the value of age in the static block of CreatingObjectByPrivateConstructor this class then it will not affect the k value
        // Because it is only dependant on constructor of class CreatingObjectByPrivateConstructor
        // Now calling the main method of class CreatingObjectByPrivateConstructor
        System.out.println("Calling the main method of CreatingObjectByPrivateConstructor this class ");
        System.out.println("It will print the value of age from class CreatingObjectByPrivateConstructor");
        CreatingObjectByPrivateConstructor.main(null);
    }
}
