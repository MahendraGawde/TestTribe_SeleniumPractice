package com.thetesttribeproject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Date;

public class NestedShadowDom {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver(); // Selenium Manager will manage the driver
         
        driver.manage().window().maximize();
        driver.get("https://airindia.com");
        Thread.sleep(2000);
        WebElement acceptCookies = driver.findElement(By.xpath(" //button[contains(@id, 'accept-btn')]"));
        acceptCookies.click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;

        Date date = new Date();


        //Find shadow host 1
        WebElement shadowHost1 = driver.findElement(By.xpath("//div[@class = 'ai-date-display']"));
//        WebElement shadowRoot1 = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost1);

        SearchContext sc = shadowHost1.getShadowRoot();
        WebElement departDate = sc.findElement(By.cssSelector("input[id = 'dpFromDate ']"));
        departDate.click();
        System.out.println(driver.getTitle());
        Thread.sleep(5000);
        driver.quit();
    }
}
