package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectTest {
    static WebDriver driver;
    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/en/30-day-free-trial");
        By country = By.id("Form_getForm_Country");

        /*Select selCountry = new Select(driver.findElement(country));
        selCountry.selectByVisibleText("India");*/

        doSelectByVisibleText(country,"India");

    }

    public static WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public static void doSelectByVisibleText(By locator, String value){
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(value);
    }
}
