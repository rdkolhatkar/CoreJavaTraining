package com.practice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonClassImplementationForWebDriver {

    private static SingletonClassImplementationForWebDriver instanceDriver = null;
    private WebDriver driver;

    // Private constructor to prevent instantiation
    private SingletonClassImplementationForWebDriver() {
        // private constructor to prevent instantiation

    }
    // Method to open a browser and return the WebDriver instance
    public WebDriver openBrowser() {
        driver = new ChromeDriver();
        return driver;
    }
    // Static method to create and return the single instance of the class
    public static SingletonClassImplementationForWebDriver getInstance() {
        if (instanceDriver == null) {
            instanceDriver = new SingletonClassImplementationForWebDriver();
        }
        return instanceDriver;
    }


    @Test
    public void testOpenBrowser() throws InterruptedException {
        WebDriver testDriver;
        SingletonClassImplementationForWebDriver instanceWebDriver;
        instanceWebDriver = SingletonClassImplementationForWebDriver.getInstance();
        testDriver = instanceWebDriver.openBrowser();
        testDriver.get("https://www.google.com");
        System.out.println(testDriver.getTitle());
        Thread.sleep(5000); // Wait for 5 seconds to see the browser
        testDriver.quit(); // Close the browser
    }
}
