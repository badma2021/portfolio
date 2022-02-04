import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver = null;

    private Driver() {
    }

    public static WebDriver getInstance() {
        try {
            if (driver == null) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("incognito");
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.NANOSECONDS);
            }

        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return driver;
    }


    public static void quitDriver() {

        driver.quit();
        driver = null;

    }

}