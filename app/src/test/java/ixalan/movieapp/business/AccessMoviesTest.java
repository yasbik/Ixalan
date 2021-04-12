package ixalan.movieapp.business;
import ixalan.movieapp.data.FakeMovieDB;
import ixalan.movieapp.data.IMovieDB;
import ixalan.movieapp.objects.Movie;
import ixalan.movieapp.objects.Theatre;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.util.Calendar;

public class AccessMoviesTest {

    private AccessMovies accessMovie;
    private IMovieDB movieDB;

    @Before
    public void setUp()
    {
        //use fake db for unit test
        movieDB = mock(IMovieDB.class);


        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        ArrayList<Theatre> theatres = new ArrayList<Theatre>(){
            {
                add(new Theatre(1));
            }
        };

        //bunch of dummy movies to test with
        final List<Movie> movies = Arrays.asList(new Movie("Avengers Endgame", "poster_1", cal.getTime(), theatres),
                new Movie("Guardians of the galaxy", "poster_2",  cal.getTime(),  theatres),
                new Movie("Harry Potter: Deathly Hallows", "poster_3",  cal.getTime(),  theatres),
                new Movie("The Mandalorian", "poster_4",  cal.getTime(),  theatres));
        when(movieDB.getAllMovies()).thenReturn(new ArrayList<Movie>(movies));

        accessMovie = new AccessMovies(movieDB);
        accessMovie.setSearch_criteria("tHe");

    }

    @Test
    public void testNullObject()
    {
        System.out.println("\nStarting test AccessMovies: Null object(s)");

        assertNotNull(accessMovie);
        assertNotNull(accessMovie.getSearch_criteria());
        assertNotNull("List of movies shouldn't be null", accessMovie.getMovies());

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

    @Test
    public void testFilterMovies()
    {
        System.out.println("\nStarting test AccessMovies: Filter movies");

        //Only two movies with "The" in their title
        assertEquals(2, accessMovie.filterMovies().size());

        System.out.println("\nEnding test AccessMovies: Filter movies");
    }

}