import org.openqa.selenium.By;

public class Button extends BaseElement{


    protected Button(By locator, String name) {
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
    String getText() {
        super.getText();
        return null;
    }
}
