package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutStepTwoPage extends BasePage {
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }
    //Locators
    @FindBy(css = "[data-test=\"inventory-item-name\"]")
    private WebElement inventoryItemNameInput;
    @FindBy(css = "[data-test=\"tax-label\"]")
    private WebElement taxLabel;
    @FindBy(css = "[data-test=\"total-label\"]")
    private WebElement totalLabel;
    @FindBy(css = "[data-test=\"cancel\"]")
    private WebElement getCancelButton;
    @FindBy(css = "[data-test=\"finish\"]")              //data-test gives failure to test so we tried id instead
    private WebElement getFinishButton;

    //Actions
    public CheckoutFinishPage clickFinishButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(getFinishButton));
        getFinishButton.click();
        return new CheckoutFinishPage(driver);
    }

    public ProductDetailsPage returnProductDetailsPage() {
        inventoryItemNameInput.click();
        return new ProductDetailsPage(driver);
    }

    public ProductsPage secondCancelCheckoutPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(getCancelButton));
        getCancelButton.click();
        return new ProductsPage(driver);
    }

    //Validation
    public boolean isTotalLabelDisplayed() {
        return totalLabel.isDisplayed();
    }
    public boolean isTaxLabelDisplayed() {
        return taxLabel.isDisplayed();
    }
}
