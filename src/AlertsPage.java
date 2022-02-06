import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class AlertsPage extends BaseForm {
    private String locatorAlertsHeader = "//div[@class='main-header'][contains(text(),'Alerts')]";
    private String locatorToSeeAlertButton = "//*[@id='alertButton']";
    public String labelYouClickedButton = "You clicked a button";
    private String locatorConfirmBoxButton = "//*[@id='confirmButton']";
    public String labelDoYouConfirmAction = "Do you confirm action?";
    private String locatorYouSelectedOK="//*[@id='confirmResult']";

    protected AlertsPage(BaseElement uniqueElement, String name) {
        super(uniqueElement, name);
    }

    Actions builder = new Actions(Driver.getInstance());
    Alerts alert = new Alerts();
    TextField tFAlertsPage = new TextField(By.xpath(locatorAlertsHeader), "Main header of Alerts page");
    TextField tFYouSelectedOK = new TextField(By.xpath(locatorYouSelectedOK), "Label along confirm box after pushing");
    Button btToSeeAlert = new Button(By.xpath(locatorToSeeAlertButton), "Click button to see alert");
    Button btConfirmBox = new Button(By.xpath(locatorConfirmBoxButton), "On button click, confirm box will appear");

    public boolean getTextFieldYouSelectedOK() throws IOException {
        return tFYouSelectedOK.isDisplayed();

    }

    public boolean getTextFieldAlertsPage() throws IOException {
        return tFAlertsPage.isDisplayed();

    }


    public void clickToSeeAlertButton() throws IOException {

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorToSeeAlertButton));
        builder.moveToElement(element).build().perform();
        btToSeeAlert.click();
    }

    public boolean getAlerts()  {
        try {
            WaitUtils.getInstance().until(ExpectedConditions.alertIsPresent());
            return alert.isAlertPresent();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String APgetAlertsText() throws IOException {
        // WaitUtils.getInstance().until(ExpectedConditions.alertIsPresent());

        return alert.getAlertText();
    }

    public void APacceptAlert() throws IOException {
        // WaitUtils.getInstance().until(ExpectedConditions.alertIsPresent());

        alert.acceptAlert();

    }
    public void clickConfirmBoxButton() throws IOException {

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorConfirmBoxButton));
        builder.moveToElement(element).build().perform();
        btConfirmBox.click();
    }

}
