package SupplySync.Test;

import SupplySync.Pages.BranchesPage;
import SupplySync.Pages.LoginPage;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilities.Config;
import utilities.Driver;

public class BranchesTests {
    static WebDriver driver = Driver.getDriver();

    static BranchesPage branchesPage = new BranchesPage(driver);
    static LoginPage loginPage = new LoginPage(driver);

    @BeforeAll
    public static void before() {
        driver.get(Config.getValue("url"));
        loginPage.email.sendKeys(Config.getValue("email"));
        loginPage.password.sendKeys(Config.getValue("password"));
        loginPage.submit.click();
        System.out.println("successfully sign in");
    }

    @Test
    public void AlmaSTest() throws InterruptedException {

        branchesPage.branchesButton.click();
        System.out.println("branches button");
        branchesPage.createBranchButton.click();
        System.out.println("create branches button");
        branchesPage.branchNameField.sendKeys("aisha");
        System.out.println("name field");
        branchesPage.emailField.sendKeys("alma@gmail.com");
        System.out.println("email field");
        branchesPage.addressField.sendKeys("byng thr");
        System.out.println("address field");
        branchesPage.phoneNumberField.sendKeys("777773441");
        System.out.println("phone number field");
        branchesPage.locationField.sendKeys("astana");
        System.out.println("location field");
        branchesPage.selectRegion.click();
        System.out.println("region selected");
        branchesPage.clickOnRegion.click();
        System.out.println("click on region");
        branchesPage.selectCity.click();
        System.out.println("select city");
        branchesPage.clickOnCity.click();
        branchesPage.clickOnCity.sendKeys(Keys.ESCAPE);
        System.out.println("esc button");
        branchesPage.selectCompanies.click();
        System.out.println("select companies");
        branchesPage.clickOnCompanies.click();
        System.out.println("companies button");
        Thread.sleep(3000);
        branchesPage.showBranchToCustomers.click();
        System.out.println("show to customers");
        branchesPage.createButton.click();
        System.out.println("create button");


    }

    @Test
    public void NegativeTest() {

        branchesPage.branchesButton.click();
        branchesPage.createBranchButton.click();
        branchesPage.branchNameField.sendKeys("num");
        branchesPage.emailField.sendKeys("abc@gmail.com");
        branchesPage.addressField.sendKeys("love st");
        branchesPage.phoneNumberField.sendKeys("87654321");

        String currentUrl = driver.getCurrentUrl();
        branchesPage.createButton.click();

      //(currentUrl, driver.getCurrentUrl());
        Assertions.assertEquals(currentUrl, driver.getCurrentUrl());


    }

    @Test
    public void positiveTestCase() throws InterruptedException {
        branchesPage.branchesButton.click();
        branchesPage.clickCompanyButton.click();
        Thread.sleep(5000);
        branchesPage.chooseCompany.click();
        Thread.sleep(5000);
        branchesPage.threeDotsButton.click();
        Thread.sleep(10000);
        branchesPage.editButton.click();
        branchesPage.addressField.click();
        Thread.sleep(10000);
        branchesPage.addressField.sendKeys("privet drive");
        branchesPage.saveButton.click();


    }

}
