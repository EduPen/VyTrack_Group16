package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FleetPage extends BasePage{


    public FleetPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(className = "title title-level-1")
    public WebElement fleetPage;

    @FindBy(xpath = "(//div[@class='message'])[2]")
    public WebElement warningmessagetoStoreManager;
}
