package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CountryCapitals {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.countries-ofthe-world.com/capitals-of-the-world.html");
        driver.manage().window().maximize();

        List<WebElement> countries = null;
        List<WebElement> capitals = null;

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            Thread.sleep(10000);

            countries = driver.findElements(By.xpath("//tbody//tr[td[not(@colspan)]]/td[1]"));
            capitals = driver.findElements(By.xpath("//tbody//tr[td[not(@colspan)]]/td[2]"));

            for (int i = 0; i < countries.size(); i++) {

                System.out.println("Country: " + countries.get(i).getText() + ", Capital: " + capitals.get(i).getText());
            }


        Thread.sleep(5000);
        System.out.println("No.of countries ->" +countries.size());
        System.out.println("No.of capitals ->" +capitals.size());
        driver.quit();


    }
}
