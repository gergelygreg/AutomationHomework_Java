package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.pom.base.BasePage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderConformationPage extends BasePage {
    private final By headerText = By.xpath("//h1[normalize-space()='Order confirmation']");
    private final By backToOrders = By.xpath("//a[normalize-space()='Back to orders']");

    public OrderConformationPage(WebDriver driver) {
        super(driver);
    }

    public boolean headerTextValidation(){
        return waitUtil.elementIsDisplayed(headerText);
    }

    public String getOrderReference(int indexBegin, int indexEnd){
        String orderReferenceString = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div")).getText();
        String orderReferenceStringSub = orderReferenceString.substring(indexBegin, indexEnd);
        return orderReferenceStringSub;
    }

    public OrderConformationPage backToOrders(){
        waitUtil.waitAndClick(backToOrders);
        return this;
    }
}
