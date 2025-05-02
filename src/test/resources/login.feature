Feature: User Login

  Scenario Outline: Successful login with valid credentials
    Given User enters valid email "<email>"
    And User enters valid password "<password>"
    When User clicks on login button
    Then User should be logged in successfully

    Examples:
      | email                | password |
      | bohara17d@gmail.com  | pass1    |



#  Scenario: User is not able to login with invalid credentials
#    Given User enters invalid email "" in the email field
#    And user enters invalid password "" in the password field
#    When Error message is displayed

