package com.frischman.uri.instagramclone.Home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Uri on 2017-06-06.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG = "SectionsPagerAdapter";

    private final List<Fragment> mFragmentsList = new ArrayList<>();

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentsList.size();
    }

    public void addFragment(Fragment fragment) {
        mFragmentsList.add(fragment);
    }
}
