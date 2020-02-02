package com.example.simpleparadox.listycity;


import android.content.Context;
import android.widget.ArrayAdapter;
import java.util.ArrayList;


public class CustomList extends ArrayAdapter<City> {

    private  ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities){
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }
}