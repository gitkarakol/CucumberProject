package SupplySync.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement submit;

    @FindBy(xpath = "//p[.='Incorrect login and/or password.']")
    public WebElement incorrectCredentialsErrorMessage;



}
