import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    protected BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;

    }

    protected WebElement BaseElement;
    protected By locator;
    protected String name;


    void isDisplayed() {

    }

    void click() {

    }

    void getText() {
    }
}
