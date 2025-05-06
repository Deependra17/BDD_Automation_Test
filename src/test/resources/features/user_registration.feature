Feature: User Registration via Phone and OTP

  Background:
    Given User is on the Hamro Chat registration page

  @registration @positive
  Scenario: Successful registration with valid phone and OTP
    When User enters phone number "9800000000"
    And User submits the phone number
    And User enters valid OTP "123456"
    Then User should be redirected to the profile setup page

  @registration @negative
  Scenario: Registration with invalid phone number
    When User enters phone number "1234"
    And User submits the phone number
    Then User should see an error message "Invalid phone number"

  @registration @negative
  Scenario: Registration with incorrect OTP
    When User enters phone number "9800000000"
    And User submits the phone number
    And User enters invalid OTP "999999"
    Then User should see an error message "Incorrect OTP"

  @registration @edge
  Scenario: OTP expired
    When User enters phone number "9800000000"
    And User submits the phone number
    And User enters expired OTP "123456"
    Then User should see an error message "OTP expired. Please try again"

  @registration @resend
  Scenario: Resend OTP functionality
    When User enters phone number "9800000000"
    And User submits the phone number
    And User clicks on "Resend OTP"
    Then a new OTP should be sent
