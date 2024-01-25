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
       branchesPage.emailField.sendKeys("citycity@gmail.com");
       branchesPage.addressField.sendKeys(faker.address().fullAddress());
       branchesPage.phoneNumberField.sendKeys(faker.phoneNumber().phoneNumber());
       branchesPage.locationField.sendKeys(faker.address().city());
       branchesPage.selectRegion.click();
       branchesPage.clickOnRegion.click();
       branchesPage.selectCity.click();
       branchesPage.clickOnCity.sendKeys(Keys.ESCAPE);
       branchesPage.selectCompanies.click();
        List<WebElement> companies = branchesPage.clickOnCompanies;
        for(WebElement company : companies){
            company.click();
        }
        branchesPage.showBranchToCustomers.click();
        branchesPage.clickCompanyButton.click();
        branchesPage.chooseCompany.click();

    }
    @When("user clicks on create branch button")
    public void user_clicks_on_create_branch_button() {
       branchesPage.createButton.click();
    }

    @Then("verify new branch appeared")
    public void verify_new_branch_appeared() {
        Assert.assertEquals("https://supplysync.us/dashboard/branches", driver.getCurrentUrl());

    }

    //second
    @And("user make changes existing Master Branch")
    public void user_make_changes_existing_master_branch() {
      branchesPage.threeDotsButton.click();
      branchesPage.editButton.click();
      branchesPage.saveButton.click();

    }


    @Then("verify s the existing branch has been changes")
    public void verify_s_the_existing_branch_has_been_changes() {
        Assert.assertEquals("https://supplysync.us/dashboard/branches", driver.getCurrentUrl());
    }
    //third
    @Then("user fill all field with valid info with instruction without phone number")
    public void user_fill_all_field_with_valid_info_with_instruction_without_phone_number() {
        Faker faker = new Faker();
        branchesPage.branchNameField.sendKeys(faker.name().name());
        branchesPage.emailField.sendKeys("citycity@gmail.com");
        branchesPage.addressField.sendKeys(faker.address().fullAddress());
    }
    @When("user enter uncorrect phono number")
    public void user_enter_uncorrect_phono_number() {
        branchesPage.phoneNumberField.sendKeys("00000000");
    }
    @Then("ensure the phone number box change its color to red")
    public void ensure_the_phone_number_box_change_its_color_to_red() {
        Assert.assertEquals("https://supplysync.us/dashboard/branches", driver.getCurrentUrl());
    }



}
