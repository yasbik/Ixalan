package ixalan.movieapp.business;

import ixalan.movieapp.application.Services;
import ixalan.movieapp.data.IMerchandiseDB;
import ixalan.movieapp.data.IMovieDB;
import ixalan.movieapp.data.MerchandiseDB;
import ixalan.movieapp.data.MovieDB;
import ixalan.movieapp.utils.TestUtils;

import org.junit.Test;
import org.junit.Before;

import java.io.File;
import java.io.IOException;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;

public class AccessMoviesIT
{

    private AccessMovies accessMovies;
    private File tempDB;

    @Before
    public void setUp() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        final IMovieDB persistence = new MovieDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessMovies = new AccessMovies(persistence);
    }

    @Test
    public void testGetMovies()
    {
        System.out.println("\nTesting accessMoviesIT_testGetMovies\n");

        //Total number of movies from SC.script
        assertEquals(accessMovies.getMovies().size(), 4);

        System.out.println("\nFinished accessMoviesIT_testGetMovies\n");
    }

    public void testFilterMovies()
    {
        System.out.println("\nTesting accessMoviesIT_testFilterMovies\n");

        //Total number of upcoming movies from SC.script
        assertEquals(accessMovies.filterMovies("", true).size(), 0);

        System.out.println("\nFinished accessMoviesIT_testFilterMovies\n");
    }
}
