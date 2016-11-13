package com.example.woonhyoungcheong.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by cheon on 2016-11-14.
 */

public class CheckableLinearLayout extends LinearLayout implements Checkable {

    private ArrayList<Boolean>checkedOrNot;

    public CheckableLinearLayout(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    public boolean isChecked(){
        CheckBox cb = (CheckBox)findViewById(R.id.checkBox1);
        return cb.isChecked();
    }

    @Override
    public void toggle() {
        CheckBox cb = (CheckBox) findViewById(R.id.checkBox1) ;

        setChecked(cb.isChecked() ? false : true) ;
        // setChecked(mIsChecked ? false : true) ;
    }

    @Override
    public void setChecked(boolean checked) {
        CheckBox cb = (CheckBox) findViewById(R.id.checkBox1) ;

        if (cb.isChecked() != checked) {
            cb.setChecked(checked) ;
        }

        // CheckBox 가 아닌 View의 상태 변경.
    }
}
