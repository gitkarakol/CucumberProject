package SupplySync.Test;

import SupplySync.Pages.LoginPage;
import SupplySync.Pages.TariffPage;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Config;
import utilities.Driver;
import utilities.UtilWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class TariffsTest {

    static WebDriver driver = Driver.getDriver();
    static LoginPage loginPage = new LoginPage(driver);
    static TariffPage tariffPage = new TariffPage(driver);

    @BeforeAll
    public static void before(){

        driver.get(Config.getValue("url"));
        loginPage.email.sendKeys(Config.getValue("email"));
        loginPage.password.sendKeys(Config.getValue("password"));
        loginPage.submit.click();
        System.out.println("Successful log in");
    }

    @Test
    public void test() throws InterruptedException {
        tariffPage.tariffsBtn.click();
        System.out.println(driver.getCurrentUrl());
        for(WebElement element : tariffPage.expandRow){
            element.click();
        }
        UtilWait.waitUntilElementIsVisible(driver, 10, tariffPage.tariffNames.get(0));
        UtilWait.waitUntilElementIsVisible(driver, 10, tariffPage.deliveryTime.get(0));

        List <List<WebElement>> tariffs = new ArrayList<>();
        tariffs.add(tariffPage.tariffNames);
        tariffs.add(tariffPage.deliveryTime);

        System.out.println("Total tariffs: " + tariffPage.tariffNames.size()+"\n");
        for(int i = 0; i < tariffs.get(0).size(); i++){
            for(int j = 0; j < tariffs.size(); j++){
                System.out.println(tariffs.get(j).get(i).getText());
            }
            System.out.println("----------------------------------------------");
        }

        //create tariff
        tariffPage.createTariff.click();
        tariffPage.chooseBranch.click();
        tariffPage.branch.click();
        tariffPage.chooseTariffName.sendKeys("Test tariff name");
        tariffPage.chooseDeliveryType.click();
        tariffPage.deliveryType.click();
        tariffPage.chooseDeliveryTime.sendKeys("12:30 PM");
        tariffPage.cost.sendKeys("150");
        tariffPage.address.sendKeys("1632 W Washington St, Chicago, IL, 62363");
        tariffPage.comments.sendKeys("No comments =)");
        tariffPage.create.click();

        //edit tariff
        tariffPage.expandRow.get(0).click();
        tariffPage.tariffOptions.click();
        tariffPage.block.click();

        UtilWait.waitUntilElementIsClickable(driver, 10, tariffPage.expandRow.get(0));
        Thread.sleep(300);
        tariffPage.expandRow.get(0).click();
        tariffPage.tariffOptions.click();
        tariffPage.unlock.click();

        Thread.sleep(300);
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
        UtilWait.waitUntilElementIsClickable(driver, 10, tariffPage.adminPanel);
        Thread.sleep(3000);
        tariffPage.adminPanel.click();
        tariffPage.exit.click();
        tariffPage.exitBtn.click();
        System.out.println(driver.getCurrentUrl());
    }

    public void clear(WebElement element){
        for(int i = 50; i > 0; i--){
            element.click();
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    @AfterAll
    public static void after(){
        Driver.closeDriver();
    }
}
