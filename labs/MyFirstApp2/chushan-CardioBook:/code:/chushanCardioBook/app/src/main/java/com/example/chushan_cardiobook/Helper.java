package com.example.chushan_cardiobook;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Helper extends ArrayAdapter<Measurement> {

    private ArrayList<Measurement> measurements;
    private Context context;

    public Helper(Context context,ArrayList<Measurement> measurements){

        super(context,0,measurements);
        this.measurements = measurements;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.history_layout,parent,false);
        }

        Measurement measurement = measurements.get(position);

        TextView dataDate = view.findViewById(R.id.HistoryDate);
        TextView timeDate = view.findViewById(R.id.HistoryTime);
        TextView SPDate = view.findViewById(R.id.HistorySP);
        TextView DPDate = view.findViewById(R.id.HistoryDP);
        TextView commentsDate = view.findViewById(R.id.HistoryComments);
        TextView heartrateDate = view.findViewById(R.id.HistoryHeartRate);

        Integer IntHR = measurement.getHeartRate();
        Integer IntDP = measurement.getDiastolicPressure();
        Integer IntSP = measurement.getSystolicPressure();


        if (90 > IntSP || IntSP > 140){
            SPDate.setTextColor(Color.RED);
        }

        if (60 > IntDP || IntDP > 90){
            DPDate.setTextColor(Color.RED);
        }

        dataDate.setText("Date: " + measurement.getDate());
        timeDate.setText("Time: " + measurement.getTime());
        SPDate.setText("SystolicPressure: "+ String.valueOf(IntSP));
        DPDate.setText("DiastolicPressure: "+ String.valueOf(IntDP));
        heartrateDate.setText("HeartRate: "+ String.valueOf(IntHR));
        commentsDate.setText("Comments: "+measurement.getComments());
        return view;

    }

}
