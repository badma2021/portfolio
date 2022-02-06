import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class NestedFramesPage extends BaseForm {

    protected NestedFramesPage(BaseElement uniqueElement, String name) {
        super(uniqueElement, name);
    }

    private String locatorNestedFramesHeader = "//div[@class='main-header'][contains(text(),'Nested')]";
    public String locatorIframe = "//*[@id='frame1']";
    public String labelIframeInternalText = "Parent frame Child Iframe";

    Actions builder = new Actions(Driver.getInstance());
    TextField tFNestedFramesPage = new TextField(By.xpath(locatorNestedFramesHeader), "Main header of Nested Frames page");
    //

    public boolean appearTextFieldNestedFramesPage() throws IOException {
        return tFNestedFramesPage.isDisplayed();

    }

    public String getIframeText() throws IOException {

        WebElement element = Driver.getInstance().findElement(By.xpath(MenuForm.locatorMovetoMenuAlerts));
        builder.moveToElement(element).build().perform();
        WebElement webIframe = WaitUtils.getInstance().until(presenceOfElementLocated(By.xpath(locatorIframe)));
        Driver.getInstance().switchTo().frame(webIframe);
        String p = Driver.getInstance().findElement(By.xpath("/html/body")).getText();
        Driver.getInstance().switchTo().frame(0);
        String c = Driver.getInstance().findElement(By.xpath("/html/body/p")).getText();
        Driver.getInstance().switchTo().defaultContent();
        //System.out.println(p + " " + c);
        return (p + " " + c);


    }

    public void clickMenuFrames(){
        MenuForm.clickMenuFrames();
    }

}

