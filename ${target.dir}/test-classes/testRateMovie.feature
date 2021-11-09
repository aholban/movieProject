Feature: Rate a movie

  Scenario: Rate a movie that hasn't been rated before
    Given Movie has no rating
    When I give the movie "4.5" stars
    Then the movie should have the rating "4.5"

  Scenario: Rate a movie that has rating 4 and was only rated once
    Given Movie has rating "4" and "1" people rated it
    When I give the movie "5" stars
    Then the movie should have the rating "4.5"

  Scenario: Rate a movie that has rating 3 and was rated 3 times
    Given Movie has rating "3" and "3" people rated it
    When I give the movie "4" stars
    Then the movie should have the rating "3.25"