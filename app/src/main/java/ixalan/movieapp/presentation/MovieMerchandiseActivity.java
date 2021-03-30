package ixalan.movieapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ixalan.movieapp.R;
import ixalan.movieapp.business.AccessMerchandise;
import ixalan.movieapp.business.AccessMovies;
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

            showMerchandiseItem(accessMerchandise.getNextItem());

            adjustQuantity();

            Button addQtyBtn = (Button)findViewById(R.id.addQty);
            addQtyBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    changeQuantity(true);
                }
            });

            Button rmvQtyBtn = (Button)findViewById(R.id.rmvQty);
            rmvQtyBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    changeQuantity(false);
                }
            });

            Button showNextBtn = (Button)findViewById(R.id.showNextButton);
            //if clicked, display movie details
            showNextBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    showMerchandiseItem(accessMerchandise.getNextItem());
                }
            });

            Button addToCart = (Button)findViewById(R.id.addToCartButton);
            addToCart.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    addToCart();
                }
            });
        }
    }

    public void showMerchandiseItem(Merchandise merchandise)
    {
        TextView merchandiseTitle = (TextView)findViewById(R.id.merchandise_item_title);
    }

    public void changeQuantity(boolean increaseQty)
    {
        //update quantity in AccessMerchandise
        if (increaseQty)
        {
            accessMerchandise.setQuantity(accessMerchandise.getQuantity()+1);
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
        Merchandise merchandise = accessMerchandise.getCurrentItem();
        int quantity = accessMerchandise.getQuantity();

        //Merchandise item of quantity quantity to be added to cart
        //TODO: Finish code for adding item to cart
    }
}
