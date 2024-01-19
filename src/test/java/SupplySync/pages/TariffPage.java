package SupplySync.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TariffPage {
    WebDriver driver;
    public TariffPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[.='Tariffs']")
    public WebElement tariffsBtn;

    @FindAll(@FindBy(xpath = "//button[@aria-label='expand row']"))
    public List<WebElement> expandRow;

    @FindAll(@FindBy(xpath = "//div[.='Name of the tariff']/following-sibling::h3"))
    public List<WebElement> tariffNames;

    @FindAll(@FindBy(xpath = "//div[.='Delivery time']/following-sibling::h3"))
    public List<WebElement> deliveryTime;

    @FindBy(xpath = "//text()/following-sibling::span/../../button")
    public WebElement createTariff;

    @FindBy(xpath = "//label[text()='Choose a branch']/following-sibling::div")
    public WebElement chooseBranch;

    @FindBy(xpath = "//div/ul/li[child::text()='CodeWise']")
    public WebElement branch;

    @FindBy(xpath = "//label[.='Write the name of the tariff']/following-sibling::div/input")
    public WebElement chooseTariffName;

    @FindBy(xpath = "//label[.='Specify the delivery time']/following-sibling::div/input")
    public WebElement chooseDeliveryTime;

    @FindBy(xpath = "//label[.='Type of delivery']/following-sibling::div")
    public WebElement chooseDeliveryType;

    @FindBy(xpath = "//div/ul/li[child::text()='City express']")
    public WebElement deliveryType;

    @FindBy(xpath = "//label[.='Delivery cost in dollar']/following-sibling::div/input")
    public WebElement cost;

    @FindBy(xpath = "//textarea[1]")
    public WebElement address;

    @FindBy(xpath = "(//textarea[1])[2]")
    public WebElement comments;

    @FindBy(xpath = "//button[child::text()='Create']")
    public WebElement create;

    @FindBy(xpath = "//div[.='Name of the tariff']/../../..//button")
    public WebElement tariffOptions;

    @FindBy (xpath = "//*[text()='Block']")
    public WebElement block;

    @FindBy (xpath = "//*[text()='Unlock']")
    public WebElement unlock;

    @FindBy (xpath = "(//li/div/following-sibling::text())[2]/..")
    public WebElement edit;

    @FindBy (xpath = "//button[text()='Save']")
    public WebElement save;

    @FindBy(xpath = "//p[text()='Administrator']/../../../..")
    public WebElement adminPanel;

    @FindBy(xpath = "//li[text()='Exit']")
    public WebElement exit;

    @FindBy(xpath = "//button[text()='Exit']")
    public WebElement exitBtn;

}
