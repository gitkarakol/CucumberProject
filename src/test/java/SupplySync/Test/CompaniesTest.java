package SupplySync.Test;

import SupplySync.Pages.CompaniesPage;
import SupplySync.Pages.LoginPage;
import org.junit.Before;
import utilities.Config;
import utilities.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

public class CompaniesTest {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    CompaniesPage companiesPage = new CompaniesPage(driver);


    @Test
    public void testAddNewCompany() {

        driver.get(Config.getValue("url"));


        loginPage.email.sendKeys(Config.getValue("email"));
        loginPage.password.sendKeys(Config.getValue("password"));
        loginPage.submit.click();


        companiesPage.clickEditButton();
                
        companiesPage.clickElementWithJS(companiesPage.editButton);
        companiesPage.selectMenuOption();
        companiesPage.clickEdit.click();



        companiesPage.fillCompanyDetails("Dasha's Company", "dashuha1405@gmail.com", "111 Wall Street", "1234567890");

        companiesPage.saveChanges();


        String confirmationMessage = companiesPage.getConfirmationMessage();
        Assert.assertEquals("Company successfully changed", confirmationMessage);
    }

    public static void clearWebField(WebElement element) {
        while (!element.getAttribute("value").equals("")) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }
    @Test
    public void testAddNewCompanyWithInvalidData() {

        driver.get(Config.getValue("url"));
        loginPage.email.sendKeys(Config.getValue("email"));
        loginPage.password.sendKeys(Config.getValue("password"));
        loginPage.submit.click();

        companiesPage.clickEditButton();
        companiesPage.clickElementWithJS(companiesPage.editButton);
        companiesPage.selectMenuOption();
        companiesPage.clickEdit.click();
        companiesPage.fillCompanyDetails("da$ha's", "invalid@email@gmail.com", "123 newStreet dr", "0001110001");
        companiesPage.saveChanges();


    }
}

