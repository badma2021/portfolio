package Pages;

import Elements.Button;
import Elements.TextField;
import Utils.ConfigReader;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class WebTablesPage extends BaseForm {


    private String locatorWebTablesHeader = "//div[@class='main-header'][contains(text(),'Tables')]";
    private String locatorAddButton = "//*[@id='addNewRecordButton']";
    private String locatorUserForDelete="//*[@id='delete-record-4']";
    private String locatorButtonsMenu = "//*[@id='item-4']/span[contains(text(),'Buttons')]";
    private String locatorUserAdded = "//div[@class='rt-tr-group'][" + ConfigReader.util().getString("user_number") + "]";
    private String locatorAlertsHeader = "//div[@class='main-header'][contains(text(),'Alerts')]";

    public WebTablesPage(String name) throws IOException {

        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Tables')]"), name), name);
    }

    private RegistrationForm rf = new RegistrationForm("Registration form");
    Actions builder = new Actions(Driver.getInstance());
    private TextField tFWebTablesPage = new TextField(By.xpath(locatorWebTablesHeader), "Main header of Web Tables page");
    private Button btAdd = new Button(By.xpath(locatorAddButton), "Add");
    private TextField tableAdd = new TextField(By.xpath(locatorUserAdded), "New User row in the table");
    private TextField tfRemoveUser = new TextField(By.xpath(locatorUserForDelete), "Basket sign for removing any user in the table");



    public boolean appearTextFieldWebTablesPage() {
        return tFWebTablesPage.isDisplayed();

    }

    public void clickAddButton() {

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorAddButton));
        builder.moveToElement(element).build().perform();
        btAdd.click();
    }

    public boolean appearTextFieldRegistrationFormOnWebTablesPage() throws IOException {
        return rf.appearTextFieldRegistrationForm();
    }

    public String getRowTextFromNewUser() {
        return tableAdd.cleanText();

    }

    public void clickRemoveUserButton() {

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorButtonsMenu));
        builder.moveToElement(element).build().perform();
        tfRemoveUser.click();
    }
    public boolean appearTextFieldAddedUser() {
        return tableAdd.getText().isBlank();

    }
}
