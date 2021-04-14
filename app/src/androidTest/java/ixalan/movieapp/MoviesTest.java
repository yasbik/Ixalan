package ixalan.movieapp;
import android.app.Instrumentation;
import android.content.Intent;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.intent.Intents;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;

import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.hamcrest.CoreMatchers.containsString;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.rule.ActivityTestRule;

import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;


import ixalan.movieapp.application.Services;
import ixalan.movieapp.objects.Movie;
import ixalan.movieapp.presentation.MovieListActivity;

/*
    System tests relating to Feature #1: Movies & Feature #2: Movie details and trailers

    Number of tests: 3
    Number of user stories under all features: 5
    (Note: Multiple user stories may be tested under a single test case)
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
    Feature #1: User Story #2: See what movies are on
    Feature #2: User Story #19: Movie details
    Feature #2: User Story #20: Movie trailer

    * (Verification #1) Number of movies displaying is equal to number of movies in database
    * (Action #1) Click on any of the movies
    * (Verification #2) The movie details displayed must match the global movie
    * (Verification #3) Upon clicking the poster, the trailer must play in youtube
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
        onView(withId(R.id.merch_details_textView)).check(matches(withSubstring("Rating")));
        onView(withId(R.id.merch_details_textView)).check(matches(withSubstring("Directors")));
        onView(withId(R.id.merch_details_textView)).check(matches(withSubstring("Cast")));

        //Verification #3
        //Check that the trailer plays
        Intents.init();
        String url = activityRule.getActivity().getResources().getString(R.string.YOUTUBE_PREFIX) + "TcMBFSGVi1c"; //hardcoded url trailer for avengers (extracted from SC.script)
        Matcher<Intent> expectedIntent = allOf(hasAction(Intent.ACTION_VIEW), hasData(url));
        intending(expectedIntent).respondWith(new Instrumentation.ActivityResult(0, null));
        onView(withId(R.id.movie_poster_imageview)).perform(click());
        intended(expectedIntent);
        Intents.release();

        //restore back to original screen
        pressBack();

        System.out.println("\nFinished display movies acceptance test\n");

    }


    @Test
    /*
    User Story #3: Filter Movies

    * (Verification #1) Number of currently running movies must match number of currently running movies from database
    * (Action #1) Click on the drop down menu at the top and select "Upcoming Movies"
    * (Verification #2) Number of upcoming movies must match number of upcoming movies from database
    */
    public void test2()
    {

        System.out.println("\nStarting Filter movies acceptance test\n");

        //Assumptions made based on existing movies in the database based on what's added from SC.script
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

    @Test
    /*
    User Story #4: Lookup movies

    * (Action #1) Type something in the search box at the very top
    * (Verification #1) Only the movie names that contain the search criteria must be displayed
    */
    public void test3() throws Throwable
    {
        System.out.println("\nStarting Lookup movies acceptance test\n");

        //Action #1
        SearchView search_box = (SearchView) activityRule.getActivity().findViewById(R.id.search_movies_searchview);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                search_box.setQuery("tHe", true);
            }
        });

        //Verification #1
        ArrayList<View> movie_displays =  ((LinearLayout) activityRule.getActivity().findViewById(R.id.movies_list_linear_layout)).getTouchables();
        assertNotNull(movie_displays);
        //For each of the movies displayed, ensure that they meet the search criteria
        for(View view : movie_displays)
        {
            Button btn = (Button)view;
            String txt1 = btn.getText().toString();
            assertTrue(StringUtils.containsIgnoreCase(txt1, "tHe"));
        }

        System.out.println("\nFinished Lookup movies acceptance test\n");
    }
}