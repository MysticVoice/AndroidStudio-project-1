package com.example.fredrik.messageapp;

/**
 * Created by Fredrik on 16.09.2016.
 */
import java.util.ArrayList;
public class User {

    private String name;
    private ArrayList<Message> messages;
    public User(String name)
    {
        this.name = name;
        messages = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
}
