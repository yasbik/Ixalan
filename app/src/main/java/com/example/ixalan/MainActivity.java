package com.example.ixalan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {

    //file names of image posters, can be replaced later with database objects
    String[] movie_names = new String[]{"poster_1", "poster_2", "poster_3.jpg", "poster_4.jpg"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = (LinearLayout)findViewById(R.id.movies_display_layout);
        for (int i = 0; i < movie_names.length; i++)
        {
            Button btn = new Button(this);
            btn.setText(movie_names[i]);
            layout.addView(btn);
        }

    }
}