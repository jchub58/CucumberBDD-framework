@login
Feature: SauceDemo Login Functionality
  As a user of SauceDemo
  I want to be able to login to the application
  So that I can access the products page

  Scenario: Valid user login
    Given I am on the SauceDemo login page
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And I click the login button
    Then I should be redirected to the products page
    And I should see "Products" as the page title

  Scenario: Invalid user login
    Given I am on the SauceDemo login page
    When I enter username "invalid_user"
    And I enter password "wrong_password"
    And I click the login button
    Then I should see an error message
    And the error should contain "Username and password do not match"