package com.example.fredrik.messageapp;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by mikael on 01.09.2016.
 */

public class Message implements Serializable {
    User user;
    String message;
    Date timestamp;

    public Message(User user, String message) {
        this.user = user;
        this.message = message;
        this.timestamp = new Date();
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
