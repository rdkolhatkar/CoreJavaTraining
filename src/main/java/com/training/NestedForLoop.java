package com.training;

/**
 Using Nested For Loop print number in the console as shown below:
 [
 1 2 3 4
 5 6 7
 8 9
 10
 ]
 Using Nested For Loop print number in the console as shown below:
 [
 1
 2 3
 4 5 6
 7 8 9 10
 ]
 Using Nested For Loop print number in the console as shown below:
 [
 1
 1 2
 1 2 3
 1 2 3 4
 1 2 3 4 5
 1 2 3 4 5 6
 1 2 3 4 5 6 7
 1 2 3 4 5 6 7 8
 1 2 3 4 5 6 7 8 9
 ]
 */
public class NestedForLoop {

    public static void main(String argvs[]) {
        // Problem 1
        System.out.println(" Problem 1 ");
        int k=1;
        for (int i = 0; i < 4; i++){
            for (int j = 1; j <= 4 - i; j++) {
                System.out.print(" " +k);
                System.out.print("\t");
                k++;
            }
            System.out.println("");
        }
        // Problem 2
        System.out.println(" Problem 2 ");
        int p=1;
        for (int i = 1; i <= 5; i++){
            for (int j = 1; j <= i; j++) {
                System.out.print(p);
                System.out.print("\t");
                p++;
            }
            System.out.println("");
        }
        // Problem 3
        System.out.println(" Problem 3 ");
        for(int i=1;i<=9;i++){
            for(int j=1;j<=i;j++) {
                System.out.print(j);
                System.out.print("\t");
            }
            System.out.println("");
        }
    }
}
