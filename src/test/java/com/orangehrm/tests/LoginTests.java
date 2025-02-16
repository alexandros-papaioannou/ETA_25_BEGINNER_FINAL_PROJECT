package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginSuccessfully() {
        Assert.assertEquals(loginPage.getLoginHeader(), "Login");
        Assert.assertTrue(loginPage.isUserNameFieldDisplayed());
        Assert.assertTrue(loginPage.isPassWordFieldDisplayed());
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
        DashboardPage dashboard = loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        Assert.assertTrue(dashboard.isDashboardHeaderDisplayed());
        Assert.assertEquals(dashboard.getDashboardHeader(),"Dashboard");
    }

    @Test
    public void invalidLogin() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("WrongPassword");
        loginPage.clickLoginButton();

        String expectedErrorMessage = "Invalid credentials";

        Assert.assertEquals(loginPage.getInvalidLoginMessage(),expectedErrorMessage);
    }
}
