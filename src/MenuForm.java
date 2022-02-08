import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenuForm extends BaseForm {

    private String locatorMenuAlerts = "//*[@id='item-1']/span[contains(text(),'Alerts')]";
    private String locatorMovetoMenuAlerts = "//*[@id='item-3']/span[contains(text(),'Nested')]";
    private String locatorMovetoMenuNestedFrames = ".//*[text()='Widgets']";
    private String locatorMovetoMenuFrames = "//*[@id='item-2']/span[contains(text(),'Frames')]";
    private String locatorMenuWebTables = "//*[@id='item-3']/span[contains(text(),'Tables')]";
    private String locatorMovetoMenuButtons = "//*[@id='item-6']/span[contains(text(),'Broken Links')]";
    private String locatorMenuBrowserWindows = "//*[@id='item-0']/span[contains(text(),'Browser')]";

    protected MenuForm(String name) {

        super(new TextField(By.xpath(".//*[text()='Widgets']"), name), name);
    }

    TextField tFMenuAlerts = new TextField(By.xpath(locatorMenuAlerts), "Textfield Alerts on the menu");
    TextField tFMenuNestedFrames = new TextField(By.xpath(locatorMovetoMenuAlerts), "Textfield Nested Frames on the menu");
    TextField tFMenuFrames = new TextField(By.xpath(locatorMovetoMenuFrames), "Textfield Frames on the menu");
    TextField tFMenuWebTables = new TextField(By.xpath(locatorMenuWebTables), "Textfield Web Tables on the menu");
    TextField tFMenuBrowserWindows = new TextField(By.xpath(locatorMenuBrowserWindows), "Textfield Browser Windows on the menu");

    public void clickMenuAlerts() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoMenuAlerts));
        Actions builder = new Actions(Driver.getInstance());
        builder.moveToElement(element).build().perform();
        tFMenuAlerts.click();
    }

    public void clickMenuNestedFrames() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoMenuNestedFrames));
        Actions builder = new Actions(Driver.getInstance());
        builder.moveToElement(element).build().perform();
        tFMenuNestedFrames.click();
    }

    public String getLocatorMovetoMenuAlerts() {
        return locatorMovetoMenuAlerts;
    }

    public void clickMenuFrames() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoMenuNestedFrames));
        Actions builder = new Actions(Driver.getInstance());
        builder.moveToElement(element).build().perform();
        tFMenuFrames.click();
    }

    public void clickMenuWebTables() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoMenuButtons));
        Actions builder = new Actions(Driver.getInstance());
        builder.moveToElement(element).build().perform();
        tFMenuWebTables.click();
    }

    public String getLocatorMenuAlerts() {
        return locatorMenuAlerts;
    }

    public void clickMenuBrowserWindows() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorMovetoMenuAlerts));
        Actions builder = new Actions(Driver.getInstance());
        builder.moveToElement(element).build().perform();
        tFMenuBrowserWindows.click();


    }


}
