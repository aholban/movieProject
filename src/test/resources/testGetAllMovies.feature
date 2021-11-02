Feature: Listing all movies
  #AS A user I WANT to see all movies available SO THAT I can find out more about them

  Scenario: Getting the details of all movies
    Given There are movies in the database
    When I ask to see all movies
    Then I get a list of movies