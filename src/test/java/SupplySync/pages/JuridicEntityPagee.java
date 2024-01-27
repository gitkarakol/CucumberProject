package SupplySync.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JuridicEntityPagee {
    public WebDriver driver;
    public JuridicEntityPagee(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()='Branches']")
    public WebElement branches;

    @FindBy(id = "mui-component-select-company")
    public  WebElement chooseCompanyFromBranches;

    @FindBy(xpath = "(//div[@id='menu-company']//li)[2]")
    public WebElement dropdownBranches;
    @FindBy(xpath = "//span[text()='Juridic Entity']")
    public WebElement juridicEntity;

    @FindBy(xpath = "//div[@id='root']//div[@class='sc-gJbFto jUsODE']/button")
    public WebElement createLegalEntityButton ;

    @FindBy(xpath = "(//form[@id='form-engine']//div)[4]")
    public WebElement companiesField ;

    @FindBy(xpath = "//div[@id='menu-companyId']//li[1]")
    public WebElement chooseCompany ;

    @FindBy(xpath = "//div[@id='mui-component-select-branchId']")
    public WebElement branchField ;

    @FindBy(xpath = "//div[@id='menu-branchId']//li[text()='Blanda, Simonis and Kris']")
    public WebElement chooseBranch ;

    @FindBy(xpath = "//input[@id='mui-2']")
    public WebElement legalEntityNameField ;

    @FindBy(xpath = "//div[@class='sc-jnrVZQ ieeBTg']/button[text()='Create']")
    public WebElement createButton ;

    public void clickAJuridicEntityButton(){
//        branches.click();
//        chooseCompanyFromBranches.click();
//        dropdownBranches.click();
        juridicEntity.click();


    }
    public  void createLegalEntity() throws InterruptedException {
        createLegalEntityButton.click();
        companiesField.click();
        chooseCompany.click();
        branchField.click();
        Thread.sleep(5000);
        chooseBranch.click();
        legalEntityNameField.click();
        legalEntityNameField.sendKeys("Absd");
        // createButton.click();

    }
    public void createLegalButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//div[@class='sc-ksdxgE gVZjGP']//button[text()='Create']")));

        element.click();
    }



}
