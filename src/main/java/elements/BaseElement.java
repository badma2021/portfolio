package elements;

import org.apache.log4j.Level;
import org.openqa.selenium.By;
import util.ActionsBuilder;
import util.Driver;
import util.LoggerTest;

public abstract class BaseElement {
    protected By element;
    protected String name;

    public BaseElement(By element, String name) {
        this.element = element;
        this.name = name;
    }

    public boolean isDisplayed() {
        LoggerTest.log(Level.INFO, "BaseElement method ia activating : isDisplayed");
        return Driver.getInstance().findElement(element).isDisplayed();
    }

    public void click() {
        LoggerTest.log(Level.INFO, "BaseElement method ia activating : click");
        Driver.getInstance().findElement(element).click();
    }

    public String getText() {
        LoggerTest.log(Level.INFO, "BaseElement method ia activating : getText");

        return Driver.getInstance().findElement(element).getText();
    }

    public void moveTo(){
        LoggerTest.log(Level.INFO, "BaseElement method ia activating : moveTo");
        ActionsBuilder.getInstance().moveToElement(Driver.getInstance().findElement(element)).build().perform();
    }
}
