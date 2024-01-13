package SupplySync.Test;

import SupplySync.Pages.LoginPage;
import SupplySync.Pages.MasterPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Config;
import utilities.Driver;
import utilities.UtilWait;

import java.time.Duration;

public class MasterTest {

    static WebDriver driver = Driver.getDriver();
    static LoginPage loginPage = new LoginPage(driver);
    static MasterPage masterPage = new MasterPage(driver);

    @BeforeClass
    public static void before() {
        driver.get(Config.getValue("url"));
        loginPage.email.sendKeys(Config.getValue("email"));

        loginPage.password.sendKeys(Config.getValue("password"));
        loginPage.submit.click();
        System.out.println("Congratulations! You have successfully logged in");
    }

    @Test
    public void AishasTest() {
        masterPage.masterButton.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println("Master Page Opened");

        masterPage.createMasterButton.click();
        System.out.println("You have clicked on Create Master");

        masterPage.name.sendKeys("John");
        masterPage.lastName.sendKeys("Doe");
        masterPage.emailMaster.sendKeys("johndoe@gmail.com");
        masterPage.password.sendKeys("anypassword");
        masterPage.location.sendKeys("Toronto");
        masterPage.number.sendKeys("777771441");
        masterPage.createButton.click();
        System.out.println("successfully created MASTER");

    }

    @Test
    public void EditTheMaster() throws InterruptedException {

        masterPage.masterButton.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println("Master Page Opened");
        masterPage.threeDots.click();
        masterPage.edit.click();
        masterPage.password.click();
        Thread.sleep(10000);
        masterPage.password.sendKeys("asdsadas");
        masterPage.name.click();
        masterPage.name.clear();
        masterPage.name.sendKeys("  Jolene");
        masterPage.save.click();
        System.out.println("You edited the name");

    }

    @Test
    public void NegativeTest() {

        masterPage.masterButton.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println("Master Page Opened");

        masterPage.createMasterButton.click();
        System.out.println("You have clicked on Create Master");

        masterPage.name.sendKeys("John");
        masterPage.lastName.sendKeys("Doe");
        masterPage.emailMaster.sendKeys("johndoe@gmail.com");
        masterPage.password.sendKeys("anypassword");
        masterPage.location.sendKeys("Toronto");
        masterPage.number.sendKeys("77777144");
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        masterPage.createButton.click();
        Assert.assertEquals(currentUrl, driver.getCurrentUrl());
        System.out.println("You are in the same link");


    }


}


