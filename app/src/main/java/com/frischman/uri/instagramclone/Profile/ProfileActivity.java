package com.frischman.uri.instagramclone.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.frischman.uri.instagramclone.R;
import com.frischman.uri.instagramclone.Utils.BottonNavigationViewHelper;
import com.frischman.uri.instagramclone.Utils.GridImageAdapter;
import com.frischman.uri.instagramclone.Utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM = 4;
    private static final int NUM_GRID_COLUMNS = 3;

    private Context mContext = ProfileActivity.this;
    private ProgressBar mProgressBar;
    private ImageView mProfilePhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: srarts.");

        setupActivityWidgets();
        setupBottomNavigationView();
        setupToolbar();
        setProfileImage();
        tempSetupGridView();
    }

    private void tempSetupGridView () {
        ArrayList<String> imgUrls = new ArrayList<>();
        imgUrls.add("http://loremflickr.com/320/240/dog");
        imgUrls.add("http://loremflickr.com/320/240/dog");
        imgUrls.add("http://loremflickr.com/320/240/dog");
        imgUrls.add("http://loremflickr.com/320/680/dog");
        imgUrls.add("http://loremflickr.com/320/240/dog");
        imgUrls.add("http://loremflickr.com/320/240/dog");
        imgUrls.add("http://loremflickr.com/320/240/dog");
        imgUrls.add("http://loremflickr.com/320/240/dog");

        setupImageGridView(imgUrls);

    }

    private void setupImageGridView(ArrayList<String> listOfImages) {
        GridView gridView = (GridView) findViewById(R.id.grid_view);

        int gridWitdh = getResources().getDisplayMetrics().widthPixels / NUM_GRID_COLUMNS;
        gridView.setColumnWidth(gridWitdh);

        GridImageAdapter gridImageAdapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview, "", listOfImages);
        gridView.setAdapter(gridImageAdapter);

    }

    private void setProfileImage() {
        String stringUrl = "battleroyalewithcheese.com/wp-content/uploads/2015/06/Homer_simpsonwoohooo.gif";
        UniversalImageLoader.setImage(stringUrl, mProfilePhoto, mProgressBar,"http://");
    }

    private void setupActivityWidgets() {
        mProgressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        mProfilePhoto = (ImageView) findViewById(R.id.profile_image);

    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = (ImageView) findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AccountSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    // BottomNavigationView Setup
    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottonNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottonNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
