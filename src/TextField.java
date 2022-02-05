import org.openqa.selenium.By;

public class TextField extends BaseElement {

    TextField(By locator, String name) {
        super(locator, name);

    }

    @Override
    boolean isDisplayed() {
       return Driver.getInstance().findElement(locator).isDisplayed();
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
