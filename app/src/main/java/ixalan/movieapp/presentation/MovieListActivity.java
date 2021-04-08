package ixalan.movieapp.presentation;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import ixalan.movieapp.R;
import ixalan.movieapp.application.Main;
import ixalan.movieapp.application.Services;
import ixalan.movieapp.business.AccessMovies;
import ixalan.movieapp.objects.Movie;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
        copyDatabaseToDevice();
       //initDB();

        accessMovies = new AccessMovies(false, "");

        //Initialize action event for the movie filter
        initializeMoviesFilterActionEvents();
        //Initialize action event for the movie search function
        initializeMoviesSearchActionEvents();
        //Initialize action event for viewing booking history
        initializeBookingHistoryActionEvent();
        view_cart();


    }

    private void initializeBookingHistoryActionEvent()
    {
        Button historyButton = (Button) findViewById(R.id.booking_history_button);
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Pass user information in intent to retrieve booking history
                Intent intent = new Intent(MovieListActivity.this, BookingHistoryActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initDB()
    {
        final String DB_PATH = "db";
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        Main.setDBPathName(dataDirectory.toString() + "/" + Main.getDBPathName());
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

    private void view_cart() {
        Button mmButton = (Button) findViewById(R.id.cart_button);
        mmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MovieListActivity.this, ViewCartActivity.class));
            }
        });
    }

    private void copyDatabaseToDevice() {
        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {

            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);

            Main.setDBPathName(dataDirectory.toString() + "/" + Main.getDBPathName());

        } catch (final IOException ioe) {
            //Messages.warning(this, "Unable to access application data: " + ioe.getMessage());
        }
    }

    public void  copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];

            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }

}