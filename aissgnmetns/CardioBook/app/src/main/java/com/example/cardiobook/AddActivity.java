package com.example.cardiobook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    EditText comments;
    EditText date;
    EditText time;
    EditText SystolicPressure;
    EditText HeartRate;
    EditText DiastolicPressure;

    String StringComment;
    String StringDate;
    String StringTime;
    String StringHearRate;
    String StringSystolicPressure;
    String StringDiastolicPressure;

    Integer IntSystolicPressure;
    Integer  IntDiastolicPressure;
    Integer IntHeartRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void Validate(View v){
        comments = findViewById(R.id.CommentText);
        StringComment = comments.getText().toString();

        date = findViewById(R.id.DateText);
        StringDate = date.getText().toString();

        time = findViewById(R.id.TimeText);
        StringTime = time.getText().toString();

        SystolicPressure = findViewById(R.id.systolic_pressureText);
        StringSystolicPressure = SystolicPressure.getText().toString();

        HeartRate = findViewById(R.id.heart_rateText);
        StringHearRate = HeartRate.getText().toString();

        DiastolicPressure = findViewById(R.id.diastolic_pressureText);
        StringDiastolicPressure = DiastolicPressure.getText().toString();

        if (StringTime.length() <= 0 || StringDate.length() <= 0 || StringSystolicPressure.length() <= 0 || StringHearRate.length() <= 0) {
            Toast.makeText(AddActivity.this,"Invalid inputs",Toast.LENGTH_SHORT).show();
            return;
        }


        IntSystolicPressure = Integer.parseInt(StringSystolicPressure);
        IntDiastolicPressure = Integer.parseInt(StringDiastolicPressure);
        IntHeartRate = Integer.parseInt(StringHearRate);

        if (90 > IntSystolicPressure || IntSystolicPressure > 140){
            SystolicPressure.setTextColor(Color.RED);
        }

        if (60 > IntDiastolicPressure || IntDiastolicPressure > 90){
            DiastolicPressure.setTextColor(Color.RED);
            System.out.println("Abnormal DiastolicPressure");
        }

        if (StringComment.length() > 20) {
            Toast.makeText(AddActivity.this,"Invalid comments",Toast.LENGTH_SHORT).show();
            return;
        }

//        System.out.println(StringDate);
//        System.out.println(StringTime);
//        System.out.println(StringComment);
//        System.out.println(IntSystolicPressure);
//        System.out.println(IntHeartRate);
//        System.out.println(IntDiastolicPressure);
//        System.out.println(StringDate);

        Measurement measurement = new Measurement(StringDate,StringTime,StringComment,IntSystolicPressure,IntHeartRate,IntDiastolicPressure);
        MainActivity.DataList.add(measurement);
        finish();

    }

}


