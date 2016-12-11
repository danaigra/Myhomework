package com.example.dana.myhomework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MyBirthdays extends AppCompatActivity {
    EditText Name, Bday, Comment;
    Context context;
    DBOpenHelper dbOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_birthdays);
        Name= (EditText) findViewById(R.id.name);
        Bday= (EditText) findViewById(R.id.birth_date);
        Comment= (EditText) findViewById(R.id.comment);
    }



    public void addBDay (View view)
    {
        String name=Name.getText().toString();
        String bday=Bday.getText().toString();
        String comment=Comment.getText().toString();
        dbOpenHelper=new DBOpenHelper(context);
        sqLiteDatabase=dbOpenHelper.getWritableDatabase();
        dbOpenHelper.addInformations(name, bday, comment, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "data saved", Toast.LENGTH_LONG).show();
        dbOpenHelper.close();
    }
}
