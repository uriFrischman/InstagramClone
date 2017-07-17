package com.frischman.uri.instagramclone.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frischman.uri.instagramclone.R;

import java.util.ArrayList;

/**
 * Created by Uri on 2017-07-07.
 */

public class EditProfileFragment extends Fragment {

    private RecyclerView mPublicInformationRecyclerView;
    private RecyclerView mPrivateInformationRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerAdapter mPublicRecyclerAdapter;
    private RecyclerAdapter mPrivateRecyclerAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);

        mPublicInformationRecyclerView = (RecyclerView) view.findViewById(R.id.edit_profile_recycler_view);
        mPrivateInformationRecyclerView = (RecyclerView) view.findViewById(R.id.private_information_recycler_view);

//        mPublicLinearLayoutManager = new LinearLayoutManager(getContext());


        mPublicInformationRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mPrivateInformationRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<MenuItem> menuItems = new ArrayList<>();
        ArrayList<MenuItem> privateMenuItems = new ArrayList<>();

        menuItems.add(new MenuItem(R.drawable.ic_camera, "Username"));
        menuItems.add(new MenuItem(R.drawable.ic_checkmark, "Display Name"));
        menuItems.add(new MenuItem(R.drawable.ic_website, "Website"));
        menuItems.add(new MenuItem(R.drawable.ic_camera, "Description"));

        privateMenuItems.add(new MenuItem(R.drawable.ic_email, "Email"));
        privateMenuItems.add(new MenuItem(R.drawable.ic_phone, "Phone Number"));

        mPublicRecyclerAdapter = new RecyclerAdapter(menuItems);
        mPrivateRecyclerAdapter = new RecyclerAdapter(privateMenuItems);


        mPublicInformationRecyclerView.setAdapter(mPublicRecyclerAdapter);
        mPrivateInformationRecyclerView.setAdapter(mPrivateRecyclerAdapter);


        return view;
    }
}
