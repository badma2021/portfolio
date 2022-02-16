package Pages;

import Elements.TextField;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class WidgetsPage extends BaseForm {

    private String locatorWidgetsHeader = "//div[@class='main-header'][contains(text(),'Widgets')]";
private String locatorDatePickers="//*[@id='item-2']/span[contains(text(),'Picker')]";
    private String locatorToolTips="//*[@id='item-6']/span[contains(text(),'Tips')]";

        public WidgetsPage(String name) {
        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Widgets')]"), name), name);
    }

    MenuForm mf = new MenuForm("Left hand side base menu");
    TextField tfDatePickers = new TextField(By.xpath(locatorDatePickers), "Date Pickers");
    Actions builder = new Actions(Driver.getInstance());


    public void clickTextDatePicker() {

        mf.clickTextDatePicker();
    }

}
