import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class AlertsPage extends BaseForm {
    private String locatorAlertsHeader = "//div[@class='main-header'][contains(text(),'Alerts')]";
    private String locatorToSeeAlertButton = "//*[@id='alertButton']";


    protected AlertsPage(BaseElement uniqueElement, String name) {
        super(uniqueElement, name);
    }

    Actions builder = new Actions(Driver.getInstance());
    TextField tFAlertsPage = new TextField(By.xpath(locatorAlertsHeader), "Main header of Alerts page");
    Button btToSeeAlert = new Button(By.xpath(locatorToSeeAlertButton), "Click button to see alert");
    Alerts alert = new Alerts();

    public boolean getTextFieldAlertsPage() throws IOException {
        return tFAlertsPage.isDisplayed();

    }

    public void clickToSeeAlertButton() throws IOException {

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorToSeeAlertButton));
        builder.moveToElement(element).build().perform();
        btToSeeAlert.click();
    }

    public boolean getAlerts() throws IOException {
        WaitUtils.getInstance().until(ExpectedConditions.alertIsPresent());

        return alert.isAlertPresent();

    }
    public String APgetAlertsText() throws IOException {
       // WaitUtils.getInstance().until(ExpectedConditions.alertIsPresent());

        return alert.getAlertText();

    }


}
