package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StaticTable {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        int tableRows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
//        int rows = driver.findElements(By.tagName("tr")).size(); // when single table on webpage
        System.out.println("no. of rows: "+tableRows);

        // No. of columns in table
        int cols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
//        int cols1 = driver.findElements(By.tagName("th")).size(); // when only 1 table on webpage.
        System.out.println("No. of cols: " +cols);

//        String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
//        System.out.println("book name in selected column: " +bookName);

        // Read all table data in rows and cols

        // To pass strings in tr and td array index we required to add +r+ in "" and +c+ in ""
       /* for (int r = 2; r <= tableRows ; r++) {
            for (int c = 1; c <= cols ; c++) {
               String values = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
                System.out.print(values +"\t");
            }
            System.out.println();
        }*/

        // Print book names whose author is Mukesh
        /*for (int r = 2; r <= tableRows ; r++) {
            String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
            if(authorName.equals("Mukesh")){
                String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
                System.out.println(bookName +"\t ->" +authorName);
            }
        }*/

        // Print total price of the books
        int total = 0;
        for (int r = 2; r <= tableRows ; r++) {
            String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
            total = total + Integer.parseInt(price);

            }
        System.out.println("Total price of books: " +total);

    }
}
