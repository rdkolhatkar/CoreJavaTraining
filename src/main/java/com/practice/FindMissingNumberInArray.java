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
    }

}
