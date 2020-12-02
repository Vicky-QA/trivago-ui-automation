Feature: This feature will test the Account registration at Trivago and raise a ticket and store the ticket id

  Scenario: User sign up at Trivago
    Given I am in the homepage
    And I click on the Login button
    And I enter the valid email address
    And I click on next button
    And I enter the valid password
    When I click on the Register button
    Then  I access the account settings
     And  I select the topic
    When  I send a message by providing all the details
    Then I should see a confirmation message
    And I store the ticket id
#  Scenario Outline: Title of your scenario outline
#    Given I want to write a step with <name>
#    When I check for the <value> in step
#    Then I verify the <status> in step
#
#    Examples:
#      | name  | value | status  |
#      | name1 |     5 | success |
#      | name2 |     7 | Fail    |
