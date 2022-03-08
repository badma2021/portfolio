package pages;

import elements.BaseElement;
import org.apache.log4j.Level;
import util.LoggerTest;

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