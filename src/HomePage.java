import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class HomePage extends BaseForm {


    HomePage(BaseElement uniqueElement, String name) {
        super(uniqueElement, name);
    }
    TextField tFAlertsFrameWindows = new TextField(By.xpath("//div[@class='card mt-4 top-card'][3]"), "Alerts&Frame&Windows");

    public boolean getElementHomepage() throws IOException {
        ///return Driver.getInstance().findElement(uniqueElement).isDisplayed();
        return false;
    }

    public void textFieldAlertsFrameWindowsClick() throws IOException {
//       Driver.getInstance().findElement(By.xpath(alertsFrameWindows)).click();


        tFAlertsFrameWindows.click();
    }

}
