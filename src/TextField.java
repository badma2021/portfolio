import org.openqa.selenium.By;

public class TextField extends BaseElement {

    TextField(By element, String name) {
        super(element, name);

    }

    @Override
    boolean isDisplayed() {
       return Driver.getInstance().findElement(element).isDisplayed();
    }

    @Override
    void click() {
        Driver.getInstance().findElement(element).click();

    }

    @Override
    String getText() {
      return  Driver.getInstance().findElement(element).getText();
    }

    void sendText() {
        Driver.getInstance().findElement(element).sendKeys();

    }
//    void switchTo(){
//        Driver.getInstance().switchTo().frame(webIframe);
//    }
}
