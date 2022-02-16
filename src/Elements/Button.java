package Elements;

import Elements.BaseElement;
import Utils.Driver;
import org.openqa.selenium.By;

public class Button extends BaseElement {


    public Button(By element, String name) {
        super(element, name);
    }

    @Override
    boolean isDisplayed() {
        return Driver.getInstance().findElement(element).isDisplayed();
    }

    @Override
    public void click() {
        Driver.getInstance().findElement(element).click();

    }

    @Override
    String getText() {
        super.getText();
        return null;
    }
}
