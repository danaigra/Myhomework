package com.example.dana.myhomework;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.animation;

public class settings extends AppCompatActivity {

    TextView animationTextView;
    SharedPreferences animation;
    String currAnimation;
    ArrayList<String> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        animationTextView= (TextView) findViewById(R.id.aniTextView);
        animation = this.getSharedPreferences("com.example.dana.homework3", Context.MODE_PRIVATE);
        animationTextView.setText(animation.getString("animation_name",""));

        final ListView myList= (ListView) findViewById(R.id.animList);
        array= new ArrayList<>();
        array.add("fade");
        array.add("zoom");
        array.add("slide");
        ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        myList.setAdapter(ad);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                currAnimation= array.get(i);
                animationTextView.setText(currAnimation);
                animation.edit().putString("animation_name" , currAnimation).apply();
            }
        });
    }
}
