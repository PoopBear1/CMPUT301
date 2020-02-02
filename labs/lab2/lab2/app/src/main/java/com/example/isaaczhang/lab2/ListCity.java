package com.example.isaaczhang.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;



public class ListCity extends AppCompatActivity {
    private EditText cityname;
    private Button button;
    private Button button2;
    private int remove;




    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_city);
        cityList = findViewById(R.id.city_list);
        cityname = findViewById(R.id.editText2);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        String[]cities={"Edmonton","Vancouver","Moscow","Sydney","Berlin","Vienna","Tokyo","New Delhi"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));
        cityAdapter = new ArrayAdapter<>(this,R.layout.content,dataList);
        cityList.setAdapter(cityAdapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = cityname.getText().toString();
                dataList.add(name);
                cityAdapter.notifyDataSetChanged();
            }
        });

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                remove = position;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList.remove(remove);
                cityAdapter.notifyDataSetChanged();
            }
        });
    }



}
