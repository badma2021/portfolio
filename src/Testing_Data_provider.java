import Utils.ConfigReader;
import Utils.JSON_Reader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Testing_Data_provider {
    @DataProvider(name = "registration data")
    public Object[][] passData() throws IOException, ParseException {

        return JSON_Reader.getData("C:/Users/Observer/IdeaProjects/Demoqa/src/Testing_data.json", "Registration data", 7);
        //return null;
    }

    @Test(dataProvider = "registration data")
    public void userRegistration(String UserNumber,String FirstName,String LastName, String Email, String Age, String Salary, String Department) throws Exception
    {
        HomePage hp = new HomePage("Main page");
        ElementsPage ep = new ElementsPage("Elements page");
        WebTablesPage wtp = new WebTablesPage("Web Tables page");
        BrowserWindows bw = new BrowserWindows("Browser Windows page");
        RegistrationForm rf = new RegistrationForm("Registration form");
        //Шаг1 Перейти на главную страницу
        Driver.getInstance().manage().window().maximize();
        Driver.getInstance().get(ConfigReader.util().getString("base_Url"));

        Assert.assertTrue((hp.getTextFieldHeaderHomepage()), "Home page is not open");

        //Шаг2 Кликнуть на кнопку Elements.
        //На открывшейся странице в левом меню кликнуть пункт Web Tables

        hp.clickTextFieldElements();
        Assert.assertTrue((ep.getTextFieldElementsPage()), "Verification Failed: Elements page is not open");
        ep.clickMenuWebTables();
        Assert.assertTrue((wtp.appearTextFieldWebTablesPage()), "Verification Failed: Web tables page is not open");

        //Шаг3 Кликнуть на кнопку Add.

        wtp.clickAddButton();
       // Assert.assertTrue((wtp.appearTextFieldRegistrationFormOnWebTablesPage()), "Verification Failed: Registration form did not appear");

        rf.getFInputFirstName(FirstName);
        rf.getFInputLastName(LastName);
        rf.getFInputUserEmail(Email);
        rf.getFInputAge(Age);
        rf.getFInputSalary(Salary);
        rf.getFInputDepartment(Department);
        rf.clickSubmitButton();


    }



}
