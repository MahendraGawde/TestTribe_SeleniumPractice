package com.thetesttribeproject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NestedShadowDomExample {
    WebDriver driver;
    @BeforeTest
    public void launchUrl(){
        driver = new ChromeDriver();
        driver.get("https://shop.polymer-project.org/");
        driver.manage().window().maximize();
    }

    @Test
    public void findELementInNestedShadowDom(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement shopNowMaleButton =
                (WebElement) jsExecutor.executeScript ("return document.querySelector('shop-app')" +
                ".shadowRoot.querySelector('shop-home')" +
                ".shadowRoot.querySelector('shop-button > a')");
        assert shopNowMaleButton != null;
        shopNowMaleButton.click();

    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
