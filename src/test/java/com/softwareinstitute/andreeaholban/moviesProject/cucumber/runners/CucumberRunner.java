package com.softwareinstitute.andreeaholban.moviesProject.cucumber.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.stereotype.Service;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/", glue = {"com.softwareinstitute.andreeaholban.moviesProject.cucumber.stepdefinitions"})
@CucumberContextConfiguration
@TestConfiguration
public class CucumberRunner {
}
