package com.example.fredrik.messageapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mikael on 01.09.2016.
 */

public class MessageListAdapter extends ArrayAdapter<Message> {
    public MessageListAdapter(Context context, List<Message> messages) {
        super(context, 0, messages);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       Message message = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.message,parent,false);
        }


        ImageView person = (ImageView)convertView.findViewById(R.id.imageView);
        TextView messageView = (TextView)convertView.findViewById(R.id.textView);
        person.setImageResource(android.R.drawable.btn_default);
        messageView.setText(message.getMessage());

        return convertView;
    }


}
