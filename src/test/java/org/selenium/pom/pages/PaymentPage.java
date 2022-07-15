package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class PaymentPage extends BasePage {
    private final By headerText = By.xpath("//h1[normalize-space()='Please choose your payment method']");
    private final By payByBankWireLink = By.xpath("//a[@title='Pay by bank wire']");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public boolean headerTextValidation(){
        return waitUtil.elementIsDisplayed(headerText);
    }

    public PaymentPage payByBankwire (){
        waitUtil.waitAndClick(payByBankWireLink);
        return this;
    }
}
