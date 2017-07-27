package com.frischman.uri.instagramclone.Utils;


import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

    private Context mContext;

    public ToastUtil(Context context) {
        mContext = context;
    }

    public void showToastWithMessage(String message, int duration) {
        Toast.makeText(mContext, message, duration).show();
    }
}
