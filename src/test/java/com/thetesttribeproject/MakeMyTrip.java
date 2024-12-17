package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class MakeMyTrip {
    WebDriver driver;
    @BeforeMethod
    public void launchSite()  {
         driver = new EdgeDriver();
         driver.manage().window().maximize();


    }

    @Test
    public void checkPrices() throws InterruptedException {
        driver.get("https://www.makemytrip.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//span[@data-cy = 'closeModal']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//li[@class = 'menu_Hotels']//span[contains(@class,'chHotels')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id = 'hsw_search_button']")).click();
        Thread.sleep(10000);
       List<WebElement> prices = driver.findElements(By.xpath("//p[@id = 'hlistpg_hotel_shown_price']"));

       for(WebElement price : prices){
           System.out.println("list of prices: " +price.getText());
       }
    }
@AfterMethod
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }
}
