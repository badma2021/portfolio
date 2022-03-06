package pages;

import elements.TextField;
import org.apache.log4j.Level;
import org.openqa.selenium.By;
import util.LoggerTest;
import util.Util;

public class AboutSteamPage extends BaseForm {
    private String aboutTitle = "//div[@class='about_subtitle']";
    private String inGamePlayers = "//div[contains(@class, 'gamers_in')]//parent::*";
    private String outGamePlayers = "//div[contains(@class, 'gamers_on')]//parent::*";
    private String apShopElement = "//div[@class='supernav_container']/a[1]";

    public AboutSteamPage() {
        super(new TextField(By.xpath("//div[@class='about_subtitle']"), "Text under the Steam logo"), "Steam About page");
    }

    private TextField textFieldAboutSteamPageLogo=new TextField(By.xpath(aboutTitle),"ABOUT subtitle");
    private TextField textFieldInGamePlayers=new TextField(By.xpath(inGamePlayers),"ABOUT subtitle");
    private TextField textFieldOutGamePlayers=new TextField(By.xpath(outGamePlayers),"ABOUT subtitle");

    public boolean textFieldAboutSteamPageLogoDisplay(){
        LoggerTest.log(Level.INFO, "2nd test is starting: method textFieldAboutSteamPageLogoDisplay is invoked");
       return textFieldAboutSteamPageLogo.isDisplayed();
    }

    public int getInGamePlayers() {
        return Util.cleanText(textFieldInGamePlayers.getText());
    }

    public int getOutGamePlayers() {
        return Util.cleanText(textFieldOutGamePlayers.getText());
    }
}
