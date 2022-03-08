package util;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    private static WebDriverWait wait = null;
    private static SupportingReader sr = new SupportingReader();

    private WaitUtils() {
    }

    public static WebDriverWait getInstance() {
        try {
            if (wait == null) {
                wait = new WebDriverWait(Driver.getInstance(), Long.parseLong(sr.config("config").getString("timeout")));
            }

        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return wait;
    }

}

