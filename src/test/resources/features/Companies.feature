Feature: Manage Companies Functionality

  @CompanyEdit
  Scenario: Edit a company with valid data
    Given the user is logged in
    When the user edit company with valid data
    Then the company should be successfully edited with a confirmation message

    @CompanyEditNegative
  Scenario: Edit company with invalid data
    Given the user is logged in
    When the user attempts to edit company with invalid data
    Then the company should not be added