package com.frischman.uri.instagramclone.Profile;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.frischman.uri.instagramclone.R;

import java.util.ArrayList;

/**
 * Created by Uri on 2017-07-16.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemHolder> {

    private ArrayList<MenuItem> mMenuItems;


    public RecyclerAdapter(ArrayList<MenuItem> menuItems) {
        mMenuItems = menuItems;
    }

    @Override
    public RecyclerAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_profile_menu_item, parent, false);
        return new ItemHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ItemHolder holder, int position) {
        MenuItem menuItem = mMenuItems.get(position);
        holder.onBindItem(menuItem);

    }

    @Override
    public int getItemCount() {
        return mMenuItems.size();
    }

    public static class ItemHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private EditText mEditText;

        public ItemHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.item_icon);
            mEditText = (EditText) itemView.findViewById(R.id.item_text);
        }

        public void onBindItem(MenuItem menuItem) {
            mEditText.setHint(menuItem.getText());
            mImageView.setImageResource(menuItem.getImage());
        }
    }
}
