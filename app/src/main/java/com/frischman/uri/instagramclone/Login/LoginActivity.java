package com.frischman.uri.instagramclone.Login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.frischman.uri.instagramclone.R;
import com.frischman.uri.instagramclone.Utils.FireBaseUtil;
import com.frischman.uri.instagramclone.Utils.ToastUtil;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.frischman.uri.instagramclone.Utils.FireBaseUtil.getFireBaseInstance;
import static com.frischman.uri.instagramclone.Utils.FireBaseUtil.logoutUser;
import static com.frischman.uri.instagramclone.Utils.NavigationUtil.goToHomeActivity;
import static com.frischman.uri.instagramclone.Utils.NavigationUtil.goToRegisterActivity;
import static com.frischman.uri.instagramclone.Utils.TextUtil.isTextNullOrEmty;


public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private Context mContext;
    private ProgressBar mProgressBar;
    private EditText mEmail, mPassword;
    private TextView mPleaseWait, mSignUp;
    private AppCompatButton mLoginButton;

    private FireBaseUtil mFireBaseUtil;
    private ToastUtil mToastUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = LoginActivity.this;
        mFireBaseUtil = new FireBaseUtil(mContext);
        mToastUtil = new ToastUtil(mContext);
        logoutUser();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = mFireBaseUtil.getCurrentUser();
                if (user == null) {
                    setContentView(R.layout.activity_login);
                    mProgressBar = (ProgressBar) findViewById(R.id.loginProgressBar);
                    mProgressBar.setVisibility(View.GONE);

                    mPleaseWait = (TextView) findViewById(R.id.loginProgressBarTextView);
                    mPleaseWait.setVisibility(View.GONE);

                    mEmail = (EditText) findViewById(R.id.loginInputEmail);
                    mPassword = (EditText) findViewById(R.id.loginInputPassword);

                    mLoginButton = (AppCompatButton) findViewById(R.id.loginButton);

                    mSignUp = (TextView) findViewById(R.id.loginSignUp);

                    mSignUp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            goToRegisterActivity(LoginActivity.this, mContext, false);
                        }
                    });

                    mLoginButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (isTextNullOrEmty(mEmail.getText().toString()) || isTextNullOrEmty(mPassword.getText().toString())) {
                                mToastUtil.showToastWithMessage("Please enter all fields", Toast.LENGTH_SHORT);
                            }
                            else {
                                mFireBaseUtil.loginUser(mEmail.getText().toString(), mPassword.getText().toString(), mProgressBar, LoginActivity.this, mContext);
                            }
                        }
                    });

                } else {
                    goToHomeActivity(LoginActivity.this, mContext, true);
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        getFireBaseInstance().addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthStateListener != null) {
            getFireBaseInstance().removeAuthStateListener(mAuthStateListener);
        }
    }
}
