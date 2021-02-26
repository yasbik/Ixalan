package com.example.ixalan.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ixalan.R;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        Intent intent = getIntent();
        String movie_display_name = intent.getStringExtra(MovieListActivity.get_MOVIE_NAME());
        String movie_poster_file_name = intent.getStringExtra(MovieListActivity.get_MOVIE_POSTER());

        //Display movie poster
        ImageView movie_poster_imageview =(ImageView)findViewById(R.id.movie_poster_imageview);
        int movie_poster_id = getResources().getIdentifier(movie_poster_file_name, "drawable", getPackageName());
        movie_poster_imageview.setImageResource(movie_poster_id);

        //Display movie name
        TextView movie_name_textview = (TextView)findViewById(R.id.movie_name_textview);
        movie_name_textview.setText(movie_display_name);

        //TODO: Get additional details about the movie and display it. Since the db isn't fully implemented, just display some relevant text
        //Display movie details
        TextView movie_details_textview = (TextView)findViewById(R.id.movie_details_textView);
        movie_details_textview.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        movie_details_textview.setText("Display details of the movie \"" + movie_display_name + "\" here.");


    }
}