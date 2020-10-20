package com.cybertek.tests;

import com.cybertek.pages.LoginPage;
import com.cybertek.pages.VehicleCostPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class testWithDDF extends TestBase {

    @DataProvider
    public Object[][] userData() {

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA2-short");

        String[][] dataArray = qa3short.getDataArrayWithoutFirstRow();

        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void CancelingVehicleCostPage(String username, String password) {
        extentLogger= report.createTest("TC-1 Canceling Vehicle Cost page");
        extentLogger.info("Open Chrome Browser");
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);

        extentLogger.info("Login teh app");
        VehicleCostPage createNewCost = new VehicleCostPage();

        createNewCost.waitUntilLoaderScreenDisappear();
        createNewCost.costPage();
        extentLogger.info("Select the Vehicle Cost in the Fleet module");
        String actualResult = createNewCost.totalRecords.getText();

        createNewCost.CreateVehicleCost.click();
        extentLogger.info("Click the create vehicle cost button");
        BrowserUtils.waitFor(4);
        createNewCost.Cancel.click();
        extentLogger.info("Click the cancel button");
        String expectedResult = createNewCost.totalRecords.getText();

        Assert.assertEquals(expectedResult, actualResult, "verify that you canceled the cost creating");
        extentLogger.info("Verify canceled the cost page");
        extentLogger.pass("PASS");
    }


    @Test(dataProvider = "userData")
    public void AccesingVehicleCostPage(String username, String password) {
        extentLogger= report.createTest("TC-2 Accessing Vehicle Cost page");
        extentLogger.info("Open Chrome Browser");
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);
        extentLogger.info("Login teh app");
        VehicleCostPage createNewCost = new VehicleCostPage();

        createNewCost.waitUntilLoaderScreenDisappear();
        createNewCost.costPage();
        extentLogger.info("Select the Vehicle Cost in the Fleet module");

        String expectedUrl = "https://qa2.vytrack.com/entity/Extend_Entity_VehicleCosts";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl, "Verify that you accessed th cost page");
        extentLogger.info("Verify that successfully accessed the Vehicle Cost Page");
        extentLogger.pass("PASS");
    }

    @Test(dataProvider = "userData")
    public void CreatingVehicleCostPage(String username, String password) {
        extentLogger= report.createTest("TC-3 Creating Vehicle Cost Page");
        extentLogger.info("Open Chrome Browser");
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);
        extentLogger.info("Login teh app");
        VehicleCostPage createNewCost = new VehicleCostPage();

        createNewCost.waitUntilLoaderScreenDisappear();
        createNewCost.costPage();
        extentLogger.info("Select the Vehicle Cost in the Fleet module");
        createNewCost.CreateVehicleCost.click();
        extentLogger.info("Click the create vehicle cost button");
        createNewCost.clickType.click();

        createNewCost.select.click();

        createNewCost.cost.sendKeys("100");

        createNewCost.description.sendKeys("All drivers will get 100% support for the first year");
        extentLogger.info("Fill up the input boxes");
        createNewCost.SaveAndClose.click();
        extentLogger.info("Click the save button");
        BrowserUtils.waitForVisibility(createNewCost.message, 5);

        String actualMessage = createNewCost.message.getText();

        String expectedMessage = "×\n" + "Entity saved";

        Assert.assertEquals(actualMessage, expectedMessage, "Verify that you created the cost");
        extentLogger.info("Verify that the cost created");
        extentLogger.pass("PASS");
    }

    @Test(dataProvider = "userData")
    public void DeletingVehicleCost(String username, String password) {
        extentLogger= report.createTest("TC-4 Deleting Vehicle Cost");
        extentLogger.info("Open Chrome Browser");
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);
        extentLogger.info("Login teh app");
        VehicleCostPage createNewCost = new VehicleCostPage();

        createNewCost.waitUntilLoaderScreenDisappear();
        createNewCost.costPage();
        extentLogger.info("Select the Vehicle Cost in the Fleet module");
        createNewCost.selectedCost.click();
        extentLogger.info("Select an item from costs list and click it");
        BrowserUtils.waitFor(4);

        createNewCost.delete.click();
        extentLogger.info("Click the delete button");
        createNewCost.confirmDelete.click();
        extentLogger.info("Confirm teh delete");
        BrowserUtils.waitForVisibility(createNewCost.message, 5);
        String actualMessage = createNewCost.message.getText();

        String expectedMessage = "×\n" + "Vehicle Costs deleted";

        Assert.assertEquals(actualMessage, expectedMessage, "Verify that you delete the cost");
        extentLogger.info("Verify that the cost deleted");
        extentLogger.pass("PASS");
    }

    @Test(dataProvider = "userData")
    public void EditingTheCost(String username, String password) {
        extentLogger= report.createTest("TC-5 Editing The Cost");
        extentLogger.info("Open Chrome Browser");
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);
        extentLogger.info("Login teh app");

        VehicleCostPage createNewCost = new VehicleCostPage();
        createNewCost.costPage();

        extentLogger.info("Select the Vehicle Cost in the Fleet module");
        createNewCost.selectedCost.click();
        BrowserUtils.waitFor(4);

        extentLogger.info("Select an item from costs list and click it");
        createNewCost.edit.click();
        BrowserUtils.waitFor(4);

        extentLogger.info("Click the edit button");
        createNewCost.clickType.click();

        createNewCost.selectType.click();
        extentLogger.info("Select a cost item from list");

        createNewCost.cost.clear();
        createNewCost.cost.sendKeys("1000");

        createNewCost.description.clear();
        createNewCost.description.sendKeys("You have to allow to change");
        extentLogger.info("fill up some information");

        createNewCost.SaveAndClose.click();
        extentLogger.info("Click the save button");
        BrowserUtils.waitForVisibility(createNewCost.message, 5);
        String actualMessage = createNewCost.message.getText();

        String expectedMessage = "×\n" + "Entity saved";

        Assert.assertEquals(actualMessage, expectedMessage, "Verify that you edit the cost");
        extentLogger.info("Verify that the cost edited");
        extentLogger.pass("PASS");
    }

 @Test(dataProvider = "userData")
  public void AddingAttachmentToCost(String username,String password) {
     extentLogger= report.createTest("TC-6  Adding Attachment To Cost");
     extentLogger.info("Open Chrome Browser");
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);
     extentLogger.info("Login teh app");
        VehicleCostPage createNewCost = new VehicleCostPage();
        createNewCost.costPage();
         extentLogger.info("Select the Vehicle Cost in the Fleet module");

         createNewCost.waitUntilLoaderScreenDisappear();

        BrowserUtils.waitFor(4);
        createNewCost.selectedCost.click();
        extentLogger.info("Select an item from costs list and click it");

        createNewCost.waitUntilLoaderScreenDisappear();
        createNewCost.moreActions.click();
        extentLogger.info("Click the More Action button");

        BrowserUtils.waitFor(5);
        createNewCost.addAttachment.click();
        extentLogger.info("Click the add attachment");
        createNewCost.waitUntilLoaderScreenDisappear();
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/star.png";

        String fullPath = projectPath + "/" + filePath;
        createNewCost.file.sendKeys(fullPath);
        extentLogger.info("star.png added");
        BrowserUtils.waitFor(5);
        createNewCost.submit.click();
     extentLogger.info("Slick submit button");
        BrowserUtils.waitFor(4);
        BrowserUtils.waitForVisibility(createNewCost.message, 5);
        String actualMessage = createNewCost.message.getText();

        String expectedMessage = "×\n" + "Attachment created successfully";

        Assert.assertEquals(actualMessage, expectedMessage, "Verify that you add attachment");

     extentLogger.info("Verify that the attachment added");
     extentLogger.pass("PASS");
    }

    @Test(dataProvider = "userData")
    public void AddingNoteToCost(String username,String password) {
        extentLogger= report.createTest("TC-7 Adding note to the cost");
        extentLogger.info("Open Chrome Browser");
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);
        extentLogger.info("Login teh app");

        VehicleCostPage createNewCost = new VehicleCostPage();
        createNewCost.costPage();
        extentLogger.info("Select the Vehicle Cost in the Fleet module");

        createNewCost.selectedCost.click();
        BrowserUtils.waitFor(4);
        extentLogger.info("Select an item from costs list and click it");

        createNewCost.moreActions.click();
        BrowserUtils.waitFor(4);
        extentLogger.info("Click the More Action button");

        createNewCost.addNote.click();
        extentLogger.info("Click the add note button");
        driver.switchTo().frame(createNewCost.noteFrame);

        BrowserUtils.waitFor(4);
        createNewCost.notepad.sendKeys("This is my first note");
        extentLogger.info("add some note");
        driver.switchTo().parentFrame();

        createNewCost.add.click();
        extentLogger.info("Click the add button");
        BrowserUtils.waitForVisibility(createNewCost.message, 5);
        String actualMessage = createNewCost.message.getText();

        String expectedMessage = "×\n" + "Note saved";

        Assert.assertEquals(actualMessage, expectedMessage, "Verify that you add note");

        extentLogger.info("Verify that the note added");
        extentLogger.pass("PASS");
    }

    @Test(dataProvider = "userData")
    public void AddingEventToCost(String username,String password) {
        extentLogger= report.createTest("TC-8 Adding Event To Cost");
        extentLogger.info("Open Chrome Browser");
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);
        extentLogger.info("Login teh app");

        VehicleCostPage createNewCost = new VehicleCostPage();
        createNewCost.costPage();
        extentLogger.info("Select the Vehicle Cost in the Fleet module");

        createNewCost.selectedCost.click();
        BrowserUtils.waitFor(4);
        extentLogger.info("Select an item from costs list and click it");

        createNewCost.moreActions.click();
        BrowserUtils.waitFor(4);
        extentLogger.info("Click the More Action button");

        createNewCost.AddEvent.click();
        extentLogger.info("Click the add event button");

        createNewCost.eventTitle.sendKeys("Maintenance will be start");

        createNewCost.organizerName.sendKeys("El parterro Jardineria Sl.");

        createNewCost.organizerEmail.sendKeys("jardineria@gmail.com");
        extentLogger.info("Fill up the input boxes");
        createNewCost.submit.click();
        extentLogger.info("Click the save button");
        BrowserUtils.waitForVisibility(createNewCost.message, 5);
        String actualMessage = createNewCost.message.getText();

        String expectedMessage = "×\n" + "Calendar event saved";

        Assert.assertEquals(actualMessage, expectedMessage, "Verify that you add event");
        extentLogger.info("Verify that the event added");
        extentLogger.pass("PASS");
    }

    @Test(dataProvider = "userData")
    public void ResettingTheCostGrid(String username,String password) {
        extentLogger= report.createTest("TC-9 Reseting Cost Grid");
        extentLogger.info("Open Chrome Browser");
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);
        extentLogger.info("Login teh app");

        VehicleCostPage createNewCost = new VehicleCostPage();
        createNewCost.costPage();
        extentLogger.info("Select the Vehicle Cost in the Fleet module");

        List<WebElement> listOfGrid = driver.findElements(By.xpath("//tr[@class='grid-header-row']/th/a"));

        String expected="";
        for (WebElement list : listOfGrid) {

            expected+=list.getText()+" ";

        }
        System.out.println("expected ="+expected);

        createNewCost.GridSetting.click();
        extentLogger.info("Click the grid setting button");
        Actions actions=new Actions(driver);

        actions.clickAndHold(createNewCost.dateGrid).moveToElement(createNewCost.idGrid).release(createNewCost.idGrid).perform();
        extentLogger.info("move to date to id ");
        createNewCost.closeGridSetting.click();
        extentLogger.info("SClose the grid setting");
        createNewCost.reset.click();
        extentLogger.info("Click the reset button");
        List<WebElement> listOfGrid2 = driver.findElements(By.xpath("//tr[@class='grid-header-row']/th/a"));
        String actual="";
        for (WebElement newlist : listOfGrid2) {

            actual+=newlist.getText()+" ";

        }
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected, "verify grid reset");
        extentLogger.info("Verify that the grid is reset");
        extentLogger.pass("PASS");
    }
// github denemesi
}
