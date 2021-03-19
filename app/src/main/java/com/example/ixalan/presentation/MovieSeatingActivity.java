package com.example.ixalan.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ixalan.R;

public class MovieSeatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_seating);

        Intent intent = getIntent();

        if (intent != null) {

            Button proceed_to_payment = (Button) findViewById(R.id.proceed_payment_btn);
            proceed_to_payment.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //start payment activity
                }
            });
        }
    }
}
