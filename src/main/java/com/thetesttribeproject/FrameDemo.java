package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://selectorshub.com/iframe-scenario/");

        // Index
//        driver.switchTo().frame(1).findElement(By.cssSelector("#inp_val")).sendKeys("mahi");

        //nameorID
//        driver.switchTo().frame("pact1").findElement(By.cssSelector("#inp_val")).sendKeys("mahi");

        WebElement frameElement = driver.findElement(By.cssSelector("#pact1 ")); // WebElement
//        driver.switchTo().frame(frameElement).findElement(By.cssSelector("#inp_val")).sendKeys("mahi");

        // Nested Iframes
        driver.switchTo().frame(frameElement).switchTo().frame("pact2").findElement(By.cssSelector("#jex")).sendKeys("Janu");
        Thread.sleep(2000);
        driver.switchTo().parentFrame().findElement(By.cssSelector("#inp_val")).sendKeys("mahi");
    }
}
