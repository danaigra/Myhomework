package com.example.dana.myhomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class homework1_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework1_2);
        Intent intent=getIntent();
        int x=Integer.parseInt(intent.getStringExtra("number1"));
        int y=Integer.parseInt(intent.getStringExtra("number2"));
        Toast.makeText(this, String.valueOf(x+y), Toast.LENGTH_SHORT).show();

    }
}
