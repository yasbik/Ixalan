package ixalan.movieapp.presentation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
                EditText mEdit   = (EditText)findViewById(R.id.card_name_text);
                EditText mEdit1   = (EditText)findViewById(R.id.card_number_text);
                EditText mEdit2   = (EditText)findViewById(R.id.postal_code_text);
                EditText mEdit3   = (EditText)findViewById(R.id.expiry_date_text);
                EditText mEdit4   = (EditText)findViewById(R.id.security_code_text);
                //Log.d("mytag","here");
                Log.d("mytag",mEdit.getText().toString());

                if(mEdit.getText().toString().length() != 0 && mEdit1.getText().toString().length() != 0 && mEdit2.getText().toString().length() != 0 && mEdit3.getText().toString().length() != 0 && mEdit4.getText().toString().length() != 0 )
                {
                    Intent intent = new Intent(CardPaymentActivity.this, PaymentSuccessfulActivity.class);
                    intent.putExtra("PAYMENT_MODE", "card");
                    startActivity(intent);
                }
                else
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(CardPaymentActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Please fill out all required fields.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });
    }
}

