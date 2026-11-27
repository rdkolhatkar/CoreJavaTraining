package com.concepts.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        Adding Elements in ArrayList
        When we add an element to an ArrayList, the following steps occur:
        -> Check Capacity: Before adding the new element, ArrayList checks if there is enough space in the internal Array (elementData). If the array is full, it needs to be resized.
        -> Resize if Necessary: If the internal array is full, the ArrayList will create a new array with a larger capacity (usually 1.5 times the current capacity) and copy the elements from the old array to the new array.
        -> Add the Element: The new element is then added to the internal array at the appropriate index, and the size is increased.

        Resizing the Array:
        -> Initial Capacity: By default, the initial capacity is 10. This means the internal array can hold 10 elements before it needs to grow.
        -> Growth Factor: When the internal array is full, a new array is created with a size of 1.5 times the old array. This growth factor balances the memory efficiency and resizing cost.
        -> Copying Elements: When resizing occurs, all elements from the old array are copied to the new array, which is an O(n) operation, where n is the number of elements in the ArrayList.

        Removing Elements:
        -> Check Bounds: The ArrayList first checks if the index is within the valid range.
        -> Remove the Element: The element is removed, and all elements to the right of the removed element are shifted one position to the left to fill the gap.
        -> Reduce Size: The size is decremented by 1.

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

        // Reducing the Size of ArrayList using "trimToSize()" method.
        integerArrayList.trimToSize();
        System.out.println(integerArrayList.getClass().getName()); // Output:java.util.ArrayList

        // Another way to create ArrayList
        List<String> stringList = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        // ArrayList<String> = Arrays.asList("Monday", "Tuesday"); This is invalid syntax because ArrayList is implementation of List Interface.
        System.out.println(stringList.getClass().getName()); // Output: java.util.Arrays$ArrayList

        // Converting an Array to ArrayList
        String[] basicStringArray = {"Monday", "Tuesday", "Wednesday"};
        List<String> newStringList = Arrays.asList(basicStringArray);
        System.out.println(newStringList.getClass().getName()); // Output: java.util.Arrays$ArrayList

        // Important Note: Arrays.asList() => is a nested static class hence we cannot add anything inside it
        /*
        newStringList.add("Test"); => This will throw the Exception as :
        Exception in thread "main" java.lang.UnsupportedOperationException
        at java.base/java.util.AbstractList.add(AbstractList.java:155)
        at java.base/java.util.AbstractList.add(AbstractList.java:113)
        at com.concepts.collection.MasterArrayList.main(MasterArrayList.java:125)
        */
        // We cannot add or remove anything from Arrays.asList() but we can replace the existing value.
        newStringList.set(1, "Friday"); // It will not throw any exception
        System.out.println(newStringList.get(1));
        // Arrays.asList() method only return the fixed size list.
        // To make the "newStringList" modifiable we need to perform below operation
        List<String> listString = new ArrayList<>(newStringList);
        listString.add("Mango");
        System.out.println(listString); // Output: [Monday, Friday, Wednesday, Mango]
        // Adding a value at specific index
        listString.add(0, "Apple"); // Output: [Apple, Monday, Friday, Wednesday, Mango]


        // Another way to create a unmodifiable list is using
        List<Integer> integerList1 = List.of(1,2,3,4,5,6,7);
        // This also return unmodifiable list.
        List<Integer> flexiList = new ArrayList<>();
        flexiList.addAll(integerList1);
        System.out.println(flexiList); // Output: [1, 2, 3, 4, 5, 6, 7]
        flexiList.remove(Integer.valueOf(1)); // Here we are using Integer.valueOf(1) because by default remove method will not be able to recognize the integer index value.
        System.out.println(flexiList); // Removes the value at index 1, Output: [2, 3, 4, 5, 6, 7]
        // Converting List to an Array
        flexiList.toArray(new Integer[0]);

        // Sorting the ArrayList
        // Here we will use the Collection class to sort the ArrayList
        List<Integer> integerList2 = new ArrayList<>(List.of(9, 2, 5, 4, 7, 6, 8, 1, 3));
        Collections.sort(integerList2);
        System.out.println(integerList2); // OutPut: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
