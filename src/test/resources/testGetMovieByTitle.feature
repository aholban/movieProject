Feature: Search for a movie by title

  Scenario: Successfully finding the movie
    Given The movie is in the database
    When I enter "Lord of the rings"
    Then I should get its details


  Scenario: Movie is not available
    Given The movie is not in the database
    When I enter "Lord of the rings"
    Then I should get "Movie is unavailable"