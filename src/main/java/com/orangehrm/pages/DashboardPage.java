package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends MasterPage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardHeader;

    public String getDashboardHeader() {
        return getTextFromElement(dashboardHeader);
    }

    public boolean isDashboardHeaderDisplayed() {
        return isWebElementDisplayed(dashboardHeader);
    }
}
