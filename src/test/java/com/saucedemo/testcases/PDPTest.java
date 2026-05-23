package com.saucedemo.testcases;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductDetailsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Feature("Product Detailed Page Feature")
public class PDPTest extends BaseTest {


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
                    //------------------------Add/Remove Item TestCases------------------------//

    @Story("Add Item To Cart")
    @Description("Add an Item To Cart From Product Detailed Page")
    @Test(dataProvider = "products",description = "Add an Item To Cart From Product Detailed Page")
    public void addItemToCartInPDPage(String productName) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("standard_user", "secret_sauce")
                .goToProductDetailsByText(productName)
                .clickAddToCartButton();
    }

    @Story("Remove Item From Cart")
    @Description("Remove an Item From Cart in Product Detailed Page")
    @Test(dataProvider = "products",description = "Remove an Item From Cart in Product Detailed Page")
    public void removeItemToCartInPDPage(String productName) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("standard_user", "secret_sauce")
                .goToProductDetailsByText(productName)
                .clickAddToCartButton()
                .clickRemoveButton();
    }


                    //------------------------Verify Item Details TestCases------------------------//
    @Story("Verify Product Details")
    @Description("Verify Product Details is appeared in Product Detailed Page")
    @Test(dataProvider = "products",description = "Verify Product Details is appeared in Product Detailed Page")
    public void verifyProductDetailsInPDPage(String productName) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("standard_user", "secret_sauce")
                .goToProductDetailsByText(productName);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        boolean isItemNameDisplayed = productDetailsPage.isItemNameDisplayed(productName);
        Assert.assertTrue(isItemNameDisplayed);
        boolean isItemPriceDisplayed = productDetailsPage.isItemPriceDisplayed();
        Assert.assertTrue(isItemPriceDisplayed);
        boolean isItemDescriptionDisplayed = productDetailsPage.isItemDescriptionDisplayed();
        Assert.assertTrue(isItemDescriptionDisplayed);
    }

                //------------------------Return To ProductsPage TestCases------------------------//

    @Story("Return To Products Page")
    @Description("Return to Products Page Using Return To Products Page Button when user in PDP")
    @Test(dataProvider = "products",description = "Return to Products Page Using Return To Products Page Button when user in PDP")
    public void returnToProductsPageFromPDP(String productName) {
        LoginPage loginPage = new LoginPage(driver);

        boolean returnToProductsPage =
                loginPage
                    .load()
                    .login("standard_user", "secret_sauce")
                    .goToProductDetailsByText(productName)
                    .clickReturnToProductsPage()
                    .isPageTitleDisplayed();

        Assert.assertTrue(returnToProductsPage);

    }

                //------------------------Go to Cart From PDP TestCases------------------------//

    @Story("Going To Cart")
    @Description("Click on Cart Icon when user is in the PDP")
    @Test(dataProvider = "products",description = "Click on Cart Icon when user is in the PDP")
    public void goToCartPageFromPDP(String productName) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("standard_user", "secret_sauce")
                .goToProductDetailsByText(productName)
                .clickCartButton();

    }
}
