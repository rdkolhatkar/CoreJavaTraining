package com.concepts.lambadas;
/*
    A Functional Interface is an interface which contains a single abstract method.
    A functional interface in Java is an interface that contains exactly one abstract method, known as the Single Abstract Method (SAM).
    It may also contain multiple default and static methods. Functional interfaces provide the target type for lambda expressions and method references.
    Examples include Runnable, Callable, Comparator, Predicate, Function, Consumer, and Supplier.

    Example:
    @FunctionalInterface
    interface Greeting {
        void greet();   // This is the SAM
    }
    Here, greet() is called the Single Abstract Method because it is the only abstract method in the interface.
    A Single Abstract Method interface may still contain default and static methods:
    Example:
    @FunctionalInterface
    interface Greeting {
        // Single Abstract Method
        void greet();
        // Allowed
        default void sayBye() {
            System.out.println("Bye");
        }
        // Allowed
        static void info() {
            System.out.println("Greeting Interface");
        }
    }

    In Java, an anonymous function usually refers to a lambda expression.
*/
public class LambadaExpression {
    public static void main(String[] args) {
        EngineeringStudent engineeringStudent = new EngineeringStudent();
        String ram = engineeringStudent.getBioData("Ram");
        System.out.println(ram); // Output: Ram is Engineering Student !
        // Same above thing we can achieve by lambada expression
        // Directly using the Student Interface
        Student student = new Student() {
            @Override
            public String getBioData(String name) {
                return name + " is Engineering Student !";
            }
        };
        String ramNew = student.getBioData("Ram");
        System.out.println(ramNew);  // Output: Ram is Engineering Student !
        // In both above cases output is same, so we can simplify it with lambada
        Student lawStudent = (String name) -> {
            return name + " is Law Student !";
        };
        System.out.println(lawStudent.getBioData("Jack")); // Output: Jack is Law Student !
        // Above lambada expression we can write like this as well
        Student pharmacyStudent = name -> name + " is Pharmacy Student !";
        System.out.println(pharmacyStudent.getBioData("Vipul")); // Output: Vipul is Pharmacy Student !
        // If there is no return type then we can directly use the round brackets
        // Refer below Threading Example:
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("My Thread !");
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();
        t1.run();
        // Output: My Thread !
        // Same thing we can write with lambada
        Thread t2 = new Thread(() -> {System.out.println("My Thread With Lambada Expression !");});
        t2.start();
        t2.run();
        // Output: My Thread With Lambada Expression !
        Runnable run = () -> {
            for(int i = 0; i<=5; i++){
                System.out.println("Hello World !!!");
            }
        };
        Thread t3 = new Thread(run);
        t3.start();
        t3.run();
    }
}
