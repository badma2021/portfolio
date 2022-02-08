import org.json.JSONObject;
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


    protected RegistrationForm(String name) {

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
    public String getFInputFirstName(String key){
        return tFInputFirstName.sendText(key);
    }
    public String getFInputLastName(String key){
        return tFInputLastName.sendText(key);
    }
    public String getFInputUserEmail(String key){
        return tFInputUserEmail.sendText(key);
    }

    public String getFInputAge(String key){
        return tFInputAge.sendText(key);
    }
    public String getFInputSalary(String key){
        return tFInputSalary.sendText(key);
    }
    public String getFInputDepartment(String key){
        return tFInputDepartment.sendText(key);
    }

    public void clickSubmitButton() throws IOException {

        WebElement element = Driver.getInstance().findElement(By.xpath(locatorSubmitButton));
        builder.moveToElement(element).build().perform();
        btSubmit.click();
    }
}