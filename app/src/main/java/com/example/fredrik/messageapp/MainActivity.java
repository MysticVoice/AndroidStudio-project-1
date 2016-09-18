package com.example.fredrik.messageapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List data = Arrays.asList(
                new User("Mikael"),
                new User("Harry"),
                new User("Manning"),
                new User("Friedrich"),
                new User("Fredrik"),
                new User("Fredrico"),
                new User("Fanthomas"),
                new User("Dan")
        );
        UserListAdapter ula = new UserListAdapter(getApplicationContext(),data);

        ListView listView = (ListView)findViewById(R.id.userField);
        listView.setAdapter(ula);

    }
}
