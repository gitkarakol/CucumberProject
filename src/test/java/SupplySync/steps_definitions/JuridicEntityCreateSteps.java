package SupplySync.steps_definitions;

import SupplySync.pages.JuridicEntityPage;
import SupplySync.pages.JuridicEntityPagee;
import SupplySync.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utilities.Config;
import utilities.Driver;

public class JuridicEntityCreateSteps {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    JuridicEntityPagee juridicEntityPagee = new JuridicEntityPagee(driver);



    @Given("user logs in to supplysync")
    public void user_logs_in_to_supplysync() {
        driver.get(Config.getValue("url"));
        loginPage.email.sendKeys(Config.getValue("email"));
        loginPage.password.sendKeys(Config.getValue("password"));
        loginPage.submit.click();
    }
    @When("user goes to Juridic Entity page")
    public void user_goes_to_juridic_entity_page() {
        juridicEntityPagee.clickAJuridicEntityButton();
    }
    @When("user creates a legal entity")
    public void user_creates_a_legal_entity() throws InterruptedException {
        juridicEntityPagee.createLegalEntity();
        juridicEntityPagee.createLegalButton();
    }
    @Then("verify the course is created")
    public void verify_the_course_is_created() {
        System.out.println("the course is successfully created");
    }
}
