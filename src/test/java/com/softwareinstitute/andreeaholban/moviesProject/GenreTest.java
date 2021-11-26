package com.softwareinstitute.andreeaholban.moviesProject;


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GenreTest {

    @Test
    public void testDefaultConstructor(){
        Genre genre = new Genre();
        assertNull(genre.getName());
    }

    @Test
    public void testGetGenreID(){
        Genre genre = new Genre(32, "superhero");
        assertEquals(32, genre.getGenreID(), "Getting wrong genre ID");
    }

    @Test
    public void testSetGenreID(){
        Genre genre = new Genre(32, "superhero");
        genre.setGenreID(40);
        assertEquals(40, genre.getGenreID(), "Setting the wrong genre ID");
    }

    @Test
    public void testGetName(){
        Genre genre = new Genre(32, "superhero");
        assertEquals("superhero", genre.getName(), "Getting the wrong genre name");
    }

    @Test
    public void testSetName(){
        Genre genre = new Genre(32, "superhero");
        genre.setName("anime");
        assertEquals("anime", genre.getName(), "Setting wrong genre name");
    }
}
