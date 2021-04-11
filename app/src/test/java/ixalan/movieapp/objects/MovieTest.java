package ixalan.movieapp.objects;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import ixalan.movieapp.objects.Movie;
import static org.junit.Assert.*;

public class MovieTest {
    private Movie movie;
    private Movie movie2;

    @Before
    public void setUp()
    {
        movie = new Movie("Test Movie 1",
                "Test Poster",
                new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime(),
                new ArrayList<Theatre>(),
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
        assertEquals(0, new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime().compareTo(movie.getReleaseDate()));
        assertTrue(new ArrayList<Theatre>().equals(movie.getTheatres()));
        assertTrue("Test Synopsis".equals(movie.getSynopsis()));
        assertTrue("Test trailer URL".equals(movie.getTrailerUrl()));
        assertEquals(1, movie.getMovieID());
        assert(6.9 == movie.getRating());
        assertTrue("Test Cast Crew".equals(movie.getCastCrew()));
        assertTrue(new ArrayList<Merchandise>().equals(movie.getMerchandises()));

        assertTrue(movie.equals(movie2));

        System.out.println("\nFinished testMovie1\n");
    }

    @Test
    public void testMovie2()
    {
        System.out.println("\nStarting movieSetTheatreListTest\n");



        System.out.println("\nFinished movieSetTheatreListTest\n");
    }
}

