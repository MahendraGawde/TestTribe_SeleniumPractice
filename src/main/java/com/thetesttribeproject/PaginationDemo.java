package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class PaginationDemo {
    static WebDriver driver;
    static JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException {

        /*Steps to execute pagingation flow
        1. Extract table rows and columns from page
        2. Count no. of pages in table to paginate using substring method
        3. Loop through pages and simultaneously all rows in each page and extract columns data using xpath
         */

        //Open Cart admin dashboard login
        loginApplication("demoadmin","demopass");

        Thread.sleep(1000);

        System.out.println(driver.getCurrentUrl());
        //Navigate to Customer Dashboard
        WebElement customersMenu = driver.findElement(By.partialLinkText("Custome"));
        customersMenu.click();

        WebElement customerSubMenu = driver.findElement((By.xpath("//ul[@id='collapse9']//a[contains(text(),'Customers')]")));
        customerSubMenu.click();

         js = (JavascriptExecutor) driver;
         // Showing 1 to 20 of 893 (45 Pages)
        String text = driver.findElement(By.xpath("//div[contains(text(),'Pages')]")).getText();

        int totalPages = Integer.parseInt(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));

        for (int p = 1; p <= 5 ; p++) {
            if(p>1){
                WebElement activePage = driver.findElement(By.xpath("//ul[@class = 'pagination']//*[text() = "+p+"]"));
                activePage.click();
                Thread.sleep(2000);
                js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            }
            //Reading data from tables
            int noOfRows = driver.findElements(By.xpath("//table[contains(@class, 'table-bordered')]//tbody//tr")).size();

            for (int r = 1; r <= noOfRows; r++) {
                String customer_name = driver.findElement(By.xpath("//table[contains(@class, 'table-bordered')]//tbody//tr["+r+"]//td[2]")).getText();
                String email = driver.findElement(By.xpath("//table[contains(@class, 'table-bordered')]//tbody//tr["+r+"]//td[3]")).getText();
                String status = driver.findElement(By.xpath("//table[contains(@class, 'table-bordered')]//tbody//tr["+r+"]//td[5]")).getText();
                System.out.println(customer_name + "\t" +email+ "\t" +status);
        }

        }
        driver.quit();

    }

    public static void loginApplication(String uName, String Pwd)
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.ecomdeveloper.com/demo/admin/index.php");
        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.id("input-username"));
        userName.sendKeys(uName);
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys(Pwd);
        WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginBtn.click();

    }


}
