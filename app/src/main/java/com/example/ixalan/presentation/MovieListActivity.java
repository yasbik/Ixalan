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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieListActivity extends AppCompatActivity

{
    //List to store currently running and upcoming movies
    //TODO: Once objects implemented, change string to object
    private List<String> list_of_movies;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list);

        //Initialize action event for the movie filter
        initializeMoviesFilterActionEvents();

        //TODO: Initialize list of currently running and upcoming movies from db through logic layer and store in list_of_movies.
        //Currently just use strings as objects haven't been implemented yet
        list_of_movies = new ArrayList<String>(){{
            add("Movie 1");
            add("Movie 2");
            add("Movie 3");
            add("Movie 4");
        }};

        populateMovies();
    }

    /*
    Action event when a filter is applied
    */
    private void initializeMoviesFilterActionEvents()
    {
        Spinner spinner = (Spinner)findViewById(R.id.movies_filter);
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                        String filter_criteria = parent.getItemAtPosition(pos).toString(); //filter that was selected
                        String[] array = getResources().getStringArray(R.array.movie_display_filters); //list of acceptable filters

                        if (Arrays.asList(array).contains(filter_criteria))
                        { //ensure valid filter criteria is selected

                            //TODO: Get list of movies based on filter from db through logic layer and store in list_of_movies.

                            //Once we know what movies meet filter criteria, populate them in-app
                            populateMovies();
                        }
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
    }

    /*
       To display list of movies in app
       Parameters: None
       Return: None
       TODO: Once objects are implemented, change code to consider objects instead of generic strings
    */
    private void populateMovies()
    {
        //Clear layout of all entries
        LinearLayout layout = (LinearLayout)findViewById(R.id.movies_display_layout);
        layout.removeAllViews();

        //Add entries one by one
        if (list_of_movies != null)
        {
            for (String movie_name : list_of_movies) {
                Button btn = new Button(this);
                btn.setText(movie_name);
                layout.addView(btn);
            }
        }
        else
        {
            //print error message saying list is null (not empty, but null)
        }
    }
}