import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenuForm extends BaseForm {

    public static String locatorMenuAlerts = "//*[@id='item-1']/span[contains(text(),'Alerts')]";
    public static String locatorMovetoMenuAlerts = "//*[@id='item-3']/span[contains(text(),'Nested')]";
    private static String locatorMovetoMenuNestedFrames=".//*[text()='Widgets']";
    private static String locatorMovetoMenuFrames="//*[@id='item-2']/span[contains(text(),'Frames')]";
    public static String locatorMenuWebTables="//*[@id='item-3']/span[contains(text(),'Tables')]";
    public static String locatorMovetoMenuButtons="//*[@id='item-6']/span[contains(text(),'Broken Links')]";

    protected MenuForm(BaseElement uniqueElement, String name) {

        super(uniqueElement, name);
    }

    static TextField tFMenuAlerts = new TextField(By.xpath(locatorMenuAlerts), "Textfield Alerts on the menu");
    static TextField tFMenuNestedFrames = new TextField(By.xpath(locatorMovetoMenuAlerts), "Textfield Nested Frames on the menu");
    static TextField tFMenuFrames = new TextField(By.xpath(locatorMovetoMenuFrames), "Textfield Frames on the menu");
    static TextField tFMenuWebTables = new TextField(By.xpath(locatorMenuWebTables), "Textfield Web Tables on the menu");

    public static void clickMenuAlerts() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoMenuAlerts));
        Actions builder = new Actions(Driver.getInstance());
        builder.moveToElement(element).build().perform();
        tFMenuAlerts.click();
    }

    public static void clickMenuNestedFrames() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoMenuNestedFrames));
        Actions builder = new Actions(Driver.getInstance());
        builder.moveToElement(element).build().perform();
        tFMenuNestedFrames.click();
    }
    public static void clickMenuFrames() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoMenuNestedFrames));
        Actions builder = new Actions(Driver.getInstance());
        builder.moveToElement(element).build().perform();
        tFMenuFrames.click();
    }
    public static void clickMenuWebTables() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoMenuButtons));
        Actions builder = new Actions(Driver.getInstance());
        builder.moveToElement(element).build().perform();
        tFMenuWebTables.click();
    }

}
