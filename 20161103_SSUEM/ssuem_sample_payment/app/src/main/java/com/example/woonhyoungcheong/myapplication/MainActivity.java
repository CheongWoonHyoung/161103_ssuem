package com.example.woonhyoungcheong.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    ListViewAdapter adapter;
    Button btsend;
    private ArrayList<String>checkedItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkedItemList = new ArrayList<String>();
        adapter = new ListViewAdapter(getApplicationContext());
        btsend = (Button)findViewById(R.id.btSend);
        listview = (ListView)findViewById(R.id.sample_list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(listener);
        User u1 = new User("user1","감자탕");
        adapter.add(u1);
        User u2 = new User("user1","곰국");
        adapter.add(u2);
        User u3 = new User("user1","김치찌개");
        adapter.add(u3);

        btsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i=0; i<adapter.getCount(); i++){
                    if(adapter.getncb().get(i).isChecked()){
                        checkedItemList.add(adapter.getnky().get(i));
                    }

                }
                Intent payment_intent = new Intent(MainActivity.this, Payment.class);
                ArrayList<String> sample = checkedItemList;
                payment_intent.putExtra("checked_items",sample );
                int count = checkedItemList.size();
                startActivity(payment_intent);
                for(int i = 0; i<count;i++){
                    checkedItemList.remove(0);
                }

            }
        });

    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView parent, View v, int position, long id) {

            User user = (User)parent.getItemAtPosition(position);
            String titleStr = user.getUserWriting();

            Intent intent = new Intent(MainActivity.this, MyItems.class);
            intent.putExtra("name",titleStr.toString());
            startActivity(intent);
        }
    };


}
