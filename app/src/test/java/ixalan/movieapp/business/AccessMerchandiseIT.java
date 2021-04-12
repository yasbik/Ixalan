package ixalan.movieapp.business;

import ixalan.movieapp.application.Services;
import ixalan.movieapp.data.IMerchandiseDB;
import ixalan.movieapp.data.IMovieDB;
import ixalan.movieapp.data.MerchandiseDB;
import ixalan.movieapp.data.MovieDB;
import ixalan.movieapp.objects.Movie;
import ixalan.movieapp.utils.TestUtils;

import org.junit.Test;
import org.junit.Before;

import java.io.File;
import java.io.IOException;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;

public class AccessMerchandiseIT
{
    private AccessMerchandise accessMerchandise;
    private File tempDB;

    @Before
    public void setUp() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        final IMerchandiseDB persistence = new MerchandiseDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessMerchandise = new AccessMerchandise(persistence);
    }

    @Test
    public void testGetMerchandise()
    {
        System.out.println("\nTesting accessMerchandiseIT_testGetMerchandise\n");

        assertNotNull(accessMerchandise);
        accessMerchandise.setMovie(new Movie(1, "Avengers Endgame"));

        //Total number of merchandise items associated with movie ID #1 is 2
        //Since there's no accessor to the merchandise list, this test is performed using the index pointer
        assertEquals(accessMerchandise.getIndexPointer(), 0);
        assertNotNull(accessMerchandise.getCurrentItem());
        accessMerchandise.incrementIndexPtr();
        assertEquals(accessMerchandise.getIndexPointer(), 1);
        assertNotNull(accessMerchandise.getCurrentItem());
        accessMerchandise.incrementIndexPtr();
        assertEquals(accessMerchandise.getIndexPointer(), 0);

        System.out.println("\nFinished accessMerchandiseIT_testGetMerchandise\n");
    }
}
