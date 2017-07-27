package com.frischman.uri.instagramclone.Utils;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.frischman.uri.instagramclone.Home.HomeActivity;
import com.frischman.uri.instagramclone.Register.RegisterActivity;

public class NavigationUtil {

    public static void goToHomeActivity(Activity activity, Context context, boolean isFinish) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
        if (isFinish) {
            activity.finish();
        }
    }

    public static void goToRegisterActivity(Activity activity, Context context, boolean isFinish) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
        if (isFinish) {
            activity.finish();
        }
    }
}
