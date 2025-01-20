package com.training;

/**
 Write a program in Java to prove that the strings are immutable in Java.
 In order to check that strings are immutable in Java, we have to use the == operator.
 It is because the == compares the references or the addresses of the objects.
 If, after making a change in the string and comparing it with the unchanged one and we get a true value,
 then it means strings are not immutable; otherwise, they are immutable.
 True value means the changed string has the same address as compared to the previous one.
 The following program shows the immutability of strings.
*/
public class ImmutableStrings {

    // main method
    public static void main(String argvs[])
    {
        String str1 = "dadi";
    // assigning the reference of string str1 to string str2
        String str2 = str1;
        str1 = str1 + "Gulzar";

        if(str1 == str2)
        {
            System.out.println("Strings are not immutable.");
        }
        else
        {
        // if the control reaches here, then it means == operator
        // has returned a false value.
            System.out.println("Strings are immutable.");
        }


    }
}
