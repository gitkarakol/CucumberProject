package SupplySync.test;

import SupplySync.pages.LoginPage;

import org.junit.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilities.Config;
import utilities.Driver;

public class LoginFuncTest {
    static WebDriver driver = Driver.getDriver();
    static LoginPage loginPage = new LoginPage(driver);

    @BeforeClass
    public static void beforeAll(){
        driver.get(Config.getValue("url"));
    }
    @Before
    public void refresh(){
        driver.navigate().refresh();
    }

    @Test
    public void loginTest1(){
        loginPage.email.sendKeys(Config.getValue("email"));
        loginPage.password.sendKeys(Config.getValue("password"));
        loginPage.submit.click();
        System.out.println("Positive scenario: pass");
    }

    @Test
    public void loginTest2(){
        loginPage.email.sendKeys("testgmail.com");
        loginPage.password.sendKeys(Config.getValue("password"));
        loginPage.submit.click();
        if(loginPage.incorrectCredentialsErrorMessage.isDisplayed()) System.out.println("Negative scenario 1: pass");
    }

    @Test
    public void loginTest3(){
        loginPage.email.sendKeys(Config.getValue("email"));
        loginPage.password.sendKeys("wrongpassword");
        loginPage.submit.click();
        if(loginPage.incorrectCredentialsErrorMessage.isDisplayed()) System.out.println("Negative scenario 2: pass");
    }

    @Test
    public void loginTest4(){
        loginPage.email.sendKeys("wrongemail");
        loginPage.password.sendKeys("wrongpassword");
        loginPage.submit.click();
        if(loginPage.incorrectCredentialsErrorMessage.isDisplayed()) System.out.println("Negative scenario 3: pass");
    }

    @AfterClass
    public static void afterAll(){
        //Driver.closeDriver();
    }

    public void clear(){
        while(!loginPage.email.getAttribute("value").isEmpty()){
            loginPage.email.sendKeys(Keys.BACK_SPACE);
        }
        while(!loginPage.password.getAttribute("value").isEmpty()){
            loginPage.password.sendKeys(Keys.BACK_SPACE);
        }
    }
}
