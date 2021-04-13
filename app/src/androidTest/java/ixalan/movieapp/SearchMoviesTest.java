package ixalan.movieapp;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import ixalan.movieapp.application.Services;
import ixalan.movieapp.objects.Movie;
import ixalan.movieapp.presentation.MovieListActivity;

public class SearchMoviesTest {
    @Rule
    public ActivityTestRule<MovieListActivity> activityRule = new ActivityTestRule<>(MovieListActivity.class);

    /*
    User Story #2: See what movies are on

    * (Verification #1) Number of movies displaying is equal to number of movies in database
    * (Action) Click on any of the movies
    * (Verification #2) The movie details displayed must match the global movie
    */

    @Before
    public void setUp()
    {

    }

    @Test
    public void test1()
    {

    }

}
