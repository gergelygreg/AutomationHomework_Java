package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class ShippingPage extends BasePage {
    private final By headerText = By.xpath("//h1[normalize-space()='Shipping']");
    private final By termsOfServiceChx = By.xpath("//div[@id='uniform-cgv']");
    private final By proceedToCheckoutBtn = By.xpath("//button[@name='processCarrier']");

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public boolean headerTextValidation(){
        return waitUtil.elementIsDisplayed(headerText);
    }

    public ShippingPage proceedToCheckout(){
        waitUtil.waitAndClick(proceedToCheckoutBtn);
        return this;
    }

    public ShippingPage acceptTermOfService(){
        waitUtil.waitAndClick(termsOfServiceChx);
        return this;
    }
}
