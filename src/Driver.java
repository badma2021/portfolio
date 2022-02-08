import Utils.BrowserFactory;
import org.openqa.selenium.*;

import java.io.IOException;

public class Driver {

    private static WebDriver driver = null;

    private Driver() {
    }

    public static WebDriver getInstance() {
        try {
            if (driver == null) {
                driver = BrowserFactory.getBrowser("Chrome");
            }

        } catch (WebDriverException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return driver;
    }


    public static void quitDriver() {

        driver.quit();
        driver = null;

    }

}