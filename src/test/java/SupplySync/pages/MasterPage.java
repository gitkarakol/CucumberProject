package SupplySync.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterPage {
    WebDriver driver;

    public MasterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Masters")
    public WebElement masterButton;

    @FindBy(xpath = "(//button[@tabindex='0' and @type='button'])[2]")
    public WebElement createMasterButton;


    @FindBy(name = "name")
    public WebElement name;


    @FindBy(name = "lastName")
    public WebElement lastName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(name = "email")
    public WebElement emailMaster;

    @FindBy(name = "location")
    public WebElement location;

    @FindBy(name = "number")
    public WebElement number;

    @FindBy(xpath = "//div[@class='sc-Galmp bETMfV MuiSelect-select MuiSelect-outlined sc-iAKWXU sc-hUpaCq vLxkU GZxze MuiOutlinedInput-input MuiInputBase-input']")
    public WebElement branchDropDown;

    @FindBy(xpath = "//li[text()='CodeWise']")
    public WebElement option;

    @FindBy(xpath = "//button[text()='Create']")
    public WebElement createButton;

    @FindBy(xpath =  "(//button[@class='sc-ikJyIC idrUqC MuiButtonBase-root sc-jJoQJp bFnKEe MuiIconButton-root MuiIconButton-sizeMedium'])[1]")
    public WebElement threeDots;

    @FindBy(xpath = "(//li[@class='sc-ikJyIC idrUqC MuiMenuItem-root MuiMenuItem-gutters MuiButtonBase-root sc-ZOtfp nBBxr sc-eVmaCL fxUfBO'])[1]")
    public WebElement edit;


    @FindBy(xpath = "//button[@class='sc-ikJyIC idrUqC MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root sc-gsNilK hofTdo sc-dFtzxp khbbrI']")
    public WebElement save;



}

