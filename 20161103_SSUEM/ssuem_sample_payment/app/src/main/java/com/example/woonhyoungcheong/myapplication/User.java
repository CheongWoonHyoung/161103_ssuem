package com.example.woonhyoungcheong.myapplication;

import java.util.ArrayList;

/**
 * Created by cheon on 2016-11-13.
 */

public class User {
    private String mUserName;
    private String mUserWriting;
    private String mUserWriting_ID;
    User(String user_ID, String writing, String writing_ID){
        mUserName = user_ID;
        mUserWriting = writing;
        mUserWriting_ID = writing_ID;
    }

    public String getUserName(){
        return mUserName;
    }

    public  String getUserWriting(){
        return mUserWriting;
    }

    public String getUserWriting_ID() {return mUserWriting_ID; }
}
