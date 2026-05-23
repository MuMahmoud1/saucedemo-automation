package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutFinishPage extends BasePage {
    public CheckoutFinishPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(css = "[data-test=\"complete-header\"]")
    private WebElement completeHeader;
    @FindBy(css = "[data-test=\"pony-express\"]")
    private WebElement ponyExpressImg;
    @FindBy(css = "[data-test=\"back-to-products\"]")
    private WebElement backToProductsButton;

    //Actions
    public ProductsPage clickBackToProductsButton() {
        backToProductsButton.click();
        return new ProductsPage(driver);
    }

    //Validation
    public boolean isCompleteHeaderDisplayed() {
        return completeHeader.isDisplayed();
    }
    public boolean isPonyExpressDisplayed() {
        return ponyExpressImg.isDisplayed();
    }

}
