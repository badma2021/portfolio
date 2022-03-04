package elements;

import org.openqa.selenium.By;
import util.ActionsBuilder;
import util.Driver;

public abstract class BaseElement {
    protected By element;
    protected String name;

    public BaseElement(By element, String name) {
        this.element = element;
        this.name = name;

    }

    public boolean isDisplayed() {
        return Driver.getInstance().findElement(element).isDisplayed();
    }

    public void click() {
        Driver.getInstance().findElement(element).click();
    }

    public String getText() {
        return Driver.getInstance().findElement(element).getText();
    }

    public void moveTo(){
        ActionsBuilder.getInstance().moveToElement(Driver.getInstance().findElement(element)).build().perform();
    }
}
