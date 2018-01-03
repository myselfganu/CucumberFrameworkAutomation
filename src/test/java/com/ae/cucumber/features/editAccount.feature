Feature: Check the Edit Account functionality
@editAccount
  Scenario: Check that edit account page is shown to the user
    Given user is logged using the credentials "civihr_admin" and "civihr_admin"
    And hover mouse over the user image on the right corner
    And click on Edit Account link
    #Then check edit account page is opened