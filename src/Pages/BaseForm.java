package Pages;

import Elements.BaseElement;
import Utils.LoggerTest;
import org.apache.log4j.Level;
import org.openqa.selenium.WebDriver;

public abstract class BaseForm {

    private BaseElement uniqueElement;;
    private String name;

    public BaseForm(BaseElement uniqueElement, String name) {
        this.uniqueElement = uniqueElement;
        this.name = name;
    }


    public boolean isDisplayed() {
        LoggerTest.log(Level.INFO, "Checking a presence of unique element " + this.name);
        return uniqueElement.isDisplayed();
    }



}
