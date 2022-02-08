import org.openqa.selenium.By;

import java.io.IOException;

public class AlertsFrameWindowsPage extends BaseForm {


    private String locatorAlertsFrameWindowsHeader = "//div[@class='main-header']";

    protected AlertsFrameWindowsPage(String name)
    {
        super(new TextField(By.xpath("//div[@class='main-header']"), name), name);
    }

    TextField tFAlertsFrameWindowsPage = new TextField(By.xpath(locatorAlertsFrameWindowsHeader), "Main header of Alerts&Frame&Windows page");
    MenuForm mf = new MenuForm(new TextField(By.xpath(".//*[text()='Widgets']"), "Widgets textfield of left hand-side Menu of DemoQA"), "left hand-side Menu of DemoQA");

    public boolean getTextFieldAlertsFrameWindowsPage() throws IOException {
        return tFAlertsFrameWindowsPage.isDisplayed();

    }

    public void clickMenuAlerts() {
        MenuForm.clickMenuAlerts();
    }

    public void clickMenuNestedFrames() {
        MenuForm.clickMenuNestedFrames();
    }

    public void clickMenuBrowserWindows() {
        mf.clickMenuBrowserWindows();
    }

}