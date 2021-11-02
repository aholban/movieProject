package com.softwareinstitute.andreeaholban.moviesProject.cucumber.stepdefinitions;

import com.softwareinstitute.andreeaholban.moviesProject.Film;
import com.softwareinstitute.andreeaholban.moviesProject.MovieRepository;
import com.softwareinstitute.andreeaholban.moviesProject.MoviesProjectApplication;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class TestFilmStepDefinition {



    private List<Film> actualMovies = new ArrayList<>();

    @Given("There are movies in the database")
    public void setUpMovieDB(){
        assertEquals("Need to implement test for getting all movies", true, false);
    }

    @When("I ask to see all movies")
    public void seeAllMovies(){

    }

    @Then("I get a list of movies")
    public void checkGettingAllMovies(){

    }
}
