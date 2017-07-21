package com.frischman.uri.instagramclone.Utils;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.frischman.uri.instagramclone.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;

public class GridImageAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private int layoutResource;
    private String mAppend;
    private ArrayList<String> mUrlsList;

    public GridImageAdapter(Context context, int layoutResource, String append, ArrayList<String> urlsList) {
        super(context, layoutResource, urlsList);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContext = context;
        this.layoutResource = layoutResource;
        mAppend = append;
        mUrlsList = urlsList;
    }

    private static class ViewHolder {
        ImageView mImage;
        ProgressBar mProgressBar;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder mViewHolder;

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(layoutResource, parent, false);
            mViewHolder = new ViewHolder();
            mViewHolder.mImage = (ImageView) convertView.findViewById(R.id.gridImageView);
            mViewHolder.mProgressBar = (ProgressBar) convertView.findViewById(R.id.gridImageProgressbar);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        String imgUrl = getItem(position);

        ImageLoader.getInstance().displayImage(mAppend + imgUrl, mViewHolder.mImage, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if (mViewHolder.mProgressBar != null) {
                    mViewHolder.mProgressBar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if (mViewHolder.mProgressBar != null) {
                    mViewHolder.mProgressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if (mViewHolder.mProgressBar != null) {
                    mViewHolder.mProgressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if (mViewHolder.mProgressBar != null) {
                    mViewHolder.mProgressBar.setVisibility(View.GONE);
                }
            }
        });


        return convertView;
    }
}
