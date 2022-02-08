import org.openqa.selenium.By;

import java.io.IOException;

public class ElementsPage extends BaseForm {

    private String locatorHeaderElements = "//*[@id='app']/header/a/img";


    protected ElementsPage(String name) {

        super(new TextField(By.xpath("//*[@id='app']/header/a/img"), name), name);
    }

    TextField tFHeaderElements = new TextField(By.xpath(locatorHeaderElements), "Main header of Elements page of DemoQA");

    public boolean getTextFieldElementsPage() throws IOException {
        return tFHeaderElements.isDisplayed();

    }

    public void clickMenuWebTables() {
        MenuForm.clickMenuWebTables();
    }
}
