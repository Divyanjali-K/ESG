package com.example.esgapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    private CardView card1,card2,card3,card4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

         drawerLayout=findViewById(R.id.drawerlayout);
         navigationView=findViewById(R.id.navigationview);
         toolbar=findViewById(R.id.toolbar);


         setSupportActionBar(toolbar);

         ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        card1=(CardView) findViewById(R.id.c1);
        card2=(CardView) findViewById(R.id.c2);
        card3=(CardView) findViewById(R.id.c3);
        card4=(CardView) findViewById(R.id.c4);


        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);

    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
           Intent i;
        int id = v.getId();
        if (id == R.id.c1) {
            i = new Intent(this, Accenture.class);
            startActivity(i);
        } else if (id == R.id.c2) {
            i = new Intent(this, amazon.class);
            startActivity(i);
        } else if (id == R.id.c3) {
            i = new Intent(this, ibm.class);
            startActivity(i);
        } else if (id == R.id.c4) {
            i = new Intent(this, Reliance.class);
            startActivity(i);
        }
    }
}