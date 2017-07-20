package com.frischman.uri.instagramclone.Profile;

public class MenuItem {

    private int image;
    private String text;

    public MenuItem(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }
}
