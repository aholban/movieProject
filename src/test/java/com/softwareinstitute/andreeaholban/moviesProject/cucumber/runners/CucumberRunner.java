package com.softwareinstitute.andreeaholban.moviesProject.cucumber.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/", glue = {"com.softwareinstitute.andreeaholban.moviesProject.cucumber.stepdefinitions"})
public class CucumberRunner {
}
