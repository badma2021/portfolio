package Utils;

import Utils.ConfigReader;
import Utils.Driver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class WaitUtils {
    private static WebDriverWait wait = null;
    private static ConfigReader cf = new ConfigReader();

    private WaitUtils() {
    }

    public static WebDriverWait getInstance() {
        try {
            if (wait == null) {
                wait = new WebDriverWait(Driver.getInstance(), Long.parseLong(cf.util().getString("timeout")));

            }

        } catch (WebDriverException | IOException e) {
            e.printStackTrace();
        }
        return wait;
    }


    public static void quitDriver() {
        wait = null;

    }

}


