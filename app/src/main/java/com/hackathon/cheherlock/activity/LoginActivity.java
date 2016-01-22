package com.hackathon.cheherlock.activity;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hackathon.cheherlock.R;
import com.hackathon.cheherlock.activity.SignupActivity;
import com.hackathon.cheherlock.business.SBO_AuthResponse;
import com.hackathon.cheherlock.interfaces.IWebConnected;
import com.hackathon.cheherlock.interfaces.SportusBusinessObject;
import com.hackathon.cheherlock.network.WebCallerAPI;
import com.hackathon.cheherlock.parsejson.ParseCity;
import com.hackathon.cheherlock.parsejson.ParseLoginResponse;

import java.util.ArrayList;

//import butterknife.Bind;
//import butterknife.ButterKnife;


public class LoginActivity extends AppCompatActivity implements IWebConnected {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    EditText _emailText;
    EditText _passwordText;
    Button _loginButton;
    TextView _signupLink;
    ProgressDialog progressDialogref;
    //@Bind(R.id.input_email)
    //@Bind(R.id.input_password) EditText _passwordText;
    //@Bind(R.id.btn_login) Button _loginButton;
    //@Bind(R.id.link_signup) TextView _signupLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        //ButterKnife.bind(this);
        _emailText = (EditText) this.findViewById(R.id.input_email);
        _passwordText = (EditText) this.findViewById(R.id.input_password);
        _loginButton = (Button) this.findViewById(R.id.btn_login);
        _signupLink = (TextView) this.findViewById(R.id.link_signup);
        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.Base_Theme_AppCompat_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();
        progressDialogref = progressDialog;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.

        WebCallerAPI webcaller = new WebCallerAPI();
        webcaller.setURT("http://www.sportus.netne.net/auth.php?tag=login&email="+email + "&password="+ password);
        webcaller.setConnectedActivity(this);
        webcaller.setParseStrategy(new ParseLoginResponse());
        webcaller.call();
        /*
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);*/
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
       // finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

    @Override
    public void setView(ArrayList<? extends SportusBusinessObject> sbo) {
        SBO_AuthResponse response = (SBO_AuthResponse) sbo.get(0);
        if (!response.getError())
        {
            // On complete call either onLoginSuccess or onLoginFailed
            onLoginSuccess();
            // onLoginFailed();
            progressDialogref.dismiss();
            Toast.makeText(getBaseContext(), "Login Successful", Toast.LENGTH_LONG).show();
        }
        else
            onLoginFailed();

    }
}