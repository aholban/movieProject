package com.softwareinstitute.andreeaholban.moviesProject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilmTest {

    @Test
    void testGetTitle(){
        Film film = new Film("Lord of the rings");
        String movieTitle = film.getTitle();
        assertEquals("Lord of the rings", movieTitle, "Wrong title");
    }

    @Test
    void testSetTitle(){
        Film film = new Film("Lord of the rings");
        film.setTitle("Harry Potter");
        assertEquals("Harry Potter", film.getTitle(), "Set wrong title");
    }

    @Test
    void testGetStar_rating(){
        Film film = new Film("Lord of the rings");
        double movieRating = film.getStar_rating();
        assertEquals(0, movieRating, "Wrong rating");
    }

    @Test
    void testSetStar_rating(){
        Film film = new Film("Lord of the rings");
        film.setStar_rating(4.5);
        assertEquals(4.5, film.getStar_rating(), "Set wrong rating");
    }

    @Test
    void testGetLength(){
        Film film = new Film("Lord of the rings", 120);
        int movieLength = film.getLength();
        assertEquals(120, movieLength, "Wrong length");
    }

    @Test
    void testSetLength(){
        Film film = new Film("Lord of the rings");
        film.setLength(120);
        assertEquals(120, film.getLength(), "Set wrong length");
    }

}
