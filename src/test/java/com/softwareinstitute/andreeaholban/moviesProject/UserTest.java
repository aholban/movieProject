package com.softwareinstitute.andreeaholban.moviesProject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testGetUsername(){
        User user = new User("madhatter", "alice");
        String username = user.getUsername();
        assertEquals("madhatter", username, "Getting wrong username");
    }

    @Test
    public void testSetUsername(){
        User user = new User("madhatter", "alice");
        user.setUsername("wonderland");
        assertEquals("wonderland", user.getUsername(), "Setting wrong username");
    }

    @Test
    public void testGetPassword(){
        User user = new User("madhatter", "alice");
        String password = user.getPassword();
        assertEquals("alice", password, "Getting wrong password");
    }

    @Test
    public void testSetPassword(){
        User user = new User("madhatter", "alice");
        user.setPassword("wonderland");
        assertEquals("wonderland", user.getPassword(), "Setting wrong password");
    }

    @Test
    public void testGetAdmin(){
        User user = new User("madhatter", "alice");
        assertEquals(Boolean.FALSE, user.getAdmin(), "Getting wrong admin privileges");
    }

    @Test
    public void testSetAdmin(){
        User user = new User("madhatter", "alice");
        user.setAdmin(Boolean.TRUE);
        assertEquals(Boolean.TRUE, user.getAdmin(), "Setting wrong admin privileges");
    }

    @Test
    public void testGivePrivileges(){
        User user = new User("madhatter", "alice");
        User admin = new User("admin", "1234");
        String message = admin.givePrivileges(user);
        assertEquals("You cannot give privileges to user", message, "User should not be able to give privileges to others");
        admin.setAdmin(Boolean.TRUE);
        message = admin.givePrivileges(user);
        assertEquals("Privileges successfully set", message, "Didn't manage to set privileges");
    }
}
