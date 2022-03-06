package test;

import pages.*;
import org.apache.log4j.Level;
import org.testng.Assert;
import org.testng.annotations.Test;


import util.ConfigReader;
import util.LoggerTest;
import util.Util;

import java.io.IOException;

public class Testing extends BaseTest {
    HomePage hp = new HomePage();
    AboutSteamPage ap = new AboutSteamPage();
    TopSellersPage ts = new TopSellersPage();
    TopGamePage tg = new TopGamePage();

    @Test(priority = 1, description = "Test1", enabled = true)//Test case 1.
    public void Homepage() throws IOException {
        LoggerTest.log(Level.INFO, "1st test is starting, Home page is displayed:" + hp.isDisplayed()); //Шаг1
        Assert.assertTrue((hp.isDisplayed()), "Home page is not open");
        LoggerTest.log(Level.INFO, "2nd test is starting");//шаг2
        hp.clickMenuAbout();
        LoggerTest.log(Level.INFO, "2nd test is starting, Steam About page is displayed:" + ap.isDisplayed());
        Assert.assertTrue((ap.textFieldAboutSteamPageLogoDisplay()), "Verification Failed:Steam About page is not open");
        LoggerTest.log(Level.INFO, "3d test is starting, the number of in game players is:" + ap.getInGamePlayers());//шаг3
        LoggerTest.log(Level.INFO, "3d test is starting, the number of out game players is:" + ap.getOutGamePlayers());
        Assert.assertFalse(ap.getOutGamePlayers() < ap.getInGamePlayers(), "Verification Failed: in-game participants are greater than on-line");
        Util.getDriverUrl("homepage_url");//шаг4
        LoggerTest.log(Level.INFO, "4th test is starting, Store page is displayed:" + hp.isDisplayed());
        Assert.assertTrue((hp.isDisplayed()), "Store page is not open");
    }

    @Test(priority = 2, description = "Test2", enabled = true)
    public void TopSellers() {

        LoggerTest.log(Level.INFO, "5th test is starting, Home page is displayed:" + hp.isDisplayed());
        Assert.assertTrue((hp.isDisplayed()), "Home page is not open");
        LoggerTest.log(Level.INFO, "6th test is starting, Top Sellers pop-up textfield is clicking");
        ts.clickTopSellers();//шаг6
        LoggerTest.log(Level.INFO, "6th test is starting, Top Sellers pop-up textfield is displayed:" + ts.textFieldAnyPriceDisplay());
        Assert.assertTrue(ts.textFieldAnyPriceDisplay(), "Verification Failed: Top Sellers page is not open");
    }
}

