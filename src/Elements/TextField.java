package Elements;

import Elements.BaseElement;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.input.Input;

public class TextField extends BaseElement {

    public TextField(By element, String name) {
        super(element, name);

    }

    @Override
    public boolean isDisplayed() {
        return Driver.getInstance().findElement(element).isDisplayed();
    }

    @Override
    public void click() {
        Driver.getInstance().findElement(element).click();

    }

    @Override
    public String getText() {
        return Driver.getInstance().findElement(element).getText();
    }

   public void sendText(String s) {
        Driver.getInstance().findElement(element).sendKeys(s);

    }

    public String cleanText() {

        return Driver.getInstance().findElement(element).getText().replaceAll("\n|\r\n", "");
    }

    public void clear() {
        Driver.getInstance().findElement(element).sendKeys(Keys.CONTROL + "A");
        Driver.getInstance().findElement(element).sendKeys(Keys.BACK_SPACE);
    }
    public String getAttribute(){
       return Driver.getInstance().findElement(element).getAttribute("value");
    }
}
