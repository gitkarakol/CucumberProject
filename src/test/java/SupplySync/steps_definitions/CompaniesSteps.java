package SupplySync.steps_definitions;


import SupplySync.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utilities.Config;
import utilities.Driver;



public class CompaniesSteps {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    CompaniesPage companiesPage = new CompaniesPage(driver);

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        driver.get(Config.getValue("url"));
        loginPage.email.sendKeys(Config.getValue("email"));
        loginPage.password.sendKeys(Config.getValue("password"));
        loginPage.submit.click();
    }

    @When("the user edit company with valid data")
    public void the_user_edit_company_with_valid_data() {
        companiesPage.editButton.click();
        companiesPage.menuOption.click();
        companiesPage.clickEdit.click();
    }

    @Then("the company should be successfully edited with a confirmation message")
    public void the_company_should_be_successfully_edited_with_a_confirmation_message() {
        companiesPage.menuOption.click();
        companiesPage.fillCompanyDetails("Dasha's Company", "dashuha1405@gmail.com", "111 Wall Street", "1234567890");
        companiesPage.replacePicture.sendKeys("file:///Users/enigma/Desktop/1660078396_5-kartinkin-net-p-kramatorsk-dostoprimechatelnosti-krasivo-f-5.jpg");
        companiesPage.saveChanges();
        String confirmationMessage = companiesPage.getConfirmationMessage();
        Assert.assertEquals("Company successfully changed", confirmationMessage);
    }

    @When("the user attempts to edit company with invalid data")
    public void the_user_attempts_to_edit_company_with_invalid_data() {
        driver.get(Config.getValue("https://supplysync.us/login"));
        loginPage.email.sendKeys(Config.getValue("admin@codewise.com"));
        loginPage.password.sendKeys(Config.getValue("codewise123"));
        loginPage.submit.click();

        companiesPage.editButton.click();
        companiesPage.clickElementWithJS(companiesPage.editButton);
        companiesPage.menuOption.click();
        companiesPage.clickEdit.click();
        companiesPage.fillCompanyDetails("da$ha's", "invalid@email@gmail.com", "123 newStreet dr", "0001110001");
        companiesPage.saveChanges();
    }

    @Then("the company should not be added")
    public void the_company_should_not_be_added() {

    }
}
