package ixalan.movieapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ixalan.movieapp.R;

public class MovieSeatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_seating);

        Intent intent = getIntent();

        /*goes to new view where payment option can be chosen. payments faked */
        Button proceed_to_payment = (Button) findViewById(R.id.proceed_payment_btn);
        proceed_to_payment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //start payment activity
                startActivity(new Intent(MovieSeatingActivity.this, ViewCartActivity.class));
            }
        });
    }
}
