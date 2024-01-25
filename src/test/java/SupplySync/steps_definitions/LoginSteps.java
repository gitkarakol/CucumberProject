package SupplySync.steps_definitions;

import SupplySync.pages.LoginPage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import utilities.Config;
import utilities.Driver;

public class LoginSteps {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("user logs in to the website")
    public void user_logs_in_to_the_website() {
        driver.get(Config.getValue("url"));
        loginPage.email.sendKeys(Config.getValue("email"));
        loginPage.password.sendKeys(Config.getValue("password"));
        loginPage.submit.click();
    }
}
