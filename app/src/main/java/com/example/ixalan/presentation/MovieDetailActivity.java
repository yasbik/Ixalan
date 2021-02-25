package com.example.ixalan.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        //TODO: Based on the movie_name, fetch the poster and any other details from db through business layer and display it

        //Display movie name
        TextView movie_name_textview = (TextView)findViewById(R.id.movie_name_textview);
        movie_name_textview.setText(movie_display_name);
    }
}