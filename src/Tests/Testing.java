package Tests;


import Pages.*;
import Utils.ConfigReader;
import Utils.Driver;
import Utils.LoggerTest;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Testing {

    HomePage hp = new HomePage();
    AlertsFrameWindowsPage afwp = new AlertsFrameWindowsPage();
    AlertsPage ap = new AlertsPage();
    NestedFramesPage nf = new NestedFramesPage();
    FramesPage fp = new FramesPage();
    BrowserWindows bw = new BrowserWindows();
    LinksPage lp = new LinksPage();
    WidgetsPage wp = new WidgetsPage();
    DatePickerPage dp = new DatePickerPage();

    public Testing() {
    }

    @BeforeTest
    public void setUp() {
        Driver.getInstance().manage().window().maximize();

    }

    @Test(priority = 1, description = "Test1", enabled = true)//Test case 1. Alerts
    public void Alerts() throws IOException {

        LoggerTest.log(Level.INFO, "1st test is starting");
        Driver.getInstance().get(ConfigReader.util().getString("base_Url"));//Шаг1
        Assert.assertTrue((hp.getTextFieldHeaderHomepage()), "Home page is not open");

        hp.clickTextFieldAlertsFrameWindows();//Шаг2
        Assert.assertTrue((afwp.getTextFieldAlertsFrameWindowsPage()), "Verification Failed: AlertsFrameWindowsPage page is not open");
        afwp.clickMenuAlerts();
        Assert.assertTrue((ap.appearTextFieldAlertsPage()), "Verification Failed: Alerts page is not open");

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
        Assert.assertTrue((afwp.getTextFieldAlertsFrameWindowsPage()), "Verification Failed: AlertsFrameWindowsPage page is not open");
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
        Assert.assertTrue((afwp.getTextFieldAlertsFrameWindowsPage()), "Verification Failed: AlertsFrameWindowsPage page is not open");
        afwp.clickMenuBrowserWindows();
        Assert.assertTrue((bw.appearTfBrowserWindowsPage()), "Verification Failed: Browser Windows page is not open");
        bw.clickNewTabButton();//Шаг3
        String base = Driver.getInstance().getWindowHandle();
        List<String> browserTabs = new ArrayList<String>(Driver.getInstance().getWindowHandles());
        Driver.getInstance().switchTo().window(browserTabs.get(1));
        Assert.assertTrue(Driver.getInstance().getCurrentUrl().equals(ConfigReader.util().getString("new_tab_url")));
        Assert.assertTrue(bw.appearSamplePageHeader().equals(ConfigReader.util().getString("new_tab")));
        Driver.getInstance().close();
        Driver.getInstance().switchTo().window(base);
        Assert.assertTrue((bw.appearTfBrowserWindowsPage()), "Verification Failed: Browser Windows page is not open");//Шаг4

        bw.clickMenuElements();//Шаг5
        bw.clickMenuElementsLinks();
        Assert.assertTrue((lp.appearTfLinksPage()), "Links page is not displayed");
        Driver.getInstance().findElement(By.linkText("Home")).click();//Шаг6
        Assert.assertTrue((hp.getTextFieldHeaderHomepage()), "Home page is not open");

        Driver.getInstance().switchTo().window(browserTabs.get(0));//Шаг7
        Assert.assertTrue((lp.appearTfLinksPage()), "Links page is not displayed");


    }

    @Test(priority = 5, description = "Test5", enabled = true)
    public void Date_Picker() throws IOException {
        LoggerTest.log(Level.INFO, "5th test is starting");
        Driver.getInstance().get(ConfigReader.util().getString("base_Url"));//Шаг1
        Assert.assertTrue((hp.getTextFieldHeaderHomepage()), "Home page is not open");
        hp.clickTextFieldWidgets();
        wp.clickTextDatePicker();

        Date date = new Date();
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String today = formatter.format(date);
        Assert.assertTrue(dp.getInputFirstDate1().equals(today), "Verification Failed: First date does not equal to current");
        formatter = new SimpleDateFormat("MMMM dd, yyyy h:mm aa", Locale.ENGLISH);
        String today1 = formatter.format(date);
        Assert.assertTrue(dp.getInputFirstDate2().equals(today1), "Verification Failed: Second date does not equal to current");

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
    //   @AfterTest
    //   public void tearDown() throws IOException {
    //       Utils.Driver.getInstance();
    //      Utils.Driver.quitDriver();
    //  }
}
