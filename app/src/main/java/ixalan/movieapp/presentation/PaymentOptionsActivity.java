package ixalan.movieapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ixalan.movieapp.R;
import ixalan.movieapp.business.AccessCart;

public class PaymentOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_options);

        /*different options of payment */
        pay_with_apple();
        pay_with_google();
        pay_with_facebook();
        pay_with_email();
        pay_with_card();

    }

    private void pay_with_apple() {
        Button mButton = (Button) findViewById(R.id.apple_payment_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentOptionsActivity.this, PaymentSuccessfulActivity.class);
                intent.putExtra("PAYMENT_MODE", "apple");
                startActivity(intent);
            }
        });
    }

    private void pay_with_google() {
        Button mButton = (Button) findViewById(R.id.google_payment_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentOptionsActivity.this, PaymentSuccessfulActivity.class);
                intent.putExtra("PAYMENT_MODE", "google");
                startActivity(intent);
            }
        });
    }

    private void pay_with_facebook() {
        Button mButton = (Button) findViewById(R.id.facebook_payment_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentOptionsActivity.this, PaymentSuccessfulActivity.class);
                intent.putExtra("PAYMENT_MODE", "facebook");
                startActivity(intent);
            }
        });
    }
    private void pay_with_email() {
        Button mButton = (Button) findViewById(R.id.email_payment_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentOptionsActivity.this, PaymentSuccessfulActivity.class);
                intent.putExtra("PAYMENT_MODE", "email");
                startActivity(intent);
            }
        });
    }

    private void pay_with_card() {
        Button mButton = (Button) findViewById(R.id.card_payment_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentOptionsActivity.this, CardPaymentActivity.class);
                startActivity(intent);
            }
        });
    }
}

