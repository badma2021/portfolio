import configs.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Testing {
    ConfigReader cf = new ConfigReader();

    HomePage hp = new HomePage(new TextField(By.xpath("//*[@id='app']/header/a/img"), "Main header of home page of DemoQA"), "Home page of DemoQA");
    AlertsFrameWindowsPage afwp = new AlertsFrameWindowsPage(new TextField(By.xpath("//div[@class='main-header']"), "Main header of Alerts&Frame&Windows page"), "Alerts&Frame&Windows page");
    AlertsPage ap = new AlertsPage(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Alerts')]"), "Main header of Alerts page of DemoQA"), "Alerts page of DemoQA");

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
        Assert.assertTrue((ap.getTextFieldAlertsPage()), "Verification Failed: Alerts page is not open");

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
        ap.APacceptAlert();
        Assert.assertTrue((ap.getTextFieldYouSelectedOK()), "Verification Failed: No text appeared after pushing on confirm box");

    }
//    @AfterTest
//    public void tearDown() throws IOException {
//        Driver.getInstance();
//        Driver.quitDriver();
//    }
}
