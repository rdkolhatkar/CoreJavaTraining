package com.training;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileHandling_05_ReadFile {
    /*
        Read the given txt file using Java
        1) FileInputStream
        2) BufferReader
        3) FileReader
        4) Scanner
        5) NIO
    */
    public static void main(String[] args) {
        String filePath = "src/main/resources/OutputFileLocation/Ratnakar.txt";
        System.out.println("Reading the Given file using FileInputStream .......");
        FileInputStream fileInputStream = null;
        File file = null;
        try{
            file = new File(filePath);
            // First we have to check if our Desktop or Operating System is compatible with the given file or not
            if(!Desktop.isDesktopSupported()){
                // Desktop is class from java.awt. & isDesktopSupported() method will return true if out file is compatible with OS
               System.out.println("Desktop does not support this file");
               return;
            }
            Desktop desktop = Desktop.getDesktop();
            if(file.exists()){
                desktop.open(file);
                // desktop.open this method requires the file Object to open the file in Desktop window
                // But here we are only launching the file on Desktop to read the file content we will use the below code
                // To read the file content we will use the FileInputStream
                fileInputStream = new FileInputStream(file);
                // Now we will print the file content in the Console
                System.out.println("File Content is : ");
                int c = 0;
                while ((c = fileInputStream.read()) != -1){
                    System.out.print((char) c);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("******************************************************************");
        System.out.println("Reading the Given file using BufferedReader .......");
        BufferedReader bufferedReader = null;
        try{
            // Declaring the Object of BufferedReader
            bufferedReader = new BufferedReader(new FileReader(file));
            System.out.println("File Content is : ");
            int i = 0;
            while ((i = bufferedReader.read()) != -1){
                System.out.print((char) i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("******************************************************************");
        System.out.println("Reading the Given file using FileReader .......");
        FileReader fileReader = null;
        try{
            fileReader = new FileReader(filePath);
            System.out.println("File Content is : ");
            int j = 0;
            while ((j = fileReader.read()) != -1){
                System.out.print((char)j);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("******************************************************************");
        System.out.println("Reading the Given file using Scanner in Java .......");
        Scanner scanner = null;
        try{
            scanner = new Scanner(file);
            System.out.println("File Content is : ");
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("******************************************************************");
        System.out.println("Reading the Given file NIO package in Java .......");
        // NIO package will give us the Files class and we can use different Methods
        try {
            List<String> list = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
