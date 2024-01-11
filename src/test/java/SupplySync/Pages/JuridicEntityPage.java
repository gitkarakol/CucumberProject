package SupplySync.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JuridicEntityPage {
    public WebDriver driver;
    public JuridicEntityPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()='Juridic Entity']")
    public WebElement juridicEntity;

    @FindBy(xpath = "//div[@class='sc-gJbFto jUsODE']//button ")
    public WebElement createLegalEntityButton ;

    @FindBy(id = "mui-component-select-companyId")
    public WebElement companiesField ;

    @FindBy(xpath = "//div[@id='menu-companyId']//li)[1] ")
    public WebElement chooseCompany ;

    @FindBy(id = "mui-component-select-branchId ")
    public WebElement branchField ;

    @FindBy(xpath = "//div[@id='menu-branchId']//li[text()='Blanda, Simonis and Kris'] ")
    public WebElement chooseBranch ;

    @FindBy(id = "mui-2")
    public WebElement legalEntityNameField ;

    @FindBy(xpath = "//div[@class='sc-jnrVZQ ieeBTg']/button[text()='Create']")
    public WebElement createButton ;

}
