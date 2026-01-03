package com.training;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileHandling_04_FileDeletion {
    /*
        Delete a file in Java using:
        1) File class
        2) Scanner (dynamic path) + File class
        3) Java NIO (Files.delete / Files.deleteIfExists)
    */

    public static void main(String[] args) {

        // =======================
        // 1️⃣ Deleting file using File class (Static Path)
        // =======================
        String filePath = "src/main/resources/OutputFileLocation/OutPut.txt";
        File file = new File(filePath);

        if (file.exists()) {
            boolean deleted = file.delete(); // deletes the file
            if (deleted) {
                System.out.println("File deleted successfully using File class");
            } else {
                System.out.println("File deletion failed");
            }
        } else {
            System.out.println("File does not exist");
        }

        System.out.println("********************************************************");

        // =======================
        // 2️⃣ Deleting file using Scanner (User input path)
        // =======================
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter file path to delete:");
            String userPath = sc.nextLine();

            File userFile = new File(userPath);

            if (userFile.exists()) {
                if (userFile.delete()) {
                    System.out.println("File deleted successfully from given path");
                } else {
                    System.out.println("Unable to delete the file");
                }
            } else {
                System.out.println("File not found at given path");
            }

        } catch (Exception e) {
            System.out.println("Exception occurred while deleting file");
            e.printStackTrace();
        }

        System.out.println("********************************************************");

        // =======================
        // 3️⃣ Deleting file using Java NIO
        // =======================
        Path nioPath = Paths.get("src/main/resources/OutputFileLocation/newFileText.txt");

        try {
            // deleteIfExists() avoids exception if file is missing
            boolean deleted = Files.deleteIfExists(nioPath);
            if (deleted) {
                System.out.println("File deleted successfully using Java NIO");
            } else {
                System.out.println("File does not exist (Nothing to delete)");
            }
        } catch (IOException e) {
            System.out.println("Error while deleting file using Java NIO");
            e.printStackTrace();
        }
    }
}

