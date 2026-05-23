package com.saucedemo.testcases;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CheckoutStepOnePage;
import com.saucedemo.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Feature("Checkout Feature")
public class CheckoutTest extends BaseTest {
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

//-------------------- Flow Test --------------------//
    @Story("Complete Checkout Flow With One Product")
    @Description("Verify Complete Checkout Flow With Only One Product")
    @Test(dataProvider = "productsID",description = "Verify Complete Checkout Flow With Only One Product")
    public void CompleteCheckoutTestFlowWithOneProduct(String productName) {
        LoginPage loginPage = new LoginPage(driver);
                loginPage
                        .load()
                        .login("standard_user","secret_sauce")
                        .addOneProductToCart(productName)
                        .clickCartButton()
                        .checkoutButton()
                        .inputField("test","test","3")    //First Checkout Page
                        .clickFinishButton();                                    //Second Checkout Page
    }

    @Story("Complete Checkout Flow With Missing FirstName")
    @Description("Verify Complete Checkout Flow With a missing FirstName Field")
    @Test(dataProvider = "productsID",description = "Verify Complete Checkout Flow With a missing FirstName Field")
    public void CompleteCheckoutTestFlowWithMissingFirstName(String productName) {
        LoginPage loginPage = new LoginPage(driver);
                loginPage
                        .load()
                        .login("standard_user","secret_sauce")
                        .addOneProductToCart(productName)
                        .clickCartButton()
                        .checkoutButton()
                        .inputField("","test","3");
        boolean isErrorDisplayed = loginPage.isErrorMessageDisplayed();
        Assert.assertTrue(isErrorDisplayed);
        loginPage.errorButtonClick();
    }

    @Story("Complete Checkout Flow With Missing SecondName")
    @Description("Verify Complete Checkout Flow With a missing SecondName Field")
    @Test(dataProvider = "productsID",description = "Verify Complete Checkout Flow With a missing SecondName Field")
    public void CompleteCheckoutTestFlowWithMissingSecondName(String productName) {
        LoginPage loginPage = new LoginPage(driver);
                loginPage
                        .load()
                        .login("standard_user","secret_sauce")
                        .addOneProductToCart(productName)
                        .clickCartButton()
                        .checkoutButton()
                        .inputField("test","test","");
        boolean isErrorDisplayed = loginPage.isErrorMessageDisplayed();
        Assert.assertTrue(isErrorDisplayed);
        loginPage.errorButtonClick();
    }

    @Story("Complete Checkout Flow With Missing PostalCode")
    @Description("Verify Complete Checkout Flow With a missing PostalCode Field")
    @Test(dataProvider = "productsID",description = "Verify Complete Checkout Flow With a missing PostalCode Field")
    public void CompleteCheckoutTestFlowWithMissingPostalCode(String productName) {
        LoginPage loginPage = new LoginPage(driver);
                loginPage
                        .load()
                        .login("standard_user","secret_sauce")
                        .addOneProductToCart(productName)
                        .clickCartButton()
                        .checkoutButton()
                        .inputField("test","test","");
        boolean isErrorDisplayed = loginPage.isErrorMessageDisplayed();
        Assert.assertTrue(isErrorDisplayed);
        loginPage.errorButtonClick();
    }

    @Story("Complete Checkout Flow using Numbers only in Names")
    @Description("Verify Complete Checkout Flow With Entering Numbers only in the Field names")
    @Test(dataProvider = "productsID",description = "Verify Complete Checkout Flow With Entering Numbers only in the Field names")
    public void CompleteCheckoutTestFlowWithNumbersInNames(String productName) {
        LoginPage loginPage = new LoginPage(driver);
                loginPage
                        .load()
                        .login("standard_user","secret_sauce")
                        .addOneProductToCart(productName)
                        .clickCartButton()
                        .checkoutButton()
                        .inputField("1","2","3");
        boolean isErrorDisplayed = loginPage.isErrorMessageDisplayed();
        Assert.assertTrue(isErrorDisplayed);
        loginPage.errorButtonClick();
    }

