package Pages;

import Elements.TextField;
import Pages.BaseForm;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HomePage extends BaseForm {
    private final String locatorAlertsFrameWindows = "//div[@class='card mt-4 top-card'][3]";
    private final String locatorHeaderHomepage = "//*[@id='app']/header/a/img";
    private final String locatorMovetoAlertsFrameWindows = "//div[@class='card-body']/h5[contains(text(),'Alert')]";
    private final String locatorElements = "//div[@class='card mt-4 top-card'][1]";
    private final String locatorWidgets = "//div[@class='card mt-4 top-card'][4]";

    public HomePage() {
        super(new TextField(By.xpath("//*[@id='app']/header/a/img"), "Main header of home page of DemoQA"), "Home page");
    }


    private TextField tFAlertsFrameWindows = new TextField(By.xpath(locatorAlertsFrameWindows), "Alerts&Frame&Windows");
    private TextField tFHeaderHomepage = new TextField(By.xpath(locatorHeaderHomepage), "Main header of home page of DemoQA");
    private TextField tFElements = new TextField(By.xpath(locatorElements), "Elements");
    private TextField tFWidgets = new TextField(By.xpath(locatorWidgets), "Widgets");
    private TextField tFMovetoAlertsFrameWindows = new TextField(By.xpath(locatorMovetoAlertsFrameWindows), "to move to AlertsFrameWindows");


    public void clickTextFieldAlertsFrameWindows() {

        tFMovetoAlertsFrameWindows.moveTo();

        tFAlertsFrameWindows.click();
    }

    public void clickTextFieldElements() {

        tFMovetoAlertsFrameWindows.moveTo();
        tFElements.click();
    }

    public void clickTextFieldWidgets() {

        tFMovetoAlertsFrameWindows.moveTo();
        tFWidgets.click();
    }

}
