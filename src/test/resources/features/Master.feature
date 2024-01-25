Feature:
  User should be able to create a new Master Profile and edit it

  @creationOfMasterProfile
  Scenario: Create Master
    Given user logs in to the website
    Then user goes to Master tab
    Then display all existing Masters
    Then user clicks on create button on Master Page
    And user fills all fields on Master Page
    When user clicks on save Master button
    Then verify Master appeared



@EditMaster
Scenario: Edit Master
    Then User makes changes in existing Master Profile
    And User clicks on Save button
    Then verify if the existing Master has been changed




