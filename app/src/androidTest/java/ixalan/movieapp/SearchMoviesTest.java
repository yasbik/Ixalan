package ixalan.movieapp;

import android.widget.LinearLayout;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
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
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import androidx.test.runner.AndroidJUnitRunner;

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

    private ArrayList<Movie> movies;
    private int upcoming_movies_database = 0;
    private int currently_running_movies_database = 0;

    @Before
    public void setUp()
    {
        movies = Services.getiMovieDB().getAllMovies();

        //track number of currently running and upcoming movies in the database
        assertNotNull(movies);
        for(Movie movie : movies)
        {
            if (movie.isUpcoming())
            {
                upcoming_movies_database++;
            } else
            {
                currently_running_movies_database++;
            }
        }
    }

    @Test
    /*
    User Story #3: Filter Movies

    * (Verification 1) Number of currently running movies must match number of currently running movies from database
    * (Action #1) Click on the drop down menu at the top and select "Upcoming Movies"
    * (Verification 2) Number of upcoming movies must match number of upcoming movies from database
    */
    public void test1()
    {
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
    }

}
