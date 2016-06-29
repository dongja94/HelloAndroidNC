package com.begentgroup.helloandroid;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.Random;

public class CustomListActivity extends AppCompatActivity {

    ListView listView;
    PersonAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        listView = (ListView)findViewById(R.id.listView3);
        mAdapter = new PersonAdapter();
        listView.setAdapter(mAdapter);

        initData();
    }

    private void initData() {
        String[] items = getResources().getStringArray(R.array.list_items);
        for (String s : items) {
            Person p = new Person();
            p.setName(s);
            p.setAge(20 + new Random().nextInt(30));
            p.setPicture(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
            mAdapter.add(p);
        }
    }
}
