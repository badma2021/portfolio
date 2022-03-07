package pages;

import elements.BaseElement;
import elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.*;
import util.SupportingReader;

import java.io.IOException;

public class TopSellersPage extends BaseForm {

    private final String locatorMovetoAlertsFrameWindows = "//div[@class='card-body']/h5[contains(text(),'Alert')]";
    private final String locatorElements = "//div[@class='card mt-4 top-card'][1]";
    private final String locatorAnyPrice = "//div[@class='range_display']";
    private final String steamOSCheckboxText = "//div[@data-param='os' and @data-value='linux']//span[contains(@class,'checkbox')]";
    private final String steamOScheckboxChecked = "//div[@data-param='os' and @data-value='linux' and contains(@class,'checked')]";
    private final String cooperativeLAN = "//div[@data-collapse-name='category3']";
    private final String lANCheckbox = "//div[@data-value='48']";
    private final String topGameName = "//div[@id='search_result_container']//a[1]//span";
    private final String cooperativeLANchecked = "//div[@data-param='category3' and @data-value='48' and contains(@class,'checked')]";
    private final String locatorSearchActionInput = "//input[@type='text' and @id='TagSuggest']";
    private final String firstGenre = "//*[@id='TagFilter_Container']/div[1]/span[1]";
    private final String actionCheckbox = "//*[@data-loc='Action']//span[contains(@class,'checkbox')]";
    private final String filterTag = "//a/div[contains(@class, 'responsive_search')]";
    private final String tsNumberOfGames = "//div[@class='search_results_count']";

    public TopSellersPage() {
        super(new TextField(By.xpath("//div[@class='range_display']"), "Any price"), "Top Sellers page");
    }

    private Menu m = new Menu();
    private TextField textFieldAnyPrice = new TextField(By.xpath(locatorAnyPrice), "Any price");
    private TextField textFieldSteamOSCheckbox = new TextField(By.xpath(steamOSCheckboxText), "steamOS+Linux checkbox");
    private TextField textFieldSteamOScheckboxChecked = new TextField(By.xpath(steamOScheckboxChecked), "steamOS+Linux checkbox");
    private TextField textFieldCooperativeLAN = new TextField(By.xpath(cooperativeLAN), "steamOS+Linux checkbox");
    private TextField textFieldlANCheckbox = new TextField(By.xpath(lANCheckbox), "LAN Co-op checkbox");
    private TextField textFieldCooperativeLANchecked = new TextField(By.xpath(lANCheckbox), "LAN Co-op checkbox checked");
    private TextField textFieldInputSearchAction = new TextField(By.xpath(locatorSearchActionInput), "search for more Tags");
    private TextField textFieldActionCheckbox = new TextField(By.xpath(actionCheckbox), "Action");
    private TextField textFieldtsNumberOfGames=new TextField(By.xpath(tsNumberOfGames), "Action");
    private TextField textFieldFilterTag=new TextField(By.xpath(filterTag), "Filter Tag for counting of number of games");


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
        WaitUtils.getInstance().until(ExpectedConditions.presenceOfElementLocated(By.xpath(topGameName)));
        textFieldlANCheckbox.click();
    }

    public boolean getCooperativeLANChecked() {
        return textFieldCooperativeLANchecked.isDisplayed();
    }

    public void sendKeysTsSearchActionInput() {
        WaitUtils.getInstance().until(ExpectedConditions.presenceOfElementLocated(By.xpath(topGameName)));
        textFieldInputSearchAction.sendText(SupportingReader.test().getString("findActionTag"));
    }

    public void clickActionCheckbox() {
        WaitUtils.getInstance().until(ExpectedConditions.presenceOfElementLocated(By.xpath(firstGenre)));
        textFieldActionCheckbox.click();
    }
    public boolean getActionCheckbox() {
        return textFieldActionCheckbox.isDisplayed();

    }
    public int getTsNumberOfGames() {
        WaitUtils.getInstance().until(ExpectedConditions.presenceOfElementLocated(By.xpath(topGameName)));
        return Util.cleanText(textFieldtsNumberOfGames.getText());

    }
    public int getNumberOfFilterGames() {
        WaitUtils.getInstance().until(ExpectedConditions.presenceOfElementLocated(By.xpath(topGameName)));
        return textFieldFilterTag.size();
}}