package com.example.dana.myhomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class homework1_1 extends AppCompatActivity {

    EditText num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework1_1);
    }

    public void start (View v)
    {
        Intent myIntent = new Intent(getApplicationContext(), homework1_2.class);
        num1= (EditText)findViewById(R.id.editText);
        num2= (EditText)findViewById(R.id.editText2);

        myIntent.putExtra("number1", String.valueOf(num1.getText()));
        myIntent.putExtra("number2", String.valueOf(num2.getText()));
        startActivity(myIntent);
    }
}


