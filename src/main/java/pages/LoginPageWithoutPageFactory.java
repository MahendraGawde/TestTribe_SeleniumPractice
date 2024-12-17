package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageWithoutPageFactory {
    private WebDriver driver;

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login_button");

    public LoginPageWithoutPageFactory(WebDriver driver){
        this.driver = driver;
    }

    public void enterEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
}
