package com.frischman.uri.instagramclone.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.frischman.uri.instagramclone.R;

/**
 * Created by Uri on 2017-07-07.
 */

public class AccountSettingsActivity extends AppCompatActivity {

    private ImageView mBackButton;
    private Context mContext = AccountSettingsActivity.this;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);

        mBackButton = (ImageView) findViewById(R.id.backArrow);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
