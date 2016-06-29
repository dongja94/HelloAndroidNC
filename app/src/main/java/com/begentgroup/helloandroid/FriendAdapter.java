package com.begentgroup.helloandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-06-29.
 */
public class FriendAdapter extends BaseAdapter {

    FriendList mFriendList;

    public void setFriendList(FriendList list) {
        mFriendList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mFriendList == null) return 0;
        int count = 0;
        if (mFriendList.newPerson.size() > 0) {
            count += (1 + mFriendList.newPerson.size());
        }
        if (mFriendList.favPerson.size() > 0) {
            count += (1 + mFriendList.favPerson.size());
        }
        if (mFriendList.friPerson.size() > 0) {
            count += (1 + mFriendList.friPerson.size());
        }
        return count;
    }

    private static final int VIEW_TYPE_COUNT = 2;
    private static final int VIEW_TYPE_TITLE = 0;
    private static final int VIEW_TYPE_ITEM = 1;

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        Object data = getItem(position);
        if (data instanceof String) {
            return VIEW_TYPE_TITLE;
        } else {
            return VIEW_TYPE_ITEM;
        }
    }

    @Override
    public Object getItem(int position) {
        int itemSize = mFriendList.newPerson.size();
        if (itemSize > 0) {
            if (position == 0) {
                return "New";
            }
            position--;
            if (position < itemSize) {
                return mFriendList.newPerson.get(position);
            }
            position-=itemSize;
        }

        itemSize = mFriendList.favPerson.size();
        if (itemSize > 0) {
            if (position == 0) {
                return "favorit";
            }
            position--;
            if (position < itemSize) {
                return mFriendList.favPerson.get(position);
            }
            position -= itemSize;
        }

        itemSize = mFriendList.friPerson.size();
        if (itemSize > 0) {
            if (position == 0) {
                return "friend list";
            }
            position--;
            if (position < itemSize) {
                return mFriendList.friPerson.get(position);
            }
        }
        throw new IllegalArgumentException("invalid position");
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_TITLE : {
                TextView view;
                if (convertView == null || !(convertView instanceof TextView)) {
                    view = (TextView)LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
                } else {
                    view = (TextView)convertView;
                }
                view.setText((String)getItem(position));
                return view;
            }
            case VIEW_TYPE_ITEM : {
                PersonView view;
                if (convertView == null || !(convertView instanceof PersonView)) {
                    view = new PersonView(parent.getContext());
                } else {
                    view = (PersonView)convertView;
                }
                view.setPerson((Person)getItem(position));
                return view;
            }
        }
        throw new IllegalArgumentException("invalid position");
    }
}
