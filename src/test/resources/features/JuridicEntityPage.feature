Feature: verify as a user can create a legal entity

 @createAJuridicEntity
  Scenario: when user successfully log in to Supplysync,
  he should be able to create a legal entity
   Given user logs in to supplysync
    When user goes to Juridic Entity page
    And user creates a legal entity
    Then verify the course is created



