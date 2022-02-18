package Pages;

import Elements.TextField;
import Utils.Driver;
import Utils.LoggerTest;
import Utils.WaitUtils;
import org.apache.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class NestedFramesPage extends BaseForm {

    public NestedFramesPage() {
        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Nested')]"), "Main header of Nested Frames page"), "Nested Frames page");
    }

    private final String locatorNestedFramesHeader = "//div[@class='main-header'][contains(text(),'Nested')]";
    private final String locatorIframe = "//*[@id='frame1']";
    private final String locatorIframeParentText = "/html/body";
    private final String locatorIframeChildText = "/html/body/p";


    private MenuForm mf = new MenuForm();
    private TextField tFNestedFramesPage = new TextField(By.xpath(locatorNestedFramesHeader), "Main header of Nested Frames page");
    private TextField ifParentNestedFramesPage = new TextField(By.xpath(locatorIframeParentText), "Parent frame in Nested Frames page");
    private TextField iFChildNestedFramesPage = new TextField(By.xpath(locatorIframeChildText), "Child Iframe in Nested Frames page");


    public String getIframeText() {

        mf.moveToMenuNestedFrames();
        WebElement webIframe = WaitUtils.getInstance().until(presenceOfElementLocated(By.xpath(locatorIframe)));
        Driver.getInstance().switchTo().frame(webIframe);
        LoggerTest.log(Level.INFO, "2nd test is starting: Internal text from Parent Frame is " + ifParentNestedFramesPage.getText());
        String p = ifParentNestedFramesPage.getText();
        Driver.getInstance().switchTo().frame(0);
        LoggerTest.log(Level.INFO, "2nd test is starting: Internal text from Child IFrame is " + iFChildNestedFramesPage.getText());
        String c = iFChildNestedFramesPage.getText();
        Driver.getInstance().switchTo().defaultContent();
        return (p + " " + c);


    }

    public void clickMenuFrames(){
        mf.clickMenuFrames();
    }

}

