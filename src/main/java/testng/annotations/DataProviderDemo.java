package testng.annotations;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DataProviderDemo {
    WebDriver driver;

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test(dataProvider = "loginCreds")
    void testLogin(String emailId, String pwd) throws InterruptedException {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.manage().window().maximize();
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys(emailId);
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys(pwd);
        WebElement submitBtn = driver.findElement(By.xpath("//input[@value='Login']"));
        submitBtn.click();
        Thread.sleep(2000);

        WebElement myAcct = driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']"));
        boolean status = myAcct.isDisplayed();

        if(status == true){
            driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }
    @AfterClass
    void teardown(){
        driver.quit();
    }

    @DataProvider(name = "loginCreds", indices = {0,2})
    Object[][] loginData(){
        Object data[][] = {
                {"abc@gmail.com","test123"},
                {"xyz@gmail.com","ab@123"},
                {"mahitest011@gmail.com","test@1234"},
                {"john.canaday@gmail.com","testabc"},
                {"sam@gmail.com","testt122"}
        };
        return data;
    }
}
