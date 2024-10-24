package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.time.Duration;

public class EtMoney {
    public static void main(String[] args) throws InterruptedException {
        // Clicking on Menu and submenu 2nd and then again find menu and other submenu
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://etmoney.com");
        driver.manage().window().maximize();
        Actions act = new Actions(driver);

        WebElement mfElement = driver.findElement(By.xpath("//span[@class = 'header-nav-link']"));

        Thread.sleep(2000);
        WebElement investorPersonalityLnk = driver.findElement(By.xpath("//strong[normalize-space()='Know your Investor Personality']"));

        act.moveToElement(mfElement).moveToElement(investorPersonalityLnk).click().perform();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

        WebElement mfElement1 = driver.findElement(By.xpath("//span[@class = 'header-nav-link']"));
        WebElement allAboutMflnk = driver.findElement(By.xpath("//strong[normalize-space()='All about Mutual Funds']"));

        act.moveToElement(mfElement1).moveToElement(allAboutMflnk).click().perform();


        Assert.assertTrue(driver.getTitle().contains("Invest Online in Mutual Funds in India"));

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
