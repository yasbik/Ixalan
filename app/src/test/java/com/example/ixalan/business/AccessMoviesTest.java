package com.example.ixalan.business;
import com.example.ixalan.business.AccessMovies;
import com.example.ixalan.objects.Movie;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AccessMoviesTest {

    private AccessMovie accessMovie;

    @Before
    public void setUp()
    {
        accessMovie = new AccessMovie(true, "test_criteria");
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
        assertTrue(accessMovie.isUpcoming());
        assertEquals("test_criteria", accessMovie.getSearch_criteria());

        System.out.println("\nStarting test AccessMovies: Getters");
    }

    @Test
    public void te

    @Test
    public void testAccessMovies1() {
        // match the list of all movies with list of current movies. They should be equal as there's no way of saying
        // if a movie is currently running, just return the list of hardcoded movies. This is stated in AccessMovies.java

        System.out.println("\nStarting test AccessMovies");

        AccessMovies access_movies = new AccessMovies();
        assertNotNull(access_movies);
        List<Movie> list_of_movies = access_movies.getMovies();
        List<Movie> list_of_current_movies = access_movies.getCurrentlyRunningMovies();

        for(int j = 0; j < list_of_current_movies.size(); j++) {
            assertTrue((list_of_current_movies.get(j).getMovieName()).equals(list_of_movies.get(j).getMovieName()));
        }

        System.out.println("Finished test AccessMovies");

    }

    @Test
    public void testAccessMovies2() {
        // match the list of all movies with list of upcoming movies. They should be equal as there's no way of saying
        // if a movie is upcoming, just return the list of hardcoded movies. This is stated in AccessMovies.java

        System.out.println("\nStarting testAccessMovies2");

        AccessMovies access_movies = new AccessMovies();
        assertNotNull(access_movies);
        List<Movie> list_of_movies = access_movies.getMovies();
        List<Movie> list_of_upcoming_movies = access_movies.getUpcomingMovies();

        for(int j = 0; j < list_of_upcoming_movies.size(); j++) {
            assertTrue((list_of_upcoming_movies.get(j).getMovieName()).equals(list_of_movies.get(j).getMovieName()));
        }

        System.out.println("Finished testAccessMovies2");

    }

    @Test
    public void testAccessMovies3() {
        // match the list of all movies with list of filtered movies. They should be equal
        // as the db hasn't been fully implemented, just return the list of hardcoded movies.
        // This is stated in AccessMovies.java

        System.out.println("\nStarting testAccessMovies3");

        AccessMovies access_movies = new AccessMovies();
        assertNotNull(access_movies);
        List<Movie> list_of_movies = access_movies.getMovies();
        List<Movie> list_of_filtered_movies = access_movies.getFilteredMovies("null");

        for(int j = 0; j < list_of_filtered_movies.size(); j++) {
            assertTrue((list_of_filtered_movies.get(j).getMovieName()).equals(list_of_movies.get(j).getMovieName()));
        }

        System.out.println("Finished testAccessMovies3");

    }
}