package com.example.dana.myhomework;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class DBOpenHelper extends SQLiteOpenHelper {


    private static final String DB_NAME="myDB.DB";
    private static final int DATABASE_VERSION=1;
    private static final String CREATE_QUERY=
            "CREATE TABLE "+Birthday.MyBirthdaysTable.TABLE_NAME + "(" +Birthday.MyBirthdaysTable.NAME+" TEXT,"+
                    Birthday.MyBirthdaysTable.BIRTH_DATE+" TEXT,"+Birthday.MyBirthdaysTable.NEXT_COMING_BIRTHDAY+" TEXT"+
                    Birthday.MyBirthdaysTable.COMMENT+" TEXT);";

    /**
     * SQL DELETE TABLE SENTENCE
     */
    public static final String DROP_MYBIRTHDAYS_TABLE = "DROP TABLE IF EXISTS" + Birthday.MyBirthdaysTable.TABLE_NAME;

    public DBOpenHelper(Context context){
        super(context, DB_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "database created or opened");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS", "table created or opened");
    }

    public void addInformations(String name, String date, String comment, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Birthday.MyBirthdaysTable.NAME,name);
        contentValues.put(Birthday.MyBirthdaysTable.BIRTH_DATE,date);
        //contentValues.put(Birthday.MyBirthdaysTable.NEXT_COMING_BIRTHDAY,nextDate);
        contentValues.put(Birthday.MyBirthdaysTable.COMMENT,comment);
        db.insert(Birthday.MyBirthdaysTable.TABLE_NAME,null, contentValues);
        Log.e("DATABASE OPERATIONS", "one row inserted");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_MYBIRTHDAYS_TABLE);
        onCreate(db);
    }


}