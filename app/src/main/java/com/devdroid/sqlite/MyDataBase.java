package com.devdroid.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ContactsDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CONTACT = "Contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE_NO = "phone_no";



    public MyDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // Create table and add column with name and Datatype

        //  Query--> CREATE TABLE contacts (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone_no TEXT);
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CONTACT +
                "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT," + KEY_PHONE_NO + " TEXT" + ")");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        // This method is used when new database is update or change
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TABLE_CONTACT);
        onCreate(sqLiteDatabase);

    }

    // Insertion Method
    public void addContacts(String name, String phone_no)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        // To pass the value in content we make a content  variable
        ContentValues values = new ContentValues();
        // Add column and data of column
        values.put(KEY_NAME, name);
        values.put(KEY_PHONE_NO, phone_no);

        sqLiteDatabase.insert(TABLE_CONTACT,null,values);

    }
}
