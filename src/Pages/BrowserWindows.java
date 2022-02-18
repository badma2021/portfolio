package Pages;

import Elements.Button;
import Elements.TextField;
import org.openqa.selenium.By;

public class BrowserWindows extends BaseForm {

    private final String locatorNewTabButton = "//*[@id='tabButton']";
    private final String locatorSamplePage="//*[@id='sampleHeading']";


    public BrowserWindows() {
        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Browser')]"), "Main header of Browser Windows page"), "Browser Windows page");
    }

    private MenuForm mf = new MenuForm();
    private Button btNewTab = new Button(By.xpath(locatorNewTabButton), "New Button");
    private TextField tfSamplePageHeader = new TextField(By.xpath(locatorSamplePage), "Sample page tab header");

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
