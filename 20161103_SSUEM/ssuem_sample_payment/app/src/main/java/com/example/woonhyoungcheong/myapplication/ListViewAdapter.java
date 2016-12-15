package com.example.woonhyoungcheong.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by WoonHyoungCheong on 2016-11-03.
 */

public class ListViewAdapter extends BaseAdapter{

    private Context mContext;
    private User mUser;
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();
    private ArrayList<User> mUserData;
    private ArrayList<CheckBox> ncb;
    private ArrayList<String> nky;
    private ArrayList<String> nkyid;
    CheckBox chkbox;

    public ListViewAdapter(Context context){
        super();
        mUserData = new ArrayList<User>();
        mContext = context;
        ncb = new ArrayList<CheckBox>();
        nky = new ArrayList<String>();
        nkyid = new ArrayList<String>();

    }

    @Override
    public int getCount(){
        return mUserData.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        final Context context = parent.getContext();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
            chkbox = (CheckBox)convertView.findViewById(R.id.checkBox1);
        }
        ncb.add(chkbox);



        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1) ;
        //ListViewItem listViewItem = listViewItemList.get(position);
        mUser = getItem(position);
        if(mUser != null){
            titleTextView.setText(mUser.getUserWriting());
            nky.add(mUser.getUserWriting());
            nkyid.add(mUser.getUserWriting_ID());
        }
        return convertView;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public User getItem(int position) {
        return mUserData.get(position);
    }

    public void add(User user){
        mUserData.add(user);
    }

    public String getItemCheckedId(int position){
        return mUserData.get(position).getUserWriting();
    }
    public ArrayList<CheckBox> getncb(){
        return ncb;
    }

    public ArrayList<String> getnky(){
        return nky;
    }

    public ArrayList<String> getnkyid() { return nkyid; }


}
