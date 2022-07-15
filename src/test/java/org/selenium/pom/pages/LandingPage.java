package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.pages.components.Header;
import org.selenium.pom.pages.components.ProductThumbnail;
import org.selenium.pom.utils.WaitUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LandingPage extends BasePage {
    private final By viewMyShoppingCart = By.xpath("//a[@title='View my shopping cart']");
    //Popular section
    private final By fadedShortListItem = By.xpath("(//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line'])[1]");
    private final By blouseListItem = By.xpath("(//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-mobile-line'])[1]");
    private final By printedDressShortListItem = By.xpath("(//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-tablet-line first-item-of-mobile-line'])[1]");
    private final By printedDressLongListItem = By.xpath("(//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-in-line first-item-of-tablet-line last-item-of-mobile-line'])[1]");
    private final By printedSummerDressKneeLengthListItem = By.xpath("(//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line last-line first-item-of-mobile-line'])[1]");
    private final By printedSummerDressLongListItem = By.xpath("(//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-line last-item-of-tablet-line last-item-of-mobile-line'])[1]");
    private final By printedChiffonDressListItem = By.xpath("(//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line'])[1]");

    private final By fadedShortAddToCartBtn = By.xpath("(//a[@title='Add to cart'])[1]");
    private final By printedDressShortAddToCartBtn = By.xpath("(//a[@title='Add to cart'])[3]");
    //Add to cart window
    private final By headerText = By.xpath("//h2[contains(normalize-space(),'Product successfully added to your shopping cart')]");
    private final By continueShopping = By.xpath("//span[contains(@title,'Continue shopping')]");
    private final By proceedToCheckout = By.xpath("//a[contains(@title,'Proceed to checkout')]");
    //Search
    private final By searchBar = By.xpath("//input[@id='search_query_top']");
    private final By submitSearchBtn = By.xpath("//button[@name='submit_search']");
    private final By cartQuantity = By.xpath("//span[@class='ajax_cart_quantity unvisible']");

    private Header header;
    private ProductThumbnail productThumbnail;

    public Header getHeader() {
        return header;
    }
    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    public LandingPage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
        productThumbnail = new ProductThumbnail(driver);
    }

    public LandingPage load(){
        load("/");
        return this;
    }

    public boolean weAreOnLandingPage(){
        return waitUtil.elementIsDisplayed(searchBar);
    }

    public LandingPage enterTextToSearchBar(String searchTerm){
        waitUtil.waitAndSendkeys(searchBar,searchTerm);
        return this;
    }

    public LandingPage clickOnSubmitBtn(){
        waitUtil.waitAndClick(submitSearchBtn);
        return this;
    }

    public LandingPage searchProduct(String productName){
        enterTextToSearchBar(productName);
        clickOnSubmitBtn();
        return this;
    }

    /*public void addProductToCart(By item, By addToCartBtn){
        WebElement listItem = driver.findElement(item);
        Actions actions = new Actions(driver);
        actions.moveToElement(listItem);
        WebElement addToCart = driver.findElement(addToCartBtn);
        actions.moveToElement(addToCart);
        actions.click().build().perform();
    }*/

    public LandingPage addFadedShortToCart(){
        WebElement listItem = driver.findElement(fadedShortListItem);
        Actions actions = new Actions(driver);
        actions.moveToElement(listItem);
        WebElement addToCart = driver.findElement(fadedShortAddToCartBtn);
        actions.moveToElement(addToCart);
        actions.click().build().perform();
        return this;
    }

    public LandingPage addPrintedDressShortToCart(){
        WebElement listItem = driver.findElement(printedDressShortListItem);
        Actions actions = new Actions(driver);
        actions.moveToElement(listItem);
        WebElement addToCart = driver.findElement(printedDressShortAddToCartBtn);
        actions.moveToElement(addToCart);
        actions.click().build().perform();
        return this;
    }

    public void enteredSearchTermInList(String searchTerm){
        List<WebElement> elements = driver.findElements(By.xpath("//ul[contains(@class,\"product_list\")]//a[contains(.,'"+searchTerm+"')]"));
        //List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='product_list grid row']//a[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"+searchTerm+"')]"));
        if(elements.size()>0)
        {
            System.out.println("Search is passed");
        }
        else {
            System.out.println("Search is failed");
        }
    }

    public boolean headerTextValidationShoppingCart(){
        return waitUtil.elementIsDisplayed(headerText);
    }

    public LandingPage continueShopping(){
        waitUtil.waitAndClick(continueShopping);
        return this;
    }

    public LandingPage proceedToCheckout(){
        waitUtil.waitAndClick(proceedToCheckout);
        return this;
    }

    public String cartQuantity(){
        return driver.findElement(cartQuantity).getText();
    }
}
