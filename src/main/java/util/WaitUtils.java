package util;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class WaitUtils {
    private static WebDriverWait wait = null;
    private static SupportingReader sr = new SupportingReader();

    private WaitUtils() {
    }

    public static WebDriverWait getInstance() {
        try {
            if (wait == null) {
                wait = new WebDriverWait(Driver.getInstance(), Long.parseLong(sr.config().getString("timeout")));

            }

        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return wait;
    }


    public static void quitDriver() {
        wait = null;

    }

}

