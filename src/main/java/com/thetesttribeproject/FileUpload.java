package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class FileUpload {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");

        // Single file upload
       /*driver.findElement(By.xpath("//input[@id = 'filesToUpload']")).sendKeys("E:\\testdata_excel\\UserData.xlsx");

        WebElement uploadedFile = driver.findElement(By.xpath("//ul[@id = 'fileList']"));
        if(uploadedFile.getText().equals("UserData.xlsx")){
            System.out.println("File is successfully Uploaded");
        }else{
            System.out.println("Upload Failed");
        }*/

        //Multiple files upload
        String file1 = "E:\\testdata_excel\\UserData.xlsx";
        String file2 = "E:\\testdata_excel\\airindia_date.docx";

        driver.findElement(By.xpath("//input[@id = 'filesToUpload']")).sendKeys(file1 + "\n" +file2);
        int noOfFilesUpload =driver.findElements(By.xpath("//ul[@id = 'fileList']//li")).size();

        if(noOfFilesUpload == 2){
            System.out.println("All files uploaded");
        }else {
            System.out.println("All files not uploaded or error occurred");
        }
        // File names validation
        if(driver.findElement(By.xpath("//ul[@id = 'fileList']//li[1]")).getText().equals("UserData.xlsx")
        && driver.findElement(By.xpath("//ul[@id = 'fileList']//li[2]")).getText().equals("airindia_date.docx")){
            System.out.println("Files Names matching");
        }else{
            System.out.println("Files Names not matching..");

        }

    }
}
