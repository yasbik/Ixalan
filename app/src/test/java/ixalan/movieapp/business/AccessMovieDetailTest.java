package ixalan.movieapp.business;

import org.junit.Before;
import org.junit.Test;

import ixalan.movieapp.objects.Movie;

import static org.junit.Assert.assertNotNull;

public class AccessMovieDetailTest
{
    //TODO: Tests completed

    private AccessMovieDetail aMovieDetail;
    private Movie movie;

    @Before
    public void setUp()
    {
        movie = new Movie(1, "test_movie");

        aMovieDetail = new AccessMovieDetail(movie);

        movie.setCastCrew("This is a test Cast: /crew");
        movie.setRating((float)6.7);
        movie.setSynopsis("This is a test synopsis");
    }

    @Test
    public void test1()
    {
        System.out.println("\nStarting accessMovieDetailTest\n");

        assertNotNull(aMovieDetail);

        String fullDetails = aMovieDetail.getFullDetails();

        assertNotNull(fullDetails);
        assert(fullDetails.contains("This is a test synopsis"));
        assert(fullDetails.contains("This is a test \nCast: /crew"));
        assert(fullDetails.contains(""+(float)6.7));

        System.out.println("\nFinished accessMovieDetailTest\n");
    }
}
