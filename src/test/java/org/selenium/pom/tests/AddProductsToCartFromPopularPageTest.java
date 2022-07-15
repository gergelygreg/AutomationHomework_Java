package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.LandingPage;
import org.selenium.pom.pages.ShoppingCartSummaryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductsToCartFromPopularPageTest extends BaseTest {

    @Test
    public void user_is_able_to_add_multiple_items_to_the_cart_from_the_Popular_tab_on_the_Home_Page() throws InterruptedException {
        LandingPage landingPage = new LandingPage(getDriver());
        landingPage
                .load("/");
        Thread.sleep(5000);

        //Test
        landingPage
                .addFadedShortToCart()
                .continueShopping()
                .addPrintedDressShortToCart();

    }

    @Test
    public void user_sees_message_that_the_item_has_been_successfully_added_to_the_cart() throws InterruptedException {
        LandingPage landingPage = new LandingPage(getDriver());
        landingPage
                .load("/");
        Thread.sleep(5000);

        //Test
        landingPage
                .addFadedShortToCart();
        Assert.assertTrue(landingPage.headerTextValidationShoppingCart());
        landingPage
                .continueShopping();

        landingPage
                .addPrintedDressShortToCart();
        Assert.assertTrue(landingPage.headerTextValidationShoppingCart());
        landingPage
                .continueShopping();


    }

    @Test
    public void user_sees_product_count_updating_in_the_cart_on_the_Home_Page() throws InterruptedException {
        LandingPage landingPage = new LandingPage(getDriver());
        landingPage
                .load("/");
        Thread.sleep(5000);

        //Test
        landingPage
                .addFadedShortToCart();
        Assert.assertTrue(landingPage.headerTextValidationShoppingCart());
        Assert.assertEquals(landingPage.cartQuantity(), "1");
        landingPage
                .continueShopping();
        landingPage
                .addPrintedDressShortToCart();
        Assert.assertTrue(landingPage.headerTextValidationShoppingCart());
        Assert.assertEquals(landingPage.cartQuantity(), "2");

    }

    @Test
    public void upon_navigating_to_the_cart_user_sees_the_same_items_in_the_cart_that_were_previously_added() throws InterruptedException {
        LandingPage landingPage = new LandingPage(getDriver());
        landingPage
                .load("/");
        Thread.sleep(5000);

        //Pre-condition
        landingPage
                .addFadedShortToCart();
        Assert.assertTrue(landingPage.headerTextValidationShoppingCart());
        Assert.assertEquals(landingPage.cartQuantity(), "1");
        landingPage
                .continueShopping();
        landingPage
                .addPrintedDressShortToCart();
        Assert.assertTrue(landingPage.headerTextValidationShoppingCart());
        Assert.assertEquals(landingPage.cartQuantity(), "2");
        landingPage.proceedToCheckout();

        //Test
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(getDriver());
        shoppingCartSummaryPage
                .cartContainsProduct("Faded Short Sleeve T-shirts")
                .cartContainsProduct("Printed Dress");
    }

    @Test
    public void user_sees_the_same_quantity_of_items_that_were_previously_added() throws InterruptedException {
        LandingPage landingPage = new LandingPage(getDriver());
        landingPage
                .load("/");
        Thread.sleep(5000);

        //Pre-condition
        landingPage
                .addFadedShortToCart();
        Assert.assertTrue(landingPage.headerTextValidationShoppingCart());
        Assert.assertEquals(landingPage.cartQuantity(), "1");
        landingPage
                .continueShopping();
        landingPage
                .addPrintedDressShortToCart();
        Assert.assertTrue(landingPage.headerTextValidationShoppingCart());
        Assert.assertEquals(landingPage.cartQuantity(), "2");
        landingPage.proceedToCheckout();

        //Test
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(getDriver());
        Assert.assertEquals(shoppingCartSummaryPage.getQuantity("1_1"), "1");
        Assert.assertEquals(shoppingCartSummaryPage.getQuantity("3_13"), "1");
    }

    @Test
    public void user_sees_the_same_price_of_items_that_were_previously_added() throws InterruptedException {
        LandingPage landingPage = new LandingPage(getDriver());
        landingPage
                .load("/");
        Thread.sleep(5000);

        //Pre-condition
        landingPage
                .addFadedShortToCart();
        Assert.assertTrue(landingPage.headerTextValidationShoppingCart());
        Assert.assertEquals(landingPage.cartQuantity(), "1");
        landingPage
                .continueShopping();
        landingPage
                .addPrintedDressShortToCart();
        Assert.assertTrue(landingPage.headerTextValidationShoppingCart());
        Assert.assertEquals(landingPage.cartQuantity(), "2");
        landingPage.proceedToCheckout();

        //Test
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(getDriver());
        shoppingCartSummaryPage
                .checkUnitPrice("$16.51");
        shoppingCartSummaryPage
                .checkUnitPrice("$26.00");
        shoppingCartSummaryPage
                .checkTotalPrice("$44.51");
    }




}
