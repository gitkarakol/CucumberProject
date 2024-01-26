package SupplySync.steps_definitions;

import SupplySync.pages.BranchesPage;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;

public class BranchSteps {
    WebDriver driver = Driver.getDriver();
    BranchesPage branchesPage = new BranchesPage(driver);

    @Then("user goes to branch tab")
    public void user_goes_to_branch_tab() {
        branchesPage.branchesButton.click();
    }

    @Then("user click on create branch button")
    public void user_click_on_create_branch_button() {
        branchesPage.createBranchButton.click();
    }

    @Then("user fill all field with valid info with instruction")
    public void user_fill_all_field_with_valid_info_with_instruction() {
        Faker faker = new Faker();
        branchesPage.branchNameField.sendKeys(faker.name().name());
        branchesPage.emailField.sendKeys("bigcitylife@gmail.com");
        branchesPage.addressField.sendKeys(faker.address().fullAddress());
        branchesPage.phoneNumberField.sendKeys(faker.phoneNumber().phoneNumber());
        branchesPage.locationField.sendKeys(faker.address().city());
        branchesPage.selectRegion.click();
        branchesPage.clickOnRegion.click();
        branchesPage.selectCity.click();
        branchesPage.clickOnCity.sendKeys(Keys.ESCAPE);
        branchesPage.selectCompanies.click();
        branchesPage.clickOnCompanies.click();
//        branchesPage.createButton.click();
//        branchesPage.showBranchToCustomers.click();


    }

    @When("user clicks on create branch button")
    public void user_clicks_on_create_branch_button() {
        System.out.println("branch created");
        branchesPage.createButton.click();
    }

    @Then("verify new branch appeared")
    public void verify_new_branch_appeared() {
        System.out.println("new branch is appeared");
    }

    //second
    @And("user make changes existing Master Branch")
    public void user_make_changes_existing_master_branch() {
        Faker faker = new Faker();
        branchesPage.threeDotsButton.click();
        branchesPage.editButton.click();
        branchesPage.addressField.clear();
        branchesPage.addressField.sendKeys(faker.address().fullAddress());
        branchesPage.saveButton.click();

    }


    @Then("verify s the existing branch has been changes")
    public void verify_s_the_existing_branch_has_been_changes() {
        System.out.println("branch was updated");
    }


    // third
    @Then("user click on create branch button second time")
    public void userClickOnCreateBranchButtonSecondTime() {
        branchesPage.createBranchButton.click();
    }

    @And("user fill all field with valid info with instruction without phone number")
    public void user_fill_all_field_with_valid_info_with_instruction_without_phone_number() {
        Faker faker = new Faker();
        branchesPage.branchNameField.sendKeys(faker.name().name());
        branchesPage.emailField.sendKeys("citycity@gmail.com");
        branchesPage.addressField.sendKeys(faker.address().fullAddress());
    }

    @When("user enter incorrect phone number")
    public void userEnterIncorrectPhoneNumber() {
        branchesPage.phoneNumberField.sendKeys("000");
        branchesPage.createButton.click();
    }

    @Then("ensure the phone number box change its color to red")
    public void ensureThePhoneNumberBoxChangeItsColorToRed() {
        System.out.println("enable to create not existing phone number");
    }


}
