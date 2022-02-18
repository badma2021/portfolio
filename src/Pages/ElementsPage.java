package Pages;

import Elements.TextField;
import org.openqa.selenium.By;

public class ElementsPage extends BaseForm {

    private final String locatorHeaderElements = "//*[@id='app']/header/a/img";


    public ElementsPage() {

        super(new TextField(By.xpath("//*[@id='app']/header/a/img"), "Main header of Elements page"), "Elements page");
    }
    private MenuForm mf = new MenuForm();
    private TextField tFHeaderElements = new TextField(By.xpath(locatorHeaderElements), "Main header of Elements page of DemoQA");


    public void clickMenuWebTables() {
        mf.clickMenuWebTables();
    }
}
