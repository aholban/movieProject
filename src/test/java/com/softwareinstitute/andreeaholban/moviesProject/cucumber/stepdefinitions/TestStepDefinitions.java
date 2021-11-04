package com.softwareinstitute.andreeaholban.moviesProject.cucumber.stepdefinitions;


import com.softwareinstitute.andreeaholban.moviesProject.Film;
import com.softwareinstitute.andreeaholban.moviesProject.MovieRepository;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.stereotype.Service;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@CucumberOptions
@CucumberContextConfiguration
@TestConfiguration
@SpringBootTest
public class TestStepDefinitions {

    @Autowired
    private MovieRepository testMovies;

    private Film movie;

    @Given("movie is in database")
    public void setUpMovie(){
        movie = new Film("Batman", 120);
        testMovies.save(movie);
    }

    @When("I ask for movie")
    public void askMovie(){

    }

    @Then("I get yes")
    public void checkMovie(){
        assertEquals(testMovies.findOneByTitle("Batman").get(), movie);
    }
}
