package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.time.Duration;
import java.util.List;

public class GoIbiboReservation {
    WebDriver driver;
    @BeforeTest
    public void launchUrl() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.goibibo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//span[@role = 'presentation']")).click();
        driver.findElement(By.xpath("//div[@data-id = 'dweb_pip_id']/child::p")).click();
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[@class = 'button close']")).click();

    }

    @Test
    public void bookFlight() throws InterruptedException {
        WebElement fromDest =
                driver.findElement(By.xpath("//span[text() = 'From']/following-sibling::p"));
        fromDest.click();
        driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys("Mumbai");

        List<WebElement> dynListFrom = driver.findElements(By.xpath("//li[@role='presentation']"));

        for (WebElement srcElement : dynListFrom) {
            String text = srcElement.getText();
            System.out.println("From selected text: " + text);
            if (text.contains("Mumbai")) {
                srcElement.click();
                break;
            }
        }
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));


        WebElement toDest= driver.findElement(By.xpath("//input[@type = 'text']//preceding-sibling::span"));
        toDest.click();
        driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys("Dubai");
        List<WebElement> dynListTo = driver.findElements(By.xpath("//li[@role='presentation']"));

        for (WebElement targetEle : dynListTo) {
            String text = targetEle.getText();
            System.out.println("To selected text: " + text);
            if (text.contains("Dubai")) {
                targetEle.click();
                break;
            }
        }

        WebElement radioBtnRoundTrip = driver.findElement(By.xpath("//div[@data-id = 'flt-srch-wdgt']//child:: li/p[text() = 'Round-trip']"));
        radioBtnRoundTrip.click();

        String fromTxt = driver.findElement(By.xpath("//span[text() = 'From']/following-sibling::p")).getText();
        String toTxt = driver.findElement(By.xpath("//span[text() = 'To']/following-sibling::p")).getText();
        String departureDate = driver.findElement(By.xpath("//span[text() = 'Departure']/following-sibling::p")).getText();
        String returnDate = driver.findElement(By.xpath("//span[text() = 'Return']/following-sibling::p")).getText();
        String travellersClassTxt = driver.findElement(By.xpath("//span[text() = 'Travellers & Class']/following-sibling::p")).getText();
        System.out.println("Travel details: <=================>");
        System.out.println(" From: " +fromTxt+ "\n To: " +toTxt+ "\n Departure: " +departureDate+ "\n return: " +returnDate+ "\n Travellers & Class: " +travellersClassTxt);
        }
}
