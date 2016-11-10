package com.example.woonhyoungcheong.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adapter = new ListViewAdapter();

        listview = (ListView)findViewById(R.id.sample_list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(listener);
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView parent, View v, int position, long id) {

            ListViewItem item = (ListViewItem)parent.getItemAtPosition(position);
            String titleStr = item.getTitle();

            Intent intent = new Intent(MainActivity.this, MyItems.class);
            intent.putExtra("name",titleStr.toString());
            startActivity(intent);
        }
    };


}
