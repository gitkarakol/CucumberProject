package SupplySync.steps;

import SupplySync.pages.LoginPage;
import SupplySync.pages.MasterPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class MasterSteps {

    WebDriver driver = Driver.getDriver();

    MasterPage masterPage = new MasterPage(driver);

    @Then("user goes to Master tab")
    public void user_goes_to_master_tab() {
        masterPage.masterButton.click();

    }

    @Then("display all existing Masters")
    public void display_all_existing_masters() {

        Assert.assertEquals("https://supplysync.us/dashboard/masters", driver.getCurrentUrl());

    }

    @Then("user clicks on create button on Master Page")
    public void user_clicks_on_create_button_on_master_page() throws InterruptedException {
        masterPage.createMasterButton.click();
    }

    @Then("user fills all fields on Master Page")
    public void user_fills_all_fields_on_master_page() {
        masterPage.emailMaster.sendKeys("johndoe@gmail.com");
        masterPage.lastName.sendKeys("Doe");
        masterPage.name.sendKeys("John");
        masterPage.number.sendKeys("777771441");
        masterPage.location.sendKeys("Toronto");
        masterPage.password.sendKeys("anypassowrd");

    }

    @When("user clicks on save Master button")
    public void user_clicks_on_save_master_button() throws InterruptedException {
        masterPage.save.click();



    }

    @Then("verify Master appeared")
    public void verify_master_appeared() {


    }


    @Then("User makes changes in existing Master Profile")
    public void user_makes_changes_in_existing_master_profile() throws InterruptedException {
        Thread.sleep(5000);
        masterPage.masterButton.click();
        masterPage.threeDots.click();
        masterPage.edit.click();
        Thread.sleep(10000);
        masterPage.lastName.click();
        masterPage.lastName.sendKeys("  CHANGED");
        masterPage.password.sendKeys("anypassowrd");
    }
    @Then("User clicks on Save button")
    public void user_clicks_on_save_button() {
     masterPage.save.click();
    }
    @Then("verify if the existing Master has been changed")
    public void verify_if_the_existing_master_has_been_changed() {
    }








}
