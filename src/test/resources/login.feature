@SmokeTestScenarios
Feature: Login functionality

  @SmokeTest
    Scenario Outline: Check login functionality with valid credentials
    Given User is on the login page
    When User enters valid <userName> and <password>
    And User clicks on login button
    Then User should logged in successfully

    Examples:
    |userName | password|
    |user1    |pass1   |
    |user2    |pass2   |
    |user3    |pass3   |

  Scenario: Verify login  functionality with invalid credentials
    Given User is on the login page
    When User enters invalid <userName> and <password>
    And User clicks on login button
    Then It will throw an error

  Scenario: Check user registration with valid phone number
    Given User is on the registartion page
    When User enter valid phone number
    And User enter valid OTP
    Then User should be able to register successfully
    And Sync contact popup should visible on the  landing page
