package com.appdeveloperrakib.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "my_database";
    public static final int DB_VERSION = 1;

    public DatabaseHelper( Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table my_table (id INTEGER primary key autoincrement,name TEXT,mobile TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists my_table");

    }

    public void insertData(String name, String mobile){

        SQLiteDatabase database = this.getWritableDatabase();

        //Contentvalues is like a hashmap
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("mobile",mobile);
        database.insert("my_table",null,contentValues);

    }

    public Cursor getAllData(){

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from my_table",null);

        return cursor;

    }

    public Cursor searchDatabyID( int id){

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from my_table where id like '"+id+"'",null);

        return cursor;

    }

    public Cursor searchDatabyName( String name){

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from my_table where name like '%"+name+"%'",null);

        return cursor;

    }



}
