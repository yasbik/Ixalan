package ixalan.movieapp.business;
import ixalan.movieapp.data.FakeMovieDB;
import ixalan.movieapp.data.IMerchandiseDB;
import ixalan.movieapp.data.IMovieDB;
import ixalan.movieapp.objects.Merchandise;
import ixalan.movieapp.objects.Movie;
import ixalan.movieapp.objects.Theatre;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.util.Calendar;

public class AccessMoviesTest {

    private AccessMovies accessMovie;
    private IMovieDB movieDB;
    private ArrayList<Movie> movies;

    @Before
    public void setUp()
    {
        movieDB = mock(IMovieDB.class);

        DateTime yesterday = new DateTime().minusDays(1);
        DateTime tomorrow = new DateTime().plusDays(1);
        ArrayList<Theatre> theatres = new ArrayList<Theatre>(){
            {
                add(new Theatre(1));
            }
        };

        //bunch of dummy movies to test with
        movies = new ArrayList<Movie>() {
            {
                add(new Movie("Avengers Endgame", "poster_1", yesterday, theatres));
                add(new Movie("Guardians of the galaxy", "poster_2", yesterday, theatres));
                add(new Movie("Harry Potter: Deathly Hallows", "poster_3", yesterday, theatres));
                add(new Movie("The Mandalorian", "poster_4", tomorrow, theatres));
            }
        };

        when(movieDB.getAllMovies()).thenReturn(new ArrayList<Movie>(movies));

        accessMovie = new AccessMovies(movieDB);
        accessMovie.setSearch_criteria("tHe");
    }

    @Test
    public void test1()
    {
        System.out.println("\nStarting AccessMoviesTest\n");

        assertNotNull(accessMovie);
        assertNotNull(movieDB);
        assertNotNull(accessMovie.getSearch_criteria());
        assert(accessMovie.getSearch_criteria().equals("tHe"));
        assertFalse(accessMovie.isUpcoming());

        System.out.println("\nFinished AccessMoviesTest\n");
    }

    @Test
    public void testgetMovies()
    {
        System.out.println("\nStarting AccessMovies_testgetMovies\n");

        assertEquals(accessMovie.getMovies(), movies);

        System.out.println("\nFinished AccessMovies_testgetMovies\n");
    }

    @Test
    public void testGetFilterMoviesOverridden()
    {
        System.out.println("\nStarting AccessMovies_testGetFilterMoviesOverridden\n");

        //only one movie with "tHe" in it that is also upcoming
        assertEquals(accessMovie.filterMovies("tHe", true).size(), 1);

        System.out.println("\nFinished AccessMovies_testGetFilterMoviesOverridden\n");
    }

    @Test
    public void testGetFilterMovies()
    {
        System.out.println("\nStarting AccessMovies_testGetFilterMovies\n");

        //only one movie with "tHe" in it that is also currently running
        assertEquals(accessMovie.filterMovies().size(), 1);

        System.out.println("\nFinished AccessMovies_testGetFilterMovies\n");
    }

    @Test
    public void test2()
    {
        System.out.println("\nStarting AccessMoviesTest_2\n");

        accessMovie.setSearch_criteria("Test Criteria");
        assertEquals(accessMovie.getSearch_criteria(), "Test Criteria");
        accessMovie.setUpcoming(true);
        assertTrue(accessMovie.isUpcoming());

        System.out.println("\nFinished AccessMoviesTest_2\n");
    }
}