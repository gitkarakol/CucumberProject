package SupplySync.steps_definitions;

import SupplySync.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Config;
import utilities.Driver;
import utilities.UtilWait;


public class TariffSteps {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    TariffPage tariffPage = new TariffPage(driver);

    @Given("user logs in to the website")
    public void user_logs_in_to_the_website() {
        driver.get(Config.getValue("url"));
        loginPage.email.sendKeys(Config.getValue("email"));
        loginPage.password.sendKeys(Config.getValue("password"));
        loginPage.submit.click();
        //System.out.println("1. user logs in to the website");
    }

    @Then("user goes to tariff tab")
    public void user_goes_to_tariff_tab(){
        tariffPage.tariffsBtn.click();
    }

    @Then("display all existing tariffs")
    public void display_all_existing_tariffs() {
        //System.out.println("3. display all existing tariffs");
        for(WebElement element : tariffPage.expandRow){
            element.click();
        }
        UtilWait.waitUntilElementIsVisible(driver, 10, tariffPage.tariffNames.get(0));
        UtilWait.waitUntilElementIsVisible(driver, 10, tariffPage.deliveryTime.get(0));

//        List <List<WebElement>> tariffs = new ArrayList<>();
//        tariffs.add(tariffPage.tariffNames);
//        tariffs.add(tariffPage.deliveryTime);

        //System.out.println("    Total tariffs: " + tariffPage.tariffNames.size());
//        for(int i = 0; i < tariffs.get(0).size(); i++){
//            for (List<WebElement> tariff : tariffs) {
//                System.out.println(tariff.get(i).getText());
//            }
//            System.out.println("----------------------------------------------");
//        }
    }

    @Then("user clicks on create button")
    public void user_clicks_on_create_button() {
        UtilWait.waitUntilElementIsClickable(driver, 10, tariffPage.createTariff);
        //List<WebElement> errorMessages = driver.findElements(By.linkText("Something went wrong Request failed with status code 500"));

        //Wait for error messages to disappear
        //UtilWait.waitUntilElementIsNotVisible(driver,3, errorMessages.get(errorMessages.size()-1));

        tariffPage.createTariff.click();
        //System.out.println("4. user clicks on create tariff button");
    }

    @Then("user fills all fields")
    public void user_fills_all_fields() {
        tariffPage.chooseBranch.click();
        tariffPage.branch.click();
        tariffPage.chooseTariffName.sendKeys("Test tariff name");
        tariffPage.chooseDeliveryType.click();
        tariffPage.deliveryType.click();
        tariffPage.chooseDeliveryTime.sendKeys("12:30 PM");
        tariffPage.cost.sendKeys("150");
        tariffPage.address.sendKeys("1632 W Washington St, Chicago, IL, 62363");
        tariffPage.comments.sendKeys("No comments =)");
        //System.out.println("5. user fills all fields");
    }

    @When("user clicks on save tariff button")
    public void user_clicks_on_save_tariff_button() {
        tariffPage.create.click();
        //System.out.println("6. user saves a new tariff");
    }

    @Then("verify tariff appeared")
    public void verify_tariff_appeared() {
        //System.out.println("7. tariff created successful");
    }

    @Then("user edit tariff")
    public void user_edit_tariff() throws InterruptedException {
        UtilWait.waitUntilElementIsClickable(driver, 10, tariffPage.expandRow.get(0)).click();
        UtilWait.waitUntilElementIsClickable(driver, 10, tariffPage.tariffOptions).click();
        tariffPage.block.click();

        Thread.sleep(500);
        UtilWait.waitUntilElementIsVisible(driver, 10, tariffPage.expandRow.get(0)).click();
        tariffPage.tariffOptions.click();
        tariffPage.unlock.click();

        Thread.sleep(500);
        tariffPage.expandRow.get(0).click();
        tariffPage.tariffOptions.click();
        tariffPage.edit.click();

        clear(tariffPage.chooseTariffName);
        clear(tariffPage.chooseDeliveryTime);
        clear(tariffPage.cost);
        clear(tariffPage.address);
        clear(tariffPage.comments);

        tariffPage.chooseTariffName.sendKeys("Test tariff name222");
        tariffPage.chooseDeliveryTime.sendKeys("3:30 PM");
        tariffPage.cost.sendKeys("200");
        tariffPage.address.sendKeys("1999 W Washington St, Chicago, IL, 62363");
        tariffPage.comments.sendKeys("Comments!!");

        tariffPage.save.click();

        //System.out.println("8. user edited tariff successful");
    }

    @Then("user delete tariff")
    public void user_delete_tariff() {
        tariffPage.expandRow.get(0).click();
        tariffPage.tariffOptions.click();
        tariffPage.delete.click();
        tariffPage.confirmDelete.click();
        //System.out.println("9. user deleted tariff successful");
    }

    @Then("log out")
    public void log_out(){
            UtilWait.waitUntilElementIsNotVisible(driver, 5, tariffPage.errorMessages);
            UtilWait.waitUntilElementIsClickable(driver, 10, tariffPage.adminPanel).click();
            tariffPage.exit.click();
            tariffPage.exitBtn.click();
            Driver.closeDriver();
            //System.out.println("10. user logged out");
    }

    public void clear(WebElement element){
        while(!element.getText().isEmpty()){
            element.click();
            element.sendKeys(Keys.BACK_SPACE);
        }
    }
}