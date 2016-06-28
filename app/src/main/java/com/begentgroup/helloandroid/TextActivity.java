package com.begentgroup.helloandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        TextView textView = (TextView)findViewById(R.id.textView8);
        textView.setSelected(true);
    }

    public void onButtonClick(View view) {
        Toast.makeText(this, "button click", Toast.LENGTH_SHORT).show();
    }
}
