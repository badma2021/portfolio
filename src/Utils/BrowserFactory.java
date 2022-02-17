package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {

        private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

        public static WebDriver getBrowser(String browserName) throws IOException {
            WebDriver driver = null;

            switch (browserName) {
                case "Firefox":
                    driver = drivers.get("Firefox");
                    if (driver == null) {
                        driver = new FirefoxDriver();
                        drivers.put("Firefox", driver);
                    }
                    break;

                case "Chrome":
                    driver = drivers.get("Chrome");
                    if (driver == null) {
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments(ConfigReader.util().getString("mode"));
                        options.setExperimentalOption(ConfigReader.util().getString("infobars"),false);
                        options.setExperimentalOption(ConfigReader.util().getString("infobars1"), Collections.singletonList(ConfigReader.util().getString("infobars2")));
                        driver = new ChromeDriver(options);

                        drivers.put("Chrome", driver);
                    }
                    break;
            }
            return driver;
        }

        public static void closeAllDriver() {
            for (String key : drivers.keySet()) {
                drivers.get(key).close();
                drivers.get(key).quit();
            }
        }
    }
