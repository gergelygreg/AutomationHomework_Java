package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class OrderHistoryPage extends BasePage {
    private final By headerText = By.xpath("//h1[normalize-space()='Order history']");

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean headerTextValidation(){
        return waitUtil.elementIsDisplayed(headerText);
    }

    public String getOrderReference(){
        String orderReference = driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[1]/a")).getText();
        return orderReference;
    }
}
