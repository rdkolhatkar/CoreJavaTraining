package com.training;

import java.io.*;

public class FileHandling_01_CopyFile {

    /*
        Copy a File (pdf) and create a different file in the same location with new name
        Read the text from the given PDF file using java and create new PDF file in the same location
    */

    public static void main(String[] args) {

        // Step 1: Create the object of input File class from java.io
        File inputFile = new File("src/main/resources/InputFileLocation/Sample.pdf");

        // Step 2: Create the object of new file which we have to create using the existing file
        File copyInputFile = new File("src/main/resources/InputFileLocation/Sample-Copy.pdf");

        // Step 3: Call the generic method to copy the file
        copyFile(inputFile, copyInputFile);
    }

    /**
     * Generic method to copy data from one file to another
     * This method uses FileInputStream and FileOutputStream
     */
    public static void copyFile(File inputFilePath, File copyInputFilePath) {

        // Step 4: Declare FileInputStream & FileOutputStream references
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            // Step 5: Passing the File path inside the FileInputStream
            fileInputStream = new FileInputStream(inputFilePath);

            // Step 6: Creating FileOutputStream for the new copied file
            fileOutputStream = new FileOutputStream(copyInputFilePath);

            // Step 7: fileInputStream.available() gives number of bytes present in the PDF file
            System.out.println(fileInputStream.available());

            // Step 8: Read the data byte-by-byte from input file
            int i = 0;
            while ((i = fileInputStream.read()) != -1) {

                // Step 9: Write each byte into the new file
                fileOutputStream.write(i);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            // Step 10: Close the FileInputStream to release system resources
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            // Step 11: Close the FileOutputStream to complete file writing
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
