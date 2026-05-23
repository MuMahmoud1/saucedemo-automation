package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(css = "[data-test=\"title\"]")
    private WebElement pageTitle;

    @FindBy(css = "[data-test^=\"add-to-cart\"]")
    private List<WebElement> addToCart;
    @FindBy(css = "[data-test^=\"remove\"]")
    private List<WebElement> removeFromCart;

    @FindBy(css = "[data-test^='inventory-item-name']")
    private List<WebElement> productNames;

    @FindBy(css = "[data-test^='inventory-item'][data-test$='-img']")
    private List<WebElement> productImages;

    @FindBy(css = "[data-test=\"inventory-item-price\"]")
    private List<WebElement> productPrices;


    //Actions
    public ProductsPage addOneProductToCart(String productName) {
        driver
                .findElement(By.xpath("//button[@data-test='add-to-cart-" + productName + "']"))
                .click();
        return this;
    }
    public ProductsPage removeOneProductFromCart(String productName) {
        driver
                .findElement(By.xpath("//button[@data-test='remove-" + productName + "']"))
                .click();
        return this;
    }

    public ProductsPage addAllProductsToCart() {
        List<WebElement> addButtons = driver.findElements(
                By.cssSelector("[data-test^='add-to-cart']")
        );
        for (WebElement button : addButtons) {
            button.click();
        }
        return this;
    }
    public void removeAllProductsFromCart() {
        List<WebElement> removeButtons = driver.findElements(
                By.cssSelector("[data-test^='remove']")
        );
        for (WebElement button : removeButtons) {
            button.click();
        }
    }


    public ProductDetailsPage goToProductDetailsByText(String productName) {
        driver
                .findElement(By.xpath("//div[@data-test='inventory-item-name'][text()='" + productName + "']"))
                .click();
       return new ProductDetailsPage(driver);
    }

    public ProductDetailsPage goToProductDetailsByImage(String productName) {
        driver
                .findElement(By.xpath("//img[@data-test='inventory-item-" + productName + "-img']"))
                .click();
        return new ProductDetailsPage(driver);
    }


    //Validation
    public boolean isPageTitleDisplayed() {
        return pageTitle.isDisplayed();
    }

    //------------------- Sorting -------------------//
    @FindBy(css = "[data-test=\"product-sort-container\"]")
    private WebElement productSortContainer;

    public ProductsPage sortBy(String sortBy) {
        Select selectSortBy = new Select(productSortContainer);
        selectSortBy.selectByVisibleText(sortBy);
        return this;
    }

    public String getProductFirstName() {
        return productNames.get(0).getText();
    }
    public String getProductLastName() {
        return productNames.get(productNames.size() - 1).getText();
    }
    public String getLowestProductPrice() {
        return productPrices.get(0).getText();
    }
    public String getHighestProductPrice() {
        return productPrices.get(0).getText();
    }


}