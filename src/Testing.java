import Utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;


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

    @Test(priority = 1, description = "Test1", enabled = true)//Test case 1. Alerts
    public void Alerts() throws IOException {


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

        Driver.getInstance().get(ConfigReader.util().getString("base_Url"));//Шаг1
        Assert.assertTrue((hp.getTextFieldHeaderHomepage()), "Home page is not open");
        hp.clickTextFieldAlertsFrameWindows();//Шаг2
        Assert.assertTrue((afwp.getTextFieldAlertsFrameWindowsPage()), "Verification Failed: AlertsFrameWindowsPage page is not open");
        afwp.clickMenuBrowserWindows();
        //Assert.assertTrue((bw.appearTextFieldAlertsPage()), "Verification Failed: Browser Windows page is not open");
        bw.clickNewTabButton();//Шаг3
        // Driver.getInstance().switchTo().Window(getInstance().WindowHandles[1]);

    }


    @AfterTest
    public void tearDown() throws IOException {
        Driver.getInstance();
        Driver.quitDriver();
    }
}
