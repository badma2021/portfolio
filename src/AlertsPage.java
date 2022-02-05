import org.openqa.selenium.By;

import java.io.IOException;

public class AlertsPage extends BaseForm {
    private String locatorAlertsHeader = "//div[@class='main-header'][contains(text(),'Alerts')]";

    protected AlertsPage(BaseElement uniqueElement, String name) {
        super(uniqueElement, name);
    }

    TextField tFAlertsPage = new TextField(By.xpath(locatorAlertsHeader), "Main header of Alerts page");

    public boolean getTextFieldAlertsPage() throws IOException {
        return tFAlertsPage.isDisplayed();

    }
}
