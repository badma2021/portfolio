import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    protected WebElement element=null;
    protected WebDriver wait;
    protected By locator;
    protected String name;

    protected BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;

    }

    boolean isDisplayed() {
        return false;
    }

    void click() {

    }

    void getText() {
    }
}
