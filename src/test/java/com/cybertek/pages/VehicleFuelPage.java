package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleFuelPage extends BasePage {

    public void FuelPage(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        VehicleFuelPage fuelPage = new VehicleFuelPage();
        BrowserUtils.waitFor(4);

        fuelPage.navigateToModule("Fleet","Vehicles Fuel Logs");
        BrowserUtils.waitFor(4);



    }
    @FindBy(xpath = "//a[@class='btn main-group btn-primary pull-right ']")
    public WebElement createVehicleFuelLog;

    @FindBy(xpath = "//a[@title='Grid Settings']")
    public WebElement gridSettings;

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

    @FindBy(xpath = "//input[@type='file']")
    public WebElement file;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//span[@class='close']")
    public WebElement closeGridSetting;

    @FindBy(xpath = "(//td[@class='sort-cell'])[1]")
    public WebElement idGrid;

    @FindBy(xpath = "(//td[@class='sort-cell'])[9]")
    public WebElement VendorGrid;


}
