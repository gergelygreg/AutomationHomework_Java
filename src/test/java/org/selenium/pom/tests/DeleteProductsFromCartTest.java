package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.LandingPage;
import org.selenium.pom.pages.ShoppingCartSummaryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteProductsFromCartTest extends BaseTest {

    @Test
    public void user_is_able_to_delete_items_from_the_cart() throws InterruptedException {
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(getDriver());
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
        shoppingCartSummaryPage
                .deleteProduct("2");
        shoppingCartSummaryPage
                .cartContainsProduct("Faded Short Sleeve T-shirts");

    }

    @Test
    public void user_sees_the_TOTAL_price_amount_decreasing() throws InterruptedException {
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(getDriver());
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
        shoppingCartSummaryPage
                .deleteProduct("2");
        shoppingCartSummaryPage
                .cartContainsProduct("Faded Short Sleeve T-shirts");

        //Test
        shoppingCartSummaryPage.
                checkTotalPrice("$18.51");

    }

    @Test
    public void the_reduction_equals_the_price_amount_of_the_item_that_has_been_deleted() throws InterruptedException {
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(getDriver());
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
        shoppingCartSummaryPage
                .deleteProduct("1");
        shoppingCartSummaryPage
                .cartContainsProduct("Printed Dress");

        //Test
        shoppingCartSummaryPage.
                checkTotalPrice("$28.00");

    }

    @Test
    public void whenever_the_last_item_removed_is_from_the_cart_page_states_that_the_shopping_cart_is_empty() throws InterruptedException {
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(getDriver());
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
        shoppingCartSummaryPage
                .deleteProduct("1");
        shoppingCartSummaryPage
                .deleteProduct("2");

        //Test
        Assert.assertTrue(shoppingCartSummaryPage.shoppingCartIsEmpty());

    }



}
