package com.thetesttribeproject;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class EncodeDecodeExample {
    public static void main(String[] args) {

//        String password = "admin123";
//        byte[] encodedPassword = Base64.encodeBase64(password.getBytes());
//        System.out.println(new String(encodedPassword));

        // YWRtaW4xMjM=
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("Admin");


        byte[] decodedPassword = Base64.decodeBase64("YWRtaW4xMjM=");
        driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys(new String(decodedPassword));

        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        System.out.println("Logged in title: "+driver.getTitle());
        driver.quit();
    }
}
