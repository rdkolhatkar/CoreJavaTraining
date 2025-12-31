package com.practice;

public class FindMissingNumberInArray {
    public static void main(String[] args){
        int array[] = {1,2,4,5}; // In this sequence number 3 is missing
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum = sum + array[i];
        }
        System.out.println(sum);
        int sum1 = 0;
        for(int j = 1; j<= 5; j++){
            sum1 = sum1 + j;
        }
        System.out.println(sum1);

        System.out.println("missing number is: " + (sum1-sum));

        System.out.println("*******************************************************************");

        int[] a = {15, 16, 17, 18, 19, 20, 21, 22, 24, 25};

        // Calling all three approaches
        findMissingUsingDifference(a);
        findMissingUsingSum(a, 15, 25);
        findMissingUsingXOR(a, 15, 25);
    }
    /*
   ===========================================================================
   APPROACH 1: DIFFERENCE METHOD
   ===========================================================================
   - Works when array is sorted
   - Difference between consecutive elements should be 1
   - If difference is not 1, missing number is current element + 1
  */
    public static void findMissingUsingDifference(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {

            if (a[i + 1] - a[i] != 1) {
                System.out.println("Missing number (Difference Method): " + (a[i] + 1));
                return;
            }
        }
    }

    /*
/*
===============================================================================
APPROACH 2: SUM METHOD
===============================================================================

PROBLEM IDEA:
-------------
We know that one number is missing from a continuous range of numbers.
If we know:
1) The EXPECTED sum of all numbers in that range
2) The ACTUAL sum of numbers present in the array

Then:
    Missing Number = Expected Sum - Actual Sum

-------------------------------------------------------------------------------
MATHEMATICAL LOGIC (VERY IMPORTANT):
-------------------------------------------------------------------------------

Formula to calculate sum of first n natural numbers:
    Sum = n * (n + 1) / 2

But our range does NOT start from 1.
Example:
    start = 15
    end   = 25

So we calculate:
    Sum from 1 to 25  -  Sum from 1 to 14
This gives us the sum from 15 to 25.
===============================================================================
*/

    public static void findMissingUsingSum(int[] a, int start, int end) {

        // Calculate the expected sum of all numbers from start to end
        // Step 1: (end * (end + 1)) / 2  -> sum of numbers from 1 to end
        // Step 2: ((start - 1) * start) / 2 -> sum of numbers from 1 to (start - 1)
        // Step 3: Subtract step 2 from step 1 to get sum from start to end
        int expectedSum = (end * (end + 1) / 2)
                - ((start - 1) * start / 2);

        // Variable to store the sum of elements actually present in the array
        int actualSum = 0;

        // Loop through each element of the array
        // and add it to actualSum
        for (int num : a) {
            actualSum += num;
        }

        // The missing number is the difference between
        // expected sum and actual sum
        int missingNumber = expectedSum - actualSum;

        // Print the missing number
        System.out.println("Missing number (Sum Method): " + missingNumber);
    }

/*
===============================================================================
APPROACH 3: XOR METHOD (INTERVIEW FAVORITE)
===============================================================================

KEY CONCEPT:
------------
XOR is a bitwise operator that has very special properties.

XOR RULES:
----------
1) a ^ a = 0        (same numbers cancel each other)
2) a ^ 0 = a        (number remains same)
3) Order does not matter

WHY THIS WORKS:
---------------
If we XOR all numbers in the expected range
AND XOR all numbers present in the array,
all common numbers cancel out and only the missing number remains.

This method is:
- Fast
- Overflow safe
- Very popular in interviews
===============================================================================
*/

    public static void findMissingUsingXOR(int[] a, int start, int end) {

        // This variable will store XOR of all numbers from start to end
        int xorAll = 0;

        // This variable will store XOR of all numbers present in the array
        int xorArray = 0;

        // XOR all numbers in the expected range (start to end)
        // Example:
        // xorAll = 15 ^ 16 ^ 17 ^ ... ^ 25
        for (int i = start; i <= end; i++) {
            xorAll ^= i;
        }

        // XOR all numbers that actually exist in the array
        // Example:
        // xorArray = 15 ^ 16 ^ 17 ^ ... ^ 25 (except the missing number)
        for (int num : a) {
            xorArray ^= num;
        }

        // XOR both results
        // All matching numbers cancel each other
        // Only the missing number remains
        int missingNumber = xorAll ^ xorArray;

        // Print the missing number
        System.out.println("Missing number (XOR Method): " + missingNumber);
    }

/*
===============================================================================
FINAL UNDERSTANDING FOR FRESHERS:
===============================================================================

SUM METHOD:
-----------
- Uses mathematics
- Easy to understand
- Requires known start and end range
- May cause overflow for very large numbers

XOR METHOD:
-----------
- Uses bitwise operations
- No overflow problem
- Best for interviews
- Slightly harder to understand initially

===============================================================================
ONE-LINE INTERVIEW EXPLANATION:
===============================================================================

The sum method finds the missing number by subtracting the actual sum from the
expected sum, while the XOR method cancels out duplicate numbers using XOR
properties and leaves only the missing value.
===============================================================================
*/

}
