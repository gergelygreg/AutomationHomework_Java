package org.selenium.pom.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.NewAccount;

import java.time.Duration;
import java.util.List;

public class CreateAnAccountPage extends BasePage {
    private final By firstNameFld = By.xpath("//input[@id='customer_firstname']");
    private final By lastNameFld = By.xpath("//input[@id='customer_lastname']");
    private final By passwordFld = By.xpath("//input[@id='passwd']");
    private final By addressFld = By.xpath("//input[@id='address1']");
    private final By cityFld = By.xpath("//input[@id='city']");
    private final By stateDropDown = By.xpath("//select[@id='id_state']");
    private final By zipFld = By.xpath("//input[@id='postcode']");
    private final By mobilePhoneFld = By.xpath("//input[@id='phone_mobile']");

    private final By registerBtn = By.xpath("//button[@id='submitAccount']");
    private final By alertMessage = By.xpath("//div[@class='alert alert-danger']");

    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }


    public CreateAnAccountPage enterTextToFirstNameFld(String firstName){
        waitUtil.waitAndSendkeys(firstNameFld, firstName);
        return this;
    }

    public CreateAnAccountPage enterTextToLastNameFld(String lastName){
        waitUtil.waitAndSendkeys(lastNameFld, lastName);
        return this;
    }

    public CreateAnAccountPage enterTextToPasswordFld(String password){
        waitUtil.waitAndSendkeys(passwordFld, password);
        return this;
    }

    public CreateAnAccountPage enterTextToAddressFld(String address){
        waitUtil.waitAndSendkeys(addressFld, address);
        return this;
    }

    public CreateAnAccountPage enterTextToCityFld(String city){
        waitUtil.waitAndSendkeys(cityFld, city);
        return this;
    }

    public CreateAnAccountPage selectStateFromList(String state){
        //driver.findElement(By.xpath("//option[text() = '"+state+"']")).click(); NOT WORKING
        //driver.findElement(By.xpath("//select[@id='id_state']")).sendKeys(state); NOT WORKING
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='id_state']"))); //NOT ALWAYS WORKING
        dropdown.selectByVisibleText(state);
        return this;
    }


    public CreateAnAccountPage enterTextZipFld(String zip){
        waitUtil.waitAndSendkeys(zipFld, zip);
        return this;
    }

    public CreateAnAccountPage enterTextToMobilePhoneFld(String mobilePhone){
        waitUtil.waitAndSendkeys(mobilePhoneFld, mobilePhone);
        return this;
    }

    public CreateAnAccountPage register(){
        waitUtil.waitAndClick(registerBtn);
        return this;
    }

    public CreateAnAccountPage createAccount(NewAccount newAccount){
        return this
                .enterTextToFirstNameFld(newAccount.getFirstName())
                .enterTextToLastNameFld(newAccount.getLastName())
                .enterTextToPasswordFld(newAccount.getPassword())
                .enterTextToAddressFld(newAccount.getAddress())
                .enterTextToCityFld(newAccount.getCity())
                .selectStateFromList(newAccount.getState())
                .enterTextZipFld(newAccount.getZip())
                .enterTextToMobilePhoneFld(newAccount.getPhone())
                .register();
    }

    public boolean alertMessageDisplayed(){
        return waitUtil.elementIsDisplayed(alertMessage);
    }
}
