package com.example.fredrik.messageapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by Fredrik on 18.09.2016.
 */
public class ConversationActivity extends AppCompatActivity{
    Conversation conversation;
    private MessageListAdapter mla;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversation);
        User user = Singleton.getInstance().getCurrentUser();
        conversation = Singleton.getInstance().getConversation(user);
        mla = new MessageListAdapter(getApplicationContext(),conversation.getMessages());
        ListView listView = (ListView)findViewById(R.id.messages);
        listView.setAdapter(mla);


    }
    public void onButtonClick(View v)
    {

        String message = "";
        EditText txt = (EditText) findViewById(R.id.messageField);
        message = txt.getText().toString();
        conversation.postMessage(message);
        conversation.randomMessage();
    }
}
