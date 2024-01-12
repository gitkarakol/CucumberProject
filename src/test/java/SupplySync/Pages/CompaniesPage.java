package SupplySync.Pages;

import SupplySync.Test.CompaniesTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CompaniesPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/form/button")
    public WebElement editButton;

    public CompaniesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/div[3]/div/button")
    public WebElement menuOption;

    @FindBy(xpath = "//*[@id=\"long-menu\"]/div[3]/ul/li")
    public WebElement clickEdit;

    @FindBy(name = "name")
    public WebElement nameField;

    @FindBy(name = "email")
    public WebElement emailField;

    @FindBy(name = "address")
    public WebElement addressField;

    @FindBy(name = "phoneNumber")
    public WebElement phoneField;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div[2]/div/button[2]")
    public WebElement saveButton;

    @FindBy(css = "#root > div.sc-gKclnd.kTwmCH.SnackbarContainer-top.SnackbarContainer-right.SnackbarContainer-root > div > div > div > div > div > div > div")
    public WebElement confirmationMessage;

    public void clickEditButton() {
        editButton.click();
    }
    public void selectMenuOption() {
        menuOption.click();
    }

    public void clickEdit() {
        clickEdit.click();
    }


    public void fillCompanyDetails(String name, String email, String address, String phone) {
        CompaniesTest.clearWebField(nameField);
        nameField.sendKeys(name);

        CompaniesTest.clearWebField(emailField);
        emailField.sendKeys(email);

        CompaniesTest.clearWebField(addressField);
        addressField.sendKeys(address);

        CompaniesTest.clearWebField(phoneField);
        phoneField.sendKeys(phone);
    }

    public void saveChanges() {
        saveButton.click();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public void clickElementWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }


}

