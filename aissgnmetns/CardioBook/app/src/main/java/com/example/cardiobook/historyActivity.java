package com.example.cardiobook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class historyActivity extends AppCompatActivity {

    public ListView historyList;
    ArrayAdapter<Measurement> historyAdapter;
//    int remove  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // set ListView
        historyList = findViewById(R.id.History);
        // set Adapter

        historyAdapter = new Helper(this,MainActivity.DataList);

//        historyAdapter = new ArrayAdapter<>(this,R.layout.history_layout,MainActivity.DataList);

        // combine View and and adapter
        historyList.setAdapter(historyAdapter);
        // starting

//
//        history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            remove = position;
//        }
//    });


    }


}
