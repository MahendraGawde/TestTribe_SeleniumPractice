package com.thetesttribeproject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;


import java.time.Duration;

// Only Open ShadowDom elements can be located with selenium methods
// Closed ShadowDom cannot be located using selenium methods such as getShadowRoot
// We can use tips and tricks such as actions classes to navigate to ShadowDom Elements.

public class ShadowDomExample {
    public static void main(String[] args)  {

        WebDriver driver = new ChromeDriver(); // Selenium Manager will manage the driver

        driver.manage().window().maximize();
        // Open url
        driver.get("https://www.letcode.in/shadow");
        // find shadow host element
        WebElement shadowHost = driver.findElement(By.id("open-shadow"));
        //get Shadow root with method getShadowRoot()
        SearchContext sc = shadowHost.getShadowRoot();
        // find shadow dom element with css selector
        WebElement firstname = sc.findElement(By.cssSelector("#fname"));
        firstname.sendKeys("Rishi");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys("Raj").sendKeys(Keys.TAB)
                .sendKeys("test@gmail.com").build().perform();




        // Set an implicit wait of 5 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        // Quit the browser
        driver.quit();

    }
}
