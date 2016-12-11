/*package com.example.dana.homework3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyBirthday extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;
    EditText Name, BirthDay, NextBD, Comment;
    ListView listview;
    ArrayList<app> apps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_birthday);
        listview = (ListView) findViewById(R.id.myListView);
        apps = new ArrayList<>();
        try{
            sqLiteDatabase = this.openOrCreateDatabase("danaDataBase", MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS danaTable1 (name VARCHAR, date  VARCHAR, nb INTEGER(3), comment VARCHAR)");
            Name=(EditText) findViewById(R.id.name);
            BirthDay=(EditText) findViewById(R.id.birth_date);
            Comment=(EditText) findViewById(R.id.comment);



        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void addBirthday(View view) {
        String name = String.valueOf(Name.getText());
        String Bday = String.valueOf(BirthDay.getText());
        String comment = String.valueOf(Comment.getText());
        long nextBD;
        Date now = new Date();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        try {
            date = format.parse(Bday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        date.setYear(now.getYear());

        nextBD = now.getTime() - date.getTime(); // nextBD = calculateDays(date, now);

        if (nextBD < 0) {
            date.setYear(now.getYear() + 1);
            nextBD = now.getTime() - date.getTime();
        }
        String text = String.format("INSERT INTO danaTable1 (name, Bday, nextBD, comment) VALUES ('%s', '%s', %d, '%s')", Name, BirthDay, NextBD, Comment);
        sqLiteDatabase.execSQL(text);

    }
}*/
