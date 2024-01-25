Feature: Company Edit functional

  @CompanyEdit
  Scenario: Edit a company with valid data
    Given user logs in to the website
    When the user edit company with valid data
    Then the company should be successfully edited with a confirmation message

  @CompanyEditNegative
  Scenario: Edit company with invalid data
    When the user attempts to edit company with invalid data
    Then the company should not be added