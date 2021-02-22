package com.example.ixalan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {

    //file names of image posters, can be replaced later with database objects
    String[] img_file_names = new String[]{"poster_1", "poster_2"};//, "poster_3.jpg", "poster_4.jpg"};

    //number of images per row
    private static final int NUMBER_OF_MOVIES_PER_ROW = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout movies_linear_layout = (LinearLayout) findViewById(R.id.movies_linear_layout);

        //pre-determine number of rows needed depending on number of movies to display
        int number_of_rows = (img_file_names.length/NUMBER_OF_MOVIES_PER_ROW) + img_file_names.length%NUMBER_OF_MOVIES_PER_ROW;

        for (int i = 0 ; i < number_of_rows ; i++)
        {
            //Row to be added to linear layout
            TableRow row = new TableRow(getApplicationContext());
            row.setLayoutParams(new TableRow.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            for (int k = NUMBER_OF_MOVIES_PER_ROW * i ; k < (img_file_names.length < NUMBER_OF_MOVIES_PER_ROW*(i+1) ? img_file_names.length : NUMBER_OF_MOVIES_PER_ROW*(i+1)) ; k++)
            {
                //ImageView to be added
                ImageView imgView = new ImageView(this);
                imgView.setImageResource(getResources().getIdentifier(img_file_names[k] , "drawable", getPackageName()));

                row.addView(imgView);
            }
            //finally add the row itself
            movies_linear_layout.addView(row);
        }

    }
}