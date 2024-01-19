package SupplySync.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BranchesPage {
    WebDriver driver;

    public BranchesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "(//div[@class='sc-JkixQ czuAur MuiListItemText-root sc-hkgtus dGrXel'])[2]")
    public WebElement branchesButton;

    @FindBy(xpath = "(//button[@tabindex='0' and @type='button'])[2]")
    public WebElement createBranchButton;

    @FindBy(name = "name")
    public WebElement branchNameField;

    @FindBy(name = "email")
    public WebElement emailField;

    @FindBy(name = "address")
    public WebElement addressField;

    @FindBy(name = "phoneNumber")
    public WebElement phoneNumberField;

    @FindBy(name = "city")
    public WebElement locationField;

    @FindBy(xpath = "//div[@id='mui-component-select-regionId']")
    public WebElement selectRegion;

    @FindBy(xpath = "//li[text()='Issyk-Kul region']")
    public WebElement clickOnRegion;

    @FindBy(id = "mui-component-select-cities")
    public WebElement selectCity;

    @FindBy(xpath = "(//li[@data-value='[object Object]'])[7]")
    public WebElement clickOnCity; //esc button

    @FindBy(id = "mui-component-select-companyId")
    public WebElement selectCompanies;

    @FindBy(xpath = "//li[text()='RunolfssonCodewise123']")
    public WebElement clickOnCompanies;

    @FindBy(xpath = "//input[@name='shownToClients' and  @value='true']")
    public WebElement showBranchToCustomers;

    @FindBy(xpath = "//button[text()='Create']")
    public WebElement createButton;

    @FindBy(xpath = "//div[@role ='button']")
    public WebElement clickCompanyButton;

    @FindBy(xpath ="//li[text()=\"Dasha's Company\"]" )
    public WebElement chooseCompany;


    @FindBy(xpath ="(//button[@class='sc-ikJyIC idrUqC MuiButtonBase-root sc-jJoQJp bFnKEe MuiIconButton-root MuiIconButton-sizeMedium'])[1]" )
    public  WebElement threeDotsButton;

    @FindBy(xpath = "(//li[@class='sc-ikJyIC idrUqC MuiMenuItem-root MuiMenuItem-gutters MuiButtonBase-root sc-ZOtfp nBBxr sc-eVmaCL fxUfBO'])[1]")
    public  WebElement editButton;

    @FindBy(xpath = "//button[@form = 'edit-branch-form']")
    public WebElement saveButton;
}
