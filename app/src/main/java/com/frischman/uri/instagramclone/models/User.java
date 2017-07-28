package com.frischman.uri.instagramclone.models;


public class User {

    private String mUsername;
    private String mUserId;
    private String mPhoneNumber;
    private String mEmail;

    public User(String username, String userId, String phoneNumber, String email) {
        mUsername = username;
        mUserId = userId;
        mPhoneNumber = phoneNumber;
        mEmail = email;
    }

    public User() {

    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "mUsername='" + mUsername + '\'' +
                ", mUserId='" + mUserId + '\'' +
                ", mPhoneNumber='" + mPhoneNumber + '\'' +
                ", mEmail='" + mEmail + '\'' +
                '}';
    }
}
