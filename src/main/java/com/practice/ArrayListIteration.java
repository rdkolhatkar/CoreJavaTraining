package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class ArrayListIteration {
    public static void main(String[] args) {
        // Adding array elements into arrayList using for-each Loop or Enhanced for loop
        String[] names = {
                "Ram", "Shyam", "Raju", "Tina", "Shreya", "Purvi", "Tarika", "Gargi", "Shyam", "Tina", "Arjun",
                "Meera", "Rohit", "Sana", "Vikram", "Neha", "Karan", "Isha", "Dev", "Pooja"
        };
        ArrayList<String> arrayList = new ArrayList<>();

        for(String a : names){
             arrayList.add(a);
        }
        System.out.println(arrayList);

        System.out.println("*******************************************************************************");
        // Adding array elements into arrayList using stream
        ArrayList<String> list = Arrays.stream(names)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(list);
        System.out.println("*******************************************************************************");

        // Now make all names in the above list into upper case and print in console using Iterator
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toUpperCase());
        }
        System.out.println("*******************************************************************************");

        // Now we will use Java 8 forEachRemaining() method with lambada expression
        Iterator<String> ite = arrayList.iterator();
        ite.forEachRemaining(s -> {
            System.out.println(s.toLowerCase());
        });
        System.out.println("*******************************************************************************");

        // Iterate using Enhanced for Loop
        for(String k : arrayList){
            System.out.println("The length of String "+k+" is : "+k.length());
        }
        System.out.println("*******************************************************************************");

        // Iterate using simple for loop order or index
        for(int i =0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i).chars());
        }
        System.out.println("*******************************************************************************");

        // Using List Iterator to traverse in both the directions
        // In this we will first call the last element of the list and then we will iterate back to the first element

        ListIterator<String> listIterator = arrayList.listIterator(arrayList.size());
        while (listIterator.hasPrevious()){
            String previousValue = listIterator.previous();
            System.out.println(previousValue);
        }

    }

}
