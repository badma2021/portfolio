package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Collections;

public class BrowserFactory {


    public static WebDriver getBrowser(String browserName) {
        WebDriver driver = null;

        try {
            switch (browserName) {

                case "Firefox":

                    if (driver == null) {
                        driver = new FirefoxDriver();
                    }
                    break;

                case "Chrome":

                    if (driver == null) {
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments(SupportingReader.config().getString("mode"));
                        options.setExperimentalOption(SupportingReader.config().getString("infobars"), false);
                        options.setExperimentalOption(SupportingReader.config().getString("infobars1"), Collections.singletonList(SupportingReader.config().getString("infobars2")));
                        driver = new ChromeDriver(options);
                    }
                    break;
            }
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        LoggerTest.log(Level.INFO, "Getting browser from BrowserFactory: " + driver);
        return driver;
    }
}
