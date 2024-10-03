package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MoneyControl {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.moneycontrol.com");
        Thread.sleep(12000);
        WebElement notificationCancel = driver.findElement(By.xpath("//button[@id = 'wzrk-cancel']"));
        Thread.sleep(1000);
        notificationCancel.click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;


        Thread.sleep(6000);
        WebElement retirementTitle = driver.findElement(By.xpath("//div[@class = 'flinkl2']//li/a[1]"));

        js.executeScript("arguments[0].scrollIntoView()",retirementTitle);
        System.out.println("Offset of retirement webelement : " +js.executeScript("return window.pageYOffset;"));
        Thread.sleep(2000);
        retirementTitle.click();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);

        driver.quit();
    }
}
