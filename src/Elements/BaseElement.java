package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    protected By element;
    protected WebDriver wait;
    protected String name;

    public BaseElement(By element, String name) {
        this.element = element;
        this.name = name;

    }

    boolean isDisplayed() {
        return false;
    }

    void click() {

    }

    String getText() {
        return null;
    }
}
