package com.example.fredrik.messageapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mikael on 01.09.2016.
 */

public class UserListAdapter extends ArrayAdapter<User> {
    public UserListAdapter(Context context, List<User> users) {
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user,parent,false);
        }


        ImageView person = (ImageView)convertView.findViewById(R.id.imageView);
        TextView NameView = (TextView)convertView.findViewById(R.id.textView);
        person.setImageResource(android.R.drawable.btn_default);
        NameView.setText(user.getName());


        return convertView;
    }
}
