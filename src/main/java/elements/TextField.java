package elements;

import org.openqa.selenium.By;
import util.Driver;

public class TextField extends BaseElement {

    public TextField(By element, String name) {
        super(element, name);

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