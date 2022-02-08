import Utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.TestRunner.PriorityWeight.priority;

public class Testing {

    HomePage hp = new HomePage("Main page");
    AlertsFrameWindowsPage afwp = new AlertsFrameWindowsPage("Alerts&Frame&Windows page");
    AlertsPage ap = new AlertsPage("Alerts");
    NestedFramesPage nf = new NestedFramesPage("Nested Frames page");
    FramesPage fp = new FramesPage("Frames");
    ElementsPage ep = new ElementsPage("Elements page");
    WebTablesPage wtp = new WebTablesPage("Web Tables page");
    BrowserWindows bw = new BrowserWindows("Browser Windows page");

    @BeforeTest
    public void setUp() throws IOException {
        Driver.getInstance().manage().window().maximize();

    }

//Test case 1. Alerts

    @Test(priority=1,description = "Test1", enabled = true)
    public void Alerts() throws IOException {

        //Шаг1 Перейти на главную страницу

        Driver.getInstance().get(ConfigReader.util().getString("base_Url"));
        Assert.assertTrue((hp.getTextFieldHeaderHomepage()), "Home page is not open");

        //Шаг2 Кликнуть на кнопку Alerts, Frame & Windows.
        //На открывшейся странице в левом меню кликнуть пункт Alerts

        hp.clickTextFieldAlertsFrameWindows();
        Assert.assertTrue((afwp.getTextFieldAlertsFrameWindowsPage()), "Verification Failed: AlertsFrameWindowsPage page is not open");
        afwp.clickMenuAlerts();
        Assert.assertTrue((ap.appearTextFieldAlertsPage()), "Verification Failed: Alerts page is not open");

        //Шаг3 Нажать на кнопку Click Button to see alert

        ap.clickToSeeAlertButton();
        Assert.assertTrue(ap.APgetAlertsText().equals(ConfigReader.util().getString("first_alert")), "Verification Failed: There is no any alert with label 'You clicked a button'");

        //Шаг4 Нажать на кнопку OK

        ap.APacceptAlert();
        Assert.assertFalse((ap.getAlerts()), "Verification Failed: Alert still exists");

        //Шаг5 Нажать на кнопку On button click, confirm box will appear

        ap.clickConfirmBoxButton();
        Assert.assertTrue(ap.APgetAlertsText().equals(ConfigReader.util().getString("second_alert")), "Verification Failed: There is no any alert with label 'Do you confirm action?'");

        //Шаг6 Нажать на кнопку OK
        ap.APacceptAlert();
        Assert.assertTrue(ap.getTextFieldYouSelectedOK().equals(ConfigReader.util().getString("third_alert")), "Verification Failed: No text appeared after pushing on confirm box");
        System.out.println(ap.getTextFieldYouSelectedOK());

        //Шаг7 Нажать на кнопку On button click, prompt box will appear

        ap.clickPromptBoxButton();
        Assert.assertTrue(ap.APgetAlertsText().equals(ConfigReader.util().getString("forth_alert")), "Verification Failed: There is no any alert with label 'Please enter your name'");

        //Шаг8 Ввести случайно сгенерированный текст, нажать на кнопку OK

        ap.sendTextPromptBox();
        ap.APacceptAlert();
        Assert.assertTrue(ap.getTextFieldYouEntered().equals(ConfigReader.util().getString("input1")), "Verification Failed: the Alert is not closed or the label after closing alert is incorrect");
    }

    //Test case 2. Iframe

    @Test(priority=2, description = "Test2", enabled = true)
    public void Iframe() throws IOException {

        //Шаг1 Перейти на главную страницу

        Driver.getInstance().get(ConfigReader.util().getString("base_Url"));
        Assert.assertTrue((hp.getTextFieldHeaderHomepage()), "Home page is not open");

        //Шаг2 Кликнуть на кнопку Alerts, Frame & Windows.
        //На открывшейся странице в левом меню кликнуть пункт Nested Frames

        hp.clickTextFieldAlertsFrameWindows();
        Assert.assertTrue((afwp.getTextFieldAlertsFrameWindowsPage()), "Verification Failed: AlertsFrameWindowsPage page is not open");
        afwp.clickMenuNestedFrames();
        Assert.assertTrue((nf.appearTextFieldNestedFramesPage()), "Verification Failed: Nested Frames page is not open");
        Assert.assertTrue(nf.getIframeText().equals(nf.labelIframeInternalText), "Verification Failed: There are no 'Parent frame' and 'Child Frame' labels inside Iframes");

        //Шаг3 В левом меню выбрать пункт Frames.

        nf.clickMenuFrames();
        Assert.assertTrue((fp.appearTextFieldFramesPage()), "Verification Failed: Nested Frames page is not open");
        Assert.assertTrue(fp.getIframeText1FramesPage().equals(fp.getIframeText2FramesPage()), "Verification Failed: Internal text from two different Iframes is the same");
    }

//    @Test(priority=3,description = "Test3", enabled = true)
//    public void Tables() throws IOException {
//
//        //Шаг1 Перейти на главную страницу
//
//        Driver.getInstance().get(ConfigReader.util().getString("base_Url"));
//
//        Assert.assertTrue((hp.getTextFieldHeaderHomepage()), "Home page is not open");
//
//        //Шаг2 Кликнуть на кнопку Elements.
//        //На открывшейся странице в левом меню кликнуть пункт Web Tables
//
//        hp.clickTextFieldElements();
//        Assert.assertTrue((ep.getTextFieldElementsPage()), "Verification Failed: Elements page is not open");
//        ep.clickMenuWebTables();
//        Assert.assertTrue((wtp.appearTextFieldWebTablesPage()), "Verification Failed: Web tables page is not open");
//
//        //Шаг3 Кликнуть на кнопку Add.
//
//        wtp.clickAddButton();
//        Assert.assertTrue((wtp.appearTextFieldRegistrationFormOnWebTablesPage()), "Verification Failed: Registration form did not appear");
//
//


 //   }

    @Test(priority=4,description = "Test4", enabled = true)
    public void Handles() throws IOException {

        //Шаг1 Перейти на главную страницу

        Driver.getInstance().get(ConfigReader.util().getString("base_Url"));
        Assert.assertTrue((hp.getTextFieldHeaderHomepage()), "Home page is not open");

        //Шаг2 Кликнуть на кнопку Alerts, Frame & Windows.
        //На открывшейся странице в левом меню кликнуть пункт Alerts

        hp.clickTextFieldAlertsFrameWindows();
        Assert.assertTrue((afwp.getTextFieldAlertsFrameWindowsPage()), "Verification Failed: AlertsFrameWindowsPage page is not open");
        afwp.clickMenuBrowserWindows();
        //Assert.assertTrue((bw.appearTextFieldAlertsPage()), "Verification Failed: Browser Windows page is not open");

        //Шаг3 Кликнуть на кнопку New Tab
        bw.clickNewTabButton();
        // Driver.getInstance().switchTo().Window(getInstance().WindowHandles[1]);


    }


//    @AfterTest
//    public void tearDown() throws IOException {
//        Driver.getInstance();
//        Driver.quitDriver();
//    }
}
