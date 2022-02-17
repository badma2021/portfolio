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
    private final String locatorMovetoAlertsFrameWindows="//div[@class='card-body']/h5[contains(text(),'Alert')]";
    private final String locatorElements = "//div[@class='card mt-4 top-card'][1]";
    private final String locatorWidgets="//div[@class='card mt-4 top-card'][4]";

    public HomePage(String name) {
        super(new TextField(By.xpath("//*[@id='app']/header/a/img"), "Main header of home page of DemoQA"), name);
    }

    Actions builder = new Actions(Driver.getInstance());


    private TextField tFAlertsFrameWindows = new TextField(By.xpath(locatorAlertsFrameWindows), "Utils.Alerts&Frame&Windows");
    private TextField tFHeaderHomepage = new TextField(By.xpath(locatorHeaderHomepage), "Main header of home page of DemoQA");
    private TextField tFElements = new TextField(By.xpath(locatorElements), "Elements");
    private TextField tFWidgets = new TextField(By.xpath(locatorWidgets), "Widgets");


    public boolean getTextFieldHeaderHomepage(){
        return tFHeaderHomepage.isDisplayed();

    }

    public void clickTextFieldAlertsFrameWindows() {

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoAlertsFrameWindows));
        builder.moveToElement(element).build().perform();

        tFAlertsFrameWindows.click();
    }

    public void clickTextFieldElements()  {

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoAlertsFrameWindows));
        builder.moveToElement(element).build().perform();

        tFElements.click();
    }

    public void clickTextFieldWidgets() {

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoAlertsFrameWindows));
        builder.moveToElement(element).build().perform();

        tFWidgets.click();
    }

}
