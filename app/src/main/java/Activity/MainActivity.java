package com.example.doan_mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
RecyclerView recyclerView;
NavigationView navigationView;
DrawerLayout drawerLayout;
ListView listView;
ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        ActionBar();
    }

    private void ActionBar() {
       
    }

    private void anhXa() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView =findViewById(R.id.recyclerview);
        navigationView = findViewById(R.id.recyclerview);
        listView = findViewById(R.id.listview);
        viewFlipper = findViewById(R.id.viewflipper);
        drawerLayout = findViewById(R.id.drawerlayout);

    }
}