package com.practice;

public class RmoveSpecialCharactersFromString {
    public static void main(String[] args){
        String one = "圖表鐵薫描火木中心水金 Latin String 0123456789 !@#$%&*()";
        String two = one.replaceAll("[^a-zA-z0-9]", "");
        System.out.println(two);
    }
}
