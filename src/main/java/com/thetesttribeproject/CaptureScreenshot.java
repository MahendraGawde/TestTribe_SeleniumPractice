package com.thetesttribeproject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class CaptureScreenshot {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://opencart.com");
        driver.get("https://amazon.in");
        driver.manage().window().maximize();

        /*TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        File targetFile = new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");
        sourceFile.renameTo(targetFile);*/

        WebElement blockbusterDeals = driver.findElement(By.xpath("//div[@id = 'desktop-2']"));
        File sourceFile = blockbusterDeals.getScreenshotAs(OutputType.FILE);

        File targetFile = new File(System.getProperty("user.dir")+ "\\screenshots\\blockbuster_deals.png");
        sourceFile.renameTo(targetFile);
    }
}
