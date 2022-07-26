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
        pay_with_card();
        other_options();
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

    private void other_options() {
        Button button1 = (Button) findViewById(R.id.apple_payment_button);
        Button button2 = (Button) findViewById(R.id.google_payment_button);
        Button button3 = (Button) findViewById(R.id.facebook_payment_button);
        Button button4 = (Button) findViewById(R.id.email_payment_button);
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(PaymentOptionsActivity.this, PaymentSuccessfulActivity.class);
            startActivity(intent);
        }
    };

}

