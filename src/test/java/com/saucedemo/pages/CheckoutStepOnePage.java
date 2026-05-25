package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOnePage extends BasePage {
    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);

    }
        //--------------------- First-Step Checkout Page ---------------------//
    @FindBy(css = "[data-test=\"firstName\"]")
    private WebElement firstNameInput;
    @FindBy(css = "[data-test=\"lastName\"]")
    private WebElement lastNameInput;
    @FindBy(css = "[data-test=\"postalCode\"]")
    private WebElement postalCodeInput;
    @FindBy(css = "[data-test=\"continue\"]")
    private WebElement continueButton;
    @FindBy(css = "[data-test=\"cancel\"]")
    private WebElement cancelButton;

    public CheckoutStepTwoPage inputField(String firstName, String lastName, String postalCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
        continueButton.click();
        return new CheckoutStepTwoPage(driver);
    }
    public CartPage firstClickCancelButton() {
        cancelButton.click();
        return new CartPage(driver);
    }

}
