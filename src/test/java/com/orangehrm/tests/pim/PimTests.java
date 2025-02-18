package com.orangehrm.tests.pim;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.MasterPage;
import com.orangehrm.pages.PimPage;
import com.orangehrm.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.orangehrm.pages.MasterPage.delay;

public class PimTests extends BaseTest {

    @Test(priority = 1)
    //Verify successful navigation on PIM page, tab Employee List.
    public void navigateToPimPage() {
        DashboardPage dashboard = loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
        PimPage pim = dashboard.goToPimPage();
        Assert.assertEquals(pim.getPimPageHeader(),"PIM");
        Assert.assertEquals(pim.getPimPageTitle(),"Employee Information");
        Assert.assertTrue(pim.isEmployeeListHeaderButtonDisplayed());
        Assert.assertTrue(pim.isAddEmployeeHeaderButtonDisplayed());
        Assert.assertTrue(pim.isReportsHeaderButtonDisplayed());
        Assert.assertTrue(pim.isResetButtonDisplayed());
        Assert.assertTrue(pim.isSearchButtonDisplayed());
        Assert.assertTrue(pim.isAddButtonDisplayed());
    }

    @Test(priority = 2)
    //Verify the error message when trying to add a new user with missing first name.
    public void addEmployeeTestErrorMessageMissingFirstName() {
        DashboardPage dashboard = loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
        PimPage pim = dashboard.goToPimPage();
        pim.clickAddEmployeeButton();
        pim.enterEmployeeLastNameField("Popescu");
        pim.clickAddEmployeeSaveButton();
        Assert.assertEquals(pim.getMissingFirstNameErrorMessage(),"Required");
    }

    @Test(priority = 3)
    //Verify the error message when trying to add a new user with missing last name.
    public void addEmployeeTestErrorMessageMissingLastName() {
        DashboardPage dashboard = loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
        PimPage pim = dashboard.goToPimPage();
        pim.clickAddEmployeeButton();
        pim.enterEmployeeFirstNameField("Gigi");
        pim.clickAddEmployeeSaveButton();
        Assert.assertEquals(pim.getMissingLastNameErrorMessage(),"Required");
    }

    @Test(priority = 4)
    //Verify successful creation of new employee without login details
    public void addEmployeeWithoutLoginDetails() {
        DashboardPage dashboard = loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
        PimPage pim = dashboard.goToPimPage();
        pim.clickAddEmployeeButton();
        Assert.assertEquals(pim.getAddEmployeeTabTitle(),"Add Employee");
        pim.enterEmployeeFirstNameField("DavaFirst");
        pim.enterEmployeeLastNameField("DavaLast");
        pim.clickAddEmployeeSaveButton();
        Assert.assertTrue(pim.isPersonalDetailsTabTitleDisplayed());
        Assert.assertEquals(pim.getPersonalDetailsTabTitle(),"DavaFirst DavaLast");
        Assert.assertEquals(pim.getPersonalDetailsTabHeader(),"Personal Details");
        Assert.assertEquals(pim.getPersonalDetailsTabFirstNameField(),"DavaFirst");
        Assert.assertEquals(pim.getPersonalDetailsTabLastNameField(),"DavaLast");
        delay(5000);
        pim.clickSaveButton();
        pim.clickEmployeeListHeaderButton();
        pim.clickEmployeeNameField();
        pim.enterEmployeeNameField("Dava");
        delay(5000);
        pim.clickSearchButton();
        pim.clickInEmployeesList(0);
    }
}
