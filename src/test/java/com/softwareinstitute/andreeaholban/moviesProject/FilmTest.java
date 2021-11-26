package com.softwareinstitute.andreeaholban.moviesProject;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FilmTest {

    @Test
    public void testDefaultConstructor(){
        Film film = new Film();
        assertNull(film.getTitle());
        assertNull(film.getDescription());
        assertNull(film.getRelease_year());
        assertEquals(0, film.getLength());
        assertEquals(0, film.getNo_ratings());
        assertEquals(0, film.getStar_rating());
        assertEquals(1, film.getLanguage_id());
    }

    @Test
    public void testGetTitle(){
        Film film = new Film("Lord of the rings");
        String movieTitle = film.getTitle();
        assertEquals("Lord of the rings", movieTitle, "Wrong title");
    }

    @Test
    public void testSetTitle(){
        Film film = new Film("Lord of the rings");
        film.setTitle("Harry Potter");
        assertEquals("Harry Potter", film.getTitle(), "Set wrong title");
    }

    @Test
    public void testGetStar_rating(){
        Film film = new Film("Lord of the rings");
        double movieRating = film.getStar_rating();
        assertEquals(0, movieRating, "Wrong rating");
    }

    @Test
    public void testSetStar_rating(){
        Film film = new Film("Lord of the rings");
        film.setStar_rating(4.5);
        assertEquals(4.5, film.getStar_rating(), "Set wrong rating");
    }

    @Test
    public void testGetNoRatings(){
        Film film = new Film("Lord of the rings");
        assertEquals(0, film.getNo_ratings(), "Getting wrong number of ratings");
    }

    @Test
    public void testSetNoRatings(){
        Film film = new Film("Lord of the rings");
        film.setNo_ratings(1);
        assertEquals(1, film.getNo_ratings(), "Setting wrong number of ratings");
    }

    @Test
    public void testGetLength(){
        Film film = new Film("Lord of the rings", 120);
        int movieLength = film.getLength();
        assertEquals(120, movieLength, "Wrong length");
    }

    @Test
    public void testSetLength(){
        Film film = new Film("Lord of the rings");
        film.setLength(120);
        assertEquals(120, film.getLength(), "Set wrong length");
    }

    @Test
    public void testSetID(){
        Film film = new Film("Lord of the rings");
        film.setFilm_id(3000);
        assertEquals(3000, film.getFilm_id(), "Wrong film ID");
    }

    @Test
    public void testGetLangID(){
        Film film = new Film("Lord of the rings");
        assertEquals(1, film.getLanguage_id(), "Getting wrong language ID");
    }

    @Test
    public void testSetLangID(){
        Film film = new Film("Lord of the rings");
        film.setLanguage_id(2);
        assertEquals(2, film.getLanguage_id(), "Set the wrong language ID");
    }

    @Test
    public void testSetDescription(){
        Film film = new Film("Lord of the rings");
        film.setDescription("Really cool fantasy movie");
        assertEquals("Really cool fantasy movie", film.getDescription(), "Wrong film description");
    }

    @Test
    public void testSetReleaseYear(){
        Film film = new Film("Lord of the rings");
        film.setRelease_year("2004");
        assertEquals("2004", film.getRelease_year(), "Wrong release year");
    }

    @Test
    public void testUpdateRating(){
        Film film = new Film("Lord of the rings");
        film.updateRating(4);
        assertEquals(4, film.getStar_rating(), "Wrong star rating when it's the first one added");
        film.updateRating(5);
        assertEquals(4.5, film.getStar_rating(), "Wrong star rating when two people rated the movie");
        assertEquals(2, film.getNo_ratings(), "Didn't update number of ratings");
    }

}
