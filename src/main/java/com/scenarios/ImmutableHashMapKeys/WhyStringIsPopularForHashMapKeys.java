package com.scenarios.ImmutableHashMapKeys;

import java.util.HashMap;
import java.util.Map;

public class WhyStringIsPopularForHashMapKeys {
    /*
        Why HashMap key is immutable in Java?
        Why String is popular for HashMap Key in Java?

        Answer:
        1) Strings are immutable in Java
        2) HashMap keys should be immutable so their hashCode and equals don’t change after insertion. If a key changes, the entry may become unreachable. String is popular because it is immutable, has a cached hashCode, reliable equals, widely used, memory-efficient, and safe for concurrent use.
    */
    public static void main(String[] args) {
        Map<Employee, String> empMap = new HashMap<Employee, String>();
/*
        // Case 1: Creating the Object of Employee Class & assigning its value to HashMap Key Without setting new value
        // As we know object are mutable we can set the new value of object with getters and setters method.
        // We will specifically alter the existing value of Employee Object using setter method in second case
        Employee e1 = new Employee("RAY", 25);
        empMap.put(e1,"Permanent"); // Here 'e1' object is mutable & hashcode will calculate its value based on name and age variables
        System.out.println(empMap.get(e1)); // In Case 1 we are not altering the objet
        // For First case output of code will be : "Permanent"
*/
        // Case 2: Modifying the value of Employee Object 'e1' using setter method
        Employee e1 = new Employee("RAY", 25);// Initial value of age
        empMap.put(e1,"Permanent");// Initial value of 'e1' mutable key
        e1.setAge(22);// Updating the age inside the 'e1' object with setter method
        System.out.println(empMap.get(e1));// Here output will be 'null' for this SysOut statement because after modifying the age hashcode will calculate new value for Employee 'e1' object
        // This new hashcode value does not have any data present in the memory
        empMap.put(e1,"Temporary");// Storing new value for updated 'e1' key
        System.out.println(empMap.get(e1)); // Here we will get output as "Temporary" because this time we have assigned new Value for updated 'e1' key
        System.out.println("**********************************************************************************");
        // Here we will create the HashMap with Immutable key 'String'
        /*
        Cache memory in Java is a small, fast memory used to store frequently accessed data so it can be retrieved quickly instead of recalculating or reloading it.
        Examples:
        CPU cache (handled by hardware, not Java directly)
        JVM caches like:
            -> String Pool
            -> Integer cache (-128 to 127)
            -> Class metadata cache
            -> JIT compiled code cache
        Purpose: Improve performance and reduce memory access time.
        -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Cached memory in Java refers to memory where frequently used data is stored temporarily so it can be accessed faster instead of being recreated or reloaded.
        Common examples:
            -> String Constant Pool – stores reused string literals
            -> Wrapper class cache – e.g., Integer cache (-128 to 127)
            -> JVM code cache – stores JIT-compiled native code
            -> Application-level caches – like HashMap, Redis, Ehcache
        Goal: Improve performance by reducing repeated computation and memory access.
        */
        Map<String, Integer> empMapOne = new HashMap<String, Integer>();
        String str = "TOM"; // For immutable keys hashcode will be Cached into the memory, So when we will assign the value this will be linked with Cache memory in Java
        empMapOne.put(str, 100); // Here for TOM String value 100 is linked with String constant pool Cache memory
        System.out.println(empMapOne.get(str)); // Here output will be 100
        str = "Naveen"; // Now for same 'str' variable we will assign new value "Naveen"
        // But as we know String is immutable so even if we assign new value to 'str', it will not destroy the old object, it will just create new object in the string constant memory pool
        empMapOne.put(str, 26);// For this line value '26' is linked with that new 'str' object
        System.out.println(empMapOne.get(str)); // Here our output will be 26
        System.out.println(empMapOne.get("TOM")); // Here our output will be 100 because when we will pass the String value as TOM JVM will go to Cached memory and it will fetch that old object whose linked value is 100

        /*
            Final Output for all Above Code
            null
            Temporary
            **********************************************************************************
            100
            26
            100
        */
    }
}
