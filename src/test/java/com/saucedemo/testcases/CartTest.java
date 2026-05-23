package com.saucedemo.testcases;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Feature("Cart Feature")
public class CartTest extends BaseTest {

    @DataProvider
    public Object[][] productsID() {
        return new Object[][]{
                {"sauce-labs-backpack"},
                //{"sauce-labs-bike-light"},
                //{"sauce-labs-bolt-t-shirt"},
                //{"sauce-labs-fleece-jacket"},
                //{"sauce-labs-onesie"},
                //{"test.allthethings()-t-shirt-(red)"}
        };
    }
    @Story("Display One Product in Cart")
    @Description("Should Display One Product and its Details in the Cart")
    @Test(dataProvider = "productsID",description = "Should Display One Product and its Details in the Cart")
    public void shouldDisplayOneProductDetailsInCart(String productName) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("standard_user", "secret_sauce")
                .addOneProductToCart(productName)
                .clickCartButton();
        CartPage cartPage = new CartPage(driver);
        boolean isProductTitleDisplayed = cartPage.isProductNameDisplayed();
        Assert.assertTrue(isProductTitleDisplayed);
        boolean isProductPriceDisplayed = cartPage.isProductPriceDisplayed();
        Assert.assertTrue(isProductPriceDisplayed);
        boolean isProductDescriptionDisplayed = cartPage.isProductDescriptionDisplayed();
        Assert.assertTrue(isProductDescriptionDisplayed);
    }

    @Story("Remove One Product From Cart")
    @Description("Should Remove One Product From The Cart")
    @Test(dataProvider = "productsID",description = "Should Remove One Product From The Cart")
    public void shouldRemoveProductFromCart(String productName) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("standard_user", "secret_sauce")
                .addOneProductToCart(productName)
                .clickCartButton()
                .removeProduct(productName);
    }

    @Story("Add All Products To Cart")
    @Description("Should Add All the Products To the Cart")
    @Test(dataProvider = "productsID",description = "Should Add All the Products To the Cart")
    public void shouldAddAllProductsInCart(String productName) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("standard_user", "secret_sauce")
                .addAllProductsToCart()
                .clickCartButton();
    }

    @Story("Remove All Products From Cart")
    @Description("Should Remove All the Products From the Cart")
    @Test(dataProvider = "productsID",description = "Should Remove All the Products From the Cart")
    public void shouldRemoveAllProductsInCart(String productName) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("standard_user", "secret_sauce")
                .addAllProductsToCart()
                .clickCartButton()
                .removeAllProducts();
    }


    @Story("Return To Products Page Using Continue Shopping Button")
    @Description("Should Return Back To Products Page Using Continue Shopping Button in the Cart Page")
    @Test(dataProvider = "productsID",description = "Should Return Back To Products Page Using Continue Shopping Button in the Cart Page")
    public void shouldContinueShoppingFromCart(String productName) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("standard_user", "secret_sauce")
                .addOneProductToCart(productName)
                .clickCartButton()
                .continueShoppingButton();

    }

    @Story("Go To Checkout")
    @Description("Should Go To Checkout Page Using Checkout Button int the Cart Page")
    @Test(dataProvider = "productsID",description = "Should Go To Checkout Page Using Checkout Button int the Cart Page")
    public void shouldCheckOutFromCart(String productName) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("standard_user", "secret_sauce")
                .addOneProductToCart(productName)
                .clickCartButton()
                .checkoutButton();
    }
}