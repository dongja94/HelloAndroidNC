package com.begentgroup.helloandroid;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CompoundActivity extends AppCompatActivity {

    PersonView personView;
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound);
        personView = (PersonView)findViewById(R.id.cv_person);

        personView.setOnPictureClickListener(new PersonView.OnPictureClickListener() {
            @Override
            public void onPictureClick(Person person) {
                Toast.makeText(CompoundActivity.this, "person : " + person.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        Button btn = (Button)findViewById(R.id.btn_person);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p = new Person();
                p.setName("my name " + index);
                p.setAge(42);
                Drawable picture = ContextCompat.getDrawable(CompoundActivity.this, R.mipmap.ic_launcher);
                p.setPicture(picture);
                personView.setPerson(p);
            }
        });
    }
}
