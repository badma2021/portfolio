package Elements;

import Utils.Driver;
import org.openqa.selenium.By;

public class TextField extends BaseElement {

    public TextField(By element, String name) {
        super(element, name);

    }

    @Override
    public void click() {
        super.click();
    }

    @Override
    public boolean isDisplayed() {
        return super.isDisplayed();
    }

    @Override
    public String getText() {
        return super.getText();
    }

    public void sendText(String s) {
        Driver.getInstance().findElement(element).sendKeys(s);

    }

    public String cleanText() {

        return Driver.getInstance().findElement(element).getText().replaceAll("\n|\r\n", "");
    }

    public String getAttribute() {
        return Driver.getInstance().findElement(element).getAttribute("value");
    }

    @Override
    public void moveTo() {
        super.moveTo();

    }
}
