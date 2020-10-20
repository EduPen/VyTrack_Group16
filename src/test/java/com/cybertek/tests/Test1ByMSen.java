package com.cybertek.tests;

import com.cybertek.pages.VehicleFuelPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Test1ByMSen extends TestBase {

/*  User Story:
As a truck driver I should be able to access Vehicle Fuel Logs

Acceptance Criterias:

1.Verify that truck driver should be able to see all Vehicles Fuel information on the grid
2.Verify that truck driver should be able to create Vehicles Fuel logs
3.Verify that truck driver should be able to cancel Vehicles Fuel logs
4.Verify that truck driver should be able to delete Vehicles Fuel Logs
5.Verify that truck driver should be able to add attachment to Vehicle Fuel Logs
6.Verify that truck driver should be able to add event to Vehicles Fuel Logs
7.Verify that truck driver should be able to reset the grid by clicking on Grid setting

1 open chrome
2 Open the URL.-->go to qa1.vytrack-->https://qa2.vytrack.com/user/login
3 Enter username and password. -->* login as a truck driver
driver username=User20
driver password=UserUser123

4 Click on "FLEET" then
5 Click on  --> navigate to "FLEET"
6 click on "Vehicles Fuel Logs"
hello
     */


    public void cancelFuelLog() {
        VehicleFuelPage vehicleFuelPage = new VehicleFuelPage();
        String actualResult = vehicleFuelPage.totalRecords.getText();
        System.out.println(actualResult);
        vehicleFuelPage.createVehicleFuelLog.click();
        vehicleFuelPage.Cancel.click();
        String expectedResult = vehicleFuelPage.totalRecords.getText();
        System.out.println(expectedResult);
        Assert.assertEquals(expectedResult, actualResult, "verify that you canceled the fuel log creation");

    }

    @Test
    public void resetFuelLog() {
        VehicleFuelPage vehicleFuelPage = new VehicleFuelPage();
        List<WebElement> listOfGrid = driver.findElements(By.xpath("//tr[@class='grid-header-row']/th/a"));

        String expected = "";
        for (WebElement list : listOfGrid) {

            expected += list.getText() + ",";

        }
        System.out.println("expected = " + expected);

        vehicleFuelPage.gridSettings.click();
        Actions actions = new Actions(driver);
        actions.clickAndHold(vehicleFuelPage.VendorGrid).moveToElement(vehicleFuelPage.idGrid).release(vehicleFuelPage.idGrid).perform();
        vehicleFuelPage.closeGridSetting.click();
        vehicleFuelPage.reset.click();

        List<WebElement> listOfGrid2 = driver.findElements(By.xpath("//tr[@class='grid-header-row']/th/a"));
        String actual = "";
        for (WebElement newlist : listOfGrid2) {

            actual += newlist.getText() + ",";

        }
        System.out.println("actual=" + actual);
        Assert.assertEquals(actual, expected, "verify grid reset");
    }
}
