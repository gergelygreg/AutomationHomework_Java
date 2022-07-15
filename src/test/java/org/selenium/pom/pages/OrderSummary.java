package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class OrderSummary extends BasePage {
    private final By headerText = By.xpath("//h1[normalize-space()='Order summary']");
    private final By iConfirmMyOrderBtn = By.xpath("//span[normalize-space()='I confirm my order']");

    public OrderSummary(WebDriver driver) {
        super(driver);
    }

    public boolean headerTextValidation(){
        return waitUtil.elementIsDisplayed(headerText);
    }

    public OrderSummary confirmOrder(){
        waitUtil.waitAndClick(iConfirmMyOrderBtn);
        return this;
    }
}
