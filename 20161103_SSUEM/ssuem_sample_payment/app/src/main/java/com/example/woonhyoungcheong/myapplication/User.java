package com.example.woonhyoungcheong.myapplication;

/**
 * Created by cheon on 2016-11-13.
 */

public class User {
    private String mUserName;
    private String mUserWriting;
    User(String userName, String userWriting){
        mUserName = userName;
        mUserWriting = userWriting;
    }

    public String getUserName(){
        return mUserName;
    }

    public  String getUserWriting(){
        return mUserWriting;
    }

}
