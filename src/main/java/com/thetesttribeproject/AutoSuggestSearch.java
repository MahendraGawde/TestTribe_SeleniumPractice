package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("selenium");
        Thread.sleep(5000);
        List<WebElement> searchList = driver.findElements(By.xpath("//ul[@role = 'listbox']//li[@role ='presentation']//div[@role= 'option']"));
        System.out.println(searchList.size());

        /*for (int i = 0; i < searchList.size() ; i++) {
            System.out.println(searchList.get(i).getText());
            if(searchList.get(i).getText().equals("selenium webdriver")){
                searchList.get(i).click();
                break;
            }
        }*/
        for(WebElement suggestion : searchList){
            System.out.println(suggestion.getText());
        }

        for(WebElement suggestion : searchList){
            if(suggestion.getText().equals("selenium webdriver")){
                suggestion.click();
                break;
            }
        }
    }
}
