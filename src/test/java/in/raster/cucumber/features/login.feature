@loginFeature
Feature: Check login functionality of HR Administrator page
@login @regression @positive @smoke
  Scenario: Check the HR Administrator user with valid credential is successfully logged in
    Given the user is on the login page
    And enter the username as "civihr_admin"
    And enter the password as "civihr_admin"
    And click on the Log in button
    Then check following menu labels are shown: home, Search, Staff, Tasks, Leave, Recruitment, Configure, Help

  #data tables negative scenarios
  Scenario: Check that edit account page is shown to the user
    Given user is logged using the credentials "civihr_admin" and "civihr_admin"
    And hover mouse over the user image on the right corner
    And click on Edit Account link

  # test case made to test the fail scenario and the report creation
@loginFalseFail
  Scenario:  Check that login button is diable
    Given the user is on the login page
    Then check the login button has text "LoginIn"
  



















