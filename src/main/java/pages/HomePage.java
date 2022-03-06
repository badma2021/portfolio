package pages;

import elements.TextField;
import org.openqa.selenium.By;


public class HomePage extends BaseForm {
    private final String locatorAlertsFrameWindows = "//div[@class='card mt-4 top-card'][3]";
    private final String locatorMovetoAlertsFrameWindows = "//div[@class='card-body']/h5[contains(text(),'Alert')]";
    private final String locatorElements = "//div[@class='card mt-4 top-card'][1]";
    private final String locatorWidgets = "//div[@class='card mt-4 top-card'][4]";

    public HomePage() {
        super(new TextField(By.xpath("//div[@class='fullscreen-bg']"), "Banner on home page"), "Home page");
    }

    private Menu m = new Menu();

    public void clickMenuAbout() {
        m.clickTextFieldAbout();
    }
}
