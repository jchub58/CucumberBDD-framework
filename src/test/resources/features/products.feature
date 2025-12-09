@products
Feature: Products and Shopping Cart
  As a logged in user
  I want to browse products and manage my cart
  So that I can purchase items

  Background:
    Given I am logged in as a standard user

  Scenario: View products page
    Then I should see the products page
    And I should see 6 products listed

  Scenario: Add single product to cart
    When I add "Sauce Labs Backpack" to the cart
    Then the cart badge should show 1 item

  Scenario: Add multiple products to cart
    When I add "Sauce Labs Backpack" to the cart
    And I add "Sauce Labs Bike Light" to the cart
    Then the cart badge should show 2 items

  Scenario: Remove product from cart
    Given I have added "Sauce Labs Backpack" to the cart
    When I go to the cart page
    And I remove "Sauce Labs Backpack" from the cart
    Then the cart should be empty

  Scenario: Sort products by price low to high
    When I sort products by "Price (low to high)"
    Then the products should be sorted by price ascending