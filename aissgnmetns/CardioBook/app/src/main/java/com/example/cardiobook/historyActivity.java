package com.example.cardiobook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class historyActivity extends AppCompatActivity {

    ListView historyMeasurements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        historyMeasurements = findViewById(R.id.History);

    }


}
