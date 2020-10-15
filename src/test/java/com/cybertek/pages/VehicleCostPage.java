package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleCostPage extends BasePage {


    @FindBy(xpath = "//a[@title='Create Vehicle Costs']")
    public WebElement CreateVehicleCost;

    @FindBy(xpath = "//a[@title='Grid Settings']")
    public WebElement GridSetting;

    @FindBy(xpath = "//a[@title='Reset']")
    public WebElement reset;

    @FindBy(xpath = "//div/button[@type='submit']")
    public WebElement SaveAndClose;

    @FindBy(xpath = "//a[@title='Cancel']")
    public WebElement Cancel;

    @FindBy(xpath = "//a[@title='Edit Vehicle Costs']")
    public WebElement edit;

    @FindBy(xpath = "//a[@title='Delete Vehicle Costs']")
    public WebElement delete;

    @FindBy(xpath = "//a[.='Yes, Delete']")
    public WebElement confirmDelete;

    @FindBy(xpath = "//a[@class='btn dropdown-toggle']")
    public WebElement moreActions;

    @FindBy(xpath = "//a[@title='Add attachment']")
    public WebElement addAttachment;

    @FindBy(xpath = "//a[@title='Add note']")
    public WebElement addNote;

    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement AddEvent;

    @FindBy(xpath = "//label[@class='dib'][3]")
    public WebElement totalRecords;

    @FindBy(name = "custom_entity_type[TotalPrice]")
    public WebElement cost;

    @FindBy(xpath = "//select/option[4]")
    public WebElement select;

    @FindBy(xpath = "//div[@class='flash-messages-holder']")
    public WebElement message;

    @FindBy(xpath = "//button[.='Add']")
    public WebElement add;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement file;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//input[@name='oro_calendar_event_form[title]']")
    public WebElement eventTitle;

    @FindBy(xpath = "//input[@name='oro_calendar_event_form[organizerDisplayName]']")
    public WebElement organizerName;

    @FindBy(xpath = "//input[@name='oro_calendar_event_form[organizerEmail]']")
    public WebElement organizerEmail;

    @FindBy(css = ".select2-choice")
    public WebElement clickType;

    @FindBy(css = ".select2-results>li")
    public WebElement selectType;

    @FindBy(xpath = "//textarea")
    public WebElement description;

    @FindBy(xpath = "//tr[@class='grid-row row-click-action'][2]")
    public WebElement selectedCost;

    @FindBy(xpath = "//span[@class='close']")
    public WebElement closeGridSetting;

    @FindBy(xpath = "(//td[@class='sort-cell'])[1]")
    public WebElement idGrid;

    @FindBy(xpath = "(//td[@class='sort-cell'])[4]")
    public WebElement dateGrid;

    @FindBy(xpath = "//*[@id=\"tinymce\"]")
    public WebElement notepad;

    @FindBy(xpath = "//iframe")
    public WebElement noteFrame;


    public void costPage(){

        VehicleCostPage costPage = new VehicleCostPage();
        costPage.navigateToModule("Fleet", "Vehicle Costs");
        BrowserUtils.waitFor(5);
    }

}
