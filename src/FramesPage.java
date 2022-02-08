import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class FramesPage extends BaseForm {

    private String locatorFramesHeader = "//div[@class='main-header'][contains(text(),'Frames')]";
    private String locatorIframe1TextField = "//*[@id='frame1']";
    private String locatorIframe1TextFieldText = "//*[@id='sampleHeading']";
    private String locatorIframe2TextField = "//*[@id='frame2']";


    protected FramesPage(String name) {

        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Frames')]"), name), name);
    }
    MenuForm mf = new MenuForm("Left hand side base menu");
    Actions builder = new Actions(Driver.getInstance());
    TextField tFFramesPage = new TextField(By.xpath(locatorFramesHeader), "Main header of Frames page");
    TextField ifIframe1TextFieldText = new TextField(By.xpath(locatorIframe1TextFieldText), "1st Iframe internal text in Frames page");


    public boolean appearTextFieldFramesPage() throws IOException {
        return tFFramesPage.isDisplayed();

    }

    public String getIframeText1FramesPage() throws IOException {

        WebElement element = Driver.getInstance().findElement(By.xpath(mf.getLocatorMovetoMenuAlerts()));
        builder.moveToElement(element).build().perform();
        WebElement webIframe = WaitUtils.getInstance().until(presenceOfElementLocated(By.xpath(locatorIframe1TextField)));
        Driver.getInstance().switchTo().frame(webIframe);
        String p = ifIframe1TextFieldText.getText();
        System.out.println(p);
        Driver.getInstance().switchTo().defaultContent();

        return p;

    }


    public String getIframeText2FramesPage() throws IOException {

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



