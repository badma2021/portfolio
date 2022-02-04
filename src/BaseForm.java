import org.openqa.selenium.WebElement;

public abstract class BaseForm {
    protected BaseForm(BaseElement uniqueElement, String name) {
        this.uniqueElement = uniqueElement;
        this.name = name;
    }

    protected BaseElement uniqueElement;
    protected String formName;
    protected String name;

    void isDisplayed() {

    }

    void waitUntilLoaded() {

    }


}
