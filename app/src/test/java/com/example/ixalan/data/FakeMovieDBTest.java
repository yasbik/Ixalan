package com.example.ixalan.data;
import org.junit.Test;
import com.example.ixalan.data.FakeMovieDB;
import com.example.ixalan.objects.Movie;
import static org.junit.Assert.*;

public class FakeMovieDBTest {
    @Test
    public void testFakeMovieDB1() {
        System.out.println("\nStarting testFakeMovieDB1");

        FakeMovieDB fake_movie_db = new FakeMovieDB();
        assertNotNull(fake_movie_db);
        Movie movie = new Movie("test_add_movie", "test_add_movie_url");
        assertNotNull(movie);

        fake_movie_db.addMovie(movie);
        int movieID = movie.getMovieID();
        Movie movie_returned = fake_movie_db.getMovie(movieID);

        assertTrue("test_add_movie".equals(movie_returned.getMovieName()));
        assertTrue("test_add_movie_url".equals(movie_returned.getMoviePoster()));

        System.out.println("Finished testFakeMovieDB1");

    }

    @Test
    public void testFakeMovieDB2() {
        System.out.println("\nStarting testFakeMovieDB2");

        FakeMovieDB fake_movie_db = new FakeMovieDB();
        assertNotNull(fake_movie_db);
        Movie movie = new Movie("test_add_movie", "test_add_movie_url");
        assertNotNull(movie);

        fake_movie_db.addMovie(movie);
        int movieID = movie.getMovieID();

        String result = String.valueOf(fake_movie_db.removeMovie(movieID));
        assertTrue(result.equals("1"));

        System.out.println("Finished testFakeMovieDB2");

    }
}
