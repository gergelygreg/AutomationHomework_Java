package org.selenium.pom.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    private WebDriverWait wait;

    public WaitUtils(WebDriverWait wait) {
        this.wait = wait;
    }


    public void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitAndSendkeys(By element, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(text);
    }

    public void waitAndClick(By locator) {
        wait.until((ExpectedConditions.elementToBeClickable(locator))).click();
    }

    public String waitAndGetText(By element) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
    }

    public void waitAndClearText(By element) {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        e.sendKeys(Keys.CONTROL,"a", Keys.BACK_SPACE); //clearing input field
    }

    public boolean elementIsDisplayed(By locator) {
        boolean value;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            value = true;
        } catch (Exception e) {
            value = false;
        }
        return value;
    }


}
