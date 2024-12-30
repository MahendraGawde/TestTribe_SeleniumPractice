package com.thetesttribeproject;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FullPageScreenshot {

    /* Full page screenshot method only available for firefox driver in selenium 4 till current version
    *  of 4.27
    * */
    WebDriver driver;
    @BeforeTest
    public void setUp(){

        driver = new FirefoxDriver();
        driver.get("https://amazon.com");
        driver.manage().window().maximize();

    }

    @Test
    public void testFullPageScreenshot() throws IOException {
        File source = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        FileHandler.copy(source,new File("Amazone full page Screenshot.png"));

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
