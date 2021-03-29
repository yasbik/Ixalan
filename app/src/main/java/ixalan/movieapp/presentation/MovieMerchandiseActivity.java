package ixalan.movieapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import ixalan.movieapp.R;

public class MovieMerchandiseActivity extends AppCompatActivity
{
    private static final int MIN_SWIPPING_DISTANCE = 50;
    private static final int THRESHOLD_VELOCITY = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_merchandise);

        Intent intent = getIntent();

        if (intent != null)
        {
            ImageView img = (ImageView) findViewById(R.id.merchandise_item_imageview);
        }
    }
}
