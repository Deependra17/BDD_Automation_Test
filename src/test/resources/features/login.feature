Feature: User Login

  Background:
    Given User navigates to Hamro Chat URL

  @googleLogin @dataDriven @positive @negative
  Scenario Outline: Login attempt with different user credentials
    When User clicks on Google login button
    And User enters username "<username>"
    And User enters password "<password>"
    Then User should see "<result>"

    Examples:
      | username                  | password         | result                    |
      | dbohara@hamropatro.com    | validpass123     | Dashboard                 |
      | invaliduser@gmail.com     | validpass123     | Invalid email or password |
      | validuser@gmail.com       | wrongpass        | Invalid email or password |
      |                           | validpass123     | Invalid email or password |
      | validuser@gmail.com       |                  | Invalid email or password |
      |                           |                  | Invalid email or password |

  @googleLogin @edge
  Scenario: Cancel Google login midway
    When User clicks on Google login button
    And User cancels the Google login popup
    Then User should remain on the login screen

  @googleLogin @edge
  Scenario: Network failure during Google login
    When User clicks on Google login button
    And a network error occurs
    Then User should see "Network error. Please try again."

  @googleLogin @negative
  Scenario: Deny Google permission during login
    When User clicks on Google login button
    And User denies access to account information
    Then User should see "Permission denied. Unable to login."

  @googleLogin @security
  Scenario: OAuth token should be securely encrypted
    When User logs in with a valid Google account
    Then The OAuth token should be encrypted and stored securely

  @googleLogin @usability
  Scenario: Verify UI for Google login button
    Then User should see "Continue with Google" button
    And The button should follow the UI design guidelines
