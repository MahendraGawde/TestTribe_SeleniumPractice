package com.thetesttribeproject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AlertDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        Thread.sleep(5000);

        /*Alert alert = mywait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();*/

        // Using JavascriptExecutor we can handle alerts with handling exception
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.alert = function{};");
        } catch (Exception e) {
        }
        driver.switchTo().defaultContent();
        driver.quit();

    }
}
