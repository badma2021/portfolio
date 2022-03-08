package pages;

import elements.TextField;
import org.openqa.selenium.By;


public class HomePage extends BaseForm {

    public HomePage() {
        super(new TextField(By.xpath("//*[@id='logo_holder']//following::*[2]"), "Main logo on home page"), "Home page");
    }

    private Menu m = new Menu();

    public void clickMenuAbout() {
        m.clickTextFieldAbout();
    }
}
