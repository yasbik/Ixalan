package ixalan.movieapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ixalan.movieapp.R;

public class LoginActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        Button loginBtn = (Button)findViewById(R.id.login_button);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //TODO: Validate user credentials, pass that info to the next activity using intent
                showMovieListActivity();
            }
        });

        Button guestBtn = (Button)findViewById(R.id.guest_button);
        guestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //TODO: Pass info about login as a guest to the next activity
                showMovieListActivity();
            }
        });
    }

    public void showMovieListActivity()
    {
        Intent intent = new Intent(this.getApplicationContext(), MovieListActivity.class);
        startActivity(intent);
    }
}
