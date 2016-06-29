package com.begentgroup.helloandroid;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-06-29.
 */
public class PersonAdapter extends BaseAdapter implements PersonView.OnPictureClickListener {
    List<Person> items = new ArrayList<>();

    public void add(Person p) {
        items.add(p);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Person getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonView view;
        if (convertView == null) {
            view = new PersonView(parent.getContext());
            view.setOnPictureClickListener(this);
        } else {
            view = (PersonView)convertView;
        }
        view.setPerson(items.get(position));
        return view;
    }

    public interface OnAdapterPictureClickListener {
        public void onPictureClick(Person p);
    }

    OnAdapterPictureClickListener mListener;
    public void setOnAdapterPictureClickListener(OnAdapterPictureClickListener listener) {
        mListener = listener;
    }

    @Override
    public void onPictureClick(Person person) {
        if (mListener != null) {
            mListener.onPictureClick(person);
        }
    }
}
