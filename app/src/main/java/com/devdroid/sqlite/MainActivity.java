package com.devdroid.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Data is insert in Contact table when this method will call
        MyDataBase dataBase = new MyDataBase(this);
        dataBase.addContacts("Talha","03019492211");
        dataBase.addContacts("Abdullah","03029492211");
        dataBase.addContacts("Ali","03059672211");
        dataBase.addContacts("Waqas","03079782211");
        dataBase.addContacts("Ahsan","03049498811");
    }
}