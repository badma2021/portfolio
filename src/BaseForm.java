import org.openqa.selenium.WebElement;

public abstract class BaseForm {
   // private static Baselement uniqueElement;
   private BaseElement uniqueElement;
    private String formName;
    private String name;
    public BaseForm(BaseElement uniqueElement, String name) {
        this.uniqueElement = uniqueElement;
        this.name = name;
    }



    void isDisplayed() {

    }

    void waitUntilLoaded() {

    }


}
