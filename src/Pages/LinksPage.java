package Pages;

import Elements.TextField;
import Pages.BaseForm;
import org.openqa.selenium.By;

public class LinksPage extends BaseForm {


    public LinksPage( String name) {
        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Links')]"), name), name);
    }

    private String locatortfLinksPageHeader = "//div[@class='main-header'][contains(text(),'Links')]";
    TextField tfLinksPageHeader = new TextField(By.xpath(locatortfLinksPageHeader), "Main header of Links page");

    public boolean appearTfLinksPage()  {
        return tfLinksPageHeader.isDisplayed();

    }

}
