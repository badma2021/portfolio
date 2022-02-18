package Pages;
import Elements.Button;
import Elements.TextField;
import Utils.ConfigReader;
import org.openqa.selenium.By;
import java.io.IOException;

public class WebTablesPage extends BaseForm {


    private String locatorWebTablesHeader = "//div[@class='main-header'][contains(text(),'Tables')]";
    private String locatorAddButton = "//*[@id='addNewRecordButton']";
    private String locatorUserForDelete="//*[@id='delete-record-4']";
    private String locatorUserAdded = "//div[@class='rt-tr-group'][" + ConfigReader.util().getString("user_number") + "]";


    public WebTablesPage() throws IOException {

        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Tables')]"), "Main header of Web Tables page"), "Web Tables Page");
    }

    private RegistrationForm rf = new RegistrationForm();
    private TextField tFWebTablesPage = new TextField(By.xpath(locatorWebTablesHeader), "Main header of Web Tables page");
    private Button btAdd = new Button(By.xpath(locatorAddButton), "Add");
    private TextField tableAdd = new TextField(By.xpath(locatorUserAdded), "New User row in the table");
    private TextField tfRemoveUser = new TextField(By.xpath(locatorUserForDelete), "Basket sign for 4th user in the table");
    private MenuForm mf = new MenuForm();


    public boolean appearTextFieldWebTablesPage() {
        return tFWebTablesPage.isDisplayed();

    }

    public void clickAddButton() {

        btAdd.moveTo();
        btAdd.click();
    }


    public String getRowTextFromNewUser() {
        return tableAdd.cleanText();

    }

    public void clickRemoveUserButton() {

        mf.moveToMenuButtons();
        tfRemoveUser.click();
    }
    public boolean appearTextFieldAddedUser() {
        return tableAdd.getText().isBlank();

    }
}
