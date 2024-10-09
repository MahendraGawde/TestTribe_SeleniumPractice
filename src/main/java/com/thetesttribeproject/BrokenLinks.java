package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

/*
Broken Link is link which does not have resource allocated on server.

1) Link  href = "https://www.xyz.com"

2) "https://www.xyz.com" --> Server --> Status code

3) Status code >= 400  -> Broken link
    Status code < 400  --> Not a Broken link
*/

public class BrokenLinks {
    public static void main(String[] args)  {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.deadlinkcity.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Capture all the links from website
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total no. of links: " +links.size());
        int noOfBrokenLinks = 0;

        for(WebElement linkElement : links){
            String hrefAttrbuteVal = linkElement.getAttribute("href");
            if(hrefAttrbuteVal == null || hrefAttrbuteVal.isEmpty()){
                System.out.println("href attribute is null or empty, not possible to check ");
                continue;
            }
            // Hit Url to the Server
            //convert href value from string to URL format
            try {
                URL linkURL = new URL(hrefAttrbuteVal);
                //Open connection to the Server
                HttpURLConnection connectionURL = (HttpURLConnection) linkURL.openConnection();
                connectionURL.connect();//connect and send request to Server

                if(connectionURL.getResponseCode() >= 400){
                    System.out.println(hrefAttrbuteVal+ " =====> Broken link");
                    noOfBrokenLinks++;
                }else{
                    System.out.println(hrefAttrbuteVal+ " =====> Not a Broken link");
                }
            } catch (Exception e) {

            }


        }
        System.out.println("No. of Broken links on page: " +noOfBrokenLinks);
        driver.quit();

    }
}
/*
1. Capture all the links from website
2. Hit Url to the Server
3. Convert href value from string to URL format
4. Open connection to the Server
5. Connect and send request to Server
 */
