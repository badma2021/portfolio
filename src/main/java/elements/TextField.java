package elements;

import org.apache.log4j.Level;
import org.openqa.selenium.By;
import util.Driver;
import util.LoggerTest;

public class TextField extends BaseElement {

    public TextField(By element, String name) {
        super(element, name);
    }

    public void sendText(String s) {
        LoggerTest.log(Level.INFO, "TextField method is activating : sendText");
        Driver.getInstance().findElement(element).sendKeys(s);
    }

    public int size() {

        LoggerTest.log(Level.INFO, "TextField method is activating : size");

        return Driver.getInstance().findElements(element).size();
    }
}