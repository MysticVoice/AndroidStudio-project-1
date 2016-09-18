package com.example.fredrik.messageapp;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        List

        ArrayList<User> data = null;
        while(data == null) {
            data = permissionContacts();
        }

//        if(checkSelfPermission(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED)
//        {
//            data = getContacts();
//        }
//
//        else
//        {
//            data = new ArrayList<User>();
//            data.add(new User("Mikael"));
//            data.add(new User("Harry"));
//            data.add(new User("Manning"));
//            data.add(new User("Friedrich"));
//            data.add(new User("Fredrik"));
//               new User("Fredrico"),
//               new User("Fanthomas"),
//            data.add(new User("Dan"));
//        }

        UserListAdapter ula = new UserListAdapter(getApplicationContext(),data);

        ListView listView = (ListView)findViewById(R.id.userField);
        listView.setAdapter(ula);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = (User)parent.getItemAtPosition(position);
                Singleton.getInstance().setCurrentUser(user);
                Intent i = new Intent(MainActivity.this,ConversationActivity.class);
                startActivity(i);
            }
        });

    }

    // Request code for READ_CONTACTS. It can be any number > 0.
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    /**
     * Show the contacts in the ListView.
     */
    private ArrayList<User> permissionContacts() {
        // Check the SDK version and whether the permission is already granted or not.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        } else {
            // Android version is lesser than 6.0 or the permission is already granted.
            return getContacts();

        }
        return null;
    }

    private ArrayList<User> getContacts()
    {
        ContentResolver cr = getContentResolver(); //Activity/Application android.content.Context
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        ArrayList<User> contacts = new ArrayList<User>();
        if(cursor.moveToFirst())
        {

            do
            {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));

                if(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0)
                {
                    Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?",new String[]{ id }, null);
                    while (pCur.moveToNext())
                    {
                        String number = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        User user = new User(id);
                        contacts.add(user);

                        break;
                    }
                    pCur.close();
                }

            } while (cursor.moveToNext()) ;
        }
        return contacts;
    }
}
