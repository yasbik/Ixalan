package ixalan.movieapp;

import android.app.Activity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.matcher.ViewMatchers.hasBackground;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.matcher.RootMatchers;
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

/*
    System tests relating to Feature #1: Movies

    Number of tests: 3
    Number of user stories under feature: 3
*/
public class MoviesTest
{
    @Rule
    public ActivityTestRule<MovieListActivity> activityRule = new ActivityTestRule<>(MovieListActivity.class);

    private ArrayList<Movie> movies;

    private int upcoming_movies_database = 0;
    private int currently_running_movies_database = 0;

    @Before
    public void setUp()
    {
        movies = Services.getiMovieDB().getAllMovies();

        //Only keep currently running as only those will show initially
        //track number of currently running and upcoming movies in the database
        for(int i = movies.size() - 1; i>=0; i--)
        {
            if (movies.get(i).isUpcoming())
            {
                upcoming_movies_database++;
            } else
            {
                currently_running_movies_database++;
            }

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

        System.out.println("\nStarting display movies acceptance test\n");

        String currently_running = activityRule.getActivity().getResources().getStringArray(R.array.movie_display_filters)[0];

        //Verification #1
        LinearLayout layout = (LinearLayout) activityRule.getActivity().findViewById(R.id.movies_list_linear_layout);
        //make sure only currently running movies are being displayed
        onView(withId(R.id.filter_movies_spinner)).check(matches(withSpinnerText(containsString(currently_running))));
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

        //restore back to original screen
        pressBack();

        System.out.println("\nFinished display movies acceptance test\n");

    }

    @Test
    /*
    User Story #3: Filter Movies

    * (Verification 1) Number of currently running movies must match number of currently running movies from database
    * (Action #1) Click on the drop down menu at the top and select "Upcoming Movies"
    * (Verification 2) Number of upcoming movies must match number of upcoming movies from database
    */
    public void test2()
    {

        System.out.println("\nStarting Filter movies acceptance test\n");

        //Assumptions made based on existing movies in the database
        assertEquals(currently_running_movies_database, 4);
        assertEquals(upcoming_movies_database, 1);

        String currently_running = activityRule.getActivity().getResources().getStringArray(R.array.movie_display_filters)[0];
        String upcoming = activityRule.getActivity().getResources().getStringArray(R.array.movie_display_filters)[1];

        //Verification #1
        LinearLayout layout = (LinearLayout) activityRule.getActivity().findViewById(R.id.movies_list_linear_layout);
        assertNotNull(layout);
        //make sure only currently running movies are being displayed (cross check spinner selection)
        onView(withId(R.id.filter_movies_spinner)).check(matches(withSpinnerText(containsString(currently_running))));
        assertEquals(layout.getChildCount(), currently_running_movies_database);

        //Action #1
        onView(withId(R.id.filter_movies_spinner)).perform(click());
        onView(withText(upcoming)).inRoot(RootMatchers.isDialog()).perform(click());

        //Verification #2
        //make sure only upcoming movies are being displayed (cross check spinner selection)
        onView(withId(R.id.filter_movies_spinner)).check(matches(withSpinnerText(containsString(upcoming))));
        assertEquals(layout.getChildCount(), upcoming_movies_database);

        //restore back to original
        onView(withId(R.id.filter_movies_spinner)).perform(click());
        onView(withText(currently_running)).inRoot(RootMatchers.isDialog()).perform(click());

        System.out.println("\nFinished Filter movies acceptance test\n");
    }
}