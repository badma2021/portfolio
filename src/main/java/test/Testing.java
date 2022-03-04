package test;

import org.apache.log4j.Level;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AboutSteamPage;
import pages.HomePage;
import pages.TopGamePage;
import pages.TopSellersPage;
import util.LoggerTest;

import java.io.IOException;

public class Testing extends BaseTest {
    HomePage hp = new HomePage();
    AboutSteamPage ap = new AboutSteamPage();
    TopSellersPage ts = new TopSellersPage();
    TopGamePage tg = new TopGamePage();

    @Test(priority = 1, description = "Test1", enabled = true)//Test case 1.
    public void Homepage() throws IOException {
        LoggerTest.log(Level.INFO, "1st test is starting");//Шаг1
        LoggerTest.log(Level.INFO, "1st test is starting, Home page is displayed:" + hp.isDisplayed());
        Assert.assertTrue((hp.isDisplayed()), "Home page is not open");



    }
}
