package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();
        Actions act = new Actions(driver);

        WebElement min_slider = driver.findElement(By.xpath("//div[@class = 'price-range-block']//span[1]"));
        System.out.println("Default location of slider: " + min_slider.getLocation());//(59, 250)

        act.dragAndDropBy(min_slider,100,250).perform();

        System.out.println("Slider location after moving: " +min_slider.getLocation());//(158,250)

        WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
        System.out.println("Default location of max slider" +max_slider.getLocation());//(612, 250)

        act.dragAndDropBy(max_slider,-100,250).perform();
        System.out.println("Slider location after moving max slider: " +max_slider.getLocation());//(512, 250)



    }
}
