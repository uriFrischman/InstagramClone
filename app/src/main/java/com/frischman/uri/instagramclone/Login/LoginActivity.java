package com.frischman.uri.instagramclone.Login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.frischman.uri.instagramclone.Home.HomeActivity;
import com.frischman.uri.instagramclone.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private Context mContext;
    private ProgressBar mProgressBar;
    private EditText mEmail, mPassword;
    private TextView mPleaseWait;
    private AppCompatButton mLoginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = LoginActivity.this;

        mAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    setContentView(R.layout.activity_login);
                    mProgressBar = (ProgressBar) findViewById(R.id.loginProgressBar);
                    mProgressBar.setVisibility(View.GONE);

                    mPleaseWait = (TextView) findViewById(R.id.loginProgressBarTextView);
                    mPleaseWait.setVisibility(View.GONE);

                    mEmail = (EditText) findViewById(R.id.loginInputEmail);
                    mPassword = (EditText) findViewById(R.id.loginInputPassword);

                    mLoginButton = (AppCompatButton) findViewById(R.id.loginButton);

                } else {
                    Intent intent = new Intent(mContext, HomeActivity.class);
                    startActivity(intent);
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthStateListener != null) {
            mAuth.removeAuthStateListener(mAuthStateListener);
        }
    }
}
