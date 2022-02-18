package Pages;

import Elements.BaseElement;
import Utils.LoggerTest;
import Utils.WaitUtils;
import org.apache.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class BaseForm {

    private BaseElement uniqueElement;;
    private String name;
    protected WebDriver wait;

    public BaseForm(BaseElement uniqueElement, String name) {
        this.uniqueElement = uniqueElement;
        this.name = name;
    }


    public boolean isDisplayed() {
        LoggerTest.log(Level.INFO, "Checking a presence of unique element " + this.name);
        return uniqueElement.isDisplayed();
    }



}
