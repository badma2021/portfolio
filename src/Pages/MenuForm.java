package Pages;

import Elements.TextField;
import org.openqa.selenium.By;
public class MenuForm extends BaseForm {

    private final String locatorMenuAlerts = "//*[@id='item-1']/span[contains(text(),'Alerts')]";
    private final String locatorMovetoMenuAlerts = "//*[@id='item-3']/span[contains(text(),'Nested')]";
    private final String locatorMovetoMenuNestedFrames = ".//*[text()='Widgets']";
    private final String locatorMovetoMenuFrames = "//*[@id='item-2']/span[contains(text(),'Frames')]";
    private final String locatorMenuWebTables = "//*[@id='item-3']/span[contains(text(),'Tables')]";
    private final String locatorMovetoMenuButtons = "//*[@id='item-6']/span[contains(text(),'Broken Links')]";
    private final String locatorMenuBrowserWindows = "//*[@id='item-0']/span[contains(text(),'Browser')]";
    private final String locatorMenuElements = ".//*[text()='Elements']";
    private final String locatorMenuElementsLinks = "//*[@id='item-5']/span[contains(text(),'Links')]";
    private final String locatorDatePickers = "//*[@id='item-2']/span[contains(text(),'Picker')]";
    private final String locatorToolTips = "//*[@id='item-6']/span[contains(text(),'Tips')]";
    private final String locatorButtonsMenu = "//*[@id='item-4']/span[contains(text(),'Buttons')]";

    protected MenuForm() {

        super(new TextField(By.xpath(".//*[text()='Widgets']"), "Widgets textfield"), "Left hand side base menu");
    }

    private TextField tFMenuAlerts = new TextField(By.xpath(locatorMenuAlerts), "Textfield Utils.Alerts on the menu");
    private TextField tFMenuNestedFrames = new TextField(By.xpath(locatorMovetoMenuAlerts), "Textfield Nested Frames on the menu");
    private TextField tFMenuFrames = new TextField(By.xpath(locatorMovetoMenuFrames), "Textfield Frames on the menu");
    private TextField tFMenuWebTables = new TextField(By.xpath(locatorMenuWebTables), "Textfield Web Tables on the menu");
    private TextField tFMenuBrowserWindows = new TextField(By.xpath(locatorMenuBrowserWindows), "Textfield Utils.Browser Windows on the menu");
    private TextField tfMenuElements = new TextField(By.xpath(locatorMenuElements), "Elements field on Menu from Utils.Browser Windows");
    private TextField tfMenuElementsLinks = new TextField(By.xpath(locatorMenuElementsLinks), "Links field on Menu=>Elements from Utils.Browser Windows");
    private TextField tfDatePickers = new TextField(By.xpath(locatorDatePickers), "Date Pickers");
    private TextField tFMovetoMenuNestedFrames = new TextField(By.xpath(locatorMovetoMenuNestedFrames), "TextField Widgets on the menu");
    private TextField tFMovetoMenuButtons = new TextField(By.xpath(locatorMovetoMenuButtons), "Textfield Buttons on the menu");
    private TextField tFMovetoToolTips = new TextField(By.xpath(locatorToolTips), "Textfield Tool Tips on the menu");
    private TextField tFButtonsMenu = new TextField(By.xpath(locatorButtonsMenu), "Textfield Buttons on the menu");

    public void clickMenuAlerts() {
        tFMenuNestedFrames.moveTo();
        tFMenuAlerts.click();
    }

    public void clickMenuNestedFrames() {
        tFMovetoMenuNestedFrames.moveTo();
        tFMenuNestedFrames.click();
    }

    public void clickMenuFrames() {
        tFMovetoMenuNestedFrames.moveTo();
        tFMenuFrames.click();
    }

    public void clickMenuWebTables() {
        tFMovetoMenuButtons.moveTo();
        tFMenuWebTables.click();
    }

    public void clickMenuBrowserWindows() {
        tFMenuNestedFrames.moveTo();
        tFMenuBrowserWindows.click();
    }

    public void clickMenuElements() {
        tfMenuElements.moveTo();
        tfMenuElements.click();
    }

    public void clickMenuElementsLinks() {
        tFMovetoMenuNestedFrames.moveTo();
        tfMenuElementsLinks.click();

    }

    public void clickTextDatePicker() {
        tFMovetoToolTips.moveTo();
        tfDatePickers.click();
    }

    public void moveTotFMenuAlerts() {
        tFMenuAlerts.moveTo();
    }
    public void moveToDatePickers() {
        tfDatePickers.moveTo();
    }

    public void moveToMenuNestedFrames() {
        tFMovetoMenuNestedFrames.moveTo();
    }
    public void moveToMenuButtons() {
        tFButtonsMenu.moveTo();
    }
}
