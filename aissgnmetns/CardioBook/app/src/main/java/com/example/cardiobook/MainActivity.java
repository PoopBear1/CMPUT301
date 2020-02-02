package com.example.cardiobook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView measurementList;
    ArrayAdapter<Measurement> measurementArrayAdapter;
    public static List<Measurement> DataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataList = new ArrayList<>();
    }

    public void createRecord(View v){
        Intent toCreate = new Intent(MainActivity.this, AddActivity.class);
        startActivity(toCreate);
    }

    public void viewHistory(View v){
        Intent toHistory = new Intent(MainActivity.this, historyActivity.class);
        startActivity(toHistory);
    }

}
