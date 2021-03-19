package ixalan.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import ixalan.R;
import ixalan.business.AccessMovies;
import ixalan.objects.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieListActivity extends AppCompatActivity

{
    private AccessMovies accessMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list);

        accessMovies = new AccessMovies(false, "");

        //Initialize action event for the movie filter
        initializeMoviesFilterActionEvents();
        //Initialize action event for the movie search function
        initializeMoviesSearchActionEvents();

    }

    /*
    Action event when a filter is applied
    */
    private void initializeMoviesFilterActionEvents()
    {
        Spinner spinner = (Spinner)findViewById(R.id.filter_movies_spinner);
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                        String filter_criteria = parent.getItemAtPosition(pos).toString(); //filter that was selected
                        String[] array = getResources().getStringArray(R.array.movie_display_filters); //list of acceptable filters

                        if (array[0].equals(filter_criteria))
                        { //Currently running movie
                            accessMovies.setUpcoming(false);
                        } else
                        { //upcoming movie
                            accessMovies.setUpcoming(true);
                        }

                        //Once we know what movies meet filter criteria, populate them in-app
                        populateMovies(accessMovies.filterMovies());

                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
    }

    private void initializeMoviesSearchActionEvents()
    {
        SearchView search_box = (SearchView)findViewById(R.id.search_movies_searchview);

        search_box.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query)
            {   //When user searches and hits go, this code is executed
                accessMovies.setSearch_criteria(query.trim());
                populateMovies(accessMovies.filterMovies());
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                //when text changes in search field
                accessMovies.setSearch_criteria(newText.trim());
                populateMovies(accessMovies.filterMovies());

                return false;
            }
        });
    }

    /*
       To display list of movies in app
       Parameters: None
       Return: None
    */
    private void populateMovies(List<Movie> list_of_movies)
    {
        //Clear layout of all entries
        LinearLayout layout = (LinearLayout)findViewById(R.id.movies_list_linear_layout);
        layout.removeAllViews();

        //Add entries one by one
        if (list_of_movies != null)
        {
            for (Movie movie : list_of_movies) {
                Button btn = new Button(this);
                btn.setText(movie.getMovieName());
                //if clicked, display movie details
                btn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        displayMovieDetails(movie);
                    }
                });
                layout.addView(btn);
            }
        }
        else
        {
            //print error message saying list is null (not empty, but null)
        }

    }

    private void displayMovieDetails(Movie movie)
    {
        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra("MOVIE", movie);
        startActivity(intent);
    }
}