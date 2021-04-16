package ixalan.movieapp.presentation;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import ixalan.movieapp.R;
import ixalan.movieapp.application.Main;
import ixalan.movieapp.business.AccessUser;
import ixalan.movieapp.objects.User;

public class LoginActivity extends AppCompatActivity
{
    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private Button loginBtn;
    private Button guestBtn;
    private Button signUpBtn;
    private AccessUser userAccess;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        copyDatabaseToDevice();
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
                    userAccess = new AccessUser(inputName,inputPassword);
                    User tempUser=userAccess.getUSer();
                    if(tempUser!=null){
                        showMovieListActivity();
                    }else{
                        Toast.makeText(getApplicationContext(),"This user does not exist!",Toast.LENGTH_LONG).show();
                    }
                }
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

        signUpBtn = (Button) findViewById(R.id.btnSignup);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToSignUp();
            }
        });

    }

    public void showMovieListActivity()
    {
        Intent intent = new Intent(this.getApplicationContext(), MovieListActivity.class);
        startActivity(intent);
    }
    private void copyDatabaseToDevice() {
        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {

            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);

            Main.setDBPathName(dataDirectory.toString() + "/" + Main.getDBPathName());

        } catch (final IOException ioe) {
            //Messages.warning(this, "Unable to access application data: " + ioe.getMessage());
        }
    }
    public void  copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];

            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }
    public void moveToSignUp(){
        Intent intent = new Intent(this.getApplicationContext(), SignUpActivity.class);
        startActivity(intent);
    }

}
