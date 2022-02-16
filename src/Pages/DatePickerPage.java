package Pages;

import Elements.Select;
import Elements.TextField;
import Utils.ConfigReader;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.List;

public class DatePickerPage extends BaseForm {
    private String locatorDatePicker = "//div[@class='main-header'][contains(text(),'Picker')]";
    private String locatorDateInput1 = "//*[@id='datePickerMonthYearInput']";
    private String locatorDateInput2 = "//*[@id='dateAndTimePickerInput']";
    private String locatorCalendarMonth = "//*[@id='dateAndTimePicker']//span[@class='react-datepicker__month-read-view--selected-month']";
    private String locatorCalendarMonth2 = "//*[@id='dateAndTimePicker']//div[@class='react-datepicker__month']";
    private String locatorCalendarMonth3 = "//div[@class='react-datepicker__month-dropdown']";
    private String locatoranyMonth = "//div[@class='react-datepicker__month-dropdown']//following::*[2]";
    private String locatorCalendarYears="//div[@class='react-datepicker__year-dropdown']";
    private String locator2024Year="//div[@class='react-datepicker__year-dropdown']//following::*[4]";
    private String locatorCalendarYearTriangle="//*[@id='dateAndTimePicker']//span[@class='react-datepicker__year-read-view--selected-year']";
   private String locatorDays ="//*[@role='listbox']";
   private String locator29number="//*[@role='listbox']/div/div[contains(@aria-label,'February 29th')]";

    public DatePickerPage(String name) {
        super(new TextField(By.xpath("//div[@class='main-header'][contains(text(),'Picker')]"), name), name);
    }

    MenuForm mf = new MenuForm("Left hand side base menu");
    TextField tfDatePickers = new TextField(By.xpath(locatorDatePicker), "");
    Actions builder = new Actions(Driver.getInstance());
    TextField tfDateInput1 = new TextField(By.xpath(locatorDateInput1), "First textfield for date input");
    TextField tfInputCalendarMonth = new TextField(By.xpath(locatorCalendarMonth), "Second textfield for date input, Month");
    TextField tfDateInput2 = new TextField(By.xpath(locatorDateInput2), "Second textfield for date input");
    Select tfDateInput3 = new Select(By.xpath(locatorCalendarMonth3), "Month triangle");
    TextField tfAnyMonth = new TextField(By.xpath(locatoranyMonth), "Second textfield for date input");
    TextField tfCalendarYears = new TextField(By.xpath(locatorCalendarYears), "Years drop-down list");
    TextField tflocator2024Year = new TextField(By.xpath(locator2024Year), "2024 year");
    TextField tflocatorCalendarYearTriangle = new TextField(By.xpath(locatorCalendarYearTriangle), " Year triangle");
    TextField tflocator29number = new TextField(By.xpath(locator29number), " 29 day of month");


    public void getInputFirstDate(String key) {
        tfDateInput1.clear();
        tfDateInput1.sendText(key);
    }

    public void selectDate(int month_year) {
        List<WebElement> elements = Driver.getInstance().findElements(By.xpath(locatorDays));

        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i).getText());
            if (elements.get(i).getText().equals(month_year)) {
                elements.get(i).click();

            }
        }
    }

    public void clicktfDateInput2() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorDateInput2));
        builder.moveToElement(element).build().perform();
        tfDateInput2.click();

    }

    public void clicktfDateInput21() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorCalendarMonth));
        builder.moveToElement(element).build().perform();
        tfInputCalendarMonth.click();

    }


    public void clicktfAnyMonth() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatoranyMonth));
        builder.moveToElement(element).build().perform();
        tfAnyMonth.click();

    }
    public void clicktfCalendarYears() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorCalendarYears));
        builder.moveToElement(element).build().perform();
        tfCalendarYears.click();

    }

    public void clicktf2024Year() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locator2024Year));
        builder.moveToElement(element).build().perform();
        tflocator2024Year.click();

    }
    public void clicktfCalendarYearTriangle() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorCalendarYearTriangle));
        builder.moveToElement(element).build().perform();
        tflocatorCalendarYearTriangle.click();

    }
    public void clicktf29number() {
        WebElement element = Driver.getInstance().findElement(By.xpath(locatorCalendarYearTriangle));
        builder.moveToElement(element).build().perform();
        tflocator29number.click();

    }

}

