package ixalan.movieapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import ixalan.movieapp.R;

/* details of credit card used for payment */
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

    /*proceed to pay using credit card */
    private void final_payment() {
        Button mButton = (Button) findViewById(R.id.pay_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText card_number_text = (EditText) findViewById(R.id.card_number_text);
                EditText expiry_date_text = (EditText) findViewById(R.id.expiry_date_text);
                EditText security_code_text = (EditText) findViewById(R.id.security_code_text);
                EditText card_name_text = (EditText) findViewById(R.id.card_name_text);
                EditText postal_code_text = (EditText) findViewById(R.id.postal_code_text);

                String card_number = card_number_text.getText().toString().trim();
                String expiry_date = expiry_date_text.getText().toString().trim();
                String security_code = security_code_text.getText().toString().trim();
                String card_name = card_name_text.getText().toString().trim();
                String postal_code = postal_code_text.getText().toString().trim();

                if (TextUtils.isEmpty(card_number) || card_number.length() != 16) {
                    card_number_text.setError("Please Enter Valid Credit Card number!");

                } else if (TextUtils.isEmpty(expiry_date) || expiry_date.length() != 5 || expiry_date.charAt(2) != '/' ||
                        expiry_date.charAt(0) > '1' || (expiry_date.charAt(0) == '1' && expiry_date.charAt(1) > '2') ) {
                    expiry_date_text.setError("Please Enter Valid Credit Card expiry date!");

                } else if (TextUtils.isEmpty(security_code) || security_code.length() != 3) {
                    security_code_text.setError("Please Enter Valid Credit Card CVV!");

                } else if (TextUtils.isEmpty(card_name) || alphabetic(card_name) == false) {
                    card_name_text.setError("Please Enter Valid Name!");

                } else if (TextUtils.isEmpty(postal_code)) {
                    postal_code_text.setError("Please Enter Valid Postal Code!");

                } else {
                    Intent intent = new Intent(CardPaymentActivity.this, PaymentSuccessfulActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean alphabetic(String str) {
        boolean is_alphabetic = true;
        for (int i=0; i< str.length(); i++) {
            if (!Character.isLetter(str.charAt(i)) && str.charAt(i) != ' ') {
                is_alphabetic = false;
            }
        }
        return is_alphabetic;
    }
}

