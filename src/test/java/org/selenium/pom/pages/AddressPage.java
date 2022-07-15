package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class AddressPage extends BasePage {
    private final By headerText = By.xpath("//h1[normalize-space()='Addresses']");
    private final By proceedToCheckoutBtn = By.xpath("//button[@name='processAddress']");

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public boolean headerTextValidation(){
        return waitUtil.elementIsDisplayed(headerText);
    }

    public AddressPage proceedToCheckout(){
        waitUtil.waitAndClick(proceedToCheckoutBtn);
        return this;
    }
}
