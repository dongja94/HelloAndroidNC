package com.begentgroup.helloandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ChoiceListActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_list);
        listView = (ListView)findViewById(R.id.listView2);
//        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice);
        listView.setAdapter(mAdapter);
//        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        Button btn = (Button)findViewById(R.id.btn_choice);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listView.getChoiceMode() == ListView.CHOICE_MODE_SINGLE) {
                    int positioon = listView.getCheckedItemPosition();
                    if (positioon != ListView.INVALID_POSITION) {
                        String text = (String)listView.getItemAtPosition(positioon);
                        Toast.makeText(ChoiceListActivity.this, "single choice : " + text, Toast.LENGTH_SHORT).show();
                    }
                } else if (listView.getChoiceMode() == ListView.CHOICE_MODE_MULTIPLE) {
                    SparseBooleanArray choiceList = listView.getCheckedItemPositions();
                    StringBuilder sb = new StringBuilder();
                    for (int index = 0 ; index < choiceList.size(); index++) {
                        int position = choiceList.keyAt(index);
                        if (choiceList.get(position)) {
                            String text = (String)listView.getItemAtPosition(position);
                            sb.append(text).append(",");
                        }
                    }
                    Toast.makeText(ChoiceListActivity.this, "items : " + sb.toString(), Toast.LENGTH_SHORT).show();
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
