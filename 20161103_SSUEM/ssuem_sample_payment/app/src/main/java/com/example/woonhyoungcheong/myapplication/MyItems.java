package com.example.woonhyoungcheong.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by WoonHyoungCheong on 2016-11-03.
 */

public class MyItems extends Activity {

    TextView text_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        text_title = (TextView)findViewById(R.id.title);
        text_title.setText(name);

    }
}
