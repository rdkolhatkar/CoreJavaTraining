package com.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateElementsInArrayPart_1 {
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
        // 2nd Solution is Using HashSet, HashSet is part of Java collection and it's property is it stores unique values, In HashSet Duplicate elements are not allowed.
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
            System.out.println("Keys from storeMap : "+storeMap.get(name));
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
        System.out.println("***************************************************************************");
        // 4th Solution is using java Streams
        Set<String> setData = new HashSet<String>();
        // String names[] = {"Java", "JavaScript", "C", "C++", "Python", "Ruby", "Java", "Python"};
        Set<String> duplicate =
                Arrays.asList(names).stream()
                        .filter(k -> !setData.add(k)).collect(Collectors.toSet());
        System.out.println("Duplicate element is "+duplicate);
        // Here output of stream code will look like this : Duplicate element is [Java, Python]
        // While using the java Stream for finding the duplicate elements, we cannot use the same approach for Integer array
        // Above code is only applicable for String array
        System.out.println("***************************************************************************");
        // 5th Solution is using Grouping By with Stream
        Set<String> elementSet = Arrays.asList(names)
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("Duplicates are : "+elementSet);
        /*
         * Purpose:
         * --------
         * This code finds all DUPLICATE elements from a String array using
         * Java 8 Stream API, Collectors, Lambdas, and Method References.
         *
         * Example Input:
         * ---------------
         * names = {"Java", "Python", "Java", "C", "Python", "Go"}
         *
         * Example Output:
         * ----------------
         * Duplicates are : [Java, Python]
         */
        Set<String> elementSetOne =
                Arrays.asList(names)   // Step 1:
                        // Arrays.asList(names)
                        // --------------------
                        // Converts the array "names" into a List<String>.
                        // Streams work easily with collections like List, Set.
                        //
                        // Example:
                        // String[] names = {"Java", "Python"};
                        // List<String> list = Arrays.asList(names);

                        .stream()      // Step 2:
                        // stream()
                        // --------
                        // Converts the List into a Stream.
                        // Stream allows functional-style operations
                        // like filter(), map(), collect(), etc.

                        .collect(      // Step 3:
                                // collect()
                                // ----------
                                // Terminal operation.
                                // It transforms the Stream into another data structure
                                // (Map, List, Set, etc.) using Collectors.

                                Collectors.groupingBy(
                                        // groupingBy()
                                        // ------------
                                        // Groups elements of the stream based on a KEY.
                                        // Result will be a Map<K, V>.

                                        Function.identity(),
                                        // Function.identity()
                                        // -------------------
                                        // identity() returns the same element as key.
                                        //
                                        // It means:
                                        // element -> element
                                        //
                                        // Example:
                                        // "Java"   -> "Java"
                                        // "Python"-> "Python"
                                        //
                                        // So grouping happens by the element itself.

                                        Collectors.counting()
                                        // Collectors.counting()
                                        // ---------------------
                                        // Counts how many times each key appears.
                                        //
                                        // Output type: Long
                                        //
                                        // Example Map result:
                                        // {
                                        //   Java=2,
                                        //   Python=2,
                                        //   C=1,
                                        //   Go=1
                                        // }
                                )
                        )

                        .entrySet()    // Step 4:
                        // entrySet()
                        // ----------
                        // Converts the Map into a Set of key-value pairs.
                        //
                        // Each entry is of type:
                        // Map.Entry<String, Long>
                        //
                        // Example:
                        // Java=2
                        // Python=2
                        // C=1

                        .stream()      // Step 5:
                        // stream()
                        // --------
                        // Converts the Set<Map.Entry> into a Stream
                        // so that filtering and mapping can be applied.

                        .filter(e -> e.getValue() > 1)
                        // Step 6:
                        // filter()
                        // --------
                        // Keeps only those entries where the value (count)
                        // is greater than 1.
                        //
                        // e is of type Map.Entry<String, Long>
                        //
                        // Meaning:
                        // "Keep only duplicate elements"

                        .map(Map.Entry::getKey)
                        // Step 7:
                        // map()
                        // ------
                        // Transforms each Map.Entry into just its KEY.
                        //
                        // Map.Entry::getKey is a METHOD REFERENCE.
                        //
                        // Equivalent lambda:
                        // e -> e.getKey()
                        //
                        // This extracts only the duplicate element name.

                        .collect(Collectors.toSet());
                        // Step 8:
                        // collect(Collectors.toSet())
                        // ---------------------------
                        // Collects the final stream into a Set<String>.
                        //
                        // Set is used because:
                        // - We want unique duplicate elements
                        // - Set does not allow duplicates

        // Step 9:
        // Print the duplicate elements
        System.out.println("Duplicates are : " + elementSetOne);
        System.out.println("***************************************************************************");
        // 6th Solution is using Frequency method with Stream
        // In above examples we were using the "Collector" but in this example we are using the "Collections"
        List<String> list = Arrays.asList(names);
        Set<String> elementListSet = list.stream().filter(a -> Collections.frequency(list, a) > 1)
                .collect(Collectors.toSet());
        System.out.println(elementListSet);

    }

}
