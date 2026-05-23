package com.saucedemo.base;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(css = "[data-test=\"shopping-cart-link\"]")
    private WebElement cartButton;

    @FindBy(css = "#react-burger-menu-btn")
    private WebElement burgerMenuButton;


    @FindBy(css = "[data-test=\"logout-sidebar-link\"]")
    private WebElement logoutButton;

    @FindBy(css = "[data-test=\"about-sidebar-link\"]")
    private WebElement aboutButton;
    @FindBy(css = "[data-test=\"inventory-sidebar-link\"]")
    private WebElement allItemsButton;
    @FindBy(css = "[data-test=\"reset-sidebar-link\"]")
    private WebElement resetButton;

    //Actions
    public CartPage clickCartButton() {
        cartButton.click();
        return new CartPage(driver);
    }
    public BasePage clickBurgerMenuButton() {
        burgerMenuButton.click();
        return this;
    }

    public ProductsPage clickAllItemsButton() {
        allItemsButton.click();
        return new ProductsPage(driver);
    }

    public ProductsPage  clickResetButton() {
        resetButton.click();
        return  new ProductsPage(driver);
    }
    public void clickAboutButton() {
        aboutButton.click();
    }

    public LoginPage clickLogoutButton() {
        logoutButton.click();
        return new LoginPage(driver);
    }
    //Validation
    public int getCartCount() {
        String count = driver
                .findElement(By.cssSelector(".shopping_cart_badge"))
                .getText();
        return Integer.parseInt(count);
    }

    public boolean isCartBadgeDisplayed() {
        return !driver.findElements(
                By.cssSelector(".shopping_cart_badge")
        ).isEmpty();
    }

}
