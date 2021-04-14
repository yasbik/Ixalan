package ixalan.movieapp.presentation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import ixalan.movieapp.R;
import ixalan.movieapp.business.AccessCart;
import ixalan.movieapp.business.AccessMerchandise;
import ixalan.movieapp.objects.CartItem;
import ixalan.movieapp.objects.Merchandise;
import ixalan.movieapp.objects.Movie;

public class MovieMerchandiseActivity extends AppCompatActivity
{
    private AccessMerchandise accessMerchandise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_merchandise);

        Intent intent = getIntent();

        if (intent != null)
        {
            Movie movie = (Movie) getIntent().getSerializableExtra("MOVIE");
            accessMerchandise = new AccessMerchandise(movie);

            Merchandise item = accessMerchandise.getCurrentItem();
            showMerchandiseItem(item, accessMerchandise.getDetails());

            adjustQuantity();

            Button addQtyBtn = (Button)findViewById(R.id.addQty);
            addQtyBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    changeQuantity(true);
                }
            });
            addQtyBtn.setEnabled(accessMerchandise.merchandiseAvailable());

            Button rmvQtyBtn = (Button)findViewById(R.id.rmvQty);
            rmvQtyBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    changeQuantity(false);
                }
            });
            rmvQtyBtn.setEnabled(accessMerchandise.merchandiseAvailable());

            Button showNextBtn = (Button)findViewById(R.id.showNextButton);
            //if clicked, display movie details
            showNextBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    accessMerchandise.incrementIndexPtr();
                    Merchandise item = accessMerchandise.getCurrentItem();
                    accessMerchandise.setQuantity(0);
                    adjustQuantity();
                    showMerchandiseItem(item, accessMerchandise.getDetails());
                }
            });
            showNextBtn.setEnabled(accessMerchandise.merchandiseAvailable());

            Button addToCart = (Button)findViewById(R.id.addToCartButton);
            addToCart.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    addToCart();
                }
            });
            addToCart.setEnabled(accessMerchandise.merchandiseAvailable());

            Button viewCart = (Button)findViewById(R.id.view_cart_button);
            viewCart.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    viewCart();
                }
            });
        }
    }

    public void showMerchandiseItem(Merchandise merchandise, String details)
    {
        if (merchandise != null)
         {
            TextView merchandiseTitle = (TextView) findViewById(R.id.merchandise_item_title);
            merchandiseTitle.setText(merchandise.getName());

            ImageView merch_item_imageview = (ImageView) findViewById(R.id.merchandise_item_imageview);
            int merch_id = getResources().getIdentifier(merchandise.getImageUrl(), "drawable", getPackageName());
            merch_item_imageview.setImageResource(merch_id);

            TextView merchandiseDetails = (TextView) findViewById(R.id.merch_details_textView);
            merchandiseDetails.setText(details);
        }
    }

    public void viewCart()
    {
        Intent myIntent = new Intent(MovieMerchandiseActivity.this, ViewCartActivity.class);
        startActivity(myIntent);
    }

    public void changeQuantity(boolean increaseQty)
    {
        //update quantity in AccessMerchandise
        if (increaseQty)
        {
            if (!accessMerchandise.setQuantity(accessMerchandise.getQuantity()+1))
            {
               displayAlertMsg("Out of stock!", "Sorry, we don't have any more of this item");
            }
        }
        else
        {
            accessMerchandise.setQuantity(accessMerchandise.getQuantity()-1);
        }

        adjustQuantity();
    }

    public void adjustQuantity()
    {
        TextView merchandiseTitle = (TextView)findViewById(R.id.displayQty);
        merchandiseTitle.setText(""+accessMerchandise.getQuantity());
    }

    public void addToCart()
    {
        CartItem cartItem = accessMerchandise.getCurrentItem();
        int quantity = accessMerchandise.getQuantity();
        if (cartItem != null && quantity > 0)
        {
            cartItem.setQuantity(quantity);

            AccessCart.addCartItem(cartItem, quantity);

            displayAlertMsg("Success!", "You now have " + quantity +" of these items in cart");
        }

    }

    public void displayAlertMsg(String title, String description)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(MovieMerchandiseActivity.this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(description);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
