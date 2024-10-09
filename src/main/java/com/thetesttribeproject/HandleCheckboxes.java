package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandleCheckboxes {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        // Select all checkboxes
        List<WebElement> daysChkBoxes = driver.findElements(By.xpath("//input[@class = 'form-check-input' and @type = 'checkbox']"));

        /*for(WebElement day : daysChkBoxes){
           day.click();
        }*/

        // Select last 3 days


        // Select first 2 days
        /*for (int i = 0; i < 2 ; i++) {
            daysChkBoxes.get(i).click();
        }*/

        //Unselect selected checkboxes
        for (int i = 0; i <3 ; i++) {
         daysChkBoxes.get(i).click();
        }
        Thread.sleep(3000);
        for (int i = 0; i < daysChkBoxes.size(); i++) {
            if(daysChkBoxes.get(i).isSelected()) {
                daysChkBoxes.get(i).click();
            }
        }
    }

}
