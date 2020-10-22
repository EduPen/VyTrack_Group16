package com.cybertek.tests;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.pages.VehicleContractsPage;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VehicleContractsPageHulya extends TestBase {

    /**
     * Test case
     * Open Chrome browser
     * Login as Salesmanager
     * Go to Fleet -> Contract page
     * verify that sales manager can see  "All Vehicle Contract"
     */

    @Test
    public void salesManagerSeeContractPage(){

        LoginPage loginPage=new LoginPage();

        loginPage.loginAsSalesManager();

        DashboardPage dashboardPage=new DashboardPage();

        dashboardPage.navigateToModule("Fleet","Vehicle Contracts");

        VehicleContractsPage vehicleContractsPage=new VehicleContractsPage();

        String actualTitle= vehicleContractsPage.getPageSubTitle();
        String expectedTitle="All Vehicle Contract";

        Assert.assertEquals(actualTitle,expectedTitle,"verify equals");

        //




    }


    /**
     * Test case
     * Open Chrome browser
     * Login as Salesmanager
     * Go to Fleet -> Contract page
     * verify that store manager manager can see  "All Vehicle Contract"
     */


    @Test
    public void storeManagerSeeContractPage(){

        LoginPage loginPage=new LoginPage();

        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage=new DashboardPage();

        dashboardPage.navigateToModule("Fleet","Vehicle Contracts");

        VehicleContractsPage vehicleContractsPage=new VehicleContractsPage();

        String actualTitle= vehicleContractsPage.getPageSubTitle();
        String expectedTitle="All Vehicle Contract";

        Assert.assertEquals(actualTitle,expectedTitle,"verify equals");


    }

    /**
     * Test case
     * Open Chrome browser
     * Login as truck driver
     * Go to Fleet -> Contract page
     * verify that title of the page not changing
     */

    @Test
    public void driverCannotSeeContractPage(){


        LoginPage loginPage=new LoginPage();

        loginPage.loginAsDriver();

        DashboardPage dashboardPage=new DashboardPage();

        dashboardPage.navigateToModule("Fleet","Vehicle Contracts");


        String actualTitle= Driver.get().getTitle();
        String expectedTitle="Dashboard";

        Assert.assertEquals(actualTitle,expectedTitle,"verify equals");




    }

}
