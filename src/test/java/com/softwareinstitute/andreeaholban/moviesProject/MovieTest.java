package com.softwareinstitute.andreeaholban.moviesProject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    @Test
    public void testGetTitle(){
        Movie movie = new Movie("Lord of the rings");
        String movieTitle = movie.getTitle();
        assertEquals("Lord of the rings", movieTitle, "Wrong title");
    }

    @Test
    public void testSetTitle(){
        Movie movie = new Movie("Lord of the rings");
        movie.setTitle("Harry Potter");
        assertEquals("Harry Potter", movie.getTitle(), "Set wrong title");
    }
}
