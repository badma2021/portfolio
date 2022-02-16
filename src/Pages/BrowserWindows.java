package Pages;

import Elements.Button;
import Elements.TextField;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BrowserWindows extends BaseForm {

    private String locatorBrowserWindowsHeader = "//div[@class='main-header'][contains(text(),'Utils.Browser')]";
    private String locatorNewTabButton = "//*[@id='tabButton']";
    private String locatorSamplePage="//*[@id='sampleHeading']";


    public BrowserWindows(String name) {
        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Utils.Browser')]"), name), name);
    }

    MenuForm mf = new MenuForm("Left hand side base menu");
    Actions builder = new Actions(Driver.getInstance());
    TextField tFBrowserWindowsPage = new TextField(By.xpath(locatorBrowserWindowsHeader), "Main header of Utils.Browser Windows page");
    Button btNewTab = new Button(By.xpath(locatorNewTabButton), "New Elements.Button");
    TextField tfSamplePageHeader = new TextField(By.xpath(locatorSamplePage), "Sample page tab header");


    public boolean appearTfBrowserWindowsPage()  {
        return tFBrowserWindowsPage.isDisplayed();

    }

    public void clickNewTabButton() {

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorNewTabButton));
        builder.moveToElement(element).build().perform();
        btNewTab.click();
    }

    public String appearSamplePageHeader() {
        return tfSamplePageHeader.getText();
    }
    public void clickMenuElements() {
        mf.clickMenuElements();
    }

    public void clickMenuElementsLinks() {
        mf.clickMenuElementsLinks();
    }
}
