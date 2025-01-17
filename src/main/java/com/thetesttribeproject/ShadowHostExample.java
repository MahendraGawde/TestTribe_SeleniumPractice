package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShadowHostExample {
    WebDriver driver;
    @BeforeTest
    public void launchUrl(){
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        // Open url
        driver.get("https://books-pwakit.appspot.com/");
    }
    @Test
    public void findShadowElementUsingSelenium() throws InterruptedException {

        WebElement shadowHost = driver.findElement(By.tagName("book-app"));
        // get shadow root with getShadowRoot method
        SearchContext sc = shadowHost.getShadowRoot();
        Thread.sleep(2000);
        // navigate to each shadow element to capture target locator
        WebElement appHeader = sc.findElement(By.cssSelector("app-header"));

        WebElement appToolbar = appHeader.findElement(By.cssSelector(".toolbar-bottom"));

        WebElement bookInputDecorator = appToolbar.findElement(By.tagName("book-input-decorator"));

        WebElement searchInput = bookInputDecorator.findElement(By.id("input"));
        searchInput.sendKeys("My new roots");
    }

    @AfterTest
    public void tearDown(){
        if(driver != null)
            driver.quit();
    }
}
