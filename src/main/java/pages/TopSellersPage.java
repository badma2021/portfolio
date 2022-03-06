package pages;

import elements.BaseElement;
import elements.TextField;
import org.openqa.selenium.By;

public class TopSellersPage extends BaseForm {

    private final String locatorMovetoAlertsFrameWindows = "//div[@class='card-body']/h5[contains(text(),'Alert')]";
    private final String locatorElements = "//div[@class='card mt-4 top-card'][1]";
    private final String locatorAnyPrice = "//div[@class='range_display']";

    public TopSellersPage() {
        super(new TextField(By.xpath("//div[@class='range_display']"), "Any price"), "Top Sellers page");
    }

    private Menu m = new Menu();
    private TextField textFieldAnyPrice = new TextField(By.xpath(locatorAnyPrice), "Any price");

    public void clickTopSellers() {
        m.clickTextFieldTopSellers();
    }
        public boolean textFieldAnyPriceDisplay() {
            return textFieldAnyPrice.isDisplayed();


    }
}
