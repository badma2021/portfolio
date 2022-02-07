import org.openqa.selenium.By;

import java.io.IOException;

public class FramesPage extends BaseForm{
    protected FramesPage(BaseElement uniqueElement, String name) {
        super(uniqueElement, name);
    }

    private String locatorFramesHeader = "//div[@class='main-header'][contains(text(),'Frames')]";



    TextField tFFramesPage = new TextField(By.xpath(locatorFramesHeader), "Main header of Frames page");


    public boolean appearTextFieldFramesPage() throws IOException {
        return tFFramesPage.isDisplayed();

    }
}



