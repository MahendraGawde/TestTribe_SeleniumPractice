package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BrowserTest {
    public static void main(String[] args) throws InterruptedException {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.geolocation", 2); // 2: Block, 1: Allow, 0: Ask

        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.airindia.com");
        Thread.sleep(5000);
        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id = 'onetrust-accept-btn-handler']"));
        acceptCookies.click();
        System.out.println("Cookies Accepted");
        Thread.sleep(3000);
        WebElement fromDate = driver.findElement(By.xpath("//input[@fdprocessedid = 'w3c6xv']"));
        fromDate.click();
        Thread.sleep(2000);
        WebElement toDate = driver.findElement(By.xpath("//input[@fdprocessedid = 'okk75v6']"));
        toDate.click();
        Thread.sleep(2000);
        driver.quit();
        System.out.println("test passed");
    }


}
