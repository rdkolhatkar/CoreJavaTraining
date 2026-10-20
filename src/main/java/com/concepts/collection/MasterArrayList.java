package com.concepts.collection;

import java.util.ArrayList;
import java.util.List;

public class MasterArrayList {
    /*
        An ArrayList is a resizable array implementation of the List interface.
        Unlike arrays in Java, which have fixed size, an ArrayList can change its size dynamically as elements are added or removed.
        This flexibility makes it a popular choice when the number of elements in a list isn't known in advanced.
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
    }
}
