Feature: Hello world!
#    Check if text is "Hello world!"

  Scenario: Text is Hello World!
    Given Text is Hello world!
    When I ask if text is Hello World!
    Then I should be told "Yes"

  Scenario: Text is not Hello World!
    Given Text is Hi!
    When I ask if text is Hello World!
    Then I should be told "No"
