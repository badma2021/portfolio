package pages;

import elements.BaseElement;
import elements.TextField;
import org.apache.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.LoggerTest;
import util.WaitUtils;

public class TopGamePage extends BaseForm {

    private final String hubGameName = "//div[@id='appHubAppName']";
    //private final String releaseDate = "//div[contains(@class, 'coming')]//h1/span";
    private final String gamePrice = "//div[contains(@class,'purchase_price')]";
    private final String releaseDate2 = "//div[@class = 'date']";


    public TopGamePage() {
        super(new TextField(By.xpath("//div[@id='appHubAppName']"), "Top game name textfield"), "Top game name page");
    }

    private TextField textFieldHubGameName = new TextField(By.xpath(hubGameName), "Top game name textfield");
    //  private TextField textFieldReleaseDate = new TextField(By.xpath(releaseDate), "Release date textfield");
    private TextField textFieldGamePrice = new TextField(By.xpath(gamePrice), "Game price textfield");
    private TextField textFieldReleaseDate2 = new TextField(By.xpath(releaseDate2), "Release date2 textfield");

    public String getHubGameName() {
        return textFieldHubGameName.getText();
    }

    public boolean topGamePageFlag() {
        return textFieldHubGameName.isDisplayed();
    }
//    public String getTgReleaseDate() {
//        return textFieldReleaseDate.getText();
//    }

    public String getGamePrice() {
        LoggerTest.log(Level.INFO, "11th test is starting: getting of price of game " + textFieldGamePrice.getText());
        // WaitUtils.getInstance().until(ExpectedConditions.presenceOfElementLocated(By.xpath(gamePrice)));
        textFieldGamePrice.moveTo();
        return textFieldGamePrice.getText();
    }

    public String getReleaseDate2() {
        LoggerTest.log(Level.INFO, "11th test is starting: getting of date of release" + textFieldReleaseDate2.getText());
        return textFieldReleaseDate2.getText();
    }

}
