package ixalan.movieapp.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ixalan.movieapp.R;
import ixalan.movieapp.business.AccessUser;
import ixalan.movieapp.objects.User;

public class SignUpActivity extends AppCompatActivity {
    private EditText eUserName;
    private EditText eUserEmail;
    private EditText eUserCC;
    private EditText eUserPassword;
    private Button createUser;
    private Button back;
    private AccessUser userAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        eUserName=findViewById(R.id.editTextTextPersonName);
        eUserEmail=findViewById(R.id.editTextTextPersonName2);
        eUserPassword=findViewById(R.id.editTextTextPersonName3);
        eUserCC=findViewById(R.id.editTextTextPersonName4);
        back=(Button)findViewById(R.id.button);
        createUser=(Button)findViewById(R.id.button2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getToLogin();

            }
        });

        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = eUserName.getText().toString();
                String email = eUserEmail.getText().toString();
                String password = eUserPassword.getText().toString();
                String userCC = eUserCC.getText().toString();

                if(inputName.isEmpty() ||email.isEmpty() ||password.isEmpty() ||userCC.isEmpty()){
                    Toast.makeText(getApplicationContext(),"These fields can not be empty!",Toast.LENGTH_SHORT).show();
                }else{
                    userAccess = new AccessUser(inputName,password);
                    userAccess.createUser(inputName,email,password,userCC);
                    Toast.makeText(getApplicationContext(),"New user was added!",Toast.LENGTH_LONG).show();
                    getToLogin();
                }
            }
        });

    }

    public void getToLogin(){
        Intent intent=new Intent(this.getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }

}