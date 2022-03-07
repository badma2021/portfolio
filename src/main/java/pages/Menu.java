package pages;

import elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        textFieldNewNoteworthy.moveTo();
        WaitUtils.getInstance().until(ExpectedConditions.elementToBeClickable(By.linkText(linkTextNewNoteworthy)));
        textFieldTopSellersPopUp.click();
    }
}