package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;

public class DatePickerDemo {

    public static void selectFutureDate(WebDriver driver, String year, String month, String date){
        //Select year and month

        while(true){
            String selectedMonth = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']")).getText();
            String selectedYear = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-year']")).getText();

            if(selectedMonth.equals(month) && selectedYear.equals(year)){
                break;
            }
            //click arrow for next month
            driver.findElement(By.xpath("//span[@class = 'ui-icon ui-icon-circle-triangle-e']")).click();
        }
        //Select Date
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']//tbody//tr/td//a"));

        for(WebElement dt : allDates){
            if(dt.getText().equals(date)){
                dt.click();
                break;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.switchTo().frame(0);

        Thread.sleep(2000);


        //Open Date picker
        driver.findElement(By.xpath("//input[@id = 'datepicker']")).click();
        Thread.sleep(3000);

        // Select date
        String year = "2025";
        String month = "February";
        String date = "27";

        selectFutureDate(driver,year,month,date);

        Thread.sleep(3000);

        driver.quit();

    }
}
