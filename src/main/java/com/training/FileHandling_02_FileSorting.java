package com.training;

import java.io.File;
import java.util.Arrays;

public class FileHandling_02_FileSorting {
    /*
        Print all files and folders in a Directory in the Sorted Order
    */
    public static void main(String[] args) {
        String directoryPath = "src/main/resources/UnSortedFolder";
        File file = new File(directoryPath);
        // listFiles() this method from java.io.File will give us the Array of files present inside the Directory
        File unsortedDirectory[] = file.listFiles();
        // To sort the files we will use the Arrays.sort() method
        Arrays.sort(unsortedDirectory);
        for(File f : unsortedDirectory){
            if(f.isFile()){
                // getAbsolutePath() this method is used for finding the absolute file path
                // f.getFreeSpace() this method is used for checking the free space
                System.out.println("File Name is : "+f.getName()+ " "+f.getAbsolutePath()+" ");
                System.out.println( " Free Space is : "+f.getFreeSpace());
            } else if (f.isDirectory()) {
                System.out.println("Directory Name is : "+f.getName()+" "+f.getAbsolutePath());
                System.out.println( " Free Space is : "+f.getFreeSpace());
            } else {
                System.out.println("Not Known : "+f.getName()+" "+f.getAbsolutePath()+" ");
                System.out.println( " Free Space is : "+f.getFreeSpace());
            }
        }
    }
}
