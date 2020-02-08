package com.example.chushan_cardiobook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class historyActivity extends AppCompatActivity {

    public ListView historyList;
    ArrayAdapter<Measurement> historyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // set ListView
        historyList = findViewById(R.id.History);
        // set Adapter

        historyAdapter = new Helper(this,MainActivity.DataList);

        // combine View and and adapter
        historyList.setAdapter(historyAdapter);
        // starting

        historyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent editMeasurment = new Intent(historyActivity.this,AddActivity.class);

                editMeasurment.putExtra("activity","history");
                editMeasurment.putExtra("index",i);

                startActivity(editMeasurment);
            }
        });


    }

    @Override
    protected void onStart(){
        super.onStart();
        historyAdapter.notifyDataSetChanged();
    }


}
