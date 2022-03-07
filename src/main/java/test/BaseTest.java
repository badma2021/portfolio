package test;

import org.apache.log4j.Level;
import org.testng.annotations.*;
import util.SupportingReader;
import util.Driver;
import util.LoggerTest;
import util.Util;

import java.io.IOException;

public class BaseTest {

    @BeforeTest
    public void setup()  {
        LoggerTest.log(Level.INFO, "BeforeMethod=>setup() is acting with getting instance of driver");
        Util.getDriver();
        LoggerTest.log(Level.INFO, "BeforeMethod=>setup() is acting with maximizing of window");

        Util.manageDriver();
        LoggerTest.log(Level.INFO, "BeforeTest=>setup() is acting with getting Homepage URL");
        Util.getDriverUrl("homepage_url");

    }

//    @AfterTest
//    public void teardown() {
//        LoggerTest.log(Level.INFO, "AfterTest=>teardown() is acting with closing of Driver");
//        Util.quitDriver();
//    }
}
