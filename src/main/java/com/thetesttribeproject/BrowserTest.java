package com.thetesttribeproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.quit();
        System.out.println("test passed");
    }
}
