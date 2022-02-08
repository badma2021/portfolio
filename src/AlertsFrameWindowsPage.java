import org.openqa.selenium.By;

import java.io.IOException;

public class AlertsFrameWindowsPage extends BaseForm {


    private String locatorAlertsFrameWindowsHeader = "//div[@class='main-header']";

    protected AlertsFrameWindowsPage(String name)
    {
        super(new TextField(By.xpath("//div[@class='main-header']"), name), name);
    }

    TextField tFAlertsFrameWindowsPage = new TextField(By.xpath(locatorAlertsFrameWindowsHeader), "Main header of Alerts&Frame&Windows page");
    MenuForm mf = new MenuForm("Left hand side base menu");

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