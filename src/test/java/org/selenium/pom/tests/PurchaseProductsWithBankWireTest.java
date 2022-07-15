package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.UserCredentials;
import org.selenium.pom.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.selenium.pom.utils.JacksonUtils.deserializeJson;

public class PurchaseProductsWithBankWireTest extends BaseTest {

    @Test
    public void user_is_able_to_successfully_purchase_products_that_have_been_added_to_the_cart_with_bank_wire() throws InterruptedException, IOException {
        LandingPage landingPage = new LandingPage(getDriver());
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(getDriver());
        SignInPage signInPage = new SignInPage(getDriver());
        AddressPage addressPage = new AddressPage(getDriver());
        ShippingPage shippingPage = new ShippingPage(getDriver());
        PaymentPage paymentPage = new PaymentPage(getDriver());
        OrderSummary orderSummary = new OrderSummary(getDriver());
        OrderConformationPage orderConformationPage = new OrderConformationPage(getDriver());
        UserCredentials userCredentials = deserializeJson("userCredentials.json", UserCredentials.class);
        landingPage
                .load("/");
        Thread.sleep(5000);

        //Pre-condition
        landingPage
                .addFadedShortToCart();
        Assert.assertTrue(landingPage.headerTextValidationShoppingCart());
        Assert.assertEquals(landingPage.cartQuantity(), "1");
        landingPage.proceedToCheckout();
        shoppingCartSummaryPage
                .proceedToCheckOut();
        signInPage
                .headerTextValidation();
        signInPage.
                doSignIn(userCredentials);
        addressPage
                .headerTextValidation();
        addressPage
                .proceedToCheckout();
        shippingPage.
                headerTextValidation();
        shippingPage.
                acceptTermOfService();
        shippingPage
                .proceedToCheckout();

        //Test
        paymentPage
                .headerTextValidation();
        paymentPage.
                payByBankwire();
        orderSummary
                .headerTextValidation();
        orderSummary
                .confirmOrder();
        orderConformationPage.
                headerTextValidation();


    }

    @Test
    public void upon_order_confirmation_the_order_appears_on_the_My_Orders_page() throws InterruptedException, IOException {
        LandingPage landingPage = new LandingPage(getDriver());
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(getDriver());
        SignInPage signInPage = new SignInPage(getDriver());
        AddressPage addressPage = new AddressPage(getDriver());
        ShippingPage shippingPage = new ShippingPage(getDriver());
        PaymentPage paymentPage = new PaymentPage(getDriver());
        OrderSummary orderSummary = new OrderSummary(getDriver());
        OrderConformationPage orderConformationPage = new OrderConformationPage(getDriver());
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(getDriver());
        UserCredentials userCredentials = deserializeJson("userCredentials.json", UserCredentials.class);
        landingPage
                .load("/");
        Thread.sleep(5000);

        //Pre-condition
        landingPage
                .addFadedShortToCart();
        Assert.assertTrue(landingPage.headerTextValidationShoppingCart());
        Assert.assertEquals(landingPage.cartQuantity(), "1");
        landingPage.proceedToCheckout();
        shoppingCartSummaryPage
                .proceedToCheckOut();
        signInPage
                .headerTextValidation();
        signInPage.
                doSignIn(userCredentials);
        addressPage
                .headerTextValidation();
        addressPage
                .proceedToCheckout();
        shippingPage.
                headerTextValidation();
        shippingPage.
                acceptTermOfService();
        shippingPage
                .proceedToCheckout();
        paymentPage
                .headerTextValidation();
        paymentPage.
                payByBankwire();
        orderSummary
                .headerTextValidation();
        orderSummary
                .confirmOrder();
        orderConformationPage.
                headerTextValidation();
        orderConformationPage
                .backToOrders();

        //Test
        orderHistoryPage
                .headerTextValidation();
    }

    @Test
    public void user_sees_the_same_order_reference_that_was_given_on_order_completion() throws InterruptedException, IOException {
        LandingPage landingPage = new LandingPage(getDriver());
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(getDriver());
        SignInPage signInPage = new SignInPage(getDriver());
        AddressPage addressPage = new AddressPage(getDriver());
        ShippingPage shippingPage = new ShippingPage(getDriver());
        PaymentPage paymentPage = new PaymentPage(getDriver());
        OrderSummary orderSummary = new OrderSummary(getDriver());
        OrderConformationPage orderConformationPage = new OrderConformationPage(getDriver());
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(getDriver());
        UserCredentials userCredentials = deserializeJson("userCredentials.json", UserCredentials.class);
        landingPage
                .load("/");
        Thread.sleep(5000);

        //Pre-condition
        landingPage
                .addFadedShortToCart();
        Assert.assertTrue(landingPage.headerTextValidationShoppingCart());
        Assert.assertEquals(landingPage.cartQuantity(), "1");
        landingPage.proceedToCheckout();
        shoppingCartSummaryPage
                .proceedToCheckOut();
        signInPage
                .headerTextValidation();
        signInPage.
                doSignIn(userCredentials);
        addressPage
                .headerTextValidation();
        addressPage
                .proceedToCheckout();
        shippingPage.
                headerTextValidation();
        shippingPage.
                acceptTermOfService();
        shippingPage
                .proceedToCheckout();
        paymentPage
                .headerTextValidation();
        paymentPage.
                payByBankwire();
        orderSummary
                .headerTextValidation();
        orderSummary
                .confirmOrder();
        orderConformationPage.
                headerTextValidation();
        String OrderReferenceConfPage = orderConformationPage.getOrderReference(216, 225);
        orderConformationPage
                .backToOrders();
        orderHistoryPage
                .headerTextValidation();
        String OrderReferenceHistPage = orderHistoryPage.getOrderReference();

        //Test
        Assert.assertEquals(OrderReferenceConfPage, OrderReferenceHistPage);
    }
}
