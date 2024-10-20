package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class HighlightElementDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();

        WebElement departCity = driver.findElement(By.xpath("//select[@name='fromPort']"));

        Select cityDropdown = new Select(departCity);
        List<WebElement> allOptions = cityDropdown.getOptions();
        for(WebElement element : allOptions){
            System.out.println(element.getText());

        }
        highlightElement(driver, departCity);

    }
    public static void highlightElement(WebDriver driver, WebElement element) {
        // Use JavaScriptExecutor to change the style of the element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String originalStyle = element.getAttribute("style");  // Save original style
        // Change background and border to highlight
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                element, "border: 2px solid red; background-color: yellow;");

        try {
            // Pause to make the highlight visible
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Revert back to original style after highlighting
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                element, originalStyle);
    }

}
