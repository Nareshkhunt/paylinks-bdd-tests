@login
Feature: Login
  As a customer,
  I want to login
  so that I can buy products

  Scenario: Validate login with valid email and password
    Given I am on the login page
    When I enter valid email and password for "Valid User"
    And I click on log in button
    Then I should see log out icon is Displayed
    And the url should contain with "/my-workflow"

  Scenario Outline: Validate login with correct password and wrong email
    Given I am on the login page
    When I enter incorrect email "<myEmail>" and password "<myPassword>"
    And I click on log in button
    Then I should be able to see validation message "Incorrect username or password"

    Examples:
      | myEmail       | myPassword  |
      | testgmail.com | Hello@12345 |
      | amit@gmail    | Hello@12345 |
      | @gmail.com    | Hello@12345 |
      | yash@.com     | Hello@12345 |

  Scenario Outline: Validate login with invalid password format and correct email
    Given I am on the login page
    When I enter incorrect email "<myEmail>" and password "<myPassword>"
    And I click on log in button
    Then I should be able to see validation message "Incorrect username or password"

    Examples:
      | myEmail        | myPassword    |
      | test@gmail.com | hello@12      |
      | test@gmail.com | 12345668991   |
      | test@gmail.com | absdfgfghjh   |
      | test@gmail.com | ASDFGFGHJHGHJ |
      | test@gmail.com | ;';'./;';';'  |
      | test@gmail.com | @£$%$%^&^&**  |

  Scenario: Email input field validation
    Given I am on the login page
    When I enter password "Helloo@1234" and leave email filed blank
    And I click on log in button
    Then I should be able to see validation message "Your username  required"

  Scenario: Password input field validation
    Given I am on the login page
    When I enter correct email "nkhunt@gmail.com" and leave password field blank
    And I click on log in button
    Then I should be able to see validation message "Your password  required"
