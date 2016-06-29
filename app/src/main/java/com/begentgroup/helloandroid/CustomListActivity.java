package com.begentgroup.helloandroid;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Random;

public class CustomListActivity extends AppCompatActivity {

    ListView listView;
    PersonAdapter mAdapter;
    ImageView bigView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        listView = (ListView)findViewById(R.id.listView3);
        bigView = (ImageView)findViewById(R.id.image_big);
        bigView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigView.setVisibility(View.GONE);
            }
        });
        View headerView = getLayoutInflater().inflate(R.layout.view_header, listView, false);
        listView.addHeaderView(headerView, "header view", true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object data = listView.getItemAtPosition(position);
                String message = null;
                if (data instanceof String) {
                    message = (String)data;
                } else {
                    Person p = (Person) data;
                    message = p.getName();
                }
                Toast.makeText(CustomListActivity.this, "person : " + message, Toast.LENGTH_SHORT).show();
            }
        });
        mAdapter = new PersonAdapter();
        mAdapter.setOnAdapterPictureClickListener(new PersonAdapter.OnAdapterPictureClickListener() {
            @Override
            public void onPictureClick(Person p) {
                bigView.setImageDrawable(p.getPicture());
                bigView.setVisibility(View.VISIBLE);
            }
        });
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
