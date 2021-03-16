package com.example.ixalan.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ixalan.R;

public class CardPaymentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_payment_details);

        TextView card_pay_header_text_view = (TextView) findViewById(R.id.cardpay_header_text_view);
        card_pay_header_text_view.setText("   Enter Credit Card Details");

        TextView card_number_text_view = (TextView) findViewById(R.id.card_number_text_view);
        card_number_text_view.setText("Card Number");

        TextView expiry_date_text_view = (TextView) findViewById(R.id.expiry_date_text_view);
        expiry_date_text_view.setText("Expiry Date MM/YY");

        TextView security_code_text_view = (TextView) findViewById(R.id.security_code_text_view);
        security_code_text_view.setText("Security Code");

        TextView card_name_text_view = (TextView) findViewById(R.id.card_name_text_view);
        card_name_text_view.setText("Name On Card");

        TextView postal_code_text_view = (TextView) findViewById(R.id.postal_code_text_view);
        postal_code_text_view.setText("Postal Code");

        final_payment();

    }

    private void final_payment() {
        Button mButton = (Button) findViewById(R.id.pay_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardPaymentActivity.this, PaymentSuccessfulActivity.class);
                intent.putExtra("PAYMENT_MODE", "card");
                startActivity(intent);
            }
        });
    }
}
