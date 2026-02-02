package com.practice;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ConvertImageFromOneFormatToAnother {
    /*
        Write Java Code to convert image from one format into another format
        .jpg/.jpeg -> .png/.bmp/.gif
        .png/.bmp/.gif -> .jpg/.jpeg
    */
    public static void main(String[] args) throws IOException {
        // Case 1: Read image from open source Url and then convert its type
        // By inspecting 'https://www.amazon.in/' we can get any similar image Url
        String imageUrl = "https://images-eu.ssl-images-amazon.com/images/G/31/img20/Wireless/Vernac/Desktop_CC/V239875482_IN_WLME_Multibrand_Desktop_CC-379x304._SY304_CB407660272_.jpg";
        // Using Java URL class
        try {
            URL url = new URL(imageUrl);
            // Reading the image from Url
            BufferedImage bufferedImage = ImageIO.read(url);
            // Write the image into any specific format
            // As above image is in .jpg format we will convert it into .png format
            ImageIO.write(bufferedImage, "png", new File("src/main/resources/Images/Test.png"));
            ImageIO.write(bufferedImage, "gif", new File("src/main/resources/Images/TestOne.gif"));
            ImageIO.write(bufferedImage, "bmp", new File("src/main/resources/Images/TestTwo.bmp"));
            ImageIO.write(bufferedImage, "jpeg", new File("src/main/resources/Images/TestThree.jpeg"));
            System.out.println("Image converted Successfully .......................");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("***************************************************************************************************************");
        File file = new File("src/main/resources/Images/BeforeImageConversion/School.jpg");
        BufferedImage bufferedImage = ImageIO.read(file);
        // Write the image into any specific format
        // As above image is in .jpg format we will convert it into .png format
        try {
            ImageIO.write(bufferedImage, "png", new File("src/main/resources/Images/AfterImageConversion/School.png"));
            ImageIO.write(bufferedImage, "gif", new File("src/main/resources/Images/AfterImageConversion/School.gif"));
            ImageIO.write(bufferedImage, "bmp", new File("src/main/resources/Images/AfterImageConversion/School.bmp"));
            ImageIO.write(bufferedImage, "jpeg", new File("src/main/resources/Images/AfterImageConversion/School.jpeg"));
            System.out.println("Image converted Successfully .......................");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
