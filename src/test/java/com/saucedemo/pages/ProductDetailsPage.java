package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(css = "[data-test=\"inventory-item-name\"]")
    private List<WebElement> productName;

    @FindBy(css = "[data-test=\"inventory-item-price\"]")
    private List<WebElement> productPrice;

    @FindBy(css = "[data-test=\"inventory-item-desc\"]")
    private List<WebElement> productDescription;

    @FindBy(css = "[data-test=\"add-to-cart\"]")
    private WebElement addToCartButton;

    @FindBy(css = "[data-test=\"remove\"]")
    private WebElement removeButton;

    @FindBy(css = "[data-test=\"back-to-products\"]")
    private WebElement returnToProductsPage;

    //Validations
    public boolean isItemNameDisplayed(String itemName) {
        return  driver
                    .findElement(By.xpath("//div[@data-test='inventory-item-name'][text()='" + itemName + "']"))
                    .isDisplayed();
    }

    public boolean isItemPriceDisplayed() {
        return driver
                .findElement(By.xpath("//div[@data-test='inventory-item-price']"))
                .isDisplayed();
    }
    public boolean isItemDescriptionDisplayed() {
        return driver
                .findElement(By.xpath("//div[@data-test='inventory-item-desc']"))
                .isDisplayed();
    }


    //Actions
    public ProductDetailsPage clickAddToCartButton() {
        addToCartButton.click();
        return this;
    }

    public ProductDetailsPage clickRemoveButton() {
        removeButton.click();
        return this;
    }

    public ProductsPage clickReturnToProductsPage() {
        returnToProductsPage.click();
        return new ProductsPage(driver);
    }


}
