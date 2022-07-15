package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.LandingPage;
import org.testng.annotations.Test;

public class SearchingForProductsTest extends BaseTest {

    @Test
    public void user_is_able_to_search_from_the_search_bar_on_the_Landing_page() throws InterruptedException {
        LandingPage landingPage = new LandingPage(getDriver());
        landingPage
                .load("/");
        Thread.sleep(5000);

        //Test
        landingPage
                .searchProduct("Blouse");

    }

    @Test
    public void user_sees_item_that_match_search_term() throws InterruptedException {
        LandingPage landingPage = new LandingPage(getDriver());
        landingPage
                .load("/");
        Thread.sleep(5000);

        //Pre-condition
        String searchTerm = "Blouse";
        landingPage
                .searchProduct(searchTerm);
        //Test
        landingPage
                .enteredSearchTermInList(searchTerm);

    }

}
