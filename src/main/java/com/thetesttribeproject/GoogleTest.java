package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class GoogleTest {
    @Test
    public void searchFlights() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://makemytrip.com");

        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement closeBtn = driver.findElement(By.xpath("//span[@class = 'commonModal__close']"));
        closeBtn.click();


        WebElement departureDate = driver.findElement(By.xpath("//label[@for ='departure']"));
        departureDate.click();
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
