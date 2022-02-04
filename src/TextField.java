import org.openqa.selenium.By;

public class TextField extends BaseElement {
    TextField(By locator, String name) {
        super(locator, name);
    }

    @Override
    void isDisplayed() {
        super.isDisplayed();
    }

    @Override
    void click() {
        Driver.getInstance().findElement(locator).click();

    }

    @Override
    void getText() {
        super.getText();
    }
}
