import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class BrowserWindows extends BaseForm{

    private String locatorBrowserWindowsHeader = "//div[@class='main-header'][contains(text(),'Browser')]";
    private String locatorNewTabButton="//*[@id='tabButton']";
    protected BrowserWindows(String name) {
        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Browser')]"), name), name);
    }
    Actions builder = new Actions(Driver.getInstance());
    TextField tFBrowserWindowsPage = new TextField(By.xpath(locatorBrowserWindowsHeader), "Main header of Browser Windows page");
    Button btNewTab = new Button(By.xpath(locatorNewTabButton), "New Button");

    public boolean appearTextFieldAlertsPage() throws IOException {
        return tFBrowserWindowsPage.isDisplayed();

    }
    public void clickNewTabButton() throws IOException {

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorNewTabButton));
        builder.moveToElement(element).build().perform();
        btNewTab.click();
    }
}
