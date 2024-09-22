package com.thetesttribeproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FileDownload {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com");
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        System.out.println(driver.getTitle());
        if(pageSource.contains("Bing helps you turn information")){
            System.out.println("text present");
        }else{
            System.out.println("text not present");
        }
        driver.quit();
    }
}
