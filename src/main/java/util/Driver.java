package util;

import org.openqa.selenium.*;

public class Driver {
    private static WebDriver driver = null;
    private Driver() {
    }
    public static WebDriver getInstance() {
        try {
            if (driver == null) {
                driver = BrowserFactory.getBrowser(SupportingReader.config("config").getString("browser"));
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
