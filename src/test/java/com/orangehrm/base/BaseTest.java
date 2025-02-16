package com.orangehrm.base;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ConfigReader;
import com.orangehrm.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = WebDriverManager.getDriver();
        driver.get(ConfigReader.getProperty("baseURL"));
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.closeDriver();
    }
}
