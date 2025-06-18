package com.practice;

public class SwapTwoIntegers {
  public static void main(String[] args){
      // Swap two Integers using third variable
      int x = 10;
      int y = 30;
      int t;
      t = x;
      x = y;
      y = t;
      System.out.println("Value of x is "+x);
      System.out.println("Value of y is "+y);
      // Swap two Integers without using third variable
      int j = 300;
      int k =  28;
      j = j+k;
      k = j-k;
      j = j-k;
      System.out.println("Value of j is "+j);
      System.out.println("Value of k is "+k);
      // One more solution using * & / (Multiplication & Division)
      int a = 20;
      int b = 7;
      a = a*b;
      b = a/b;
      a = a/b;
      System.out.println("Value of a is "+a);
      System.out.println("Value of b is "+b);
      // One more solution using XOR (bitwise) operator - Using decimal to binary
      int c = 1576;
      int d = 657;
      c = c^d; // -> 1111
      d = d^c; // -> 1010
      c = c^d; // -> 0101
      System.out.println("Value of c is "+c);
      System.out.println("Value of d is "+d);



  }
}
