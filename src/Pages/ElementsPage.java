package Pages;

import Elements.TextField;
import Pages.BaseForm;
import org.openqa.selenium.By;

public class ElementsPage extends BaseForm {

    private final String locatorHeaderElements = "//*[@id='app']/header/a/img";


    public ElementsPage(String name) {

        super(new TextField(By.xpath("//*[@id='app']/header/a/img"), name), name);
    }
    private MenuForm mf = new MenuForm("Left hand side base menu");
    private TextField tFHeaderElements = new TextField(By.xpath(locatorHeaderElements), "Main header of Elements page of DemoQA");

    public boolean getTextFieldElementsPage() {
        return tFHeaderElements.isDisplayed();

    }

    public void clickMenuWebTables() {
        mf.clickMenuWebTables();
    }
}
