package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class PimPage extends MasterPage {

    public PimPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    private WebElement pimHeader;

    @FindBy(xpath = "//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")
    private WebElement pimTitle;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item' and contains(text(), 'Employee List')]")
    private WebElement employeeListHeaderButton;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item' and contains(text(), 'Add Employee')]")
    private WebElement addEmployeeHeaderButton;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item' and contains(text(), 'Reports')]")
    private WebElement reportsHeaderButton;

    @FindBy(xpath = "//label[@class='oxd-label' and contains(text(), 'Employee Name')]")
    private WebElement employeeNameLabel;

    @FindBy(xpath = "//label[text()='Employee Name']/following::input[1]")
    private WebElement employeeNameField;

    @FindBy(xpath = "//label[@class='oxd-label' and contains(text(), 'Employee Id')]")
    private WebElement employeeIdLabel;

    @FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
    private WebElement employeeIdField;

    @FindBy(xpath = "//label[@class='oxd-label' and contains(text(), 'Employment Status')]")
    private WebElement employmentStatusLabel;

    @FindBy(xpath = "//label[text()='Employment Status']/following::div[contains(@class, 'oxd-select-text')][1]")
    private WebElement employmentStatusDropDown;

    @FindBy(xpath = "//div[contains(@class,'oxd-select-dropdown')]//div[@role='option' and contains(.,\"-- Select --\")]")
    private WebElement employmentStatusOptionNone;

    @FindBy(xpath = "//div[@role='option']//span[contains(text(),'Freelance')]")
    private WebElement employmentStatusOptionFreeLance;

    @FindBy(xpath = "//div[@role='option']//span[contains(text(),'Full-Time Contract')]")
    private WebElement employmentStatusOptionFullTimeContract;

    @FindBy(xpath = "//div[@role='option']//span[contains(text(),'Full-Time Permanent')]")
    private WebElement employmentStatusOptionFullTimePermanent;

    @FindBy(xpath = "//div[@role='option']//span[contains(text(),'Full-Time Probation')]")
    private WebElement employmentStatusOptionFullTimeProbation;

    @FindBy(xpath = "//div[@role='option']//span[contains(text(),'Part-Time Contract')]")
    private WebElement employmentStatusOptionPartTimeContract;

    @FindBy(xpath = "//div[@role='option']//span[contains(text(),'Part-Time Internship')]")
    private WebElement employmentStatusOptionPartTimeInternShip;

    @FindBy(xpath = "//label[@class='oxd-label' and contains(text(), 'Include')]")
    private WebElement includeLabel;

    @FindBy(xpath = "//label[text()='Include']/following::div[contains(@class, 'oxd-select-text')][1]")
    private WebElement includeDropDown;

    @FindBy(xpath = "//div[@role='option']//span[contains(text(),'Current Employees Only')]")
    private WebElement includeOptionCurrentEmployeesOnly;

    @FindBy(xpath = "//div[@role='option']//span[contains(text(),'Current and Past Employees')]")
    private WebElement includeOptionCurrentAndPastEmployees;

    @FindBy(xpath = "//div[@role='option']//span[contains(text(),'Past Employees Only')]")
    private WebElement includeOptionPastEmployeesOnly;

    @FindBy(xpath = "//label[@class='oxd-label' and contains(text(), 'Supervisor Name')]")
    private WebElement supervisorNameLabel;

    @FindBy(xpath = "//label[text()='Supervisor Name']/following::input[1]")
    private WebElement supervisorNameField;

    @FindBy(xpath = "//label[@class='oxd-label' and contains(text(), 'Job Title')]")
    private WebElement jobTitleLabel;

    @FindBy(xpath = "//label[text()='Job Title']/following::div[contains(@class, 'oxd-select-text')][1]")
    private WebElement jobTitleDropDown;

    @FindBy(xpath = "//div[contains(@class,'oxd-select-dropdown')]//div[@role='option' and contains(.,\"-- Select --\")]")
    private WebElement jobTitleOptionNone;

    @FindBy(xpath = "//div[@role='option']//span[contains(text(),'Automaton Tester')]")
    private WebElement jobTitleAutoTester;

    @FindBy(xpath = "//div[@role='option']//span[contains(text(),'Financial Analyst')]")
    private WebElement jobTitleFinancialAnalyst;

    @FindBy(xpath = "//div[@role='option']//span[contains(text(),'HR Associate')]")
    private WebElement jobTitleHrAssociate;

    @FindBy(xpath = "//label[@class='oxd-label' and contains(text(), 'Sub Unit')]")
    private WebElement subUnitLabel;

    @FindBy(xpath = "//label[text()='Sub Unit']/following::div[contains(@class, 'oxd-select-text')][1]")
    private WebElement subUnitDropDown;

    @FindBy(xpath = "//div[contains(@class,'oxd-select-dropdown')]//div[@role='option' and contains(.,\"-- Select --\")]")
    private WebElement subUnitOptionNone;

    @FindBy(xpath = "//div[@role='option']//span[contains(text(),'OrangeHRM')]")
    private WebElement subUnitOrangeHrmOption;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addEmployeeButton;

    @FindBy(xpath = "//button[@type='reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
    private WebElement addEmployeeTabTitle;

    @FindBy(xpath = "//label[@class='oxd-label oxd-input-field-required']")
    private WebElement employeeFullNameLabel;

    @FindBy(xpath = "//label[@class='oxd-label']")
    private WebElement addNewEmployeeTabIdLabel;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement addEmployeeFirstNameField;

    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement addEmployeeMiddleNameField;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement addEmployeeLastNameField;

    @FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
    private WebElement addEmployeeIdField;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
    private WebElement addEmployeeCancelButton;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    private WebElement addEmployeeSaveButton;

    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit']")
    private WebElement addEmployeePersonalDetailsSaveButton;

    @FindBy(xpath = "//div[@class='orangehrm-custom-fields']//button[@type='submit']")
    private WebElement addEmployeeCustomFieldsSaveButton;

    @FindBy(xpath = "//input[@name='firstName']/parent::div/following-sibling::span")
    private WebElement missingFirstNameErrorMessage;

    @FindBy(xpath = "//input[@name='lastName']/parent::div/following-sibling::span")
    private WebElement missingLastNameErrorMessage;

    @FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
    private WebElement createLoginDetailsSwitchButton;

    @FindBy(xpath = "//h6[text()='Personal Details']")
    private WebElement personalDetailsTabHeader;

    @FindBy(xpath = "//label[@class='oxd-label oxd-input-field-required']")
    private WebElement personalDetailsEmployeeFullNameLabel;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 --strong']")
    private WebElement personalDetailsTabTitle;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement personalDetailsTabFirstNameField;

    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement personalDetailsTabMiddleNameField;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement personalDetailsTabLastNameField;

    @FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div//input")
    private WebElement personalDetailsTabEmployeeIdField;

    @FindBy(xpath = "//label[text()='Other Id']/parent::div/following-sibling::div//input")
    private WebElement personalDetailsTabOtherIdField;

    @FindBy(xpath = "//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div//input")
    private WebElement personalDetailsTabDriverLicenseNumberField;

    @FindBy(xpath = "//label[text()=\"License Expiry Date\"]/parent::div/following-sibling::div//input")
    private WebElement personalDetailsTabLicenseExpiryDateField;

    @FindBy(xpath = "//label[text()=\"Date of Birth\"]/parent::div/following-sibling::div//input")
    private WebElement personalDetailsTabDateOfBirthField;

    @FindBy(xpath = "//label[text()='Male']")
    //@FindBy(xpath = "//input[@type='radio' and contains(@value, '1')]")
    private WebElement personalDetailsTabGenderMaleRadioButton;

    @FindBy(xpath = "//label[normalize-space()='Male']/input[@type='radio']")
    private WebElement maleRadioButton;

    @FindBy(xpath = "//label[text()='Female']")
    private WebElement personalDetailsTabGenderFemaleRadioButton;

    @FindBy(xpath = "//label[text()='Nationality']/following::div[contains(@class, 'oxd-select-text')][1]")
    private WebElement personalDetailsTabNationalityDropDown;

    @FindBy(xpath = "//div[contains(@class,'oxd-select-dropdown')]//span[contains(text(),'Romanian')]")
    private WebElement personalDetailsTabNationalityOptionRomanian;

    @FindBy(xpath = "//label[text()='Marital Status']/following::div[contains(@class, 'oxd-select-text')][1]")
    private WebElement personalDetailsTabMaritalStatusDropDown;

    @FindBy(xpath = "//div[contains(@class,'oxd-select-dropdown')]//span[contains(text(),'Single')]")
    private WebElement personalDetailsTabMaritalStatusOptionSingle;

    @FindBy(xpath = "//div[contains(@class,'oxd-select-dropdown')]//span[contains(text(),'Married')]")
    private WebElement personalDetailsTabMaritalStatusOptionMarried;

    @FindBy(xpath = "//div[contains(@class,'oxd-select-dropdown')]//span[contains(text(),'Other')]")
    private WebElement personalDetailsTabMaritalStatusOptionOther;

    @FindBy(xpath = "//div[contains(@class, 'oxd-table-body')]//div[contains(@class, 'oxd-table-row')]")
    private List<WebElement> employees;

    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    private List<WebElement> deleteButtons;

    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    private WebElement userNameField;

    @FindBy(xpath = "//label[text()='Enabled']")
    private WebElement enabledRadioButton;

    @FindBy(xpath = "//label[text()='Disabled']")
    private WebElement disabledRadioButton;

    @FindBy(xpath = "//label[text()='Password']/following::input[1]")
    private WebElement passWordField;

    @FindBy(xpath = "//label[text()='Confirm Password']/following::input[1]")
    private WebElement confirmPassWordField;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
    private WebElement searchResultsMessage;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--card-title']")
    private WebElement confirmDeleteModalPageTitle;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--card-body']")
    private WebElement confirmDeleteModalPageMessage;

    public String getPimPageHeader() {
        return getTextFromElement(pimHeader);
    }

    public String getPimPageTitle() {
        return getTextFromElement(pimTitle);
    }

    public boolean isEmployeeListHeaderButtonDisplayed() {
        return isWebElementDisplayed(employeeListHeaderButton);
    }

    public boolean isAddEmployeeHeaderButtonDisplayed() {
        return isWebElementDisplayed(addEmployeeHeaderButton);
    }

    public boolean isReportsHeaderButtonDisplayed() {
        return isWebElementDisplayed(reportsHeaderButton);
    }

    public boolean isResetButtonDisplayed() {
        return isWebElementDisplayed(resetButton);
    }

    public boolean isSearchButtonDisplayed() {
        return isWebElementDisplayed(searchButton);
    }

    public boolean isAddButtonDisplayed() {
        return isWebElementDisplayed(addEmployeeButton);
    }

    public void clickAddEmployeeHeaderButton() {
        click(addEmployeeHeaderButton);
    }

    public void clickAddEmployeeButton() {
        click(addEmployeeButton);
    }

    public void clickAddEmployeeSaveButton() {
        click(addEmployeeSaveButton);
    }

    public void clickEmploymentStatusDropDown() {
        click(employmentStatusDropDown);
    }

    public void resetEmploymentStatusDropDown() {
        click(employmentStatusOptionNone);
    }

    public void employFreelance() {
        click(employmentStatusOptionFreeLance);
    }

    public void employFullTimeContract() {
        click(employmentStatusOptionFullTimeContract);
    }

    public void employFullTimePermanent() {
        click(employmentStatusOptionFullTimePermanent);
    }

    public void employFullTimeProbation() {
        click(employmentStatusOptionFullTimeProbation);
    }

    public void employPartTimeContract() {
        click(employmentStatusOptionPartTimeContract);
    }

    public void employPartTimeInternship() {
        click(employmentStatusOptionPartTimeInternShip);
    }

    public void clickIncludeDropDown() {
        click(includeDropDown);
    }

    public void includeCurrentEmployeesOnly() {
        click(includeOptionCurrentEmployeesOnly);
    }

    public void includeCurrentAndPastEmployees() {
        click(includeOptionCurrentAndPastEmployees);
    }

    public void includePastEmployeesOnly() {
        click(includeOptionPastEmployeesOnly);
    }

    public void clickJobTitleDropDown() {
        click(jobTitleDropDown);
    }

    public void resetJobTitleDropDown() {
        click(jobTitleOptionNone);
    }

    public void employAutoTester() {
        click(jobTitleAutoTester);
    }

    public void employFinancialAnalyst() {
        click(jobTitleFinancialAnalyst);
    }

    public void employHrAssociate() {
        click(jobTitleHrAssociate);
    }

    public void clickSubUnitDropDown() {
        click(subUnitDropDown);
    }

    public void resetSubUnitDropDown() {
        click(subUnitOptionNone);
    }

    public void selectSubUnitOptionOrangeHrm() {
        click(subUnitOrangeHrmOption);
    }

    public String getAddEmployeeTabTitle() {
        return getTextFromElement(addEmployeeTabTitle);
    }

    public String getEmployeeFullNameLabel() {
        return getTextFromElement(employeeFullNameLabel);
    }

    public String getAddNewEmployeeTabIdLabel() {
        return getTextFromElement(addNewEmployeeTabIdLabel);
    }

    public void enterEmployeeFirstNameField(String firstName) {
        set(addEmployeeFirstNameField, firstName);
    }

    public void enterEmployeeMiddleNameField(String middleName) {
        set(addEmployeeMiddleNameField, middleName);
    }

    public void enterEmployeeLastNameField(String lastName) {
        set(addEmployeeLastNameField, lastName);
    }

    public void enterEmployeeIdField(String id) {
        set(addEmployeeIdField, id);
    }

    public void clickCancelButton() {
        click(addEmployeeCancelButton);
    }

    public void clickSaveButton() {
        click(addEmployeePersonalDetailsSaveButton);
    }

    public String getMissingFirstNameErrorMessage() {
        return getTextFromElement(missingFirstNameErrorMessage);
    }

    public String getMissingLastNameErrorMessage() {
        return getTextFromElement(missingLastNameErrorMessage);
    }

    public void clickPersonalDetailsTabNationalityDropDown() {
        click(personalDetailsTabNationalityDropDown);
    }

    public String getPersonalDetailsTabNationalityDropDown() {
        return getTextFromElement(personalDetailsTabNationalityDropDown);
    }

    public void clickRomanianNationalityPersonalDetailsTab() {
        click(personalDetailsTabNationalityOptionRomanian);
    }

    public String getPersonalDetailsTabNationality() {
        return getTextFromElement(personalDetailsTabNationalityOptionRomanian);
    }

    public void clickPersonalDetailsTabMaritalStatusDropDown() {
        click(personalDetailsTabMaritalStatusDropDown);
    }

    public String getPersonalDetailsTabMaritalStatusDropDown() {
        return getTextFromElement(personalDetailsTabMaritalStatusDropDown);
    }

    public void clickSingleMaritalStatusPersonalDetailsTab() {
        click(personalDetailsTabMaritalStatusOptionSingle);
    }

    public String getPersonalDetailsTabMaritalStatusOptionSingle() {
        return getTextFromElement(personalDetailsTabMaritalStatusOptionSingle);
    }

    public void clickMarriedMaritalStatusPersonalDetailsTab() {
        click(personalDetailsTabMaritalStatusOptionMarried);
    }

    public String getPersonalDetailsTabMaritalStatusOptionMarried() {
        return getTextFromElement(personalDetailsTabMaritalStatusOptionMarried);
    }

    public void clickOtherMaritalStatusPersonalDetailsTab() {
        click(personalDetailsTabMaritalStatusOptionOther);
    }

    public String getPersonalDetailsTabMaritalStatusOptionOther() {
        return getTextFromElement(personalDetailsTabMaritalStatusOptionOther);
    }

    public String getPersonalDetailsTabHeader() {
        return getTextFromElement(personalDetailsTabHeader);
    }

    public String getPersonalDetailsEmployeeFullNameLabel() {
        return getTextFromElement(personalDetailsEmployeeFullNameLabel);
    }

    public String getPersonalDetailsTabTitle() {
        return getTextFromElement(personalDetailsTabTitle);
    }

    public String getPersonalDetailsTabFirstNameField() {
        return personalDetailsTabFirstNameField.getAttribute("value");
    }

    public String getPersonalDetailsTabMiddleNameField() {
        return getTextFromElement(personalDetailsTabMiddleNameField);
    }

    public String getPersonalDetailsTabLastNameField() {
        return personalDetailsTabLastNameField.getAttribute("value");
        // return getTextFromElement(personalDetailsTabLastNameField);
    }

    public String getPersonalDetailsTabEmployeeIdField() {
        return getTextFromElement(personalDetailsTabEmployeeIdField);
    }

    public String getPersonalDetailsTabOtherIdField() {
        return getTextFromElement(personalDetailsTabOtherIdField);
    }

    public String getPersonalDetailsTabDriverLicenseNumberField() {
        return personalDetailsTabDriverLicenseNumberField.getAttribute("value");
    }

    public String getPersonalDetailsTabLicenseExpiryDateField() {
        return personalDetailsTabLicenseExpiryDateField.getAttribute("value");
    }

    public void enterPersonalDetailsTabLicenseExpiryDateField(String expiry) {
        set(personalDetailsTabLicenseExpiryDateField, expiry);
    }

    public String getPersonalDetailsTabDateOfBirthField() {
        return personalDetailsTabDateOfBirthField.getAttribute("value");
    }

    public boolean isPersonalDetailsTabFirstNameFieldTextDisplayed() {
        return isTextVisibleInWebElement(personalDetailsTabFirstNameField);
    }

    public boolean isPersonalDetailsTabTitleDisplayed() {
        return isTextVisibleInWebElement(personalDetailsTabTitle);
    }

    public void clickEmployeeListHeaderButton() {
        click(employeeListHeaderButton);
    }

    public void clickEmployeeNameField() {
        click(employeeNameField);
    }

    public void enterEmployeeNameField(String name) {
        set(employeeNameField, name);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    public void clickInEmployeesList(int index) {
        click(employees.get(index));
    }

    public void clickDeleteButton(int index) {
        click(deleteButtons.get(index));
    }

    public void clickCreateLoginDetailsSwitchButton() {
        click(createLoginDetailsSwitchButton);
    }

    public void clickUserNameField() {
        click(userNameField);
    }

    public void enterUserNameField(String username) {
        set(userNameField, username);
    }

    public void clickEnabledRadioButton() {
        click(enabledRadioButton);
    }

    public void clickDisabledRadioButton() {
        click(disabledRadioButton);
    }

    public void enterPassWordField(String pass) {
        set(passWordField, pass);
    }

    public void enterConfirmPassWordField(String confPass) {
        set(confirmPassWordField, confPass);
    }

    public String getTextFromUserNameField() {
        return userNameField.getAttribute("value");
    }

    public String generateUniqueUsername(String fName, String lName) {
        Random rand = new Random();
        Integer randomNum = rand.nextInt(9000) + 1000;
        //String baseUserName = "testUser";
        return fName.substring(0, 1) + lName.substring(0, 1) + randomNum.toString();
    }

    public void enterUniqueUserName(String userName) {
        set(userNameField, userName);
    }

    public void enterPersonalDetailsTabDriverLicenseNumberField(String driverLicense) {
        set(personalDetailsTabDriverLicenseNumberField, driverLicense);
    }

    public void enterPersonalDetailsTabDateOfBirthField(String birthDate) {
        set(personalDetailsTabDateOfBirthField, birthDate);
    }

    public void clickPersonalDetailsTabGenderMaleRadioButton() {
        click(personalDetailsTabGenderMaleRadioButton);
    }

    public boolean isPersonalDetailsTabGenderMaleRadioButtonSelected() {
        return isRadioButtonSelected(personalDetailsTabGenderMaleRadioButton);
    }

    public boolean isMaleRadioButtonSelected() {
        return isRadioButtonSelected(maleRadioButton);
    }

    public void clickConfirmDeleteButton() {
        click(confirmDeleteButton);
    }

    public String getSearchResultsMessage() {
        return getTextFromElement(searchResultsMessage);
    }

    public void clearEmployeeNameSearchField() {
        clearTextField(employeeNameField);
    }

    public String getConfirmDeleteModalPageTitle() {
        return getTextFromElement(confirmDeleteModalPageTitle);
    }

    public String getConfirmDeleteModalPageMessage() {
        return getTextFromElement(confirmDeleteModalPageMessage);
    }
}
