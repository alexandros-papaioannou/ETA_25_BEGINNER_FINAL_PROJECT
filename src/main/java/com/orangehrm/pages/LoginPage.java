package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MasterPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//img[@alt='company-branding']")
    private WebElement logo;

    @FindBy(xpath = "//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
    private WebElement loginHeader;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    private WebElement invalidLoginMessage;

    public String getLoginHeader() {
        return getTextFromElement(loginHeader);
    }

    public String getInvalidLoginMessage() {
        return getTextFromElement(invalidLoginMessage);
    }

    public boolean isUserNameFieldDisplayed() {
        return isWebElementDisplayed(usernameField);
    }

    public boolean isPassWordFieldDisplayed() {
        return isWebElementDisplayed(passwordField);
    }

    public boolean isLoginButtonDisplayed() {
        return isWebElementDisplayed(loginButton);
    }

    public void enterUsername(String username) {
        set(usernameField, username);
    }

    public void enterPassword(String password) {
        set(passwordField, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public DashboardPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new DashboardPage(driver);
    }
}
