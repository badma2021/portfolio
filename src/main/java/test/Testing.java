package test;

import pages.*;
import org.apache.log4j.Level;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.LoggerTest;
import util.Util;


public class Testing extends BaseTest {
    private HomePage hp = new HomePage();
    private AboutSteamPage ap = new AboutSteamPage();
    private TopSellersPage ts = new TopSellersPage();
    private TopGamePage tg = new TopGamePage();
    private String topGameName;
    private String topGameRelease;
    private String topGamePrice;

    @Test(priority = 1, description = "Test1", enabled = true)
    public void Homepage() {
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
        LoggerTest.log(Level.INFO, "7th test is starting, SteamOS checkbox is clicking"); //шаг7
        ts.clickSteamOSCheckbox();
        LoggerTest.log(Level.INFO, "7th test is starting, SteamOS checkbox is displayed:" + ts.textFieldSteamOScheckboxCheckedDisplay());
        Assert.assertTrue(ts.textFieldSteamOScheckboxCheckedDisplay(), "Verification Failed: SteamOS+Linux checkbox is not ticked");
        LoggerTest.log(Level.INFO, "8th test is starting, Narrow by number of players is clicking");//шаг8
        ts.clickCooperativeLANElement();
        LoggerTest.log(Level.INFO, "8th test is starting, Lan Co-op is clicking");
        ts.clickLANcheckbox();
        LoggerTest.log(Level.INFO, "8th test is starting, Lan Co-op checkbox checked is displayed:" + ts.getCooperativeLANChecked());
        Assert.assertTrue(ts.getCooperativeLANChecked(), "Verification Failed: LAN cooperation checkbox is not ticked");
        LoggerTest.log(Level.INFO, "9th test is starting, Action tag is searching in 'search for more Tags'"); //шаг9
        ts.sendKeysSearchActionInput();
        LoggerTest.log(Level.INFO, "9th test is starting, Action checkbox is clicking");
        ts.clickActionCheckbox();
        LoggerTest.log(Level.INFO, "9th test is starting, clicked Action checkbox is displayed:" + ts.getActionCheckbox());
        Assert.assertTrue(ts.getActionCheckbox(), "Verification Failed: Action checkbox is not ticked");
        LoggerTest.log(Level.INFO, "9th test is starting, relevant number of games:" + ts.getNumberOfGames() + "=" + ts.getNumberOfFilterGames());
        Assert.assertFalse(ts.getNumberOfGames() != ts.getNumberOfFilterGames(), "Verification Failed: Number of games is not equal to summary");
        LoggerTest.log(Level.INFO, "10th test is starting: determining of Top game name, TopGameRelease and Top Game Price");//шаг10
        topGameName = ts.getTopGameName();
        topGameRelease = ts.getTopGameRelease();
        topGamePrice = ts.getTopGamePrice();
        LoggerTest.log(Level.INFO, "10th test is starting: determining of Top game name=" + topGameName + ", TopGameRelease= " + topGameRelease + ", and Top Game Price= " + topGamePrice);
        LoggerTest.log(Level.INFO, "11th test is starting: go to Top game name page");
        ts.clickTopGame();//шаг11
        Assert.assertTrue(tg.topGamePageFlag(), "Verification Failed: Top game page is not open");
        Assert.assertTrue(topGameName.equals(tg.getHubGameName()), "Verification Failed: Top game page is not open, as the name inside game's page does not match with the name in Topsellers page");
        Assert.assertTrue(topGameRelease.equals(tg.getReleaseDate2()), "Verification Failed: Top game page is not open, as the date of release inside game's page does not match with the name in Topsellers page");
        Assert.assertTrue(topGamePrice.equals(tg.getGamePrice()), "Verification Failed: Top game page is not open, as the game price inside game's page does not match with the price in Topsellers page");
        LoggerTest.log(Level.INFO, "11th test is starting: top game name is " + tg.getHubGameName() + " with date release2 => " + tg.getReleaseDate2() + "and price => " + tg.getGamePrice());

    }
}

