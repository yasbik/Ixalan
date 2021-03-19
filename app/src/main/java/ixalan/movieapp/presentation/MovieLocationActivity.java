package ixalan.movieapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ixalan.movieapp.R;
import ixalan.movieapp.business.AccessMovies;

public class MovieLocationActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_location);

        Intent intent = getIntent();

        if (intent != null) {
            Button proceedBtn = findViewById(R.id.movie_location_button);
            //if clicked, display movie details
            proceedBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent myIntent = new Intent(MovieLocationActivity.this, MovieSeatingActivity.class);
                    startActivity(myIntent);
                }
            });
        }

    }
}
