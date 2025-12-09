package com.saucedemo.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.factory.DriverFactory;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;

public class CheckoutSteps {
    private WebDriver driver;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    public CheckoutSteps() {
        this.driver = DriverFactory.getDriver();
        this.cartPage = new CartPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
    }

    @Given("I am on the cart page")
    public void iAmOnTheCartPage() {
        // Navigate via products page cart link
        assertTrue(driver.getCurrentUrl().contains("cart"));
    }

    @When("I proceed to checkout")
    public void iProceedToCheckout() {
        cartPage.proceedToCheckout();
    }

    @When("I enter checkout information:")
    public void iEnterCheckoutInformation(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps();
        Map<String, String> data = rows.get(0);

        checkoutPage.fillCheckoutInfo(
                data.get("firstName"),
                data.get("lastName"),
                data.get("postalCode")
        );
    }

    @When("I continue to overview")
    public void iContinueToOverview() {
        checkoutPage.clickContinue();
    }

    @Then("I should see the order summary")
    public void iShouldSeeTheOrderSummary() {
        assertTrue(checkoutPage.isOrderSummaryDisplayed());
    }

    @When("I finish the order")
    public void iFinishTheOrder() {
        checkoutPage.clickFinish();
    }

    @Then("I should see the order confirmation")
    public void iShouldSeeTheOrderConfirmation() {
        assertTrue(driver.getCurrentUrl().contains("complete"));
    }

    @Then("I should see {string}")
    public void iShouldSee(String message) {
        assertEquals(message, checkoutPage.getConfirmationMessage());
    }

    @Then("I should see error {string}")
    public void iShouldSeeError(String errorMessage) {
        assertTrue(checkoutPage.getErrorMessage().contains(errorMessage));
    }
}