package com.example.ixalan.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ixalan.R;
import com.example.ixalan.business.AccessCart;
import com.example.ixalan.business.AccessMovies;
import com.example.ixalan.objects.Merchandise;

import com.example.ixalan.objects.Movie;

import java.util.ArrayList;

public class ViewCartActivity extends AppCompatActivity {

    private ArrayList<Merchandise> cart_list;
    private AccessCart accessCart;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_cart);

        accessCart = new AccessCart();

        //Currently just use strings as objects haven't been implemented yet
        cart_list = accessCart.getCartItems();

        populateCartList(cart_list);
        place_order();

    }

    private void populateCartList(ArrayList<Merchandise> cart_list)
    {
        //Clear layout of all entries
        LinearLayout layout = (LinearLayout)findViewById(R.id.view_cart_linear_layout);
        layout.removeAllViews();
        float totalPrice = 0;
        //Add entries one by one
        if (cart_list != null) {
            for (Merchandise item : cart_list) {
                totalPrice += item.getPrice();
                Button btn = new Button(this);
                btn.setText(item.getName() + "     $" + item.getPrice());
                //if clicked, display movie details
             //   btn.setOnClickListener(new View.OnClickListener() {
              //      public void onClick(View v) {
               //         displayMovieDetails(movie);
               //     }
            //    });
                layout.addView(btn);
            }
        } else { //print error message saying list is null (not empty, but null)
        }

        TextView total_price_text_view = (TextView) findViewById(R.id.total_price_text_view);
        total_price_text_view.setText("TOTAL     $" + totalPrice);
    }

    private void place_order() {
        Button mButton = (Button) findViewById(R.id.place_order_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewCartActivity.this, PaymentOptionsActivity.class));
            }
        });
    }

}
