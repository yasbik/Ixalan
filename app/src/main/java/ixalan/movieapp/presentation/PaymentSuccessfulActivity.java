package ixalan.movieapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ixalan.movieapp.R;
import ixalan.movieapp.objects.Movie;

public class PaymentSuccessfulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_success);

        Intent intent = getIntent();

        display_success_message();
        go_to_home();

    }

    /* payment successful using any payment option */
    private void display_success_message() {
        TextView payment_done_text_view = (TextView) findViewById(R.id.payment_done_text_view);
        payment_done_text_view.setText("Your payment has been successful!");
    }

    private void go_to_home() {
        Button button = (Button) findViewById(R.id.home_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaymentSuccessfulActivity.this, MovieListActivity.class));
            }
        });
    }
}
