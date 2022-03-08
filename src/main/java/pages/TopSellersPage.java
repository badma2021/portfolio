package pages;

import elements.TextField;
import org.apache.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.*;
import util.SupportingReader;

public class TopSellersPage extends BaseForm {

    private final String locatorAnyPrice = "//div[@class='range_display']";
    private final String steamOSCheckboxText = "//div[@data-param='os' and @data-value='linux']//span[contains(@class,'checkbox')]";
    private final String steamOScheckboxChecked = "//div[@data-param='os' and @data-value='linux' and contains(@class,'checked')]";
    private final String cooperativeLAN = "//div[@data-collapse-name='category3']";
    private final String lANCheckbox = "//div[@data-value='48']";
    private final String topGameNameWait = "//div[@id='search_result_container']//a[1]//span";
    private final String locatorSearchActionInput = "//input[@type='text' and @id='TagSuggest']";
    private final String actionCheckbox = "//*[@data-loc='Action']//span[contains(@class,'checkbox')]";
    private final String filterTag = "//a/div[contains(@class, 'responsive_search')]";
    private final String numberOfGames = "//div[@class='search_results_count']";
    private final String topGameNameSearch = "//div[@id='search_result_container']//a[1]//span";
    private final String topGameRelease = "//div[@id='search_result_container']//a/div[2]/div[2]";
    private final String topGamePrice = "//div[@id='search_result_container']//a[2]//preceding::*[4]";

    public TopSellersPage() {
        super(new TextField(By.xpath("//div[@class='range_display']"), "Any price"), "Top Sellers page");
    }

    private Menu m = new Menu();
    private TextField textFieldAnyPrice = new TextField(By.xpath(locatorAnyPrice), "Any price");
    private TextField textFieldSteamOSCheckbox = new TextField(By.xpath(steamOSCheckboxText), "steamOS+Linux checkbox");
    private TextField textFieldSteamOScheckboxChecked = new TextField(By.xpath(steamOScheckboxChecked), "steamOS+Linux checkbox checked");
    private TextField textFieldCooperativeLAN = new TextField(By.xpath(cooperativeLAN), "Narrow by number of players");
    private TextField textFieldlANCheckbox = new TextField(By.xpath(lANCheckbox), "LAN Co-op checkbox");
    private TextField textFieldCooperativeLANchecked = new TextField(By.xpath(lANCheckbox), "LAN Co-op checkbox checked");
    private TextField textFieldInputSearchAction = new TextField(By.xpath(locatorSearchActionInput), "search for more Tags");
    private TextField textFieldActionCheckbox = new TextField(By.xpath(actionCheckbox), "Action checkbox");
    private TextField textFieldNumberOfGames = new TextField(By.xpath(numberOfGames), "Number of games");
    private TextField textFieldFilterTag = new TextField(By.xpath(filterTag), "Filter Tag for counting of number of games");
    private TextField textFieldTopGameNameSearch = new TextField(By.xpath(topGameNameSearch), "Top game name at the top of the list");
    private TextField textFieldTopGameRelease = new TextField(By.xpath(topGameRelease), "Top game release");
    private TextField textFieldTopGamePrice = new TextField(By.xpath(topGamePrice), "Top game price");
    private TextField textFieldTopGameName = new TextField(By.xpath(topGameNameWait), "Top game name textfield for wait");

    public void clickTopSellers() {
        m.clickTextFieldTopSellers();
    }

    public boolean textFieldAnyPriceDisplay() {
        return textFieldAnyPrice.isDisplayed();
    }

    public void clickSteamOSCheckbox() {
        textFieldSteamOSCheckbox.click();
    }

    public boolean textFieldSteamOScheckboxCheckedDisplay() {
        return textFieldSteamOScheckboxChecked.isDisplayed();
    }

    public void clickCooperativeLANElement() {

        textFieldCooperativeLAN.moveTo();
        textFieldCooperativeLAN.click();
    }


    public void clickLANcheckbox() {
        textFieldlANCheckbox.moveTo();
        WaitUtils.getInstance().until(ExpectedConditions.presenceOfElementLocated(By.xpath(topGameNameWait)));
        textFieldlANCheckbox.click();
    }

    public boolean getCooperativeLANChecked() {
        return textFieldCooperativeLANchecked.isDisplayed();
    }

    public void sendKeysSearchActionInput() {
        WaitUtils.getInstance().until(ExpectedConditions.presenceOfElementLocated(By.xpath(topGameNameWait)));
        textFieldInputSearchAction.sendText(SupportingReader.config("test").getString("findActionTag"));
    }

    public void clickActionCheckbox() {
        LoggerTest.log(Level.INFO, "9th test is starting, waiting for Action tag ");
        WaitUtils.getInstance().until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorAnyPrice)));
        LoggerTest.log(Level.INFO, "9th test is starting, clicking on Action checkbox ");
        textFieldActionCheckbox.moveTo();
        textFieldAnyPrice.click();
        textFieldActionCheckbox.click();
        WaitUtils.getInstance().until(ExpectedConditions.presenceOfElementLocated(By.xpath(topGameNameWait)));
    }

    public boolean getActionCheckbox() {
        return textFieldActionCheckbox.isDisplayed();

    }

    public int getNumberOfGames() {
        WaitUtils.getInstance().until(ExpectedConditions.presenceOfElementLocated(By.xpath(topGameNameWait)));
        return Util.cleanText(textFieldNumberOfGames.getText());

    }

    public int getNumberOfFilterGames() {
        WaitUtils.getInstance().until(ExpectedConditions.presenceOfElementLocated(By.xpath(topGameNameWait)));
        return textFieldFilterTag.size();
    }

    public String getTopGameName() {
        return textFieldTopGameNameSearch.getText();
    }

    public String getTopGameRelease() {
        return textFieldTopGameRelease.getText();
    }

    public String getTopGamePrice() {
        return textFieldTopGamePrice.getText();
    }

    public void clickTopGame() {
        textFieldTopGameName.click();
    }
}