package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.UserCredentials;

public class SignInPage extends BasePage {
    private final By createEmailFld = By.xpath("//input[@id='email_create'][contains(./preceding-sibling::label/text(),'Email address')]");
    private final By createAnAccountBtn = By.xpath("//button[@id='SubmitCreate']");
    private final By emailFld = By.xpath("//input[@id='email'][contains(./preceding-sibling::label/text(),'Email address')]");
    private final By passwordFld = By.xpath("//input[@id='passwd']");
    private final By signInBtn = By.xpath("//button[@id='SubmitLogin']");
    private final By headerText = By.xpath("//h1[normalize-space()='Authentication']");
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage createEmailAddress(String createEmail){
        waitUtil.waitAndSendkeys(createEmailFld, createEmail);
        return this;
    }

    public SignInPage createAccount(String email){
        createEmailAddress(email);
        waitUtil.waitAndClick(createAnAccountBtn);
        return this;
    }

    public SignInPage addEmail(String email){
        waitUtil.waitAndSendkeys(emailFld, email);
        return this;
    }

    public SignInPage addPassword(String password){
        waitUtil.waitAndSendkeys(passwordFld, password);
        return this;
    }

    public SignInPage clickOnSignInBtn(){
        waitUtil.waitAndClick(signInBtn);
        return this;
    }

    public boolean headerTextValidation(){
        return waitUtil.elementIsDisplayed(headerText);
    }

    public SignInPage signIn(){
        clickOnSignInBtn();
        return this;
    }

    public SignInPage doSignIn(UserCredentials userCredentials){
        return this
                .addEmail(userCredentials.getEmailAddress())
                .addPassword(userCredentials.getPassword())
                .signIn();
    }


}
