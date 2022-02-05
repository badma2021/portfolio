import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenuForm extends BaseForm{

    private static String locatorMenuAlerts="//*[@id='item-1']/span[contains(text(),'Alerts')]";
    private static String locatorMovetoMenuAlerts="//*[@id='item-3']/span[contains(text(),'Nested')]";
    protected MenuForm(BaseElement uniqueElement, String name) {
        super(uniqueElement, name);
    }
    static TextField tFMenuAlerts = new TextField(By.xpath(locatorMenuAlerts), "Textfield Alerts on the menu");

    public static void clickMenuAlerts(){
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoMenuAlerts));
        Actions builder = new Actions(Driver.getInstance());
        builder.moveToElement(element).build().perform();
        tFMenuAlerts.click();
    }
}
