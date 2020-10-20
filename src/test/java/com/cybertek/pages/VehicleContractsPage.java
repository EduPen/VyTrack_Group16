package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleContractsPage extends BasePage{

    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubTitle;

    @FindBy(xpath = "//a[@title='Create Vehicle Contract']")
    public WebElement createVehicleContract;

    @FindBy(css = ".fa-chevron-left.hide-text")
    public WebElement turnPageLeftBtn;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement pageInputBtn;

    @FindBy(css = ".fa-chevron-right.hide-text")
    public WebElement turnPageRightBtn;

    @FindBy(css = ".btn-group.open")
    public WebElement viewPerPageInput;

    @FindBy(xpath = "//a[@title='Grid Settings']")
    public WebElement gridSettingsBtn;






}
