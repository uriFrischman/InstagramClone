package com.frischman.uri.instagramclone.Utils;


public class TextUtil {

    public static boolean isTextNullOrEmty(String text) {
        if ((text == null) || (text.length() == 0)) {
            return true;
        } else {
            return false;
        }
    }
}
