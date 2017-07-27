package com.frischman.uri.instagramclone.Register;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;

import com.frischman.uri.instagramclone.R;
import com.frischman.uri.instagramclone.Utils.FireBaseUtil;
import com.frischman.uri.instagramclone.Utils.ToastUtil;
import com.google.firebase.auth.FirebaseAuth;


public class RegisterActivity extends AppCompatActivity {

    private EditText mRegisterEmail;
    private EditText mRegisterFullName;
    private EditText mRegisterPassword;

    private AppCompatButton mRegisterButton;

    private FirebaseAuth mAuth;

    private Context mContext = RegisterActivity.this;

    private FireBaseUtil mFireBaseUtil;
    private ToastUtil mToastUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mToastUtil = new ToastUtil(mContext);
        mFireBaseUtil = new FireBaseUtil(mContext);

        mRegisterEmail = (EditText) findViewById(R.id.registerInputEmail);
        mRegisterFullName = (EditText) findViewById(R.id.registerInputFullName);
        mRegisterPassword = (EditText) findViewById(R.id.registerInputPassword);

        mRegisterButton = (AppCompatButton) findViewById(R.id.registerButton);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFireBaseUtil.createUser(mRegisterEmail.getText().toString(), mRegisterPassword.getText().toString(), mRegisterFullName.getText().toString(), null, RegisterActivity.this, mContext);
            }
        });
    }
}
