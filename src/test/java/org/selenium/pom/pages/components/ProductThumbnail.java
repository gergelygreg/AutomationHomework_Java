package org.selenium.pom.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.pages.CartPage;

public class ProductThumbnail extends BasePage {
    private final By viewCartLink = By.xpath("//a[@title='View my shopping cart']");
    public ProductThumbnail(WebDriver driver) {
        super(driver);
    }





    public CartPage clickViewCart(){
        waitUtil.waitAndClick(viewCartLink);
        return new CartPage(driver);
    }
}
