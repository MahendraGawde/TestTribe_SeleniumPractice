package com.thetesttribeproject;

import jdk.jfr.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitDemo {
    EdgeDriver driver;


    @BeforeTest
    public void openBrowser(){

        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);

    }

    @Test(groups = "QA")
    @Description("Test Wait example")
    public void testFluentWaitExample(){

        driver.navigate().to("https://app.vwo.com");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("login-username")).sendKeys("mahitech011@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("Test@1234");
        driver.findElement(By.id("js-login-btn")).click();



        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);



        WebElement loggedinUsername = wait.until(driver -> driver.findElement(By.xpath("//span[contains(text(),'Account Setup')]")));
        System.out.println("Logged in username is ->" +loggedinUsername.getText());


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
