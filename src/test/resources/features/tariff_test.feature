Feature:

  @TariffTest
  Scenario: Create tariff
    Given user logs in to the website
    Then user goes to tariff tab
    Then display all existing tariffs
    Then user clicks on create button
    And user fills all fields
    When user clicks on save tariff button
    Then verify tariff appeared
    Then user edit tariff
    Then user delete tariff
    And log out
