package Elements;

import Utils.Driver;
import org.openqa.selenium.By;


public class Select extends BaseElement {

    public Select(By element, String name) {
        super(element, name);
    }


    public void selectByValue(String s) {
        new org.openqa.selenium.support.ui.Select(Driver.getInstance().findElement(element)).selectByVisibleText(s);
    }

    @Override
    public void click() {
        Driver.getInstance().findElement(element).click();

    }

}
