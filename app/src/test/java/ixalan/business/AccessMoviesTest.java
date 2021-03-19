package ixalan.business;
import ixalan.data.FakeMovieDB;
import ixalan.data.IMovieDB;
import org.junit.Test;
import org.junit.Before;
import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;

public class AccessMoviesTest {

    private AccessMovies accessMovie;
    private IMovieDB movieDB;

    @Before
    public void setUp()
    {
        //use fake db for unit test
        movieDB = new FakeMovieDB();

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

        //empty fake database, will contain no movie objects
        assertEquals(accessMovie.filterMovies().size(), 0);

        System.out.println("\nEnding test AccessMovies: Filter movies");
    }

}