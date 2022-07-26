package ixalan.movieapp.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ixalan.movieapp.business.AccessCart;
import ixalan.movieapp.business.AccessMovieDetail;
import ixalan.movieapp.objects.CartItem;
import ixalan.movieapp.objects.Movie;

import ixalan.movieapp.R;

public class MovieDetailActivity extends AppCompatActivity {

    private Movie movie = null; //the movie whose details are being displayed
    private AccessMovieDetail accessMovieDetail = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        Intent intent = getIntent();

        if (intent.getExtras() != null)
        {
            movie = (Movie) getIntent().getSerializableExtra("MOVIE");
            accessMovieDetail = new AccessMovieDetail(movie);

            String movie_display_name = movie.getMovieName();
            String movie_poster_file_name = movie.getMoviePoster();
            String movie_synopsis = movie.getSynopsis();

            //Display movie poster
            ImageView movie_poster_imageview = (ImageView) findViewById(R.id.movie_poster_imageview);
            int movie_poster_id = getResources().getIdentifier(movie_poster_file_name, "drawable", getPackageName());
            movie_poster_imageview.setImageResource(movie_poster_id);
            movie_poster_imageview.setClickable(true);
            movie_poster_imageview.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    watchYoutubeVideo(movie.getTrailerUrl());
                }
            });

            //Display movie name
            TextView movie_name_textview = (TextView) findViewById(R.id.movie_name_textview);
            movie_name_textview.setText(movie_display_name);

            //Display movie details
            TextView movie_details_textview = (TextView) findViewById(R.id.merch_details_textView);
            movie_details_textview.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            movie_details_textview.setText(accessMovieDetail.getFullDetails());

            Button btn = (Button)findViewById(R.id.book_now_button);
            btn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    addTicketAndGoToCart();
                }
            });
            btn.setEnabled(!movie.isUpcoming());

            Button merchandise_btn = (Button)findViewById(R.id.view_merchandise_button);
            merchandise_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    displayMovieMerchandise();
                }
            });

        }
    }

    private void displayMovieMerchandise()
    {
        Intent intent = new Intent(this.getApplicationContext(), MovieMerchandiseActivity.class);
        intent.putExtra("MOVIE", movie);
        startActivity(intent);
    }

    public void addTicketAndGoToCart()
    {
        addTicket();
        Intent myIntent = new Intent(MovieDetailActivity.this, ViewCartActivity.class);
        startActivity(myIntent);
    }

    public void addTicket()
    {
        CartItem cartItem = accessMovieDetail.getMovieAsTicket();
        if (cartItem != null)
        {
            cartItem.setQuantity(1);
            AccessCart.addCartItem(cartItem, 1);
        }
    }

    public void watchYoutubeVideo(String link)
    {

        String url = getResources().getString(R.string.YOUTUBE_PREFIX)+link;
        try {
            Intent i = new Intent("android.intent.action.MAIN");
            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
            i.addCategory("android.intent.category.LAUNCHER");
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        catch(ActivityNotFoundException e) {
            // Chrome is not installed
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
        }
    }

}