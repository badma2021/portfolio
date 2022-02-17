package Pages;

import Elements.Button;
import Elements.TextField;
import org.openqa.selenium.By;

public class BrowserWindows extends BaseForm {

    private final String locatorBrowserWindowsHeader = "//div[@class='main-header'][contains(text(),'Browser')]";
    private final String locatorNewTabButton = "//*[@id='tabButton']";
    private final String locatorSamplePage="//*[@id='sampleHeading']";


    public BrowserWindows() {
        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Browser')]"), "Main header of Browser Windows page"), "Browser Windows page");
    }

    private MenuForm mf = new MenuForm();
    private TextField tFBrowserWindowsPage = new TextField(By.xpath(locatorBrowserWindowsHeader), "Main header of Browser Windows page");
    private Button btNewTab = new Button(By.xpath(locatorNewTabButton), "New Button");
    private TextField tfSamplePageHeader = new TextField(By.xpath(locatorSamplePage), "Sample page tab header");


    public boolean appearTfBrowserWindowsPage()  {
        return tFBrowserWindowsPage.isDisplayed();

    }

    public void clickNewTabButton() {

        btNewTab.moveTo();
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
