package ixalan.movieapp.business;

import org.junit.Before;
import org.junit.Test;

import ixalan.movieapp.objects.Movie;

import static org.junit.Assert.assertNotNull;

public class AccessMovieDetailTest
{
    //TODO: Tests completed
    
    private AccessMovieDetail accessMovieDetail;
    private Movie movie;

    @Before
    public void setUp()
    {
        movie = new Movie(1, "test_movie");

        accessMovieDetail = new AccessMovieDetail(movie);

        final String test_synopsis = "This is a test synopsis";
        final String test_castcrew = "This is a test cast/crew";
        final float test_rating = (float)6.7;

        movie.setCastCrew(test_synopsis);
        movie.setRating(test_rating);
        movie.setSynopsis(test_castcrew);
    }

    @Test
    public void test1()
    {
        assertNotNull(accessMovieDetail);

        String fullDetails = accessMovieDetail.getFullDetails();

        assert(fullDetails.contains(movie.getSynopsis()));
        assert(fullDetails.contains(movie.getCastCrew()));
        assert(fullDetails.contains(""+movie.getRating()));
    }
}
