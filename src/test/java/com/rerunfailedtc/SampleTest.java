package com.rerunfailedtc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTest {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }

    @Test(retryAnalyzer = RerunScript.class)
    public void checkTitle(){
        String title = driver.getTitle();
        Assert.assertEquals(title, "google");
    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
