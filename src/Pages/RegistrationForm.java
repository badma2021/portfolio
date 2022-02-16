package Pages;//import org.json.JSONObject;
import Elements.TextField;
import Pages.BaseForm;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class RegistrationForm extends BaseForm {

    private String locatorRegistrationFormHeader = "//*[@id='registration-form-modal']";
    private String locatorInputFirstName = "//*[@id='firstName']";
    private String locatorInputLastName = "//*[@id='lastName']";
    private String locatorInputUserEmail = "//*[@id='userEmail']";
    private String locatorInputAge = "//*[@id='age']";
    private String locatorInputSalary = "//*[@id='salary']";
    private String locatorInputDepartment = "//*[@id='department']";
    private String locatorSubmitButton="//*[@id='submit']";


    public RegistrationForm(String name) {

        super(new TextField(By.xpath("//*[@id='registration-form-modal']"), name), name);
    }
    Actions builder = new Actions(Driver.getInstance());
    TextField tFRegistrationForm = new TextField(By.xpath(locatorRegistrationFormHeader), "Textfield Registration Form");
    TextField tFInputFirstName = new TextField(By.xpath(locatorInputFirstName), "Textfield First name input");
    TextField tFInputLastName = new TextField(By.xpath(locatorInputLastName), "Textfield Last name input");
    TextField tFInputUserEmail = new TextField(By.xpath(locatorInputUserEmail), "Textfield User email input");
    TextField tFInputAge = new TextField(By.xpath(locatorInputAge), "Textfield Age input");
    TextField tFInputSalary = new TextField(By.xpath(locatorInputSalary), "Textfield Salary input");
    TextField tFInputDepartment = new TextField(By.xpath(locatorInputDepartment), "Textfield Department input");
    TextField btSubmit = new TextField(By.xpath(locatorSubmitButton), "Submit button");

    public boolean appearTextFieldRegistrationForm() throws IOException {
        return tFRegistrationForm.isDisplayed();

    }
    public void getFInputFirstName(String key){
         tFInputFirstName.sendText(key);
    }
    public void getFInputLastName(String key){
        tFInputLastName.sendText(key);
    }
    public void getFInputUserEmail(String key){
         tFInputUserEmail.sendText(key);
    }

    public void getFInputAge(String key){
         tFInputAge.sendText(key);
    }
    public void getFInputSalary(String key){
         tFInputSalary.sendText(key);
    }
    public void getFInputDepartment(String key){
        tFInputDepartment.sendText(key);
    }

    public void clickSubmitButton() throws IOException {

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorSubmitButton));
        builder.moveToElement(element).build().perform();
        btSubmit.click();
    }
}