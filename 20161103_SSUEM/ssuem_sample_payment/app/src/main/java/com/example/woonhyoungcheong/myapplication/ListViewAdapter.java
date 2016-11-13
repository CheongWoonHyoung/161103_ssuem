package com.example.woonhyoungcheong.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by WoonHyoungCheong on 2016-11-03.
 */

public class ListViewAdapter extends BaseAdapter{

    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();
    public ListViewAdapter(){


    }

    @Override
    public int getCount(){
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1) ;
    //    ListViewItem listViewItem = listViewItemList.get(position);
    //    titleTextView.setText(listViewItem.getTitle());
        return convertView;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }
}
