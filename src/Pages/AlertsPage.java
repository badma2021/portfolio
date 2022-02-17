package Pages;

import Elements.Button;
import Elements.TextField;
import Utils.AlertsUtil;
import Utils.ConfigReader;
import Utils.Driver;
import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class AlertsPage extends BaseForm {
    private final String locatorAlertsHeader = "//div[@class='main-header'][contains(text(),'Alerts')]";
    private final String locatorToSeeAlertButton = "//*[@id='alertButton']";
    private final String locatorConfirmBoxButton = "//*[@id='confirmButton']";
    private final String locatorYouSelectedOk = "//*[@id='confirmResult']";
    private final String locatorPromptBoxButton = "//*[@id='promtButton']";
    private final String locatorYouEntered = "//*[@id='promptResult']";


    public AlertsPage() {

        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Alerts')]"), "Main header of Alerts page"), "Alerts page");
    }

    Actions builder = new Actions(Driver.getInstance());
    AlertsUtil alert = new AlertsUtil();
    private MenuForm mf = new MenuForm("Left hand side base menu");
    private TextField tFAlertsPage = new TextField(By.xpath(locatorAlertsHeader), "Main header of Alerts page");
    private TextField tFYouSelectedOK = new TextField(By.xpath(locatorYouSelectedOk), "Label along confirm box after pushing");
    private TextField tFYouEntered = new TextField(By.xpath(locatorYouEntered), "Label along prompt box after pushing");
    private Button btToSeeAlert = new Button(By.xpath(locatorToSeeAlertButton), "Click button to see alert");
    private Button btConfirmBox = new Button(By.xpath(locatorConfirmBoxButton), "On button click, confirm box will appear");
    private Button btPromptBox = new Button(By.xpath(locatorPromptBoxButton), "On button click, prompt box will appear");


    public String getTextFieldYouSelectedOK() {
        return tFYouSelectedOK.getText();

    }

    public String getTextFieldYouEntered() {
        return tFYouEntered.getText().substring(12, tFYouEntered.getText().length());

    }

    public boolean appearTextFieldAlertsPage() {
        return tFAlertsPage.isDisplayed();

    }

    public void clickToSeeAlertButton() {

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorToSeeAlertButton));
        builder.moveToElement(element).build().perform();
        btToSeeAlert.click();
    }

    public boolean getAlerts() {
        try {
            WaitUtils.getInstance().until(ExpectedConditions.alertIsPresent());
            return alert.isAlertPresent();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String APgetAlertsText() {


        return alert.getAlertText();
    }

    public void APacceptAlert() {
        alert.acceptAlert();

    }

    public void clickConfirmBoxButton() {

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorConfirmBoxButton));
        builder.moveToElement(element).build().perform();
        btConfirmBox.click();
    }

    public void clickPromptBoxButton() {

        WebElement element = Driver.getInstance().findElement(By.xpath(mf.getLocatorMenuAlerts()));
        builder.moveToElement(element).build().perform();
        btPromptBox.click();
    }

    public void sendTextPromptBox() throws IOException {
        alert.sendText(ConfigReader.util().getString("input1"));
    }

}
