package com.softwareinstitute.andreeaholban.moviesProject.cucumber.stepdefinitions;

import com.softwareinstitute.andreeaholban.moviesProject.Film;
import com.softwareinstitute.andreeaholban.moviesProject.MovieRepository;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCucumberStepDefinition {


    private String input;
    private String actualAnswer;


    @Given("Text is Hello world!")
    public void textIsHelloWorld() {
        input = "Hello world!";
    }


    @Given("Text is Hi!")
    public void textIsHi() {
        input = "Hi!";
    }

    @When("I ask if text is Hello World!")
    public void iAskIfTextIsHelloWorld() {
        if(input.equals("Hello world!")) actualAnswer = "Yes";
        else actualAnswer = "No";
    }

    @Then("I should be told {string}")
    public void iShouldBeTold(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }




}
