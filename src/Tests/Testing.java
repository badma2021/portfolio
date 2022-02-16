package Tests;


import Pages.*;
import Utils.ConfigReader;
import Utils.Driver;
import Utils.LoggerTest;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Testing {
    private static final Logger logger = Logger.getLogger(
            Testing.class);
    HomePage hp = new HomePage("Main page");
    AlertsFrameWindowsPage afwp = new AlertsFrameWindowsPage("Utils.Alerts&Frame&Windows page");
    AlertsPage ap = new AlertsPage("Utils.Alerts");
    NestedFramesPage nf = new NestedFramesPage("Nested Frames page");
    FramesPage fp = new FramesPage("Frames");
    ElementsPage ep = new ElementsPage("Elements page");
    WebTablesPage wtp = new WebTablesPage("Web Tables page");
    BrowserWindows bw = new BrowserWindows("Utils.Browser Windows page");
    LinksPage lp = new LinksPage("Links page");
    WidgetsPage wp = new WidgetsPage("Widgets page");
    DatePickerPage dp= new DatePickerPage("Date Picker page");

    public Testing() throws IOException {
    }

    @BeforeTest
    public void setUp() {
        Driver.getInstance().manage().window().maximize();

    }

    @Test(priority = 1, description = "Test1", enabled = true)//Test case 1. Utils.Alerts
    public void Alerts() throws IOException {

        LoggerTest.log(Level.INFO, "1st test is starting");
        Driver.getInstance().get(ConfigReader.util().getString("base_Url"));//Шаг1
        Assert.assertTrue((hp.getTextFieldHeaderHomepage()), "Home page is not open");

        hp.clickTextFieldAlertsFrameWindows();//Шаг2
        Assert.assertTrue((afwp.getTextFieldAlertsFrameWindowsPage()), "Verification Failed: Pages.AlertsFrameWindowsPage page is not open");
        afwp.clickMenuAlerts();
        Assert.assertTrue((ap.appearTextFieldAlertsPage()), "Verification Failed: Utils.Alerts page is not open");

        ap.clickToSeeAlertButton();//Шаг3
        Assert.assertTrue(ap.APgetAlertsText().equals(ConfigReader.util().getString("first_alert")), "Verification Failed: There is no any alert with label 'You clicked a button'");

        ap.APacceptAlert();//Шаг4
        Assert.assertFalse((ap.getAlerts()), "Verification Failed: Alert still exists");

        ap.clickConfirmBoxButton();//Шаг5
        Assert.assertTrue(ap.APgetAlertsText().equals(ConfigReader.util().getString("second_alert")), "Verification Failed: There is no any alert with label 'Do you confirm action?'");


        ap.APacceptAlert();//Шаг6
        Assert.assertTrue(ap.getTextFieldYouSelectedOK().equals(ConfigReader.util().getString("third_alert")), "Verification Failed: No text appeared after pushing on confirm box");
        System.out.println(ap.getTextFieldYouSelectedOK());

        ap.clickPromptBoxButton();//Шаг7
        Assert.assertTrue(ap.APgetAlertsText().equals(ConfigReader.util().getString("forth_alert")), "Verification Failed: There is no any alert with label 'Please enter your name'");

        ap.sendTextPromptBox();//Шаг8
        ap.APacceptAlert();
        Assert.assertTrue(ap.getTextFieldYouEntered().equals(ConfigReader.util().getString("input1")), "Verification Failed: the Alert is not closed or the label after closing alert is incorrect");
    }


    @Test(priority = 2, description = "Test2", enabled = true)//Test case 2. Iframe
    public void Iframe() throws IOException {
        LoggerTest.log(Level.INFO, "2nd test is starting");
        Driver.getInstance().get(ConfigReader.util().getString("base_Url"));//Шаг1
        Assert.assertTrue((hp.getTextFieldHeaderHomepage()), "Home page is not open");
        hp.clickTextFieldAlertsFrameWindows();//Шаг2
        Assert.assertTrue((afwp.getTextFieldAlertsFrameWindowsPage()), "Verification Failed: Pages.AlertsFrameWindowsPage page is not open");
        afwp.clickMenuNestedFrames();
        Assert.assertTrue((nf.appearTextFieldNestedFramesPage()), "Verification Failed: Nested Frames page is not open");
        Assert.assertTrue(nf.getIframeText().equals(nf.labelIframeInternalText), "Verification Failed: There are no 'Parent frame' and 'Child Frame' labels inside Iframes");
        nf.clickMenuFrames();//Шаг3
        Assert.assertTrue((fp.appearTextFieldFramesPage()), "Verification Failed: Nested Frames page is not open");
        Assert.assertTrue(fp.getIframeText1FramesPage().equals(fp.getIframeText2FramesPage()), "Verification Failed: Internal text from two different Iframes is the same");
    }


    @Test(priority = 4, description = "Test4", enabled = true)
    public void Handles() throws IOException {
        LoggerTest.log(Level.INFO, "4th test is starting");
        Driver.getInstance().get(ConfigReader.util().getString("base_Url"));//Шаг1
        Assert.assertTrue((hp.getTextFieldHeaderHomepage()), "Home page is not open");
        hp.clickTextFieldAlertsFrameWindows();//Шаг2
        Assert.assertTrue((afwp.getTextFieldAlertsFrameWindowsPage()), "Verification Failed: Pages.AlertsFrameWindowsPage page is not open");
        afwp.clickMenuBrowserWindows();
        Assert.assertTrue((bw.appearTfBrowserWindowsPage()), "Verification Failed: Utils.Browser Windows page is not open");
        bw.clickNewTabButton();//Шаг3
        String base = Driver.getInstance().getWindowHandle();
        List<String> browserTabs = new ArrayList<String>(Driver.getInstance().getWindowHandles());
        Driver.getInstance().switchTo().window(browserTabs.get(1));
        Assert.assertTrue(Driver.getInstance().getCurrentUrl().equals(ConfigReader.util().getString("new_tab_url")));
        Assert.assertTrue(bw.appearSamplePageHeader().equals(ConfigReader.util().getString("new_tab")));
        Driver.getInstance().close();
        Driver.getInstance().switchTo().window(base);
        Assert.assertTrue((bw.appearTfBrowserWindowsPage()), "Verification Failed: Utils.Browser Windows page is not open");//Шаг4

        bw.clickMenuElements();//Шаг5
        bw.clickMenuElementsLinks();
        Assert.assertTrue((lp.appearTfLinksPage()), "Links page is not displayed");
        Driver.getInstance().findElement(By.linkText("Home")).click();//Шаг6
        Assert.assertTrue((hp.getTextFieldHeaderHomepage()), "Home page is not open");

        Driver.getInstance().switchTo().window(browserTabs.get(0));//Шаг7
        Assert.assertTrue((lp.appearTfLinksPage()), "Links page is not displayed");


    }

    @Test(priority = 5, description = "Test5", enabled = true)
    public void Date_Picker() throws IOException, InterruptedException {
        LoggerTest.log(Level.INFO, "5th test is starting");
        Driver.getInstance().get(ConfigReader.util().getString("base_Url"));//Шаг1
        Assert.assertTrue((hp.getTextFieldHeaderHomepage()), "Home page is not open");
        hp.clickTextFieldWidgets();
        wp.clickTextDatePicker();

        dp.getInputFirstDate(ConfigReader.util().getString("date_picker_date"));
        dp.clicktfDateInput2();

        dp.clicktfDateInput21();
        dp.clicktfAnyMonth();
        dp.clicktfCalendarYearTriangle();
        dp.clicktf2024Year();
        dp.clicktf29number();
       // dp.selectDate(29);
       // WebElement st = Driver.getInstance().findElement(By.xpath("//*[@id='dateAndTimePicker']//span[@class='react-datepicker__month-read-view--down-arrow']"));
     // dp.selectDate(ConfigReader.util().getString("datepicker")); //st.sendKeys(ConfigReader.util().getString("datepicker"));
    //(ConfigReader.util().getString("datepicker"));
        // dp.clicktfDateInput3(ConfigReader.util().getString("datepicker"));
        //dp.selectDate();

    }
    //   @AfterTest
    //   public void tearDown() throws IOException {
    //       Utils.Driver.getInstance();
    //      Utils.Driver.quitDriver();
    //  }
}
