package com.saucedemo.stepdefinitions;

import com.saucedemo.factory.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.ConfigReader;
import static org.junit.Assert.*;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps() {
        this.driver = DriverFactory.getDriver();
        this.loginPage = new LoginPage(driver);
    }

    @Given("I am on the SauceDemo login page")
    public void iAmOnTheSauceDemoLoginPage() {
        driver.get(ConfigReader.get("base.url"));
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the products page")
    public void iShouldBeRedirectedToTheProductsPage() {
        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @And("I should see {string} as the page title")
    public void iShouldSeeAsThePageTitle(String title) {
        String actualTitle = driver.findElement(By.className("title")).getText();
        assertEquals(title, actualTitle);
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        assertTrue(loginPage.isErrorDisplayed());
    }

    @And("the error should contain {string}")
    public void theErrorShouldContain(String errorText) {
        assertTrue(loginPage.getErrorMessage().contains(errorText));
    }
}