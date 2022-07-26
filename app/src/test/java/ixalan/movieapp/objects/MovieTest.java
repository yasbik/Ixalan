package ixalan.movieapp.objects;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import ixalan.movieapp.data.ITheatreDB;
import ixalan.movieapp.objects.Merchandise;
import ixalan.movieapp.objects.Movie;
import ixalan.movieapp.objects.Theatre;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieTest {
    private Movie movie;
    private Movie movie2;

    @Before
    public void setUp()
    {

        movie = new Movie("Test Movie 1",
                "Test Poster",
                new DateTime().minusDays(10),
                new ArrayList<Theatre>() {
                    {
                        add(new Theatre(1));
                        add(new Theatre(2));
                    }
                },
                "Test Synopsis",
                "Test trailer URL");
        movie.setMovieID(1);
        movie.setRating((float)6.9);
        movie.setCastCrew("Test Cast Crew");
        movie.setMerchandiseList(new ArrayList<Merchandise>());

        movie2 = new Movie(1, "Test Movie 2");
    }

    @Test
    public void testMovie1()
    {
        System.out.println("\nStarting testMovie1\n");

        assertNotNull(movie);
        assertTrue("Test Movie 1".equals(movie.getMovieName()));
        assertTrue("Test Poster".equals(movie.getMoviePoster()));
        assertEquals(0, new DateTime().minusDays(10).toLocalDate().compareTo(movie.getReleaseDate().toLocalDate()));
        assertTrue("Test Synopsis".equals(movie.getSynopsis()));
        assertTrue("Test trailer URL".equals(movie.getTrailerUrl()));
        assertEquals(1, movie.getMovieID());
        assert((float)6.9 == movie.getRating());
        assertTrue("Test Cast Crew".equals(movie.getCastCrew()));
        assertTrue(new ArrayList<Merchandise>().equals(movie.getMerchandises()));
        assertEquals(movie.getTheatres().size(), 2);

        assertNotNull(movie2);
        assertTrue(movie.equals(movie2));

        System.out.println("\nFinished testMovie1\n");
    }
}

