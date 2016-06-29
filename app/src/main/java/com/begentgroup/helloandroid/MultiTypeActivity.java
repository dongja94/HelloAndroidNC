package com.begentgroup.helloandroid;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MultiTypeActivity extends AppCompatActivity {

    ListView listView;
    FriendAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_type);
        listView = (ListView)findViewById(R.id.listView4);
        mAdapter = new FriendAdapter();
        listView.setAdapter(mAdapter);

        initData();
    }

    private void initData() {
        FriendList list = new FriendList();
        String[] items = getResources().getStringArray(R.array.list_items);
        for (int i = 0; i < items.length; i++) {
            Person p = new Person();
            p.setName(items[i]);
            p.setAge(20 + i);
            p.setPicture(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));

            if (i % 5 == 0) {
                list.newPerson.add(p);
            }

            if (i % 7 == 0) {
                list.favPerson.add(p);
            }
            list.friPerson.add(p);
        }

        mAdapter.setFriendList(list);
    }
}
