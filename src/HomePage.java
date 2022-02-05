import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class HomePage extends BaseForm {
    private String locatorAlertsFrameWindows = "//div[@class='card mt-4 top-card'][3]";
    private String locatorHeaderHomepage = "//*[@id='app']/header/a/img";

    HomePage(BaseElement uniqueElement, String name) {
        super(uniqueElement, name);
    }

    Actions builder = new Actions(Driver.getInstance());


    TextField tFAlertsFrameWindows = new TextField(By.xpath(locatorAlertsFrameWindows), "Alerts&Frame&Windows");
    TextField tFHeaderHomepage = new TextField(By.xpath(locatorHeaderHomepage), "Main header of home page of DemoQA");


    public boolean getTextFieldHeaderHomepage() throws IOException {
        return tFHeaderHomepage.isDisplayed();

    }

    public void clickTextFieldAlertsFrameWindows() throws IOException {
//       Driver.getInstance().findElement(By.xpath(alertsFrameWindows)).click();

        WebElement element = Driver.getInstance().findElement(By.xpath("//div[@class='card-body']/h5[contains(text(),'Alert')]"));
        builder.moveToElement(element).build().perform();

        tFAlertsFrameWindows.click();
    }

}
