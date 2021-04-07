package ixalan.movieapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ixalan.movieapp.R;
import ixalan.movieapp.business.AccessCart;
import ixalan.movieapp.business.AccessMovies;
import ixalan.movieapp.objects.CartItem;
import ixalan.movieapp.objects.Merchandise;

import ixalan.movieapp.objects.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ViewCartActivity extends AppCompatActivity {

    private HashMap<CartItem, Integer> cart_list;
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

    /*display all items in the cart on the view */
    private void populateCartList(HashMap<CartItem, Integer> cart_list)
    {
        //Clear layout of all entries
        LinearLayout layout = (LinearLayout)findViewById(R.id.view_cart_linear_layout);
        layout.removeAllViews();
        float totalPrice = 0; /*calculate total price of all cart items */
        //Add entries one by one
        if (cart_list != null) {
            for(Map.Entry<CartItem, Integer> item : cart_list.entrySet()){
                totalPrice += (item.getKey().getPrice() * item.getValue());
                Button btn = new Button(this); /*display each cart item as a button. Currently button not clickable */
                btn.setText(item.getKey().getName() + "     (Qty: " + item.getValue() + ")"); /*will make this button clickable in future to view details of item */
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

    /* pay for items in the cart */
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
