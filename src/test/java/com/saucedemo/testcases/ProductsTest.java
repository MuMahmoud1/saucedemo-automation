package com.saucedemo.testcases;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductDetailsPage;
import com.saucedemo.pages.ProductsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.devtools.v143.log.Log;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Feature("Products Page Feature")
public class ProductsTest extends BaseTest {


    @DataProvider
    public Object[][] products(){
        return new Object[][]{
                {"Sauce Labs Backpack"},
                //{"Sauce Labs Bike Light"},
                //{"Sauce Labs Bolt T-Shirt"},
                //{"Sauce Labs Fleece Jacket"},
                //{"Sauce Labs Onesie"},
                //{"Test.allTheThings() T-Shirt (Red)"}
        };
    }

    @DataProvider
    public Object[][] productsID(){
        return new Object[][]{
                {"sauce-labs-backpack"},
                //{"sauce-labs-bike-light"},
                //{"sauce-labs-bolt-t-shirt"},
                //{"sauce-labs-fleece-jacket"},
                //{"sauce-labs-onesie"},
                //{"test.allthethings()-t-shirt-(red)"}
        };
    }

                    //------------------- Add Products To Cart TestCases -------------------//
    @Story("Add One Product To Cart")
    @Description("Verify Adding One Product Item To Cart")
    @Test(dataProvider = "productsID",description = "Verify Adding One Product Item To Cart")
    public void addOneProductToCart(String productName){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage =
                loginPage
                        .load()
                        .login("standard_user", "secret_sauce")
                        .addOneProductToCart(productName);
        int cartCount = productsPage.getCartCount();
        Assert.assertEquals(cartCount, 1);

    }

    @Story("Add All Products To Cart")
    @Description("Verify Adding All Products To Cart")
    @Test(description = "Verify Adding All Products To Cart")
    public void addProductsToCartUsingButtons(){
        LoginPage loginPage = new LoginPage(driver);

        ProductsPage productsPage =
                loginPage
                        .load()
                        .login("standard_user", "secret_sauce");
        productsPage.addAllProductsToCart();
        int cartCount = productsPage.getCartCount();
        Assert.assertEquals(cartCount, 6);

    }

                    //------------------- Remove Products To Cart TestCases -------------------//
    @Story("Remove One Product From Cart")
    @Description("Verify Remove One Product Item From Cart")
    @Test(dataProvider = "productsID",description = "Verify Remove One Product Item From Cart")
    public void removeOneProductToCart(String productName){
    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage =
        loginPage
                .load()
                .login("standard_user", "secret_sauce")
                .addOneProductToCart(productName)
                .removeOneProductFromCart(productName);
        Assert.assertFalse(productsPage.isCartBadgeDisplayed());

    }

    @Story("Remove All Products From Cart")
    @Description("Verify Removing All Products From Cart")
    @Test(description = "Verify Removing All Products From Cart")
    public void RemoveProductsFromCartUsingButtons(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage =
                loginPage
                        .load()
                        .login("standard_user", "secret_sauce")
                        .addAllProductsToCart();
        productsPage.removeAllProductsFromCart();

    }




                    //------------------- Title TestCases -------------------//
    @Story("Heading To PDP using Name")
    @Description("Verify Heading to PDP Using Its Title Name")
    @Test(dataProvider = "products",description = "Verify Heading to PDP Using Its Title Name")
    public void goToPDPageUsingTitle(String productName){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage =
                loginPage
                        .load()
                        .login("standard_user", "secret_sauce");
        ProductDetailsPage pdp = productsPage.goToProductDetailsByText(productName);
        Assert.assertTrue(pdp.isItemDescriptionDisplayed());

    }

                    //------------------- Images TestCases -------------------//
    @Story("Heading To PDP using Image")
    @Description("Verify Heading To PDP Using Its Image")
    @Test(dataProvider = "productsID",description = "Verify Heading To PDP Using Its Image")
    public void goToPDPageUsingImg(String productNameImage){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage =
                loginPage
                        .load()
                        .login("standard_user", "secret_sauce");
        ProductDetailsPage pdp = productsPage.goToProductDetailsByImage(productNameImage);
        Assert.assertTrue(pdp.isItemDescriptionDisplayed());
    }

                    //------------------- Cart TestCases -------------------//
    @Story("Heading To Cart")
    @Description("Verify Going to Cart Using Cart icon")
    @Test(description = "Verify Going to Cart Using Cart icon")
    public void goToCartButton(){
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage =
                loginPage
                        .load()
                        .login("standard_user","secret_sauce")
                        .clickCartButton();
        Assert.assertEquals(cartPage.getPageTitle(), "Your Cart");

    }

                    //------------------- SortBy DropDown List TestCase -------------------//
    @Story("Sorting A To Z")
    @Description("Verify Sorting By Name A To Z using Sort Dropdown Menu")
    @Test(description = "Verify Sorting By Name A To Z using Sort Dropdown Menu")
    public void sortByNameAToZ(){
            ProductsPage productsPage = new LoginPage(driver)
                    .load()
                    .login("standard_user", "secret_sauce")
                    .sortBy("Name (A to Z)");

            Assert.assertEquals(productsPage.getProductFirstName(), "Sauce Labs Backpack");

    }

    @Story("Sorting Z To A")
    @Description("Verify Sorting By Name Z To A using Sort Dropdown Menu")
    @Test(description = "Verify Sorting By Name Z To A using Sort Dropdown Menu")
    public void sortByNameZToA(){
            ProductsPage productsPage = new LoginPage(driver)
                    .load()
                    .login("standard_user", "secret_sauce")
                    .sortBy("Name (Z to A)");
            Assert.assertEquals(productsPage.getProductLastName(), "Sauce Labs Backpack");

    }

    @Story("Sorting Low To High Price")
    @Description("Verify Sorting By Price From Low To High using Sort Dropdown Menu")
    @Test(description = "Verify Sorting By Price From Low To High using Sort Dropdown Menu")
    public void sortByPriceLowToHigh(){
        ProductsPage productsPage = new LoginPage(driver)
                .load()
                .login("standard_user", "secret_sauce")
                .sortBy("Price (low to high)");
        Assert.assertEquals(productsPage.getLowestProductPrice(),"$7.99");
    }

    @Story("Sorting High To Low Price")
    @Description("Verify Sorting By Price From High To Low using Sort Dropdown Menu")
    @Test(description = "Verify Sorting By Price From High To Low using Sort Dropdown Menu")
    public void sortByPriceHighToLow(){
        ProductsPage productsPage = new LoginPage(driver)
                .load()
                .login("standard_user", "secret_sauce")
                .sortBy("Price (high to low)");
        Assert.assertEquals(productsPage.getHighestProductPrice(),"$49.99");
    }

}
