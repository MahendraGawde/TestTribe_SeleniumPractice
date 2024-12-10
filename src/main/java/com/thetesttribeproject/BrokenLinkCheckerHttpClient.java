package com.thetesttribeproject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.http.*;
import java.net.*;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BrokenLinkCheckerHttpClient {
    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the webpage
            driver.get("http://www.deadlinkcity.com/");

            // Maximize the window and wait for elements to load
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Find all links (using the <a> tag)
            List<WebElement> allLinks = driver.findElements(By.tagName("a"));

            // Print the total number of links
            System.out.println("Total number of links: " + allLinks.size());

            // Check and print each link's status
            int brokenLinks = 0;
            for (WebElement link : allLinks) {
                String url = link.getAttribute("href");

                // Validate URL and check response
                if (url != null && !url.isEmpty() && isLinkBroken(url)) {
                    System.out.println("Broken link: " + url);
                    brokenLinks++;
                } else {
                    System.out.println("Working link: " + url);
                }
            }

            // Print the number of broken links
            System.out.println("Number of broken links: " + brokenLinks);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the driver
            driver.quit();
        }
    }

    // Method to check if a link is broken
    public static boolean isLinkBroken(String url) {
        // Create an HttpClient instance
        try( HttpClient client = HttpClient.newHttpClient()) {

            // Create an HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .method("HEAD", HttpRequest.BodyPublishers.noBody())
                    .build();

            // Send the request and get the response
            HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());

            // Return true if the response code is 400 or greater
            return response.statusCode() >= 400;
        } catch (Exception e) {
            // Log the error and assume the link is broken
            System.out.println("Error checking link: " + url + " -> " + e.getMessage());
            return true;
        }
    }
}
