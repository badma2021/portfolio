import configs.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Instant;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class Testing {
    ConfigReader cf = new ConfigReader();

    HomePage hp = new HomePage(new TextField(By.xpath("//*[@id='app']/header/a/img"), "Main header of home page of DemoQA"), "Home page of DemoQA");
    AlertsFrameWindowsPage afwp = new AlertsFrameWindowsPage(new TextField(By.xpath("//div[@class='main-header']"), "Main header of Alerts&Frame&Windows page"), "Alerts&Frame&Windows page");
    AlertsPage ap = new AlertsPage(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Alerts')]"), "Main header of Alerts page of DemoQA"), "Alerts page of DemoQA");
    NestedFramesPage nf = new NestedFramesPage(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Nested')]"), "Main header of Nested Frames page of DemoQA"), "Nested Frame page of DemoQA");

    @BeforeTest
    public void setUp() throws IOException {
        Driver.getInstance().manage().window().maximize();

    }

//Test case 1. Alerts

    @Test(description = "Test1", enabled = true)
    public void Alerts() throws IOException {

        //Шаг1 Перейти на главную страницу
        Driver.getInstance().get(cf.util().getString("base_Url"));
        Assert.assertTrue((hp.getTextFieldHeaderHomepage()), "Home page is not open");

        //Шаг2 Кликнуть на кнопку Alerts, Frame & Windows.
        //На открывшейся странице в левом меню кликнуть пункт Alerts
        hp.clickTextFieldAlertsFrameWindows();
        Assert.assertTrue((afwp.getTextFieldAlertsFrameWindowsPage()), "Verification Failed: AlertsFrameWindowsPage page is not open");
        afwp.clickMenuAlerts();
        Assert.assertTrue((ap.appearTextFieldAlertsPage()), "Verification Failed: Alerts page is not open");

        //Шаг3 Нажать на кнопку Click Button to see alert
        ap.clickToSeeAlertButton();
//        System.out.println(ap.getAlerts());
//        System.out.println(ap.APgetAlertsText());
        Assert.assertTrue(ap.APgetAlertsText().equals(ap.labelYouClickedButton), "Verification Failed: There is no any alert with label 'You clicked a button'");

        //Шаг4 Нажать на кнопку OK
        ap.APacceptAlert();
        Assert.assertFalse((ap.getAlerts()), "Verification Failed: Alert still exists");

        //Шаг5 Нажать на кнопку On button click, confirm box will appear
        ap.clickConfirmBoxButton();
        Assert.assertTrue(ap.APgetAlertsText().equals(ap.labelDoYouConfirmAction), "Verification Failed: There is no any alert with label 'Do you confirm action?'");
        //System.out.println(ap.APgetAlertsText());

        //Шаг6 Нажать на кнопку OK
        ap.APacceptAlert();
        Assert.assertTrue(ap.getTextFieldYouSelectedOK().equals(ap.labelYouSelectedOk), "Verification Failed: No text appeared after pushing on confirm box");
        System.out.println(ap.getTextFieldYouSelectedOK());
        //Шаг7 Нажать на кнопку On button click, prompt box will appear
        ap.clickPromptBoxButton();
        Assert.assertTrue(ap.APgetAlertsText().equals(ap.labelPleaseEnterYourName), "Verification Failed: There is no any alert with label 'Please enter your name'");

        //Шаг8 Ввести случайно сгенерированный текст, нажать на кнопку OK
        ap.sendTextPromptBox();
        ap.APacceptAlert();
        // System.out.println(ap.getTextFieldYouEntered());
        Assert.assertTrue(ap.getTextFieldYouEntered().equals(ap.inputTextPromptBox), "Verification Failed: the Alert is not closed or the label after closing alert is incorrect");
    }
    //Test case 2. Iframe

    @Test(description = "Test2", enabled = true)
    public void Iframe() throws IOException {

        //Шаг1 Перейти на главную страницу
        Driver.getInstance().get(cf.util().getString("base_Url"));
        Assert.assertTrue((hp.getTextFieldHeaderHomepage()), "Home page is not open");

        //Шаг2 Кликнуть на кнопку Alerts, Frame & Windows.
        //На открывшейся странице в левом меню кликнуть пункт Nested Frames
        hp.clickTextFieldAlertsFrameWindows();
        Assert.assertTrue((afwp.getTextFieldAlertsFrameWindowsPage()), "Verification Failed: AlertsFrameWindowsPage page is not open");
        afwp.clickMenuNestedFrames();
        Assert.assertTrue((nf.appearTextFieldNestedFramesPage()), "Verification Failed: Nested Frames page is not open");
        Assert.assertTrue(nf.getIframeText().equals(nf.labelIframeInternalText), "Verification Failed: There are no 'Parent frame' and 'Child Frame' labels inside Iframes");

        //Шаг3 В левом меню выбрать пункт Frames.


    }


//    @AfterTest
//    public void tearDown() throws IOException {
//        Driver.getInstance();
//        Driver.quitDriver();
//    }
}
