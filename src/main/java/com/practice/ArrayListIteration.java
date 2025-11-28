package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
    }
}
