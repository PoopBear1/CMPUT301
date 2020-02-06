package com.example.cardiobook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    ListView measurementList;
//    ArrayAdapter<Measurement> measurementArrayAdapter;
    public static ArrayList<Measurement> DataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        measurementArrayAdapter = new ArrayAdapter<Measurement>();
        loadData("measurement");
    }

    public void createRecord(View v){
        Intent toCreate = new Intent(MainActivity.this, AddActivity.class);
        toCreate.putExtra("activity","add");
        startActivity(toCreate);
    }

    public void viewHistory(View v){
        Intent toHistory = new Intent(MainActivity.this, historyActivity.class);
        startActivity(toHistory);
    }

    public void loadData(String key){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(key,null);
        Type type = new TypeToken<ArrayList<Measurement>>() {}.getType();
        DataList = gson.fromJson(json,type);

        if(DataList == null){
            DataList = new ArrayList<>();
        }

    }

}
