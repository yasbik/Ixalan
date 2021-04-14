package ixalan.movieapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ixalan.movieapp.R;

public class LoginActivity extends AppCompatActivity
{
    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private Button loginBtn;
    private Button guestBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        eName = findViewById(R.id.user_name_plain_text);
        ePassword = findViewById(R.id.password_field_password);
        loginBtn = (Button)findViewById(R.id.login_button);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String inputName = eName.getText().toString();
                String inputPassword  = ePassword.getText().toString();
                //check to see if the fields are empty.
                if (inputName.isEmpty() || inputPassword.isEmpty()){
                    Toast.makeText(getApplicationContext(),"User Name and Password can not be empty!",Toast.LENGTH_SHORT).show();
                }else{
                    //TODO: Pass info about login as a guest to the next activity
                    showMovieListActivity();
                }
            }
        });

        guestBtn = (Button)findViewById(R.id.guest_button);
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
