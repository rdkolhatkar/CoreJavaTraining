package com.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateElementsInArrayPart_2 {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 1, 5, 6, 11, 12, 13, 14, 15, 16, 17, 13};

        // If we have to compare two Strings from the array then we are using ".equals()"
        // If we have to compare two Integers from the array then we are using "=="

        // Find duplicate elements in array using for loop
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    System.out.println("Duplicate elements in nums array : "+nums[i]);
                }
            }
        }
        System.out.println("***********************************************************");
        // Find duplicate elements in array Using HashSet
        Set<Integer> data = new HashSet<Integer>();
        for(Integer value : nums){
            if(data.add(value) == false){
                System.out.println("Duplicate element is "+ value);
            }
        }
        System.out.println("***********************************************************");
        // Find duplicate elements in array using HashMap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(Integer a : nums){
            System.out.println("Getting the value from HashMap "+map.get(a));
            Integer count = map.get(a);
            if(count == null){
                map.put(a, 1);
            }else {
                map.put(a, ++count);
            }
        }
        // Printing Duplicate elements
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        System.out.println(entrySet);
        for(Map.Entry<Integer, Integer> entry : entrySet){
            if(entry.getValue() > 1){
                System.err.println("Duplicate value is "+entry.getKey());
            }
        }
        System.out.println("***********************************************************");
        // Find duplicate elements in array using Java Streams
        // int nums[] = {1, 2, 3, 4, 5, 1, 5, 6, 11, 12, 13, 14, 15, 16, 17, 13};
        Set<Integer> duplicateElements =
                Arrays.stream(nums)              // IntStream
                        .boxed()                  // convert int -> Integer
                        .collect(
                                Collectors.groupingBy(
                                        Function.identity(), // number itself as key
                                        Collectors.counting() // count occurrences
                                )
                        )
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() > 1) // keep duplicates only
                        .map(Map.Entry::getKey)        // extract the number
                        .collect(Collectors.toSet()); // collect into Set

        System.out.println("Duplicates are : " + duplicateElements);
        System.out.println("***********************************************************");
        // int nums[] = {1, 2, 3, 4, 5, 1, 5, 6, 11, 12, 13, 14, 15, 16, 17, 13};
        // Find duplicate elements in array using Frequency method with Stream
        // Convert int[] to List<Integer>
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());

        // Find duplicates using Collections.frequency
        Set<Integer> duplicateListElements =
                list.stream()
                        .filter(a -> Collections.frequency(list, a) > 1)
                        .collect(Collectors.toSet());

        System.out.println("Duplicate elements are : " + duplicateElements);

    }
}
