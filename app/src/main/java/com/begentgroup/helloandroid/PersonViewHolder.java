package com.begentgroup.helloandroid;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-06-29.
 */
public class PersonViewHolder extends RecyclerView.ViewHolder {
    ImageView pictureView;
    TextView nameView, ageView;
    public PersonViewHolder(View itemView) {
        super(itemView);
        pictureView = (ImageView)itemView.findViewById(R.id.image_picture);
        nameView = (TextView)itemView.findViewById(R.id.text_name);
        ageView = (TextView)itemView.findViewById(R.id.text_age);
    }

    Person person;
    public void setPerson(Person p) {
        person = p;
        nameView.setText(p.getName());
        ageView.setText(""+p.getAge());
        pictureView.setImageDrawable(p.getPicture());
    }
}
