Feature: Adding a movie to the collection

  Scenario: Successfully adding a movie
    Given The movie is not in the database
    And I am an admin
    When I enter "Lord of the rings"
    Then I should get "Saved"

  Scenario: Movie already exists
    Given The movie is in the database
    And I am an admin
    When I enter "Lord of the rings"
    Then I should get "Movie already exists"