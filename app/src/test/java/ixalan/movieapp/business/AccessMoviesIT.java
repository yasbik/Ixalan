package ixalan.movieapp.business;

import ixalan.movieapp.application.Services;
import ixalan.movieapp.data.IMovieDB;
import org.junit.Test;
import org.junit.Before;
import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;

public class AccessMoviesIT
{

    //TODO: Unable to fully write integration tests as there is an HSQLDB dependency issue (driver not found error)
    private AccessMovies accessMovies;
    private IMovieDB iMovieDB;

    @Before
    public void setUp()
    {
        //Integration test uses real database
        iMovieDB = Services.getiMovieDB();
        accessMovies = new AccessMovies(iMovieDB);
        accessMovies.setSearch_criteria("tHe");
        accessMovies.setUpcoming(true);
    }

    @Test
    public void testFilterMovies()
    {
        //One upcoming movie with "The" in it
        assertEquals(accessMovies.filterMovies().size(), 1);

        accessMovies.setSearch_criteria("");
        accessMovies.setUpcoming(false);

        //Two currently running movies overall
        assertEquals(accessMovies.filterMovies().size(), 2);
    }
}
