package com.frischman.uri.instagramclone.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.frischman.uri.instagramclone.R;
import com.frischman.uri.instagramclone.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class EditProfileFragment extends Fragment {

    private RecyclerView mPublicInformationRecyclerView;
    private RecyclerView mPrivateInformationRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerAdapter mPublicRecyclerAdapter;
    private RecyclerAdapter mPrivateRecyclerAdapter;
    private ImageView mProfilePhoto;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);

        mProfilePhoto = (ImageView) view.findViewById(R.id.profile_image);

        mPublicInformationRecyclerView = (RecyclerView) view.findViewById(R.id.edit_profile_recycler_view);
        mPrivateInformationRecyclerView = (RecyclerView) view.findViewById(R.id.private_information_recycler_view);

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

        initImageLoader();
        setProfileImage();

        return view;
    }

    private void initImageLoader() {
        UniversalImageLoader imageLoader = new UniversalImageLoader(getActivity());
        ImageLoader.getInstance().init(imageLoader.getConfig());
    }

    private void setProfileImage() {
        String imgUrl = "http://bbsimg.res.flymeos.com/forum/201512/11/111355ylll9m5prjm99lmw.png";
        UniversalImageLoader.setImage(imgUrl, mProfilePhoto, null, "");

    }
}
