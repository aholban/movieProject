Feature: test repository

  Scenario: getting a movie
    Given movie is in database
    When I ask for movie
    Then I get yes