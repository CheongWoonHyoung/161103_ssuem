package com.example.woonhyoungcheong.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cheon on 2016-11-14.
 */

public class Payment extends Activity{
    TextView checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

        Intent intent = getIntent();
        ArrayList<String> name = intent.getStringArrayListExtra("checked_items");

        checked = (TextView)findViewById(R.id.sample_payment);
        for(int i=0; i<name.size(); i++){
            checked.append(name.get(i));
        }



    }
}
