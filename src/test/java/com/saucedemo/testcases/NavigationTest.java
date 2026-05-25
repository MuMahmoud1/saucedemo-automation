package com.saucedemo.testcases;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Navigation Feature")
public class NavigationTest extends BaseTest {


    //------------------- NavigationBar TestCases -------------------//
    @Story("Open Navigation Window")
    @Description("Should Be Able To Open Navigation Window Throw Hamburger Icon")
    @Test(description = "Should Be Able To Open Navigation Window Throw Hamburger Icon")
    public void ShouldBeAbleToOpenNavbarButton(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("standard_user", "secret_sauce")
                .clickBurgerMenuButton();

    }

    @Story("Logout Through Navigation Menu")
    @Description("Should Be Able To Logout Through the Navigation Menu")
    @Test(description = "Should Be Able To Logout Through the Navigation Menu")
    public void ShouldBeAbleToLogOut(){
        LoginPage loginPage = new LoginPage(driver);
        boolean isPageDisplayed =
                loginPage
                        .load()
                        .login("standard_user", "secret_sauce")
                        .clickBurgerMenuButton()
                        .clickLogoutButton()
                        .isPageDisplayed();
        Assert.assertTrue(isPageDisplayed);
    }

    @Story("Heading to Products Page")
    @Description("Should Be Able To Go To Products Page Through the Navigation Menu")
    @Test(description = "Should Be Able To Go To Products Page Through the Navigation Menu")
    public void ShouldBeAbleToGoToAllItemsPage(){
        LoginPage loginPage = new LoginPage(driver);
        boolean isPageTitleDisplayed =
                loginPage
                        .load()
                        .login("standard_user", "secret_sauce")
                        .clickBurgerMenuButton()
                        .clickAllItemsButton()
                        .isPageTitleDisplayed();
        Assert.assertTrue(isPageTitleDisplayed);

    }

    @Story("Heading To About Page")
    @Description("Should Be Able To Navigate To About Page through the Navigation Menu")
    @Test(description = "Should Be Able To Navigate To About Page through the Navigation Menu")
    public void ShouldBeAbleToGoToAboutPage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("standard_user", "secret_sauce")
                .clickBurgerMenuButton()
                .clickAboutButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("saucelabs.com"));
    }

    @Story("Reset Page")
    @Description("Should Be Able To Reset The Page Through the Navigation Menu")
    @Test(description = "Should Be Able To Reset The Page Through the Navigation Menu")
    public void ShouldBeAbleToResetPage(){
        LoginPage loginPage = new LoginPage(driver);
        boolean isPageTitleDisplayed =
                loginPage
                        .load()
                        .login("standard_user", "secret_sauce")
                        .clickBurgerMenuButton()
                        .clickResetButton()
                        .isPageTitleDisplayed();
        Assert.assertTrue(isPageTitleDisplayed);

    }
}
