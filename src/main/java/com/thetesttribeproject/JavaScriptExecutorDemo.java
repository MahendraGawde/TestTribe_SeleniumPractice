package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://etmoney.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement signUpBtn = driver.findElement(By.xpath("//button[@class = 'ctaBtn']"));
        js.executeScript("window.scrollBy(0,5000)","");
//        js.executeScript("arguments[0].scrollIntoView()",signUpBtn);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click()",signUpBtn);
        System.out.println("Offset of signup webelement : " +js.executeScript("return window.pageYOffset;"));
        signUpBtn.click();
        driver.quit();
    }
}
