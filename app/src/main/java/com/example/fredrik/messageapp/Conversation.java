package com.example.fredrik.messageapp;

/**
 * Created by Fredrik on 16.09.2016.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;
import java.util.Random;

import java.util.ArrayList;
public class Conversation extends AppCompatActivity {
    private ArrayList<Message> messages;
    private User user;

    private Random random;
    public Conversation() {
        messages = new ArrayList<>();
        user = Singleton.getInstance().getCurrentUser();

        random = new Random();
        //testData();
    }

    public void testData()
    {
        randomMessage();
        randomMessage();
        randomMessage();
    }

    public void addMessage(Message message)
    {

        messages.add(message);
    }

    public void postMessage(String message)
    {


        messages.add(new Message(Singleton.getInstance().getMe(),message));
    }

    public void randomMessage()
    {
        ArrayList<String> responses = new ArrayList<>();
        responses.add("Hello!");
        responses.add("Lovely day today!");
        responses.add("How do you do?");
        responses.add("...");
        responses.add("I'm a random message!");
        int randVar = random.nextInt(responses.size());
        Message tempMess = new Message(user,responses.get(randVar));
        addMessage(tempMess);

    }

    public User getUser()
    {
        return user;
    }

    public ArrayList<Message> getMessages()
    {
        return messages;
    }
}
