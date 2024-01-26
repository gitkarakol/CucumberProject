Feature:
  User should be able to create new branch

  @createNewBranch
  Scenario: Create new branch
  Given user logs in to the website
  Then user goes to branch tab
  Then user click on create branch button
  And user fill all field with valid info with instruction
  When user clicks on create branch button
  Then verify new branch appeared

@editBranch
Scenario: Edit branch
  And user make changes existing Master Branch
  Then verify s the existing branch has been changes

  @negativeTestCase
  Scenario: Invalid phone number in branch creation
    Then user click on create branch button second time
    And user fill all field with valid info with instruction without phone number
    When user enter incorrect phone number
    Then ensure the phone number box change its color to red





