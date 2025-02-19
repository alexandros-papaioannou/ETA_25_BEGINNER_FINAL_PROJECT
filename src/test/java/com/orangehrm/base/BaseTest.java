package com.orangehrm.base;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PimPage;
import com.orangehrm.utils.ConfigReader;
import com.orangehrm.utils.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected PimPage pimPage;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverManager.getDriver();
        driver.get(ConfigReader.getProperty("baseURL"));
        loginPage = new LoginPage(driver);
        pimPage = new PimPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverManager.closeDriver();
    }
}
