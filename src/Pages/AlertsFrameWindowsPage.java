package Pages;

import Elements.TextField;
import org.openqa.selenium.By;

import java.io.IOException;

public class AlertsFrameWindowsPage extends BaseForm {


    private String locatorAlertsFrameWindowsHeader = "//div[@class='main-header']";

    public AlertsFrameWindowsPage()
    {
        super(new TextField(By.xpath("//div[@class='main-header']"), "Main header of Alerts&Frame&Windows page"), "Alerts Frame Window Page");
    }

    private TextField tFAlertsFrameWindowsPage = new TextField(By.xpath(locatorAlertsFrameWindowsHeader), "Main header of Alerts&Frame&Windows page");
    private MenuForm mf = new MenuForm("Left hand side base menu");

    public boolean getTextFieldAlertsFrameWindowsPage() throws IOException {
        return tFAlertsFrameWindowsPage.isDisplayed();

    }

    public void clickMenuAlerts() {
        mf.clickMenuAlerts();
    }

    public void clickMenuNestedFrames() {
        mf.clickMenuNestedFrames();
    }

    public void clickMenuBrowserWindows() {
        mf.clickMenuBrowserWindows();
    }

}