package com.orangehrm.tests.pim;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashboardPage;
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
        Assert.assertEquals(pim.getPimPageHeader(), "PIM");
        Assert.assertEquals(pim.getPimPageTitle(), "Employee Information");
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
        Assert.assertEquals(pim.getMissingFirstNameErrorMessage(), "Required");
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
        Assert.assertEquals(pim.getMissingLastNameErrorMessage(), "Required");
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
        Assert.assertEquals(pim.getAddEmployeeTabTitle(), "Add Employee");
        pim.enterEmployeeFirstNameField("Bartholomew");
        pim.enterEmployeeLastNameField("Chamberlain");
        pim.clickAddEmployeeSaveButton();
        Assert.assertTrue(pim.isPersonalDetailsTabTitleDisplayed());
        Assert.assertEquals(pim.getPersonalDetailsTabTitle(), "Bartholomew Chamberlain");
        Assert.assertEquals(pim.getPersonalDetailsTabHeader(), "Personal Details");
        Assert.assertEquals(pim.getPersonalDetailsTabFirstNameField(), "Bartholomew");
        Assert.assertEquals(pim.getPersonalDetailsTabLastNameField(), "Chamberlain");
        delay(5000);
        pim.clickSaveButton();
        pim.clickEmployeeListHeaderButton();
        pim.clickEmployeeNameField();
        pim.enterEmployeeNameField("Bartholomew");
        delay(5000);
        pim.clickSearchButton();
        pim.clickInEmployeesList(0);
        delay(5000);
        Assert.assertTrue(pim.isPersonalDetailsTabTitleDisplayed());
        Assert.assertEquals(pim.getPersonalDetailsTabTitle(), "Bartholomew Chamberlain");
        Assert.assertEquals(pim.getPersonalDetailsTabHeader(), "Personal Details");
        Assert.assertEquals(pim.getPersonalDetailsTabFirstNameField(), "Bartholomew");
        Assert.assertEquals(pim.getPersonalDetailsTabLastNameField(), "Chamberlain");
    }

    @Test(priority = 5)
    //Verify successful creation of a new employee with user details: username and password.
    public void addEmployeeWithLoginDetails() {
        DashboardPage dashboard = loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
        PimPage pim = dashboard.goToPimPage();
        pim.clickAddEmployeeButton();
        Assert.assertEquals(pim.getAddEmployeeTabTitle(), "Add Employee");
        pim.enterEmployeeFirstNameField("Maximiliana");
        pim.enterEmployeeLastNameField("Featherstonehaugh");
        pim.clickCreateLoginDetailsSwitchButton();
        pim.enterUniqueUserName(pim.generateUniqueUsername("Maximiliana", "Featherstonehaugh"));
        pim.clickDisabledRadioButton();
        pim.clickEnabledRadioButton();
        pim.enterPassWordField("Pass1234!");
        pim.enterConfirmPassWordField("Pass1234!");
        pim.clickAddEmployeeSaveButton();
        delay(5000);
        Assert.assertTrue(pim.isPersonalDetailsTabTitleDisplayed());
        Assert.assertEquals(pim.getPersonalDetailsTabTitle(), "Maximiliana Featherstonehaugh");
        Assert.assertEquals(pim.getPersonalDetailsTabHeader(), "Personal Details");
        Assert.assertEquals(pim.getPersonalDetailsTabFirstNameField(), "Maximiliana");
        Assert.assertEquals(pim.getPersonalDetailsTabLastNameField(), "Featherstonehaugh");
    }

    @Test(priority = 6)
    //Create a new employee, search it, modify it, search it again and validate changes.
    public void createAndEditEmployee() {
        DashboardPage dashboard = loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
        PimPage pim = dashboard.goToPimPage();
        pim.clickAddEmployeeButton();
        Assert.assertEquals(pim.getAddEmployeeTabTitle(), "Add Employee");
        pim.enterEmployeeFirstNameField("Montgomery");
        pim.enterEmployeeLastNameField("Vanderhoeven");
        pim.clickAddEmployeeSaveButton();
        Assert.assertTrue(pim.isPersonalDetailsTabTitleDisplayed());
        Assert.assertEquals(pim.getPersonalDetailsTabTitle(), "Montgomery Vanderhoeven");
        Assert.assertEquals(pim.getPersonalDetailsTabHeader(), "Personal Details");
        Assert.assertEquals(pim.getPersonalDetailsTabFirstNameField(), "Montgomery");
        Assert.assertEquals(pim.getPersonalDetailsTabLastNameField(), "Vanderhoeven");
        delay(5000);
        pim.clickSaveButton();
        pim.clickEmployeeListHeaderButton();
        pim.clickEmployeeNameField();
        pim.enterEmployeeNameField("Montgomery");
        delay(5000);
        pim.clickSearchButton();
        pim.clickInEmployeesList(0);
        delay(5000);
        pim.enterPersonalDetailsTabDriverLicenseNumberField("AAA1234");
        pim.enterPersonalDetailsTabLicenseExpiryDateField("2028-15-05");
        pim.clickPersonalDetailsTabNationalityDropDown();
        pim.clickRomanianNationalityPersonalDetailsTab();
        pim.enterPersonalDetailsTabDateOfBirthField("1984-13-07");
        pim.clickPersonalDetailsTabMaritalStatusDropDown();
        pim.clickSingleMaritalStatusPersonalDetailsTab();
        pim.clickPersonalDetailsTabGenderMaleRadioButton();
        pim.clickAddEmployeeSaveButton();
        delay(5000);
        Assert.assertTrue(pim.isPersonalDetailsTabTitleDisplayed());
        Assert.assertEquals(pim.getPersonalDetailsTabTitle(), "Montgomery Vanderhoeven");
        Assert.assertEquals(pim.getPersonalDetailsTabHeader(), "Personal Details");
        Assert.assertEquals(pim.getPersonalDetailsTabFirstNameField(), "Montgomery");
        Assert.assertEquals(pim.getPersonalDetailsTabLastNameField(), "Vanderhoeven");
        Assert.assertEquals(pim.getPersonalDetailsTabDriverLicenseNumberField(), "AAA1234");
        Assert.assertEquals(pim.getPersonalDetailsTabLicenseExpiryDateField(), "2028-15-05");
        Assert.assertEquals(pim.getPersonalDetailsTabNationalityDropDown(), "Romanian");
        Assert.assertEquals(pim.getPersonalDetailsTabMaritalStatusDropDown(), "Single");
        Assert.assertEquals(pim.getPersonalDetailsTabDateOfBirthField(), "1984-13-07");
        Assert.assertTrue(pim.isMaleRadioButtonSelected());
    }

    @Test (priority = 7)
    //Create a new employee, search it and delete it.
    public void createDeleteEmployee() {
        DashboardPage dashboard = loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
        PimPage pim = dashboard.goToPimPage();
        pim.clickAddEmployeeButton();
        Assert.assertEquals(pim.getAddEmployeeTabTitle(), "Add Employee");
        pim.enterEmployeeFirstNameField("Valerianetta");
        pim.enterEmployeeLastNameField("Abernathington");
        pim.clickAddEmployeeSaveButton();
        delay(5000);
        Assert.assertTrue(pim.isPersonalDetailsTabTitleDisplayed());
        Assert.assertEquals(pim.getPersonalDetailsTabTitle(), "Valerianetta Abernathington");
        Assert.assertEquals(pim.getPersonalDetailsTabHeader(), "Personal Details");
        Assert.assertEquals(pim.getPersonalDetailsTabFirstNameField(), "Valerianetta");
        Assert.assertEquals(pim.getPersonalDetailsTabLastNameField(), "Abernathington");
        delay(5000);
        pim.clickSaveButton();
        pim.clickEmployeeListHeaderButton();
        pim.clickEmployeeNameField();
        pim.enterEmployeeNameField("Valerianetta");
        delay(5000);
        pim.clickSearchButton();
        delay(5000);
        Assert.assertEquals(pim.getSearchResultsMessage(),"(1) Record Found");
        pim.clickDeleteButton(0);
        Assert.assertEquals(pim.getConfirmDeleteModalPageTitle(),"Are you Sure?");
        Assert.assertEquals(pim.getConfirmDeleteModalPageMessage(),"The selected record will be permanently deleted. Are you sure you want to continue?");
        pim.clickConfirmDeleteButton();
        pim.clearEmployeeNameSearchField();
        pim.enterEmployeeNameField("Valerianetta");
        pim.clickSearchButton();
        Assert.assertEquals(pim.getSearchResultsMessage(),"No Records Found");
    }
}