    @Story("Complete Checkout Flow while All Products Added")
    @Description("Verify Complete Checkout Flow With All Products Added")
    @Test(dataProvider = "productsID",description = "Verify Complete Checkout Flow With All Products Added")
    public void CompleteCheckoutTestFlowWithAllProducts(String productName) {
        LoginPage loginPage = new LoginPage(driver);
                loginPage
                        .load()
                        .login("standard_user","secret_sauce")
                        .addAllProductsToCart()
                        .clickCartButton()
                        .checkoutButton()
                        .inputField("test","test","3")    //First Checkout Page
                        .clickFinishButton();                                    //Second Checkout Page
    }

    @Story("Complete Checkout With Empty Cart")
    @Description("Verify Complete Checkout Flow With an Empty Cart")
    @Test(description = "Verify Complete Checkout Flow With an Empty Cart")
    public void CompleteCheckoutWithEmptyCart() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isCompleteHeaderDisplayed =
                loginPage
                    .load()
                    .login("standard_user", "secret_sauce")
                    .clickCartButton()
                    .checkoutButton()
                    .inputField("test", "test", "3")
                    .clickFinishButton()
                    .isCompleteHeaderDisplayed();
        Assert.assertTrue(isCompleteHeaderDisplayed);
    }


    @Story("Return To PDP by Clicking On its Name")
    @Description("Return To PDP using its Name Text In the Final Checkout Page")
    @Test(dataProvider = "productsID",description = "Return To PDP using its Name Text In the Final Checkout Page")
    public void ReturnToPDPFromCheckoutPageAfterFinishingFlow(String productName) {
        LoginPage loginPage = new LoginPage(driver);
        boolean isFlowCompleted =
                loginPage
                        .load()
                        .login("standard_user","secret_sauce")
                        .addOneProductToCart(productName)
                        .clickCartButton()
                        .checkoutButton()
                        .inputField("test","test","3")    //First Checkout Page
                        .returnProductDetailsPage()                             //Second Checkout Page
                        .isItemDescriptionDisplayed();
        Assert.assertTrue(isFlowCompleted);
    }

    @Story("Cancel Checkout From StepOne")
    @Description("Verify Cancel Checkout Flow Using Cancel Button in The First Checkout Page and return To Cart Page")
    @Test(dataProvider = "productsID",description = "Verify Cancel Checkout Flow Using Cancel Button in The First Checkout Page and return To Cart Page")
    public void CancelCheckoutTestFlowFromStepOneToReturnToCartPage(String productName) {
        LoginPage loginPage = new LoginPage(driver);

        boolean isCancelCompleted =
            loginPage
                        .load()
                        .login("standard_user","secret_sauce")
                        .addOneProductToCart(productName)
                        .clickCartButton()
                        .checkoutButton()
                        .clickCancelButton()
                    .isProductPriceDisplayed();
        Assert.assertTrue(isCancelCompleted);

    }

    @Story("Cancel Checkout From StepTwo")
    @Description("Verify Cancel Checkout Flow Using Cancel Button in the Second Checkout Page and Return To Products Page")
    @Test(dataProvider = "productsID",description = "Verify Cancel Checkout Flow Using Cancel Button in the Second Checkout Page and Return To Products Page")
    public void CancelCheckoutTestFlowFromStepTwo(String productName) {
        LoginPage loginPage = new LoginPage(driver);

        boolean isCancelCompleted =
                loginPage
                        .load()
                        .login("standard_user","secret_sauce")
                        .addOneProductToCart(productName)
                        .clickCartButton()
                        .checkoutButton()
                        .inputField("test","test","3")            //First Checkout Page
                        .cancelCheckoutPage()                                           //Second CheckoutPage
                        .isPageTitleDisplayed();
        Assert.assertTrue(isCancelCompleted);

    }

}
