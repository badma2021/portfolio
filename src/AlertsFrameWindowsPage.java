import org.openqa.selenium.By;

import java.io.IOException;

public class AlertsFrameWindowsPage extends BaseForm{


    private String locatorAlertsFrameWindowsHeader = "//div[@class='main-header']";

    protected AlertsFrameWindowsPage(BaseElement uniqueElement, String name) {
        super(uniqueElement, name);
    }

    TextField tFAlertsFrameWindowsPage = new TextField(By.xpath(locatorAlertsFrameWindowsHeader), "Main header of Alerts&Frame&Windows page");

    public boolean getTextFieldAlertsFrameWindowsPage() throws IOException {
        return tFAlertsFrameWindowsPage.isDisplayed();

    }
    public void clickMenuAlerts(){
        MenuForm.clickMenuAlerts();
    }
}