package pages;

import elements.TextField;
import org.apache.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.LoggerTest;
import util.WaitUtils;

public class Menu extends BaseForm {
    private final String linkTextNewNoteworthy = "New & Noteworthy";
    private final String topSellersElementText = "//a[@class='popup_menu_item'][contains(@href,'topsellers')]";

    public Menu() {
        super(new TextField(By.xpath("//a[@class='menuitem'][contains(@href,'about')]"), "ABOUT"), "Menu");
    }

    private TextField textFieldAbout = new TextField(By.xpath("//a[@class='menuitem'][contains(@href,'about')]"), "ABOUT");
    private TextField textFieldNewNoteworthy = new TextField(By.linkText(linkTextNewNoteworthy), "New & Noteworthy");
    private TextField textFieldTopSellersPopUp = new TextField(By.xpath(topSellersElementText), "Top Sellers pop-up");

    public void clickTextFieldAbout() {
        textFieldAbout.click();
    }

    public void clickTextFieldTopSellers() {
        WaitUtils.getInstance().until(ExpectedConditions.elementToBeClickable(By.linkText(linkTextNewNoteworthy)));
        LoggerTest.log(Level.INFO, "6th test is starting: getting of price of game moveto ");
        textFieldNewNoteworthy.moveTo();
        LoggerTest.log(Level.INFO, "6th test is starting: getting of price of game wait2 ");
        WaitUtils.getInstance().until(ExpectedConditions.elementToBeClickable(By.linkText(linkTextNewNoteworthy)));
        LoggerTest.log(Level.INFO, "6th test is starting: getting of price of game click ");
        textFieldTopSellersPopUp.click();
    }
}