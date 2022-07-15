package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.NewAccount;
import org.selenium.pom.pages.CreateAnAccountPage;
import org.selenium.pom.pages.LandingPage;
import org.selenium.pom.pages.MyAccountPage;
import org.selenium.pom.pages.SignInPage;
import org.selenium.pom.pages.components.Header;
import org.selenium.pom.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.selenium.pom.utils.JacksonUtils.deserializeJson;

public class SuccessfulRegistrationTest extends BaseTest {
    @Test
    public void user_is_able_to_start_registration_from_the_sign_in_link_in_the_header_of_the_landing_page() throws IOException, InterruptedException {
        LandingPage landingPage = new LandingPage(getDriver());
        Header header = new Header(getDriver());
        SignInPage signInPage = new SignInPage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(getDriver());
        NewAccount newAccountData = deserializeJson("createAccount.json", NewAccount.class);

        //Pre-condition
        landingPage.load("/");
        Thread.sleep(5000);

        Assert.assertTrue(landingPage.weAreOnLandingPage());
        String emailForRegistration = "test" + new FakerUtils().generateRandomNumber() + "@test.com";

        //Test
        header.
                clickOnSignIn();
        signInPage
                .createAccount(emailForRegistration);
        createAnAccountPage
                .createAccount(newAccountData);
        myAccountPage
                .pageHeadingIsVisible();

    }

    @Test
    public void user_is_logged_in_after_successful_registration() throws IOException, InterruptedException {
        LandingPage landingPage = new LandingPage(getDriver());
        Header header = new Header(getDriver());
        SignInPage signInPage = new SignInPage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(getDriver());
        NewAccount newAccountData = deserializeJson("createAccount.json", NewAccount.class);

        landingPage.load("/");
        Thread.sleep(5000);

        Assert.assertTrue(landingPage.weAreOnLandingPage());
        String emailForRegistration = "test" + new FakerUtils().generateRandomNumber() + "@test.com";

        //Pre-condition
        header.
                clickOnSignIn();
        signInPage
                .createAccount(emailForRegistration);
        createAnAccountPage
                .createAccount(newAccountData);
        //Test
        myAccountPage
                .signOutBtnIsVisible();

    }

    @Test
    public void user_is_located_on_the_My_Account_page_after_successful_registration() throws IOException, InterruptedException {
        LandingPage landingPage = new LandingPage(getDriver());
        Header header = new Header(getDriver());
        SignInPage signInPage = new SignInPage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(getDriver());
        NewAccount newAccountData = deserializeJson("createAccount.json", NewAccount.class);

        landingPage.load("/");
        Thread.sleep(5000);

        Assert.assertTrue(landingPage.weAreOnLandingPage());
        String emailForRegistration = "test" + new FakerUtils().generateRandomNumber() + "@test.com";

        //Pre-condition
        header.
                clickOnSignIn();
        signInPage
                .createAccount(emailForRegistration);
        createAnAccountPage
                .createAccount(newAccountData);
        //Test
        myAccountPage
                .pageHeadingIsVisible();
    }
}
