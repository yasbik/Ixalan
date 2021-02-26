package com.example.ixalan.objects;
import org.junit.Test;
import com.example.ixalan.objects.Movie;
import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void testMovie1()
    {
        Movie movie;

        System.out.println("\nStarting testMovie1");

        movie = new Movie("new_movie", "new_movie_url");
        assertNotNull(movie);
        assertTrue("new_movie".equals(movie.getMovieName()));
        assertTrue("new_movie_url".equals(movie.getMoviePoster()));
        assertTrue("0".equals(String.valueOf(movie.getMovieID()))); // movie Ids are not assigned yet to any movies

        System.out.println("Finished testMovie1");
    }

}
