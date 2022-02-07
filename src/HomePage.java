import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class HomePage extends BaseForm {
    private String locatorAlertsFrameWindows = "//div[@class='card mt-4 top-card'][3]";
    private String locatorHeaderHomepage = "//*[@id='app']/header/a/img";
    private String locatorMovetoAlertsFrameWindows="//div[@class='card-body']/h5[contains(text(),'Alert')]";
    private String locatorElements = "//div[@class='card mt-4 top-card'][1]";

    HomePage(BaseElement uniqueElement, String name) {
        super(uniqueElement, name);
    }

    Actions builder = new Actions(Driver.getInstance());


    TextField tFAlertsFrameWindows = new TextField(By.xpath(locatorAlertsFrameWindows), "Alerts&Frame&Windows");
    TextField tFHeaderHomepage = new TextField(By.xpath(locatorHeaderHomepage), "Main header of home page of DemoQA");
    TextField tFElements = new TextField(By.xpath(locatorElements), "Elements");

    public boolean getTextFieldHeaderHomepage() throws IOException {
        return tFHeaderHomepage.isDisplayed();

    }

    public void clickTextFieldAlertsFrameWindows() throws IOException {
//       Driver.getInstance().findElement(By.xpath(alertsFrameWindows)).click();

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoAlertsFrameWindows));
        builder.moveToElement(element).build().perform();

        tFAlertsFrameWindows.click();
    }

    public void clickTextFieldElements() throws IOException {
//       Driver.getInstance().findElement(By.xpath(alertsFrameWindows)).click();

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoAlertsFrameWindows));
        builder.moveToElement(element).build().perform();

        tFElements.click();
    }

}
