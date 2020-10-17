package com.cybertek.tests.control;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.FleetPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class firstUserStory1 extends TestBase{

    @Test

    public void LoginTruckDriver() throws InterruptedException {

       /* new LoginPage().loginAsDriver();
        FleetPage fleetPage = new FleetPage();
        fleetPage.waitUntilLoaderScreenDisappear();
        fleetPage.navigateToModule("Fleet", "Vehicles");
        fleetPage.waitUntilLoaderScreenDisappear();*/

        LoginPage loginPage = new LoginPage();

        extentLogger = report.createTest("Wrong Password Test");

        loginPage.usernameInput.sendKeys("user45");

        extentLogger.info("Enter Username: user45");

        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Enter Password: UserUser123");

        loginPage.loginBtn.click();

        extentLogger.info("Click login Button");

        extentLogger.info("Verify Page URL");
        Assert.assertNotEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Login truck driver test is passed");

    }
}
