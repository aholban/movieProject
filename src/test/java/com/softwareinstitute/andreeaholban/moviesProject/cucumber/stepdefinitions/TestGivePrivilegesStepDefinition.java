package com.softwareinstitute.andreeaholban.moviesProject.cucumber.stepdefinitions;

import com.softwareinstitute.andreeaholban.moviesProject.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGivePrivilegesStepDefinition {

    private User admin;
    private User user;


    @Given("I am an admin")
    public void setUpAdmin(){
        admin = new User("admin", "password");
        admin.setAdmin(Boolean.TRUE);
    }

    @Given("I am not an admin")
    public void setUpRegularUser(){
        admin = new User("admin", "password");
    }

    @When("I enter username {string} to create admin")
    public void makeAdmin(String username){
        user = new User(username, "1234");
        admin.givePrivileges(user);
    }

    @Then("I should get {string}")
    public void getResponse(String response){
        if(response.equals("Privileges successfully set")){
            assertEquals(Boolean.TRUE, user.getAdmin(), "Privileges not set correctly");
        }
        if(response.equals("You cannot give privileges to user")){
            assertEquals(Boolean.FALSE, user.getAdmin());
        }
    }
}
