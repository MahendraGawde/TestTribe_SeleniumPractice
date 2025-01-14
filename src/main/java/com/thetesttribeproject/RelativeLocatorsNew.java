package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocatorsNew {
    WebDriver driver;
    @Test
    public void testRelativeLocators(){
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement btnLogin = driver.findElement(By.tagName("button"));
        WebElement lnkForgotPassword = driver.findElement(with(By.tagName("p")).below(btnLogin));
        lnkForgotPassword.click();
        String titleRememberPwd = driver.findElement(By.tagName("h6")).getText();
        System.out.println("Title of page: " +titleRememberPwd);



    }
}
