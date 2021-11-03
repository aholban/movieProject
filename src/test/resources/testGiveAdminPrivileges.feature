Feature: Give privileges to another user

  Scenario: Successfully giving admin privileges to a user
    Given I am an admin
    When I enter username "alice" to create admin
    Then I should get "Privileges successfully set"

  Scenario: Can't set privileges because I'm not an admin
    Given I am not an admin
    When I enter username "bob" to create admin
    Then I should get "You cannot give privileges to user"