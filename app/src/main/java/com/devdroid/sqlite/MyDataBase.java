package com.devdroid.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

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

    // When the data will be fetch we store the data in ArrayList
    public ArrayList<ContactModel> fetchContact()
    {
        // Open a database
        SQLiteDatabase db = this.getReadableDatabase();

        // To fetch the data we used a raw query
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CONTACT, null);

        ArrayList<ContactModel> arrContact = new ArrayList<>();

        // To fetch all the data we move the cursor to the end
        while (cursor.moveToNext())
        {
            // To store the value in Contact Model class
            ContactModel model = new ContactModel();
            model.id = cursor.getInt(0);
            model.name = cursor.getString(1);
            model.phone_no = cursor.getString(2);

            // Add the model class into arraylist
            arrContact.add(model);
        }
        return arrContact;
    }
}
