package com.example.fredrik.messageapp;

import java.util.Hashtable;

/**
 * Created by Fredrik on 18.09.2016.
 */
public class Singleton {
    private static Singleton sInstance = null;
    private Hashtable conversations;
    private User currentUser;
    private User me;
    private Singleton()
    {
        conversations = new Hashtable();
        me = new User("Fredrik");
    }

    public static Singleton getInstance()
    {
        if(sInstance == null)
        {

            sInstance = new Singleton();
        }
        return sInstance;
    }

    public Conversation getConversation(User user)
    {
        Conversation conversation;
        if(conversations.containsKey(user))
        {
            conversation = (Conversation)conversations.get(user);
            conversation.testData();
        }
        else
        {
            conversation = new Conversation();
            conversations.put(getCurrentUser(),conversation);

        }
        return conversation;
    }
    public void addConversation(Conversation conv)
    {
        User user = conv.getUser();
        conversations.put(user,conv);
    }

    public void updateConversation(Message message)
    {
        User user = message.getUser();
        Conversation conv = getConversation(user);
        conv.addMessage(message);
    }

    public User getMe()
    {
        return me;
    }
    public void setCurrentUser(User user)
    {
        this.currentUser = user;

    }

    public User getCurrentUser()
    {
        return currentUser;
    }
}
