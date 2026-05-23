package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(css = "[data-test=\"username\"]")
    private WebElement userNameInput;
    @FindBy(css = "[data-test=\"password\"]")
    private WebElement passwordInput;
    @FindBy(css = "[data-test=\"login-button\"]")
    private WebElement loginButton;
    @FindBy(css = "[data-test=\"error\"]")
    private WebElement errorMessage;
    @FindBy(css = "[data-test=\"error-button\"]")
    private WebElement errorButton;
    @FindBy(css = ".login_logo")
    private WebElement loginLogo;


    //Actions
    public LoginPage load(){
        driver.get("https://www.saucedemo.com/");
        return this;
    }
    public ProductsPage login(String username, String password) {
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
    }
    public void errorButtonClick() {
        errorButton.click();
    }

    //Validation
    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
    public boolean isPageDisplayed() {
        return loginLogo.isDisplayed();
    }

}
