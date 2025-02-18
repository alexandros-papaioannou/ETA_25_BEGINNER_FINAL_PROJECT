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

    @FindBy(xpath = "//button[@class='oxd-icon-button oxd-main-menu-button']")
    private WebElement sideMenuButton;

    @FindBy(xpath = "//a[@href='/web/index.php/pim/viewPimModule']")
    private WebElement pimButton;

    public String getDashboardHeader() {
        return getTextFromElement(dashboardHeader);
    }

    public boolean isDashboardHeaderDisplayed() {
        return isWebElementDisplayed(dashboardHeader);
    }

    public boolean isSideMenuButtonDisplayed() {
        return isWebElementDisplayed(sideMenuButton);
    }

    public boolean isPimButtonDisplayed() {
        return isWebElementDisplayed(pimButton);
    }

    public String getPimButtonText() {
        return getTextFromElement(pimButton);
    }

    public void clickPimButton() {
        click(pimButton);
    }

    public PimPage goToPimPage() {
        clickPimButton();
        return new PimPage(driver);
    }
}
