package com.orangehrm.pages;

import net.bytebuddy.description.type.TypeDescription;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver, this);
    }

    public void waitForElementPresence(WebElement element) {
        wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
    }

    public void waitForTextToBeVisibleInElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(driver -> !element.getText().trim().isEmpty());
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

    public String getTextFromElement(WebElement element)  {
        waitForElementToBeVisible(element);
        return element.getText();
    }

    public boolean isWebElementDisplayed(WebElement element) {
        waitForElementToBeVisible(element);
        return element.isDisplayed();
    }

    public boolean isTextVisibleInWebElement(WebElement element) {
        waitForTextToBeVisibleInElement(element);
        return true;
    }

    public boolean isRadioButtonSelected(WebElement element) {
        return element.isSelected();
    }

    public void clearTextField(WebElement element) {
        waitForElementToBeVisible(element);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.BACK_SPACE);
    }

    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
