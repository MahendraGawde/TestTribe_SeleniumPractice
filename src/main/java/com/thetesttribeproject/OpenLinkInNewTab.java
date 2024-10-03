package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OpenLinkInNewTab {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.orangehrm.com");
        driver.manage().window().maximize();

        WebElement priceLink = driver.findElement(By.linkText("Pricing"));
        Actions act = new Actions(driver);
        act.keyDown(Keys.CONTROL).click(priceLink).keyUp(Keys.CONTROL).perform();

        List<String> ids = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(ids.get(1));

        WebElement fullName = driver.findElement(By.name("FullName"));
        fullName.sendKeys("Rock Dwayne Johansson");

        WebElement email = driver.findElement(By.name("Email"));
        email.sendKeys("rockiscooking@wwe.com");

        WebElement companyName = driver.findElement(By.name("CompanyName"));
        companyName.sendKeys("World Wrestling Enterprise");

        WebElement contact = driver.findElement(By.name("Contact"));
        contact.sendKeys("9988445577");

        WebElement countryDropDown = driver.findElement(By.name("Country"));
        WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(5));

        WebElement noOfEmployees = myWait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//select[@id= 'Form_getForm_NoOfEmployees']")));
        Select selectEmpDropDown = new Select(noOfEmployees);
        selectEmpDropDown.selectByIndex(5);

//        selectByVisibleText("0 - 10")

        WebElement countryDrpDown = myWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//select[@name= 'Country']")));
        Select selectCountryDropDown = new Select(countryDrpDown);
        selectCountryDropDown.selectByVisibleText("India");

        WebElement submitBtn = driver.findElement(By.xpath("//input[@type = 'submit']"));
        submitBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.orangehrm.com/en/pricing/confirmation");

        System.out.println("Test passed");
        driver.quit();
    }
}
