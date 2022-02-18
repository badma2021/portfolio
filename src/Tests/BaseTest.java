package Tests;

import Utils.ConfigReader;
import Utils.Driver;
import Utils.LoggerTest;
import org.apache.log4j.Level;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {

    @BeforeMethod
    public void setup() throws IOException {
        LoggerTest.log(Level.INFO, "BeforeMethod=>setup() is acting with maximizing of window");
        Driver.getInstance().manage().window().maximize();
        Driver.getInstance().get(ConfigReader.util().getString("base_Url"));
    }

    @AfterClass
    public void teardown() {
        LoggerTest.log(Level.INFO, "AfterClass=>teardown() is acting with closing of Driver");
        Driver.quitDriver();
    }
}
