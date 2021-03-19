package ixalan.movieapp.presentation;

import android.content.Intent;
import android.os.Bundle;
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

        String mode = "";
        if (intent.getExtras() != null) {
            mode = (String) getIntent().getSerializableExtra("PAYMENT_MODE");
        }
        display_success_message(mode);

    }

    /* payment successful using any payment option */
    private void display_success_message(String mode) {
        TextView payment_done_text_view = (TextView) findViewById(R.id.payment_done_text_view);
        String mode_string = "";
        if (mode.equals("apple")) {
            mode_string = "APPLE PAY";
        } else if (mode.equals("google")) {
            mode_string = "GOOGLE PAY";
        } else if (mode.equals("facebook")) {
            mode_string = "FACEBOOK PAY";
        } else if (mode.equals("email")) {
            mode_string = "EMAIL";
        } else if(mode.equals("card")) {
            mode_string = "CREDIT CARD";
        }
        payment_done_text_view.setText("Your payment has been successful via " + mode_string + "!");
    }
}
