package com.frischman.uri.instagramclone.Utils;


import android.util.Log;

import com.onesignal.OSNotification;
import com.onesignal.OneSignal;

public class OneSignalUtil implements OneSignal.NotificationReceivedHandler {

    @Override
    public void notificationReceived(OSNotification notification) {
        Log.d("Notification Received:", notification.payload.body);
    }
}
