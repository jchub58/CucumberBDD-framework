package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By cancelButton = By.id("cancel");
    private By finishButton = By.id("finish");
    private By errorMessage = By.cssSelector("[data-test='error']");
    private By completeHeader = By.className("complete-header");
    private By summaryTotal = By.className("summary_total_label");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {
        waitAndSendKeys(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        waitAndSendKeys(lastNameField, lastName);
    }

    public void enterPostalCode(String postalCode) {
        waitAndSendKeys(postalCodeField, postalCode);
    }

    public void fillCheckoutInfo(String firstName, String lastName, String postalCode) {
        if (firstName != null && !firstName.isEmpty()) {
            enterFirstName(firstName);
        }
        if (lastName != null && !lastName.isEmpty()) {
            enterLastName(lastName);
        }
        if (postalCode != null && !postalCode.isEmpty()) {
            enterPostalCode(postalCode);
        }
    }

    public void clickContinue() {
        waitAndClick(continueButton);
    }

    public void clickFinish() {
        waitAndClick(finishButton);
    }

    public String getErrorMessage() {
        return waitAndGetText(errorMessage);
    }

    public String getConfirmationMessage() {
        return waitAndGetText(completeHeader);
    }

    public boolean isOrderSummaryDisplayed() {
        return isElementPresent(summaryTotal);
    }
}