package Pages;
import Elements.TextField;
import org.openqa.selenium.By;


public class WidgetsPage extends BaseForm {


    public WidgetsPage() {
        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Widgets')]"), "Main header of Widgets page"), "Widgets page");
    }

    private MenuForm mf = new MenuForm("Left hand side base menu");

    public void clickTextDatePicker() {
        mf.clickTextDatePicker();
    }

}
