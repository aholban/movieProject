package com.softwareinstitute.andreeaholban.moviesProject.cucumber.stepdefinitions;

import com.softwareinstitute.andreeaholban.moviesProject.Film;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRateMovieStepDefinition {

    private Film movie;
    private double actualResult;

    @Given("Movie has no rating")
    public void setUpMovieWithNoRating(){
        movie = new Film("Spiderman", 120);
    }

    @Given("Movie has rating {string} and {string} people rated it")
    public void setUpMovieWithRating(String currentRating, String noRatings){
        movie = new Film("Spiderman", 120);
        movie.setStar_rating(Double.parseDouble(currentRating));
        movie.setNo_ratings(Integer.parseInt(noRatings));
    }

    @When("I give the movie {string} stars")
    public void setRating(String rating){
        movie.updateRating(Double.parseDouble(rating));
    }

    @Then("the movie should have the rating {string}")
    public void checkMovieHasCorrectRating(String rating){
        assertEquals(Double.parseDouble(rating), movie.getStar_rating());
    }
}
