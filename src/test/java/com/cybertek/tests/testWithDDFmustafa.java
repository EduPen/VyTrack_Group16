package com.cybertek.tests;

import com.cybertek.pages.FleetPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testWithDDFmustafa extends TestBase {

    @DataProvider
    public Object[][] userData() {

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA2-short");

        String[][] dataArray = qa3short.getDataArrayWithoutFirstRow();

        return dataArray;
    }


    @Test(dataProvider = "userData")
    public void AccesingVehicleServiceLogsPage(String username, String password) {

        extentLogger = report.createTest("TC-1 Accessing Vehicle Services Logs");

        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);

         extentLogger.info("Open Chrome Browser");

        new LoginPage().loginAsDriver();
        FleetPage fleetPage = new FleetPage();

        fleetPage.waitUntilLoaderScreenDisappear();
        fleetPage.navigateToModule("Fleet","Vehicle Services Logs");
        fleetPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Select the Vehicle Cost in the Fleet module");

        String expectedUrl = "https://qa2.vytrack.com/entity/Extend_Entity_VehicleServicesLogs";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl, "Verify that you accessed th Service Logs page");
        extentLogger.info("Verify that successfully accessed the Vehicle Service Logs Page");
        extentLogger.pass("PASS");
    }
    //2

    @Test(dataProvider = "userData")
    public void Test2 (String username, String password) {
        extentLogger = report.createTest("TC-2 Store Manager");
        extentLogger.info("Open Chrome Browser");

        new LoginPage().loginAsStoreManager();
        FleetPage fleetPage = new FleetPage();
        fleetPage.waitUntilLoaderScreenDisappear();
        fleetPage.navigateToModule("Fleet", "Vehicle Services Logs");
        fleetPage.waitUntilLoaderScreenDisappear();

        Assert.assertEquals(fleetPage.warningmessagetoStoreManager.getText(), "You do not have permission to perform this action.");


        extentLogger.info("Verify Login as Store Manager");
        extentLogger.pass("PASS");
    }

}