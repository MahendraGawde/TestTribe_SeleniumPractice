package testng.annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchEcom {

    @Test(dataProvider = "searchItems")
    public void searchItem(String item) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://amazon.in");
        driver.manage().window().maximize();
        WebElement searchTxt = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchTxt.sendKeys(item);
        Thread.sleep(2000);
        driver.quit();
    }
    @DataProvider(name = "searchItems")
    Object[][] searchItem(){
        Object[][]items = {{"laptop"},{"mobile"},{"iphone"},{"mac"},{"tshirt"},
                {"OLED tv"},{"kindle"},{"Jeans"},{"Laptop bags"},{"Headphones"}
    };
    return items;
}

}
