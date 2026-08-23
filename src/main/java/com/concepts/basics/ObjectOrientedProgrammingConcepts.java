package com.concepts.basics;

public class ObjectOrientedProgrammingConcepts {
 /*
 ====================== Object-Oriented Programming (OOP) ======================

 OOP (Object-Oriented Programming System) is a programming paradigm in Java
 that is based on Classes and Objects.

 In OOP, we first create a Class, and then we create Objects from that class.

 -------------------------------------------------------------------------------
 What is a Class?
 -------------------------------------------------------------------------------
 A Class is a blueprint or template that defines the structure and behavior
 of a real-world object or a business entity.

 It specifies:
 1. What data (Properties) an object will have.
 2. What actions (Behaviors) an object can perform.

 Example:
 A Car class can be used as a blueprint to create multiple Car objects.

 -------------------------------------------------------------------------------
 What is an Object?
 -------------------------------------------------------------------------------
 An Object is a real instance of a Class.
 It is created using the blueprint (Class) and occupies memory at runtime.

 Example:
 If Car is a class, then BMW, Audi, and Tesla cars are different objects
 created from the Car class.

 -------------------------------------------------------------------------------
 Every Object has two main characteristics:
 -------------------------------------------------------------------------------

 1) Properties (State)
 ---------------------
 Properties represent the data or characteristics of an object.
 They are defined as variables (fields) inside a class.

 Example:
 Class: Car

 Properties:
 - Model
 - Brand
 - Color
 - Price
 - Speed

 These properties describe the current state of a Car object.

 -------------------------------------------------------------------------------

 2) Behavior (Actions) -> Also Known As Methods in Java
 ---------------------
 Behavior represents the actions or operations that an object can perform.
 These are defined using methods inside a class.

 Example:
 Class: Car

 Behaviors:
 - start()
 - stop()
 - accelerate()
 - brake()
 - changeGear()

 If a Car object's speed increases after calling accelerate(),
 then accelerating is the behavior of that object.

 -------------------------------------------------------------------------------
 Real-World Example:
 -------------------------------------------------------------------------------

 Class      : Car

 Properties : Brand = "BMW"
              Model = "X5"
              Color = "Black"
              Speed = 120 km/h

 Behaviors  : start()
              accelerate()
              brake()
              stop()

 In simple words:
 - Properties describe WHAT an object HAS.
 - Behaviors describe WHAT an object DOES.

 ===============================================================================
 Shortcut to Remember:

 Class      -> Blueprint or Template
 Object     -> Real instance of a Class
 Properties -> Data or Characteristics (HAS-A)
 Behavior   -> Actions or Functions (DOES)
 ===============================================================================
 */
/*
 =================================================================================
                    Four Main Principles (Pillars) of OOP in Java
 =================================================================================

 Object-Oriented Programming (OOP) in Java is based on four fundamental principles,
 also known as the Four Pillars of OOP. These principles help developers write
 clean, reusable, secure, and maintainable code.

 1) Encapsulation
    - Bundles data (variables) and methods into a single unit (class).
    - Protects data by restricting direct access using access modifiers.

 2) Abstraction
    - Hides the internal implementation details.
    - Shows only the essential features or functionality to the user.

 3) Inheritance
    - Allows one class to inherit the properties and methods of another class.
    - Promotes code reusability and reduces code duplication.

 4) Polymorphism
    - Allows the same method or interface to behave differently for different objects.
    - Provides flexibility by supporting multiple implementations.

 =================================================================================
 Shortcut to Remember:

 Encapsulation -> Data Hiding
 Abstraction   -> Hiding Implementation details
 Inheritance   -> Code Reusability
 Polymorphism  -> One Interface, Many Forms

 =================================================================================
*/

/*
    Encapsulation -> It is nothing but bundling of data and methods into a single unit
    For encapsulation we have to declare our variables or fields as private using "private" access modifier & getter setters
*/

}
