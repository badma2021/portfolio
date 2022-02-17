package Pages;//import org.json.JSONObject;
import Elements.TextField;
import Pages.BaseForm;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class RegistrationForm extends BaseForm {

    private final String locatorRegistrationFormHeader = "//*[@id='registration-form-modal']";
    private final String locatorInputFirstName = "//*[@id='firstName']";
    private final String locatorInputLastName = "//*[@id='lastName']";
    private final String locatorInputUserEmail = "//*[@id='userEmail']";
    private final String locatorInputAge = "//*[@id='age']";
    private final String locatorInputSalary = "//*[@id='salary']";
    private final String locatorInputDepartment = "//*[@id='department']";
    private final String locatorSubmitButton="//*[@id='submit']";


    public RegistrationForm() {

        super(new TextField(By.xpath("//*[@id='registration-form-modal']"), "Textfield Registration Form"), "Registration Form");
    }
    Actions builder = new Actions(Driver.getInstance());
    private TextField tFRegistrationForm = new TextField(By.xpath(locatorRegistrationFormHeader), "Textfield Registration Form");
    private TextField tFInputFirstName = new TextField(By.xpath(locatorInputFirstName), "Textfield First name input");
    private TextField tFInputLastName = new TextField(By.xpath(locatorInputLastName), "Textfield Last name input");
    private TextField tFInputUserEmail = new TextField(By.xpath(locatorInputUserEmail), "Textfield User email input");
    private TextField tFInputAge = new TextField(By.xpath(locatorInputAge), "Textfield Age input");
    private TextField tFInputSalary = new TextField(By.xpath(locatorInputSalary), "Textfield Salary input");
    private TextField tFInputDepartment = new TextField(By.xpath(locatorInputDepartment), "Textfield Department input");
    private TextField btSubmit = new TextField(By.xpath(locatorSubmitButton), "Submit button");

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

    public void clickSubmitButton() {

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorSubmitButton));
        builder.moveToElement(element).build().perform();
        btSubmit.click();
    }
}