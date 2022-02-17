package Utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

public class AlertsUtil {

    public boolean isAlertPresent() {
        try {
            Driver.getInstance().switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String getAlertText() {
        return Driver.getInstance().switchTo().alert().getText();
    }
    public void acceptAlert() {
        Driver.getInstance().switchTo().alert().accept();
    }

    public void sendText(String text) {
        Driver.getInstance().switchTo().alert().sendKeys(text);
    }



}
