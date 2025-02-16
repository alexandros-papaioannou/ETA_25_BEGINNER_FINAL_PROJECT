package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MasterPage {

    protected WebDriver driver;
    private WebDriverWait wait;

    public MasterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void set(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public void click(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    public String getTextFromElement(WebElement element) {
        waitForElementToBeVisible(element);
        return element.getText();
    }

    public boolean isWebElementDisplayed(WebElement element) {
        waitForElementToBeVisible(element);
        return element.isDisplayed();
    }
}
