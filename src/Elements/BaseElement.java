package Elements;

import Utils.ActionsBuilder;
import Utils.Driver;
import org.openqa.selenium.By;

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
