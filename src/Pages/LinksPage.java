package Pages;

import Elements.TextField;
import Pages.BaseForm;
import org.openqa.selenium.By;

public class LinksPage extends BaseForm {


    public LinksPage() {
        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Links')]"), "Main header of Links page"), "Links Page");
    }

    private final String locatortfLinksPageHeader = "//div[@class='main-header'][contains(text(),'Links')]";
    private TextField tfLinksPageHeader = new TextField(By.xpath(locatortfLinksPageHeader), "Main header of Links page");

    public boolean appearTfLinksPage()  {
        return tfLinksPageHeader.isDisplayed();

    }

}
