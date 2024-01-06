package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;


public class Driver {

    private static WebDriver driver = null;


    public static WebDriver getDriver(){
        String browser = Config.getValue("browser");

        if(driver != null){
            return driver;
        }


        switch (browser){
            case "Chrome" -> driver = new ChromeDriver();
            case "Firefox" -> driver = new FirefoxDriver();
            case "Safari" -> driver = new SafariDriver();
            default -> driver = new ChromeDriver();
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(Config.getValue("pageLoadTimeout"))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getValue("implicitWait"))));
        driver.manage().window().maximize();

        return driver;

    }
    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
