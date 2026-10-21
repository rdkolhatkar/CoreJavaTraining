package com.concepts.collection;

import java.util.ArrayList;
import java.util.List;

public class MasterArrayList {
    /*
        An ArrayList is a resizable array implementation of the List interface.
        Unlike arrays in Java, which have fixed size, an ArrayList can change its size dynamically as elements are added or removed.
        This flexibility makes it a popular choice when the number of elements in a list isn't known in advanced.
    */
    /*
        Internal Working of ArrayList:
        -> Unlike regular array, which has a fixed size, an ArrayList can grow and Shrink as elements are added or removed.
        -> This dynamic resizing is achieved by creating a new array when the current array is full and copying the elements to the new array.
        -> Internally, the ArrayList is implemented as an array of Objects references. When you add elements to an ArrayList, you're essentially storing these elements in this internal array.
        -> When you create an ArrayList, it has an initial capacity (default is 10). The capacity refers to the size of the internal array that can hold elements before needing to resize.

    */
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(); // ArrayList is a Generic class, we can specify the type of data explicitly
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        // We can also use the parent class which is List
        List<Integer> integerList = new ArrayList<>();
        // We have add() method to add elements in the list
        integerArrayList.add(10);
        integerArrayList.add(20);
        integerArrayList.add(30);
        integerArrayList.add(40);
        integerArrayList.add(50);
        // There is a Zeroth based indexing in the List. That means first index of the list starts from zero.
        System.out.println(integerArrayList.get(0)); // Output: 10
        // get() method is used for retrieving the elements at specific index.
        // To check the size of the list we have size() method
        System.out.println(integerArrayList.size()); // Output: 5
        // We use for loop to print all elements in the list
        for(int i = 0; i < integerArrayList.size(); i++){
            System.out.println(integerArrayList.get(i));
        }
        /*
            Output:
            10
            20
            30
            40
            50
        */
        // We can directly iterate over list using for-each loop or enhanced for loop in java
        for(int element : integerArrayList){
            System.out.println(element);
        }
        /*
            Output:
            10
            20
            30
            40
            50
        */
        // To Check if an element exists in the list or not, we use contains method
        System.out.println(integerArrayList.contains(50)); // Output: true
        // To remove the element at a specific index from the list we use remove method
        integerArrayList.remove(3); // This will remove 40 from our list because number 40 is present at 3rd index
        // To add element a specific index we use add method again but in different way
        integerArrayList.add(3, 300);
        for(int element : integerArrayList){
            System.out.println(element);
        }
        /*
            Output:
            10
            20
            30
            300
            50
        */
        // To replace a specific element at a specific index in the Array list we use set method
        integerArrayList.set(3, 600); // Now this will replace the value at 3rd index, So here 500 will become 600
        for(int element : integerArrayList){
            System.out.println(element);
        }
        /*
            Output:
            10
            20
            30
            600
            50
        */
        // We can print list without using for-loop as List uses toString method in background
        System.out.println(integerArrayList); // Output:; [10, 20, 30, 600, 50]

    }
}
