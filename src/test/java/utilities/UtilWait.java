package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UtilWait {
    public static WebElement waitUntilElementIsClickable(WebDriver driver, int seconds, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static WebElement waitUntilElementIsClickable(WebDriver driver, int seconds, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitUntilElementIsVisible(WebDriver driver, int seconds, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitUntilElementIsVisible(WebDriver driver, int seconds, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

//    public static boolean waitUntilElementIsNotVisible(WebDriver driver, int seconds, WebElement element){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
//        return wait.until(ExpectedConditions.invisibilityOf(element));
//    }
    public static WebElement waitUntilElementIsNotVisible(WebDriver driver, int seconds, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.invisibilityOf(element));
        return element;
    }
}
