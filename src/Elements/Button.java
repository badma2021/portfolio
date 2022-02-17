package Elements;
import org.openqa.selenium.By;

public class Button extends BaseElement {


    public Button(By element, String name) {
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
    String getText() {
       return super.getText();

    }
    @Override
    public void moveTo() {
        super.moveTo();}
}
