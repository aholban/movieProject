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

    @Test
    public void testGetRating(){
        Movie movie = new Movie("Lord of the rings");
        double movieRating = movie.getRating();
        assertEquals(0, movieRating, "Wrong rating");
    }

    @Test
    public void testSetRating(){
        Movie movie = new Movie("Lord of the rings");
        movie.setRating(9.7);
        assertEquals(9.7, movie.getRating(), "Set wrong rating");
    }

    @Test
    public void testGetLength(){
        Movie movie = new Movie("Lord of the rings", 120);
        int movieLength = movie.getLength();
        assertEquals(120, movieLength, "Wrong length");
    }

    @Test
    public void testSetLength(){
        Movie movie = new Movie("Lord of the rings");
        movie.setLength(120);
        assertEquals(120, movie.getLength(), "Set wrong length");
    }

    @Test
    public void testGetJasonObject(){
        Movie movie = new Movie("Lord of the rings");
        String json = movie.getJasonObjectOfMovie();
        assertEquals("{\"title\" : \"Lord of the rings\"}", json, "Generated wrong jason file");
    }
}
