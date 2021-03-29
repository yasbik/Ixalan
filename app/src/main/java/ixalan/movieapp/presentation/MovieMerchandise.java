package ixalan.movieapp.presentation;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ixalan.movieapp.R;

public class MovieMerchandise extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_movie_merchandise);

        Intent intent = getIntent();

        if (intent != null)
        {

        }
    }
}
