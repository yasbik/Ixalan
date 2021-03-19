package ixalan.objects;
import org.junit.Test;
import ixalan.objects.Movie;
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

    @Test
    public void testMovie2()
    {
        Movie movie1, movie2;

        System.out.println("\nStarting testMovie2");

        movie1 = new Movie("new_movie1", "new_movie1_url");
        assertNotNull(movie1);
        movie2 = new Movie("new_movie2", "new_movie2_url");
        assertNotNull(movie2);

        try {
            validate(movie1.getMovieID(), movie2.getMovieID());
        } catch(Exception m) {
            System.out.println("Exception occured: " + m);
        }

        System.out.println("Finished testMovie2");
    }

    static void validate(int id1, int id2) throws InvalidMovieIDException {
        if (id1 == id2) {
            throw new InvalidMovieIDException("Movie IDs not valid");
        } else {
            System.out.println("valid Movie IDs");
        }
    }

}

class InvalidMovieIDException extends Exception {
    InvalidMovieIDException(String s) {
        super(s);
    }
}
