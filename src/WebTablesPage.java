import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class WebTablesPage extends BaseForm{


    private String locatorWebTablesHeader = "//div[@class='main-header'][contains(text(),'Tables')]";
    private String locatorAddButton = "//*[@id='addNewRecordButton']";


    protected WebTablesPage(BaseElement uniqueElement, String name) {
        super(uniqueElement, name);
    }

    Actions builder = new Actions(Driver.getInstance());
    TextField tFWebTablesPage = new TextField(By.xpath(locatorWebTablesHeader), "Main header of Web Tables page");
    Button btAdd = new Button(By.xpath(locatorAddButton), "Add");

    public boolean appearTextFieldWebTablesPage() throws IOException {
        return tFWebTablesPage.isDisplayed();

    }

    public void clickAddButton() throws IOException {

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorAddButton));
        builder.moveToElement(element).build().perform();
        btAdd.click();
    }
}
