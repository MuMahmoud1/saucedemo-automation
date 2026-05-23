package com.saucedemo.testcases;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Feature("Login Feature")
public class LoginTest extends BaseTest {

    @Story("Login With Valid Credentials")
    @Description("Login with Valid Username And Password")
    @Test(description = "Login with Valid Username And Password")
    public void LoginTestWithValidUser() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isPageTitleDisplayed =
                loginPage
                        .load()
                        .login("standard_user", "secret_sauce")
                        .isPageTitleDisplayed();
        Assert.assertTrue(isPageTitleDisplayed);

    }

    @Story("Login with CapsLock UserName Only")
    @Description("Login with A CapsLocked Username And valid password")
    @Test(description = "Login with A CapsLocked Username And valid password")
    public void LoginTestWithCapsLockedUser() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isPageTitleDisplayed =
                loginPage
                        .load()
                        .login("STANDARD_USER", "secret_sauce")
                        .isPageTitleDisplayed();
        Assert.assertTrue(isPageTitleDisplayed);

    }

    @Story("Login with CapsLock Password Only")
    @Description("Login with A valid Username and CapsLocked Password")
    @Test(description = "Login with A valid Username and CapsLocked Password")
    public void LoginTestWithCapsLockedPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("standard_user", "SECRET_SAUCE");
        boolean isErrorMessageDisplayed = loginPage.isErrorMessageDisplayed();
        Assert.assertTrue(isErrorMessageDisplayed);
        loginPage.errorButtonClick();
    }

    @Story("Login With Locked User")
    @Description("Login with A Locked user")
    @Test(description = "Login with A Locked user")
    public void LoginTestWithLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("locked_out_user", "secret_sauce");
        boolean isErrorMessageDisplayed = loginPage.isErrorMessageDisplayed();
        Assert.assertTrue(isErrorMessageDisplayed);
        loginPage.errorButtonClick();
    }

    @Story("Login With Empty Fields")
    @Description("Login with An Empty Username and Empty Password")
    @Test(description = "Login with An Empty Username and Empty Password")
    public void LoginTestWithEmptyUserAndEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("", "");
        boolean isErrorMessageDisplayed = loginPage.isErrorMessageDisplayed();
        Assert.assertTrue(isErrorMessageDisplayed);
        loginPage.errorButtonClick();
    }

    @Story("Login With Empty UserName Only")
    @Description("Login with An Empty Username Only")
    @Test(description = "Login with An Empty Username Only")
    public void LoginTestWithEmptyUserOnly() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("", "secret_sauce");
        boolean isErrorMessageDisplayed = loginPage.isErrorMessageDisplayed();
        Assert.assertTrue(isErrorMessageDisplayed);
        loginPage.errorButtonClick();
    }

    @Story("Login With Empty Password Only")
    @Description("Login with An Empty Password Only")
    @Test(description = "Login with An Empty Password Only")
    public void LoginTestWithEmptyPasswordOnly() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("standard_user", "");
        boolean isErrorMessageDisplayed = loginPage.isErrorMessageDisplayed();
        Assert.assertTrue(isErrorMessageDisplayed);
        loginPage.errorButtonClick();
    }

    @Story("Login With Invalid Password")
    @Description("Login with A valid Username and Wrong Password")
    @Test (description = "Login with A valid Username and Wrong Password")
    public void LoginTestWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .load()
                .login("standard_user", "secretsauce");
        boolean isErrorMessageDisplayed = loginPage.isErrorMessageDisplayed();
        Assert.assertTrue(isErrorMessageDisplayed);
        loginPage.errorButtonClick();
    }

    @Story("Login With Problem User")
    @Description("Login with A problem User")
    @Test(description = "Login with A problem User")
    public void LoginTestWithProblemUser() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isPageTitleDisplayed =
                loginPage
                        .load()
                        .login("problem_user", "secret_sauce")
                        .isPageTitleDisplayed();
        Assert.assertTrue(isPageTitleDisplayed);
    }
}