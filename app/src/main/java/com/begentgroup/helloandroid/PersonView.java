package com.begentgroup.helloandroid;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-06-29.
 */
public class PersonView extends FrameLayout {
    public PersonView(Context context) {
        super(context);
        init();
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    ImageView pictureView;
    TextView nameView, ageView;

    private void init() {
//        LayoutInflater inflater = LayoutInflater.from(getContext());
//        inflater.inflate(R.layout.view_person, this);
        inflate(getContext(), R.layout.view_person, this);
        pictureView = (ImageView)findViewById(R.id.image_picture);
        nameView = (TextView)findViewById(R.id.text_name);
        ageView = (TextView)findViewById(R.id.text_age);
    }

    Person person;

    public void setPerson(Person p) {
        person = p;
        pictureView.setImageDrawable(p.getPicture());
        nameView.setText(p.getName());
        ageView.setText(""+p.getAge());
    }
}
