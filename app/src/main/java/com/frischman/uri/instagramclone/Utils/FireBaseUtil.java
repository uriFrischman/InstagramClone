package com.frischman.uri.instagramclone.Utils;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.frischman.uri.instagramclone.Utils.NavigationUtil.goToHomeActivity;

public class FireBaseUtil {

    private static FirebaseAuth mAuth;

    private String mUserId;

    private ToastUtil mToastUtil;
    private ViewUtil mViewUtil;

    public FireBaseUtil(Context context) {
        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            mUserId = mAuth.getCurrentUser().getUid();
        }

        mToastUtil = new ToastUtil(context);
        mViewUtil = new ViewUtil();
    }

    public static FirebaseAuth getFireBaseInstance() {
        return FirebaseAuth.getInstance();
    }

    public static DatabaseReference getDatabaseReference() {
        return FirebaseDatabase.getInstance().getReference();
    }

    public void loginUser(String email, String password, final ProgressBar progressBar, final Activity activity, final Context context) {
        final boolean progessBarExists = (progressBar != null);
        if (progessBarExists) {
            mViewUtil.setViewVisibility(progressBar, View.VISIBLE);
        }
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    mToastUtil.showToastWithMessage("Auth Successful", Toast.LENGTH_SHORT);
                    if (progessBarExists) {
                        mViewUtil.setViewVisibility(progressBar, View.GONE);
                    }
                    Log.d("ggggg", "user info: " + FirebaseDatabase.getInstance().getReference());
                    goToHomeActivity(activity, context, true);
                } else {
                    mToastUtil.showToastWithMessage(task.getException().getMessage(), Toast.LENGTH_SHORT);
                    if (progessBarExists) {
                        mViewUtil.setViewVisibility(progressBar, View.GONE);
                    }
                }
            }
        });
    }


    public void createUser(String email, String password, String fullName, final ProgressBar progressBar, final Activity activity, final Context context) {
        final boolean progressBarExists = (progressBar != null);
        if (progressBarExists) {
            mViewUtil.setViewVisibility(progressBar, View.VISIBLE);
        }

//        TODO: Implement Username Confirmation

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    mToastUtil.showToastWithMessage("Auth Successful", Toast.LENGTH_SHORT);
                    if (progressBarExists) {
                        mViewUtil.setViewVisibility(progressBar, View.GONE);
                    }
                    goToHomeActivity(activity, context, true);
                } else {
                    mToastUtil.showToastWithMessage(task.getException().getMessage(), Toast.LENGTH_SHORT);
                    if (progressBarExists) {
                        mViewUtil.setViewVisibility(progressBar, View.GONE);
                    }
                }
            }
        });
    }

    public static void logoutUser() {
        getFireBaseInstance().signOut();
    }

    public FirebaseUser getCurrentUser() {
        if (mAuth.getCurrentUser() != null) {
            return mAuth.getCurrentUser();
        } else {
            return null;
        }
    }

}
