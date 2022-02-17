package Pages;

import Elements.Button;
import Elements.TextField;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BrowserWindows extends BaseForm {

    private final String locatorBrowserWindowsHeader = "//div[@class='main-header'][contains(text(),'Browser')]";
    private final String locatorNewTabButton = "//*[@id='tabButton']";
    private final String locatorSamplePage="//*[@id='sampleHeading']";


    public BrowserWindows() {
        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Browser')]"), "Main header of Browser Windows page"), "Browser Windows page");
    }

    private MenuForm mf = new MenuForm("Left hand side base menu");
    Actions builder = new Actions(Driver.getInstance());
    private TextField tFBrowserWindowsPage = new TextField(By.xpath(locatorBrowserWindowsHeader), "Main header of Browser Windows page");
    private Button btNewTab = new Button(By.xpath(locatorNewTabButton), "New Button");
    private TextField tfSamplePageHeader = new TextField(By.xpath(locatorSamplePage), "Sample page tab header");


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
