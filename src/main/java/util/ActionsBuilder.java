package util;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;

public class ActionsBuilder {
    private static Actions builder = null;
    private ActionsBuilder() {
    }

    public static Actions getInstance() {
        try {
            if (builder == null) {
                builder = new Actions(Driver.getInstance());

            }

        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return builder;
    }
}