package Pages;

import Elements.TextField;
import Utils.Driver;
import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class NestedFramesPage extends BaseForm {

    public NestedFramesPage(String name) {
        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Nested')]"), name), name);
    }

    private String locatorNestedFramesHeader = "//div[@class='main-header'][contains(text(),'Nested')]";
    private String locatorIframe = "//*[@id='frame1']";
    public String labelIframeInternalText = "Parent frame Child Iframe";
    private String locatorIframeParentText = "/html/body";
    private String locatorIframeChildText = "/html/body/p";


    MenuForm mf = new MenuForm("Left hand side base menu");
    Actions builder = new Actions(Driver.getInstance());
    TextField tFNestedFramesPage = new TextField(By.xpath(locatorNestedFramesHeader), "Main header of Nested Frames page");
    TextField ifParentNestedFramesPage = new TextField(By.xpath(locatorIframeParentText), "Parent frame in Nested Frames page");
    TextField iFChildNestedFramesPage = new TextField(By.xpath(locatorIframeChildText), "Child Iframe in Nested Frames page");
//Elements.TextField maMovetoMenuAlerts=new Elements.TextField(By.xpath(Pages.MenuForm.locatorMovetoMenuAlerts), "Child Iframe in Nested Frames page");
    public boolean appearTextFieldNestedFramesPage() throws IOException {
        return tFNestedFramesPage.isDisplayed();

    }

    public String getIframeText() throws IOException {

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

