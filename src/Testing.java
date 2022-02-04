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

    @BeforeTest
    public void setUp() throws IOException {
        Driver.getInstance().manage().window().maximize();

    }

//Test case 1. Alerts

    @Test(description = "Test1", enabled = true)
    public void Alerts() throws IOException {

//Шаг1 Перейти на главную страницу
        Driver.getInstance().get(cf.util().getString("base_Url"));
        //Assert.assertTrue((hp.getElementHomepage()), "Home page is not open");

        //Шаг2 Кликнуть на кнопку Alerts, Frame & Windows.
        //На открывшейся странице в левом меню кликнуть пункт Alerts
        hp.textFieldAlertsFrameWindowsClick();
        //Assert.assertTrue((ap.getAboutPageTitle()), "Verification Failed:Steam About page is not open");
    }


//    @AfterTest
//    public void tearDown() throws IOException {
//        Driver.getInstance();
//        Driver.quitDriver();
//    }
}
