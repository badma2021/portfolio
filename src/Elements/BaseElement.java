package Elements;

import Utils.ActionsBuilder;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BaseElement {
    protected By element;
    protected WebDriver wait;
    protected String name;

    public BaseElement(By element, String name) {
        this.element = element;
        this.name = name;

    }

    boolean isDisplayed() {
        return Driver.getInstance().findElement(element).isDisplayed();
    }

    void click() {
        Driver.getInstance().findElement(element).click();
    }

    String getText() {
        return Driver.getInstance().findElement(element).getText();
    }

    void moveTo(){
        ActionsBuilder.getInstance().moveToElement(Driver.getInstance().findElement(element)).build().perform();
    }
}
