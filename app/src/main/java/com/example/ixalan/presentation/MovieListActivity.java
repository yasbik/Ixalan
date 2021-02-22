package com.example.ixalan.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ixalan.R;

import java.util.Arrays;

public class MovieListActivity extends AppCompatActivity

{
    //Array of movie names, temporary until objects are implemented
    String[] movie_names = new String[]{"poster_1", "poster_2", "poster_3", "poster_4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list);

        LinearLayout layout = (LinearLayout)findViewById(R.id.movies_display_layout);
        for (int i = 0; i < movie_names.length; i++)
        {
            Button btn = new Button(this);
            btn.setText(movie_names[i]);
            layout.addView(btn);
        }
    }

    /*
       Function to populate list of movies
       Parameters: Array of movies
       Return: None
       TODO: Once objects are implemented, change code to consider objects instead of generic strings
    */
    private void populateMovies(Object[] movies)
    {
        //Clear layout of all entries
        LinearLayout layout = (LinearLayout)findViewById(R.id.movies_display_layout);
        layout.removeAllViews();

        //Add entries one by one
        for (int i = 0; i < movies.length; i++)
        {
            Button btn = new Button(this);
            btn.setText((String)movies[i]);
            layout.addView(btn);
        }
    }

    /*
        On action when user searches for a movie
        Parameters: None
        Return: None
        TODO: Function also has to be bound to UI element
    */
    public void searchMovie(View v)
    {
        SearchView search_box = (SearchView)findViewById(R.id.movies_search_box);
        String search_criteria = search_box.getQuery().toString().trim();

        Log.println(Log.INFO, "tag", "Searching with criteria: " + search_criteria);

        //TODO: Based on search criteria, create an array of movie objects. SEARCH_CRITERIA MUST BE SUBSTRING OF MOVIE_NAME
        Object[] movies = movie_names;

        //Once we know what movies meet search criteria, populate them in-app
        populateMovies(movies);
    }

    /*
        On action for filtering currently running and upcoming movies
        TODO: Function also has to be bound to UI element
    */
    public void filterMovie(View v)
    {
        Spinner spinner = (Spinner)findViewById(R.id.movies_filter);

        String filter_criteria = spinner.getSelectedItem().toString();
        String[] array = getResources().getStringArray(R.array.movie_display_filters);

        if (Arrays.asList(array).contains(filter_criteria))
        { //ensure valid criteria
            Log.println(Log.INFO, "tag", "Filtering with criteria: " + filter_criteria);

            //TODO: Based on filter criteria, create an array of movie objects.
            Object[] movies = movie_names;

            //Once we know what movies meet filter criteria, populate them in-app
            populateMovies(movies);
        }
    }
}
