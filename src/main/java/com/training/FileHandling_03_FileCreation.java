package com.training;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileHandling_03_FileCreation {
    /*
        Create new file in Java using:
        1) File
        2) FileOutStream
        3) Java NIO utils
    */
    public static void main(String[] args){
        // First Solution is using the File class
        String newFilePath = "src/main/resources/OutputFileLocation/OutPut.txt";
        File file = new File(newFilePath);
        try {
            // createNewFile() this method is used for creating new file path
            boolean flag = file.createNewFile();
            if(flag == true){
                System.out.println("File is created");
            }else {
                System.out.println("File already exists inside the folder");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("******************************************************************************");
        // Second Solution is using FileOutPutStream along with Scanner class to add content in the file
         try {
             Scanner sc = new Scanner(System.in);
             System.out.println("Enter file name and File Path");
             String fileName = sc.nextLine();
             // Creating the Object of FileOutPutStream
             FileOutputStream fos = new FileOutputStream(fileName, true);
             System.out.println("Enter the file content : ");
             String content = sc.nextLine();
             // Now to write the content inside the file we have to convert out input string content into bytes
             byte[] byteArray = content.getBytes();
             // Now passing the byte array inside the generated file
             fos.write(byteArray);
             // Closing the FileOutPutStream
             fos.close();
             System.out.println("File is saved on the Given Location Path");
        } catch (Exception e) {
            System.out.println("Some exception during file creation");
            e.printStackTrace();
        }
        System.out.println("******************************************************************************");
       // Third Solution is using Java Nio package
        // Here Path is imported from java.nio.file
        Path location = Paths.get("src/main/resources/OutputFileLocation/newFileText.txt");
        try {
            Path path = Files.createFile(location);
            System.out.println("New file created at location : "+path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
