package ixalan.movieapp;

import android.app.Activity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static androidx.test.espresso.matcher.ViewMatchers.hasBackground;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.matcher.ViewMatchers.withTagValue;
import static org.junit.Assert.*;
import androidx.test.runner.AndroidJUnitRunner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import ixalan.movieapp.application.Services;
import ixalan.movieapp.objects.Movie;
import ixalan.movieapp.presentation.MovieDetailActivity;
import ixalan.movieapp.presentation.MovieListActivity;


public class MoviesTest
{
    @Rule
    public ActivityTestRule<MovieListActivity> activityRule = new ActivityTestRule<>(MovieListActivity.class);

    private ArrayList<Movie> movies;

    @Before
    public void setUp()
    {
        movies = Services.getiMovieDB().getAllMovies();

        //Only keep currently running as only those will show initially
        for(int i = movies.size() - 1; i>=0; i--)
        {
            if(movies.get(i).isUpcoming()) {
                movies.remove(i);
            }
        }
    }

    @Test
    /*
    User Story #2: See what movies are on

    * (Verification #1) Number of movies displaying is equal to number of movies in database
    * (Action #1) Click on any of the movies
    * (Verification #2) The movie details displayed must match the global movie
    */
    public void test1()
    {
        //Verification #1
        LinearLayout layout = (LinearLayout) activityRule.getActivity().findViewById(R.id.movies_list_linear_layout);
        //make sure only currently running movies are being displayed
        //TODO: Do the above
        assertNotNull(layout);
        assertNotNull(movies);
        assertEquals(layout.getChildCount(), movies.size());

        //Action #1
        onView(withId(R.id.sample_movie_button_id)).perform(click());

        //Verification #2
        //Movie ID 1 is Avengers Endgame
        onView(withId(R.id.movie_name_textview)).check(matches(withText("Avengers EndGame")));
        onView(withId(R.id.movie_details_textView)).check(matches(withSubstring("Rating")));
        onView(withId(R.id.movie_details_textView)).check(matches(withSubstring("Directors")));
        onView(withId(R.id.movie_details_textView)).check(matches(withSubstring("Cast")));
    }
}