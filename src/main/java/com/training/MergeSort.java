package com.training;

/**
 * Write a Java program that illustrates merge sort.
 * Merge sort is one of the most efficient sorting algorithms.
 * It works on the principle of “divide and conquer”.
 * It is based on the idea of breaking down a list into several sub-lists until each sub-list consists of a single element,
 * and then merging those sub-lists in a manner that results in a sorted list.
 * The following example code shows one way to use merge sort:
*/
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = { 70, 50, 30, 10, 20, 40, 60 };

        int[] merged = mergeSort(arr, 0, arr.length - 1);

        for (int val : merged) {
            System.out.print(val + " ");
        }
    }

    public static int[] mergeTwoSortedArrays(int[] one, int[] two) {
        int[] sorted = new int[one.length + two.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < one.length && j < two.length) {
            if (one[i] < two[j]) {
                sorted[k] = one[i];
                k++;
                i++;
            } else {
                sorted[k] = two[j];
                k++;
                j++;
            }
        }

        if (i == one.length) {
            while (j < two.length) {
                sorted[k] = two[j];
                k++;
                j++;
            }
        }

        if (j == two.length) {
            while (i < one.length) {
                sorted[k] = one[i];
                k++;
                i++;
            }
        }

        return sorted;
    }

    public static int[] mergeSort(int[] arr, int lo, int hi) {
        if (lo == hi) {
            int[] br = new int[1];
            br[0] = arr[lo];

            return br;
        }

        int mid = (lo + hi) / 2;

        int[] fh = mergeSort(arr, lo, mid);
        int[] sh = mergeSort(arr, mid + 1, hi);

        int[] merged = mergeTwoSortedArrays(fh, sh);

        return merged;
    }

}
