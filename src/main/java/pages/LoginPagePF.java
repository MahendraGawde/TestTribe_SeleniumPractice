package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePF {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login_button")
    private WebElement btnLogin;

    public LoginPagePF(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterEmail(String email){
        emailField.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLogin(){
        btnLogin.click();
    }



}
