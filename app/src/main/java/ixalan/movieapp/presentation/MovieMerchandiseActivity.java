package ixalan.movieapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import ixalan.movieapp.R;
import ixalan.movieapp.business.AccessMerchandise;
import ixalan.movieapp.business.AccessMovies;
import ixalan.movieapp.objects.Merchandise;
import ixalan.movieapp.objects.Movie;

public class MovieMerchandiseActivity extends AppCompatActivity
{
    private AccessMerchandise accessMerchandise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_merchandise);

        Intent intent = getIntent();

        if (intent != null)
        {
            Movie movie = (Movie) getIntent().getSerializableExtra("MOVIE");
            accessMerchandise = new AccessMerchandise(movie);

            showMerchandiseItem(accessMerchandise.getNextItem());

            Button showNextBtn = findViewById(R.id.showNextButton);
            //if clicked, display movie details
            showNextBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    showMerchandiseItem(accessMerchandise.getNextItem());
                }
            });
        }
    }

    public void showMerchandiseItem(Merchandise merchandise)
    {

    }
}
