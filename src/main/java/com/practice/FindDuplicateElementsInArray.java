package com.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindDuplicateElementsInArray {
    public static void main(String[] args){
        String names[] = {"Java", "JavaScript", "C", "C++", "Python", "Ruby", "Java", "Python"};
        // 1st Solution is we have to compare each element with other elements in array as many to many relationship
        for(int i=0; i<names.length; i++){
            for(int j = i+1; j< names.length; j++){
                if(names[i].equals(names[j])){
                    System.out.println("Duplicate element is "+ names[i]);
                }
            }
        }
        System.out.println("***************************************************************************");
        // 2nd Solution is Using HashSet, HashSet is part of Java collection and it's property is it stores unique values, In HashSet Duplicate elements are allowed.
        Set<String> arrayStore = new HashSet<String>();
        for(String name : names){
            if(arrayStore.add(name) == false){
                System.out.println("Duplicate element is :: "+ name);
            }
        }
        System.out.println("***************************************************************************");
        // 3rd Solution is using the HashMap, In HashMap duplicate elements are allowed. HashMap stores the values as key-value pair format, we will store it as String-int format & if for same key(String), value(int) is different then this is duplicate element
        Map<String, Integer> storeMap = new HashMap<String, Integer>();
        for(String name : names){
            Integer count = storeMap.get(name);
            if(count == null){
                storeMap.put(name, 1);
            } else{
                storeMap.put(name, ++count);
            }
        }
        // Now ti Iterate over HashMap, we first need to get values from HashMap & for that we will be using entrySet()
        Set<Map.Entry<String, Integer>> entrySet = storeMap.entrySet();
        for(Map.Entry<String, Integer> entry : entrySet){
            if(entry.getValue() > 1){
                System.out.println("Duplicate element is == " + entry.getKey());
            }
        }
    }

}
