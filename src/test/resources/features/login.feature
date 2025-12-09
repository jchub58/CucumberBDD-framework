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

  @negative
  Scenario Outline: Invalid login attempts
    Given I am on the SauceDemo login page
    When I enter username "<username>"
    And I enter password "<password>"
    And I click the login button
    Then I should see an error message
    And the error should contain "<error_message>"

    Examples: Invalid credentials
      | username        | password      | error_message                             |
      | invalid_user    | secret_sauce  | Username and password do not match        |
      | standard_user   | wrong_pass    | Username and password do not match        |
      | locked_out_user | secret_sauce  | Sorry, this user has been locked out      |
      |                 | secret_sauce  | Username is required                      |
      | standard_user   |               | Password is required                      |

  @smoke
  Scenario: Performance glitch user login
    Given I am on the SauceDemo login page
    When I enter username "performance_glitch_user"
    And I enter password "secret_sauce"
    And I click the login button
    Then I should be redirected to the products page