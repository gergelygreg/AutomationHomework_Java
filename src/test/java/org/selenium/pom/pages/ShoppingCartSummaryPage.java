package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class ShoppingCartSummaryPage extends BasePage {
    private final By proceedToCheckOutBtn = By.xpath("(//span[contains(text(),'Proceed to checkout')])[2]");
    private final By headerText = By.xpath("//span[@class='heading-counter']");
    private final By alertWarning = By.xpath("//p[@class='alert alert-warning']");

    public ShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkUnitPrice(String unitPrice){
        return waitUtil.elementIsDisplayed(By.xpath("(//span[@class='price'][normalize-space()='"+unitPrice+"'])[3]"));
    }

    public boolean checkTotalPrice(String totalPrice){
        return waitUtil.elementIsDisplayed(By.xpath("//span[@id='total_price'][normalize-space()='"+totalPrice+"']"));
    }

    public void deleteProduct(String index){
        waitUtil.waitAndClick(By.xpath("(//i[@class='icon-trash'])["+index+"]"));
    }

    public void proceedToCheckOut(){
        waitUtil.waitAndClick(proceedToCheckOutBtn);
    }

    public boolean headerTextValidation(){
        return waitUtil.elementIsDisplayed(headerText);
    }

    public ShoppingCartSummaryPage cartContainsProduct(String productName){
        waitUtil.elementIsDisplayed(By.xpath("//td[@class='cart_description']//a[contains(text(),'"+productName+"')]"));
        return this;
    }

    public String getQuantity(String productNumber){
        return driver.findElement(By.xpath("(//tr[@id='product_"+productNumber+"_0_0'])[1]//input[@type='hidden']")).getAttribute("value");
    }

    public boolean shoppingCartIsEmpty(){
        return waitUtil.elementIsDisplayed(alertWarning);
    }
}
