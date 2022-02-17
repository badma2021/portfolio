package Tests;

import Pages.*;
import Utils.ConfigReader;
import Utils.Driver;
import Utils.JSON_Reader;
import Utils.LoggerTest;
import org.apache.log4j.Level;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Testing_Data_provider {
    @DataProvider(name = "registration data")
    public Object[][] passData() throws IOException, ParseException {

        return JSON_Reader.getData("src/Tests/Testing_data.json", "Registration data", 7);
        //return null;
    }

    @Test(dataProvider = "registration data")
    public void userRegistration(String UserNumber,String FirstName,String LastName, String Email, String Age, String Salary, String Department) throws Exception
    {
        HomePage hp = new HomePage("Main page");
        ElementsPage ep = new ElementsPage("Elements page");
        WebTablesPage wtp = new WebTablesPage("Web Tables page");
        BrowserWindows bw = new BrowserWindows("Utils.Browser Windows page");
        RegistrationForm rf = new RegistrationForm("Registration form");
        LoggerTest.log(Level.INFO,"3d test is starting");
        Driver.getInstance().manage().window().maximize();
        Driver.getInstance().get(ConfigReader.util().getString("base_Url"));//Шаг1

        Assert.assertTrue((hp.getTextFieldHeaderHomepage()), "Home page is not open");

        hp.clickTextFieldElements();//Шаг2
        Assert.assertTrue((ep.getTextFieldElementsPage()), "Verification Failed: Elements page is not open");
        ep.clickMenuWebTables();
        Assert.assertTrue((wtp.appearTextFieldWebTablesPage()), "Verification Failed: Web tables page is not open");


        wtp.clickAddButton();//Шаг3
        Assert.assertTrue((wtp.appearTextFieldRegistrationFormOnWebTablesPage()), "Verification Failed: Registration form did not appear");

        rf.getFInputFirstName(FirstName);
        rf.getFInputLastName(LastName);
        rf.getFInputUserEmail(Email);
        rf.getFInputAge(Age);
        rf.getFInputSalary(Salary);
        rf.getFInputDepartment(Department);
        rf.clickSubmitButton();
        LoggerTest.log(Level.INFO,"Getting new user info from the table of the site " + wtp.getRowTextFromNewUser());
        LoggerTest.log(Level.INFO,"Reading from JSON the following data " + FirstName+LastName+Age+Email+Salary+Department);
        Assert.assertEquals(wtp.getRowTextFromNewUser(),FirstName+LastName+Age+Email+Salary+Department,"Verification Failed:New User data does not equal to which appeared in the table");
        wtp.clickRemoveUserButton();
        System.out.println(wtp.appearTextFieldAddedUser());
       Assert.assertTrue((wtp.appearTextFieldAddedUser()),"Verification Failed: New user is not removed");

    }



}
