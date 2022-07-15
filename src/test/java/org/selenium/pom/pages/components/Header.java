package org.selenium.pom.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.pages.SignInPage;
import org.selenium.pom.utils.WaitUtils;

public class Header extends BasePage {
    private final By signInBtn = By.xpath("//a[@class='login']");
    public Header(WebDriver driver) {
        super(driver);
    }

    public SignInPage clickOnSignIn(){
        waitUtil.waitAndClick(signInBtn);
        return new SignInPage(driver);
    }

}
