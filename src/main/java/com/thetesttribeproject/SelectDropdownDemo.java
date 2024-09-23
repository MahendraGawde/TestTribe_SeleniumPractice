package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SelectDropdownDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait myWait = new WebDriverWait(driver,Duration.ofMillis(5000));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println("->=> ->=> ->=> ->=> <- <- <- <-");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");


        WebElement drpCountryEle = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='country']")));;Select countryDropdown = new Select(drpCountryEle);
        List<WebElement> allOptions = countryDropdown.getOptions();
        for(WebElement element : allOptions){
            System.out.println(element.getText());
        }
        System.out.println("Number of options in dropdown country: " +allOptions.size());
        countryDropdown.selectByVisibleText("India");

        Thread.sleep(3000);
        countryDropdown.selectByIndex(5);
        Thread.sleep(5000);

        driver.quit();
    }
}
