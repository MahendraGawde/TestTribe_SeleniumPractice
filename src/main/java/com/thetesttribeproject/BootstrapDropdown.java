package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BootstrapDropdown {
    // We can only handle this type with xpath
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofMillis(5000));
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[contains(@class , 'multiselect')]")).click();
        //click on bootstrap options
        List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class, 'multiselect')]//label"));
        System.out.println("Number of Options in bootstrap dropdown: " +options.size());
        for(WebElement op : options){
            String option = op.getText();
            if(option.equals("Java") || option.equals("Python") || option.equals("MS SQL Server")){
                op.click();
            }
        }
        Thread.sleep(5000);

        driver.quit();
    }
}
