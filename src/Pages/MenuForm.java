package Pages;

import Elements.TextField;
import Pages.BaseForm;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenuForm extends BaseForm {

    private String locatorMenuAlerts = "//*[@id='item-1']/span[contains(text(),'Utils.Alerts')]";
    private String locatorMovetoMenuAlerts = "//*[@id='item-3']/span[contains(text(),'Nested')]";
    private String locatorMovetoMenuNestedFrames = ".//*[text()='Widgets']";
    private String locatorMovetoMenuFrames = "//*[@id='item-2']/span[contains(text(),'Frames')]";
    private String locatorMenuWebTables = "//*[@id='item-3']/span[contains(text(),'Tables')]";
    private String locatorMovetoMenuButtons = "//*[@id='item-6']/span[contains(text(),'Broken Links')]";
    private String locatorMenuBrowserWindows = "//*[@id='item-0']/span[contains(text(),'Utils.Browser')]";
    private String locatorMenuElements=".//*[text()='Elements']";
    private String locatorMenuElementsLinks="//*[@id='item-5']/span[contains(text(),'Links')]";
    private String locatorDatePickers="//*[@id='item-2']/span[contains(text(),'Picker')]";
    private String locatorToolTips="//*[@id='item-6']/span[contains(text(),'Tips')]";

    protected MenuForm(String name) {

        super(new TextField(By.xpath(".//*[text()='Widgets']"), name), name);
    }

    TextField tFMenuAlerts = new TextField(By.xpath(locatorMenuAlerts), "Textfield Utils.Alerts on the menu");
    TextField tFMenuNestedFrames = new TextField(By.xpath(locatorMovetoMenuAlerts), "Textfield Nested Frames on the menu");
    TextField tFMenuFrames = new TextField(By.xpath(locatorMovetoMenuFrames), "Textfield Frames on the menu");
    TextField tFMenuWebTables = new TextField(By.xpath(locatorMenuWebTables), "Textfield Web Tables on the menu");
    TextField tFMenuBrowserWindows = new TextField(By.xpath(locatorMenuBrowserWindows), "Textfield Utils.Browser Windows on the menu");
    TextField tfMenuElements = new TextField(By.xpath(locatorMenuElements), "Elements field on Menu from Utils.Browser Windows");
    TextField tfMenuElementsLinks = new TextField(By.xpath(locatorMenuElementsLinks), "Links field on Menu=>Elements from Utils.Browser Windows");
    TextField tfDatePickers = new TextField(By.xpath(locatorDatePickers), "Date Pickers");
    Actions builder = new Actions(Driver.getInstance());

    public void clickMenuAlerts() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoMenuAlerts));
        builder.moveToElement(element).build().perform();
        tFMenuAlerts.click();
    }

    public void clickMenuNestedFrames() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoMenuNestedFrames));
        builder.moveToElement(element).build().perform();
        tFMenuNestedFrames.click();
    }

    public String getLocatorMovetoMenuAlerts() {
        return locatorMovetoMenuAlerts;
    }

    public void clickMenuFrames() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoMenuNestedFrames));
        builder.moveToElement(element).build().perform();
        tFMenuFrames.click();
    }

    public void clickMenuWebTables() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoMenuButtons));
        builder.moveToElement(element).build().perform();
        tFMenuWebTables.click();
    }

    public String getLocatorMenuAlerts() {
        return locatorMenuAlerts;
    }

    public void clickMenuBrowserWindows() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoMenuAlerts));
        builder.moveToElement(element).build().perform();
        tFMenuBrowserWindows.click();
    }
    public void clickMenuElements() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMenuElements));
        builder.moveToElement(element).build().perform();
        tfMenuElements.click();
    }
    public void clickMenuElementsLinks() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoMenuNestedFrames));
        builder.moveToElement(element).build().perform();
        tfMenuElementsLinks.click();

    }
    public void clickTextDatePicker() {

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorToolTips));
        builder.moveToElement(element).build().perform();

        tfDatePickers.click();
    }
}
