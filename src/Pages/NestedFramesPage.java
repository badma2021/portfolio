package Pages;

import Elements.TextField;
import Utils.Driver;
import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class NestedFramesPage extends BaseForm {

    public NestedFramesPage() {
        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Nested')]"), "Main header of Nested Frames page"), "Nested Frames page");
    }

    private final String locatorNestedFramesHeader = "//div[@class='main-header'][contains(text(),'Nested')]";
    private final String locatorIframe = "//*[@id='frame1']";
    public final String labelIframeInternalText = "Parent frame Child Iframe";
    private final String locatorIframeParentText = "/html/body";
    private final String locatorIframeChildText = "/html/body/p";


    private MenuForm mf = new MenuForm();
    Actions builder = new Actions(Driver.getInstance());
    private TextField tFNestedFramesPage = new TextField(By.xpath(locatorNestedFramesHeader), "Main header of Nested Frames page");
    private TextField ifParentNestedFramesPage = new TextField(By.xpath(locatorIframeParentText), "Parent frame in Nested Frames page");
    private TextField iFChildNestedFramesPage = new TextField(By.xpath(locatorIframeChildText), "Child Iframe in Nested Frames page");

    public boolean appearTextFieldNestedFramesPage()  {
        return tFNestedFramesPage.isDisplayed();

    }

    public String getIframeText() {

        WebElement element = Driver.getInstance().findElement(By.xpath(mf.getLocatorMovetoMenuAlerts()));
        builder.moveToElement(element).build().perform();
        WebElement webIframe = WaitUtils.getInstance().until(presenceOfElementLocated(By.xpath(locatorIframe)));
        Driver.getInstance().switchTo().frame(webIframe);
        String p = ifParentNestedFramesPage.getText();
        Driver.getInstance().switchTo().frame(0);
        String c = iFChildNestedFramesPage.getText();
        Driver.getInstance().switchTo().defaultContent();
        //System.out.println(p + " " + c);
        return (p + " " + c);


    }

    public void clickMenuFrames(){
        mf.clickMenuFrames();
    }

}

