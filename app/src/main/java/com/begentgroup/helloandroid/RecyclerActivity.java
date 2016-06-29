package com.begentgroup.helloandroid;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView listView;
    RVPersonAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        listView = (RecyclerView)findViewById(R.id.rv_list);
        mAdapter = new RVPersonAdapter();
        listView.setAdapter(mAdapter);

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        listView.setLayoutManager(layoutManager);

        initData();
    }

    private void initData() {
        String[] items = getResources().getStringArray(R.array.list_items);
        for (String s : items) {
            Person p = new Person();
            p.setName(s);
            p.setAge(42);
            p.setPicture(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
            mAdapter.add(p);
        }
    }
}
