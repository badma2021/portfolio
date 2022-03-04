package test;

import org.apache.log4j.Level;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.ConfigReader;
import util.Driver;
import util.LoggerTest;

import java.io.IOException;

public class BaseTest {

    @BeforeMethod
    public void setup() throws IOException {
        LoggerTest.log(Level.INFO, "BeforeMethod=>setup() is acting with maximizing of window");
        Driver.getInstance().manage().window().maximize();
        Driver.getInstance().get(ConfigReader.util().getString("homepage_url"));
    }

    @AfterMethod
    public void teardown() {
        LoggerTest.log(Level.INFO, "AfterMethod=>teardown() is acting with closing of Driver");
        Driver.quitDriver();
    }
}
