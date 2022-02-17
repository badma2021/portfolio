package Pages;

import Elements.TextField;
import Utils.Driver;
import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class FramesPage extends BaseForm {

    private final String locatorFramesHeader = "//div[@class='main-header'][contains(text(),'Frames')]";
    private final String locatorIframe1TextField = "//*[@id='frame1']";
    private final String locatorIframe1TextFieldText = "//*[@id='sampleHeading']";
    private final String locatorIframe2TextField = "//*[@id='frame2']";


    public FramesPage() {

        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Frames')]"),"Main header of Frames page"), "Frames page");
    }
    private MenuForm mf = new MenuForm("Left hand side base menu");
    Actions builder = new Actions(Driver.getInstance());
    private TextField tFFramesPage = new TextField(By.xpath(locatorFramesHeader), "Main header of Frames page");
    private TextField ifIframe1TextFieldText = new TextField(By.xpath(locatorIframe1TextFieldText), "1st Iframe internal text in Frames page");


    public boolean appearTextFieldFramesPage(){
        return tFFramesPage.isDisplayed();

    }

    public String getIframeText1FramesPage() {

        WebElement element = Driver.getInstance().findElement(By.xpath(mf.getLocatorMovetoMenuAlerts()));
        builder.moveToElement(element).build().perform();
        WebElement webIframe = WaitUtils.getInstance().until(presenceOfElementLocated(By.xpath(locatorIframe1TextField)));
        Driver.getInstance().switchTo().frame(webIframe);
        String p = ifIframe1TextFieldText.getText();
        System.out.println(p);
        Driver.getInstance().switchTo().defaultContent();

        return p;

    }


    public String getIframeText2FramesPage() {

        WebElement element = Driver.getInstance().findElement(By.xpath(mf.getLocatorMovetoMenuAlerts()));
        builder.moveToElement(element).build().perform();
        WebElement webIframe = WaitUtils.getInstance().until(presenceOfElementLocated(By.xpath(locatorIframe2TextField)));
        Driver.getInstance().switchTo().frame(webIframe);
        String c = ifIframe1TextFieldText.getText();
        System.out.println(c);
        Driver.getInstance().switchTo().defaultContent();

        return c;
    }
}



