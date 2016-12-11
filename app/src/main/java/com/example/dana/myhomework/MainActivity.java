package com.example.dana.myhomework;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mylistview;
    ArrayList<app> apps;
    SharedPreferences animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylistview = (ListView) findViewById(R.id.myListView);
        apps = new ArrayList<>();


        app hw1 = new app("HomeWork 1",new Intent(getApplicationContext(), homework1_1.class));
        app hw2 = new app("ConstraintLayout1",new Intent(getApplicationContext(),ConstraintLayout1.class));
        app hw3 = new app("ConstraintLayout2",new Intent(getApplicationContext(),ConstraintLayout2.class));
        app hw4 = new app("ConstraintLayout3",new Intent(getApplicationContext(),ConstraintLayout3.class));
        app hw5 = new app("MyBirthdays",new Intent(getApplicationContext(),MyBirthdays.class));


        apps.add(hw1);
        apps.add(hw2);
        apps.add(hw3);
        apps.add(hw4);
        apps.add(hw5);

        ArrayAdapter<app> arrayadapter = new ArrayAdapter<app>(this, android.R.layout.simple_list_item_1,apps);
        mylistview.setAdapter(arrayadapter);
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                startActivity(apps.get(i).getAppIntent());
                pickAnimation();
            }
        });
    }

    public void pickAnimation(){
        animation = this.getSharedPreferences("com.example.dana.homework3", Context.MODE_PRIVATE);
        String title = animation.getString("animation_name","");

        if (title.equals("fade")){
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }
        else if(title.equals("zoom")){
            overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
        }
        else if (title.equals("slide")){
            overridePendingTransition(R.anim.slideup, R.anim.slidedown);
        }
        else return;
    }

 /*   public void test(View view) {
        Intent intent1 = new Intent(getApplicationContext(), homework1_1.class);
        startActivity(intent1);
    }*/

  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selectedID= item.getItemId();
        if (selectedID == R.id.Settings){
                Intent i= new Intent(MainActivity.this, settings.class);
                startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

}
class app {
    String name;

    public app(String name, Intent appIntent) {
        this.name = name;
        this.appIntent = appIntent;
    }

    Intent appIntent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Intent getAppIntent() {
        return appIntent;
    }

    public void setAppIntent(Intent appIntent) {
        this.appIntent = appIntent;
    }

    @Override
    public String toString() {
        return  name ;
    }
}

