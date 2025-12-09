@checkout
Feature: Checkout Process
  As a customer with items in cart
  I want to complete the checkout process
  So that I can purchase my items

  Background:
    Given I am logged in as a standard user
    And I have added "Sauce Labs Backpack" to the cart
    And I am on the cart page

  Scenario: Complete checkout with valid information
    When I proceed to checkout
    And I enter checkout information:
      | firstName | lastName | postalCode |
      | John      | Doe      | 12345      |
    And I continue to overview
    Then I should see the order summary
    When I finish the order
    Then I should see the order confirmation
    And I should see "Thank you for your order!"

  Scenario: Checkout validation - missing first name
    When I proceed to checkout
    And I enter checkout information:
      | firstName | lastName | postalCode |
      |           | Doe      | 12345      |
    And I continue to overview
    Then I should see error "First Name is required"

  Scenario: Checkout validation - missing postal code
    When I proceed to checkout
    And I enter checkout information:
      | firstName | lastName | postalCode |
      | John      | Doe      |            |
    And I continue to overview
    Then I should see error "Postal Code is required"