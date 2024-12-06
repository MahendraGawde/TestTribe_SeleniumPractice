package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://etmoney.com");
        JavascriptExecutor js = driver;

        WebElement signUpBtn = driver.findElement(By.xpath("//button[@class = 'ctaBtn']"));
        //Scroll till specific level of page
//        js.executeScript("window.scrollBy(0,5000)","");

        //Scroll till element is into view
//        js.executeScript("arguments[0].scrollIntoView()",signUpBtn);

        /*js.executeScript("arguments[0].click()",signUpBtn);
        System.out.println("Offset of signup webelement : " +js.executeScript("return window.pageYOffset;"));
        signUpBtn.click();*/

        //Scroll till bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        System.out.println(js.executeScript("return window.pageYOffset")); //5797.60009765625
        Thread.sleep(5000);
        //Scroll to initial position
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
        driver.quit();
    }
}
