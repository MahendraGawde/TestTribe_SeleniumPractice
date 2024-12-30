package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RectangleDimensionDemo {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
   @Test
    public void testGetPositionDimension(){

       WebElement hrmLogo = driver.findElement(By.cssSelector("img[alt='company-branding']"));
       Rectangle rectangle = hrmLogo.getRect();
       System.out.println("Height: " +rectangle.getHeight());
       System.out.println("Width: " +rectangle.getWidth());
       System.out.println("X: " +rectangle.getX());
       System.out.println("Y: " +rectangle.getY());

   }
}
