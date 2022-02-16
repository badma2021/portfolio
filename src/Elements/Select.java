package Elements;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Select extends BaseElement{

    public Select(By element, String name) {
        super(element, name);
    }


    public Select(WebElement element) {
    }

//
//    public void selectByValue(String s) {
//       new Select(Driver.getInstance().findElement(element)).selectByValue(s);
//    }
    @Override
    public void click() {
        Driver.getInstance().findElement(element).click();

    }

}
