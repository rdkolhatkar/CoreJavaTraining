package com.practice;

import com.google.common.collect.ObjectArrays;
import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JoinTwoArrays {
    /*
        Join Two Arrays using Java Streams
    */
    public static void main(String[] args) {
        // First we have two integer arrays
        System.out.println("We have two int arrays called 'array1' and 'array2' ");
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {5, 6, 7};
        // Second we have two String arrays
        System.out.println("We have two String arrays called 'array3' and 'array4' ");
        String[] array3 = {"Java", "Spring", "Hibernate"};
        String[] array4 = {"REST", "JUnit", "Docker"};
        System.out.println("****************************************************************");
        // Joining two String Arrays Using Java Stream API
        System.out.println("Joining two String arrays 'array3' and 'array4' using Stream API in java");
        Stream<String> firstStringArray = Arrays.stream(array3);
        Stream<String> secondStringArray = Arrays.stream(array4);
        String[] fullStringArray = Stream.concat(firstStringArray, secondStringArray).toArray(size -> new String[size]);
        for(String a : fullStringArray){
            System.out.println(a);
        }
        System.out.println("****************************************************************");
        // Joining two String Arrays Using Google Guava
        System.out.println("Joining two String arrays 'array3' and 'array4' using Google Guava");
        // ObjectArrays class is imported from com.google.common.collect
        String[] finalStringArray = ObjectArrays.concat(array3, array4, String.class);
        for(String a : finalStringArray){
            System.out.println(a);
        }
        System.out.println("****************************************************************");
        // With Google Guava we can connect any kind of array even if it is a primitive type array
        System.out.println("Joining two int arrays 'array1' and 'array2' using Google Guava");
        int[] combinedIntegerArray = Ints.concat(array1, array2);
        for(int a : combinedIntegerArray){
            System.out.println(a);
        }
        System.out.println("****************************************************************");
        System.out.println("Joining two int arrays 'array1' and 'array2' using Stream API in java");
        int[] combinedFinalIntArray = IntStream
                .concat(Arrays.stream(array1), Arrays.stream(array2))
                .toArray();

        System.out.println(Arrays.toString(combinedFinalIntArray));
    }
}
