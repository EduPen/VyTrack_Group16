package com.cybertek.pages;


import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {




    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[@class='btn btn-link dropdown-toggle']")
    public static WebElement calendarPageSubtitle;

    @FindBy(xpath = "//input[@class='input-widget']")
    public static WebElement pageNumber;

    @FindBy  (xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement viewPerPage;

    @FindBy(xpath = "/*[@class='pagination pagination-centered']/label[3]")
    public static WebElement numberOfRows;

    @FindBy(xpath = "//thead[@class='grid-header']/tr/th/div/button/input")
    public WebElement checkbox;

    @FindBy(xpath = "//input[@tabindex='-1']")
    public WebElement allEventsChecked;

    @FindBy(xpath = "//td[contains(text(),'Testers meeting')]")
    public WebElement testersMeeting;

    @FindBy(xpath = "//div[contains(text(),'Testers meeting')]")
    public WebElement meetingTitle;
    @FindBy(xpath = "//span[contains(text(),'This is a a weekly testers meeting')]")
    public WebElement meetingDescription;
    @FindBy(xpath = "//div[contains(text(),'Nov 27, 2019, 9:30 PM')]")
    public WebElement meetingStarts;
    @FindBy(xpath = "//div[contains(text(),'Nov 27, 2019, 10:30 PM')]")
    public WebElement meetingEnds;
    @FindBy(xpath = "//*[.='No']")
    public WebElement meetingAllDayEvents;
    @FindBy(css = "[class='calendar-event-organizer']")
    public WebElement organizer;
    @FindBy(css = "[class='user-status-list list-group']>li>span>a")
    public WebElement guests;
    @FindBy(xpath = "//div[contains(text(),'Weekly')]")
    public WebElement recurrence;
    @FindBy(xpath = "(//*[contains(text(),'No')])[6]")
    public WebElement callViaHangout;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> rows;
    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
    public  WebElement next;
    public WebElement getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(WebElement numberOfRows) {
        this.numberOfRows = numberOfRows;
    }
}