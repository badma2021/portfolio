package Pages;

import Elements.Select;
import Elements.TextField;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DatePickerPage extends BaseForm {

    private final String locatorDateInput1 = "//*[@id='datePickerMonthYearInput']";
    private final String locatorDateInput2 = "//*[@id='dateAndTimePickerInput']";
    private final String locator29number = "//*[@role='listbox']/div/div[contains(@aria-label,'February 29th')]";
    private final String locatorSelectYear = "//select[contains(@class,'year')]";
    private final String locatorSelectMonth = "//select[contains(@class,'month')]";
    private final String locatorDatePickers = "//*[@id='item-2']/span[contains(text(),'Picker')]";

    public DatePickerPage() {
        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Picker')]"), "Main header of Date Pickers page"), "Date Pickers page");
    }

    private TextField tfDateInput1 = new TextField(By.xpath(locatorDateInput1), "First textfield for date input");
    private TextField tfDateInput2 = new TextField(By.xpath(locatorDateInput2), "Second textfield for date input");
    private Select sYear = new Select(By.xpath(locatorSelectYear), "Year tick");
    private Select sMonth = new Select(By.xpath(locatorSelectMonth), "Month tick");
    private TextField tflocator29number = new TextField(By.xpath(locator29number), " 29 day of month");
    private MenuForm mf = new MenuForm();

    public String getInputFirstDate1() {
        return tfDateInput1.getAttribute();

    }

    public void clickInputFirstDate1() {
        mf.moveToDatePickers();
        tfDateInput1.click();

    }

    public String getInputFirstDate2() {
        return tfDateInput2.getAttribute();

    }

    public void clickSelectYear() {
        sYear.moveTo();
        sYear.click();
    }

    public void clickSelectMonth() {
        sMonth.click();
    }

    public void selectYear(String s) {
        sYear.selectByValue(s);
    }

    public void selectMonth(String s) {
        sMonth.selectByValue(s);
    }

    public void clicktf29number() {
        mf.moveToDatePickers();
        tflocator29number.click();
    }
}

