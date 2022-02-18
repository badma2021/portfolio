package Tests;

import Pages.*;
import Utils.ConfigReader;
import Utils.DateFormatter;
import Utils.Driver;
import Utils.LoggerTest;
import org.apache.log4j.Level;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Testing extends BaseTest {

    HomePage hp = new HomePage();
    AlertsFrameWindowsPage afwp = new AlertsFrameWindowsPage();
    AlertsPage ap = new AlertsPage();
    NestedFramesPage nf = new NestedFramesPage();
    FramesPage fp = new FramesPage();
    BrowserWindows bw = new BrowserWindows();
    LinksPage lp = new LinksPage();
    WidgetsPage wp = new WidgetsPage();
    DatePickerPage dp = new DatePickerPage();
    ElementsPage ep = new ElementsPage();
    WebTablesPage wtp = new WebTablesPage();
    RegistrationForm rf = new RegistrationForm();

    public Testing() throws IOException {
    }


    @Test(priority = 1, description = "Test1", enabled = true)//Test case 1. Alerts
    public void Alerts() throws IOException {

        LoggerTest.log(Level.INFO, "1st test is starting");//Шаг1
        LoggerTest.log(Level.INFO, "1st test is starting, Home page is displayed:" + hp.isDisplayed());
        Assert.assertTrue((hp.isDisplayed()), "Home page is not open");

        hp.clickTextFieldAlertsFrameWindows();//Шаг2
        Assert.assertTrue((afwp.getTextFieldAlertsFrameWindowsPage()), "Verification Failed: AlertsFrameWindowsPage page is not open");
        afwp.clickMenuAlerts();
        Assert.assertTrue((ap.isDisplayed()), "Verification Failed: Alerts page is not open");

        ap.clickToSeeAlertButton();//Шаг3
        Assert.assertTrue(ap.APgetAlertsText().equals(ConfigReader.util().getString("first_alert")), "Verification Failed: There is no any alert with label 'You clicked a button'");

        ap.APacceptAlert();//Шаг4
        Assert.assertFalse((ap.getAlerts()), "Verification Failed: Alert still exists");

        ap.clickConfirmBoxButton();//Шаг5
        Assert.assertTrue(ap.APgetAlertsText().equals(ConfigReader.util().getString("second_alert")), "Verification Failed: There is no any alert with label 'Do you confirm action?'");


        ap.APacceptAlert();//Шаг6
        Assert.assertTrue(ap.getTextFieldYouSelectedOK().equals(ConfigReader.util().getString("third_alert")), "Verification Failed: No text appeared after pushing on confirm box");
        LoggerTest.log(Level.INFO, "1st test is starting, after clicking on 'On button click, confirm box will appear' the green text appears:" + ap.getTextFieldYouSelectedOK());

        ap.clickPromptBoxButton();//Шаг7
        Assert.assertTrue(ap.APgetAlertsText().equals(ConfigReader.util().getString("forth_alert")), "Verification Failed: There is no any alert with label 'Please enter your name'");

        ap.sendTextPromptBox();//Шаг8
        ap.APacceptAlert();
        Assert.assertTrue(ap.getTextFieldYouEntered().equals(ConfigReader.util().getString("input1")), "Verification Failed: the Alert is not closed or the label after closing alert is incorrect");
    }


    @Test(priority = 2, description = "Test2", enabled = true)//Test case 2. Iframe
    public void Iframe() throws IOException {
        LoggerTest.log(Level.INFO, "2nd test is starting");//Шаг1
        Assert.assertTrue(hp.isDisplayed(), "Home page is not open");
        hp.clickTextFieldAlertsFrameWindows();//Шаг2
        Assert.assertTrue((afwp.isDisplayed()), "Verification Failed: AlertsFrameWindowsPage page is not open");
        afwp.clickMenuNestedFrames();
        Assert.assertTrue((nf.isDisplayed()), "Verification Failed: Nested Frames page is not open");
        LoggerTest.log(Level.INFO, "2nd test is starting: Internal text from Config.json file is " + ConfigReader.util().getString("checkFrames"));
        Assert.assertTrue(nf.getIframeText().equals(ConfigReader.util().getString("checkFrames")), "Verification Failed: There are no 'Parent frame' and 'Child Frame' labels inside Iframes");
        nf.clickMenuFrames();//Шаг3
        Assert.assertTrue((fp.isDisplayed()), "Verification Failed: Nested Frames page is not open");
        Assert.assertTrue(fp.getIframeText1FramesPage().equals(fp.getIframeText2FramesPage()), "Verification Failed: Internal text from two different Iframes is not the same");
    }

    @Test(priority = 3, description = "Test3", enabled = true, dataProvider = "registration data", dataProviderClass = TestingDataProvider.class)
    public void userRegistration(String UserNumber, String FirstName, String LastName, String Email, String Age, String Salary, String Department) {

        LoggerTest.log(Level.INFO, "3d test is starting");//Шаг1
        Assert.assertTrue((hp.isDisplayed()), "Home page is not open");

        hp.clickTextFieldElements();//Шаг2
        Assert.assertTrue((ep.isDisplayed()), "Verification Failed: Elements page is not open");
        ep.clickMenuWebTables();
        Assert.assertTrue((wtp.isDisplayed()), "Verification Failed: Web tables page is not open");

        wtp.clickAddButton();//Шаг3
        Assert.assertTrue((rf.isDisplayed()), "Verification Failed: Registration form did not appear");
        rf.getFInputFirstName(FirstName);
        rf.getFInputLastName(LastName);
        rf.getFInputUserEmail(Email);
        rf.getFInputAge(Age);
        rf.getFInputSalary(Salary);
        rf.getFInputDepartment(Department);
        rf.clickSubmitButton();
        LoggerTest.log(Level.INFO, "Getting new user info from the table of the site: " + wtp.getRowTextFromNewUser());
        LoggerTest.log(Level.INFO, "Reading from JSON the following data: " + FirstName + LastName + Age + Email + Salary + Department);
        Assert.assertEquals(wtp.getRowTextFromNewUser(), FirstName + LastName + Age + Email + Salary + Department, "Verification Failed:New User data does not equal to which appeared in the table");
        wtp.clickRemoveUserButton();
        LoggerTest.log(Level.INFO, "Given user was removed: " + wtp.appearTextFieldAddedUser());
        Assert.assertTrue((wtp.appearTextFieldAddedUser()), "Verification Failed: New user is not removed");

    }


    @Test(priority = 4, description = "Test4", enabled = true)
    public void Handles() throws IOException {
        LoggerTest.log(Level.INFO, "4th test is starting");//Шаг1
        Assert.assertTrue((hp.isDisplayed()), "Home page is not open");
        hp.clickTextFieldAlertsFrameWindows();//Шаг2
        Assert.assertTrue((afwp.isDisplayed()), "Verification Failed: AlertsFrameWindowsPage page is not open");
        afwp.clickMenuBrowserWindows();
        Assert.assertTrue((bw.isDisplayed()), "Verification Failed: Browser Windows page is not open");

        bw.clickNewTabButton();//Шаг3
        String base = Driver.getInstance().getWindowHandle();
        List<String> browserTabs = new ArrayList<String>(Driver.getInstance().getWindowHandles());
        Driver.getInstance().switchTo().window(browserTabs.get(1));
        Assert.assertTrue(Driver.getInstance().getCurrentUrl().equals(ConfigReader.util().getString("new_tab_url")));
        Assert.assertTrue(bw.appearSamplePageHeader().equals(ConfigReader.util().getString("new_tab")));
        Driver.getInstance().close();
        Driver.getInstance().switchTo().window(base);
        Assert.assertTrue((bw.isDisplayed()), "Verification Failed: Browser Windows page is not open");//Шаг4

        bw.clickMenuElements();//Шаг5
        bw.clickMenuElementsLinks();
        Assert.assertTrue((lp.isDisplayed()), "Links page is not displayed");
        Driver.getInstance().findElement(By.linkText("Home")).click();//Шаг6
        Assert.assertTrue(hp.isDisplayed(), "Home page is not open");

        Driver.getInstance().switchTo().window(browserTabs.get(0));//Шаг7
        Assert.assertTrue((lp.isDisplayed()), "Links page is not displayed");

    }

    @Test(priority = 5, description = "Test5", enabled = true)
    public void Date_Picker() throws IOException {
        LoggerTest.log(Level.INFO, "5th test is starting");//Шаг1
        Assert.assertTrue(hp.isDisplayed(), "Home page is not open");
        hp.clickTextFieldWidgets();
        wp.clickTextDatePicker();
        LoggerTest.log(Level.INFO, "5th test is starting: Date from the 1st field is " + dp.getInputFirstDate1() + " whereas Today formatted date1 is " + DateFormatter.getToday(ConfigReader.util().getString("dateFormat1")));
        Assert.assertTrue(dp.getInputFirstDate1().equals(DateFormatter.getToday(ConfigReader.util().getString("dateFormat1"))), "Verification Failed: First date does not equal to current");
        LoggerTest.log(Level.INFO, "5th test is starting: Date from the 2nd field is " + dp.getInputFirstDate2() + " whereas Today formatted date2 is " + DateFormatter.getTodayWithLocale());
        Assert.assertTrue(dp.getInputFirstDate2().equals(DateFormatter.getTodayWithLocale()), "Verification Failed: Second date does not equal to current");
        dp.clickInputFirstDate1();
        dp.clickSelectYear();
        dp.selectYear(ConfigReader.util().getString("date_picker_year"));
        dp.clickSelectYear();
        dp.clickSelectMonth();
        dp.selectMonth(ConfigReader.util().getString("date_picker_month"));
        dp.clickSelectMonth();
        dp.clicktf29number();
        Assert.assertTrue(ConfigReader.util().getString("expected_date").equals(dp.getInputFirstDate1()), "Verification Failed: the date which you set does not match with the expected date");

    }

}
