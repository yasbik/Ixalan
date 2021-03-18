package com.example.ixalan.business;
import com.example.ixalan.business.AccessMovies;
import com.example.ixalan.data.IMovieDB;
import com.example.ixalan.objects.Movie;
import org.junit.Test;
import org.junit.Before;
import static org.mockito.Mockito.mock;

import org.junit.Test;


import java.util.List;

import static org.junit.Assert.*;

public class AccessMoviesTest {

    private AccessMovies accessMovie;
    private IMovieDB movieDB;

    @Before
    public void setUp()
    {
        movieDB = mock(IMovieDB.class);
        accessMovie = new AccessMovies(movieDB);

        accessMovie.setSearch_criteria("tHe");

    }

    @Test
    public void testNullObject()
    {
        System.out.println("\nStarting test AccessMovies: Null object(s)");

        assertNotNull(accessMovie);
        assertNotNull(accessMovie.getSearch_criteria());
        assertNotNull(accessMovie.getMovies());

        System.out.println("\nFinished test AccessMovies: Null object(s)");
    }

    @Test
    public void testAccessors()
    {
        //Not really necessary, but testing getters is part of TDD!
        System.out.println("\nStarting test AccessMovies: Getters");

        assertNotNull(accessMovie);
        assertFalse(accessMovie.isUpcoming());
        assertEquals("tHe", accessMovie.getSearch_criteria());

        System.out.println("\nStarting test AccessMovies: Getters");
    }

   /* @Test
    public void testFilterMovies()
    {
        System.out.println("\nStarting test AccessMovies: Filter movies");

        //TODO: Complete test case after db entries have been w

        System.out.println("\nEnding test AccessMovies: Filter movies");
    }*/

}