package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(css = "[data-test=\"inventory-item-name\"]")
    private WebElement productName;

    @FindBy(css = "[data-test=\"inventory-item-price\"]")
    private WebElement productPrice;

    @FindBy(css = "[data-test=\"inventory-item-desc\"]")
    private WebElement productDescription;

    @FindBy(css = "[data-test=\"continue-shopping\"]")
    private WebElement continueShoppingButton;

    @FindBy(css = "[data-test=\"checkout\"]")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "[data-test^=remove]")
    private List<WebElement> removeFromCartButton;

    //Validation
    public boolean isProductNameDisplayed() {
        return productName.isDisplayed();
    }
    public boolean isProductPriceDisplayed() {
        return productPrice.isDisplayed();
    }
    public boolean isProductDescriptionDisplayed() {
        return productDescription.isDisplayed();
    }

    public ProductsPage continueShoppingButton() {
        continueShoppingButton.click();
        return new ProductsPage(driver);
    }

    //Actions
    public ProductDetailsPage returnToPDPage() {
        productPrice.click();
        return new ProductDetailsPage(driver);
    }

    public CartPage removeAllProducts() {
        for (WebElement button : removeFromCartButton) {
            button.click();
        }
        return this;
    }

    public CartPage removeProduct(String productName) {
        driver
                .findElement(By.cssSelector("[data-test='remove-" + productName + "']"))
                .click();
        return this;
    }

    public CheckoutStepOnePage checkoutButton() {
        proceedToCheckoutButton.click();
        return new CheckoutStepOnePage(driver);
    }




}
