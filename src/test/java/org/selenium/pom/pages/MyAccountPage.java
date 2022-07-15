package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class MyAccountPage extends BasePage {
    private final By pageHeading = By.xpath("//h1[normalize-space()='My account']");
    private final By signOutBtn = By.xpath("//a[@title='Log me out']");
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean pageHeadingIsVisible(){
       return waitUtil.elementIsDisplayed(pageHeading);
    }

    public boolean signOutBtnIsVisible(){
        return waitUtil.elementIsDisplayed(signOutBtn);
    }
}
