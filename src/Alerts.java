import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

public class Alerts {
    private Alert alert;

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


}
