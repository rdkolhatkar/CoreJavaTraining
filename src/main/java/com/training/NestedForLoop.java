package com.training;

/**
 Using Nested For Loop print number in the console as shown below:
 [
 1 2 3 4
 5 6 7
 8 9
 10
 ]
 */
public class NestedForLoop {

    public static void main(String argvs[]) {
        int k=1;

        for (int i = 0; i < 4; i++){
            for (int j = 1; j <= 4 - i; j++) {
                System.out.print(" " +k);
                System.out.print("\t");
                k++;
            }
            System.out.println("");
        }
    }
}
