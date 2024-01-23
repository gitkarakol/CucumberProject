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
  Given user logs in to the website
  And user make changes existing Master Branch
  Then user clicks on save tariff button
  Then verify s the existing branch has been changes

  @negativeTestCase
  Scenario: Invalid pone number in branch creation
    Given user logs in to the website
    Then user click on create branch button
    And user fill all field with valid info with instruction without phone number
    When user enter uncorrect phono number
    Then ensure the phone number box change its color to red





