package com.begentgroup.helloandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class SimpleListActivity extends AppCompatActivity {

    EditText inputView;
    ListView listView;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
        inputView = (EditText)findViewById(R.id.edit_input);
        listView = (ListView)findViewById(R.id.listView);

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String item = mAdapter.getItem(position);
                String item = (String)listView.getItemAtPosition(position);
                Toast.makeText(SimpleListActivity.this, "item : " + item, Toast.LENGTH_SHORT).show();
            }
        });

        Button btn = (Button)findViewById(R.id.btn_add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = inputView.getText().toString();
                if (!TextUtils.isEmpty(text)) {
                    mAdapter.add(text);
                    listView.smoothScrollToPosition(mAdapter.getCount() - 1);
                    inputView.setText("");
                }
            }
        });


        initData();
    }

    private void initData() {
        String[] items = getResources().getStringArray(R.array.list_items);
        for (String s : items) {
            mAdapter.add(s);
        }
    }
}
