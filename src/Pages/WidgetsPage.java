package Pages;
import Elements.TextField;
import org.openqa.selenium.By;


public class WidgetsPage extends BaseForm {


    public WidgetsPage(String name) {
        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Widgets')]"), name), name);
    }

    MenuForm mf = new MenuForm("Left hand side base menu");


    public void clickTextDatePicker() {

        mf.clickTextDatePicker();
    }

}
