import org.openqa.selenium.By;

import java.io.IOException;

public class RegistrationForm extends BaseForm {

    private String locatorRegistrationFormHeader = "//*[@id='registration-form-modal']";
    private String locatorInputFirstName = "//*[@id='firstName']";
    private String locatorInputLastName = "//*[@id='lastName']";
    private String locatorInputUserEmail = "//*[@id='userEmail']";
    private String locatorInputAge = "//*[@id='age']";
    private String locatorInputSalary = "//*[@id='salary']";
    private String locatorInputDepartment = "//*[@id='department']";


    protected RegistrationForm(String name) {

        super(new TextField(By.xpath("//*[@id='registration-form-modal']"), name), name);
    }

    TextField tFRegistrationForm = new TextField(By.xpath(locatorRegistrationFormHeader), "Textfield Registration Form");
    TextField tFInputFirstName = new TextField(By.xpath(locatorInputFirstName), "Textfield First name input");
    TextField tFInputLastName = new TextField(By.xpath(locatorInputLastName), "Textfield Registration Form");
    TextField tFInputUserEmail = new TextField(By.xpath(locatorInputUserEmail), "Textfield Registration Form");
    TextField tFInputAge = new TextField(By.xpath(locatorInputAge), "Textfield Registration Form");
    TextField tFInputSalary = new TextField(By.xpath(locatorInputSalary), "Textfield Registration Form");
    TextField tFInputDepartment = new TextField(By.xpath(locatorInputDepartment), "Textfield Registration Form");

    public boolean appearTextFieldRegistrationForm() throws IOException {
        return tFRegistrationForm.isDisplayed();

    }
}
