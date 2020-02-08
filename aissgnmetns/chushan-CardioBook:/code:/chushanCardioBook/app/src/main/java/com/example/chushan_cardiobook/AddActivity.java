package com.example.chushan_cardiobook;

import androidx.appcompat.app.AppCompatActivity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddActivity extends AppCompatActivity {


    Button delete;
    EditText comments;
    EditText date;
    EditText time;
    EditText SystolicPressure;
    EditText HeartRate;
    EditText DiastolicPressure;

    String activity;

    int index;

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

        activity = getIntent().getStringExtra("activity");

        if(activity != null && activity.equals("add")){
            delete =  findViewById(R.id.delete);
            delete.setVisibility(View.INVISIBLE);
        }

        if(activity != null && activity.equals("history")){
            index = getIntent().getIntExtra("index",0);
            editRecord();
        }
    }

    public void editRecord(){

        comments = findViewById(R.id.CommentText);
        date = findViewById(R.id.DateText);
        time = findViewById(R.id.TimeText);
        SystolicPressure = findViewById(R.id.systolic_pressureText);
        HeartRate = findViewById(R.id.heart_rateText);
        DiastolicPressure = findViewById(R.id.diastolic_pressureText);

        Measurement measurement = MainActivity.DataList.get(index);

        comments.setText(measurement.getComments());
        date.setText(measurement.getDate());
        time.setText(measurement.getTime());
        SystolicPressure.setText(String.valueOf(measurement.getSystolicPressure()));
        DiastolicPressure.setText(String.valueOf(measurement.getDiastolicPressure()));
        HeartRate.setText(String.valueOf(measurement.getHeartRate()));

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

        if (StringTime.length() <= 0 || StringDate.length() <= 0 || StringSystolicPressure.length() <= 0 || StringHearRate.length() <= 0
            || StringDiastolicPressure.length() <= 0) {
            Toast.makeText(AddActivity.this,"Invalid inputs",Toast.LENGTH_SHORT).show();
            return;
        }


        String datePattern = "^([12]\\d{3}-([0][1-9]|[1][0-2])-([3][01]|[12]\\d|[0][1-9]))$";
        Pattern pattern1 = Pattern.compile(datePattern);
        Matcher matcher1 = pattern1.matcher(StringDate);


        String timePattern = "^(([2][0-3]|[01]\\d):([0-5]\\d))$";
        Pattern pattern2 = Pattern.compile(timePattern);
        Matcher matcher2 = pattern2.matcher(StringTime);

        if ( matcher1.matches() == false  ||  matcher2.matches() ==false ){
            Toast.makeText(AddActivity.this,"Invalid format",Toast.LENGTH_SHORT).show();
            return;
        }

        IntSystolicPressure = Integer.parseInt(StringSystolicPressure);
        IntDiastolicPressure = Integer.parseInt(StringDiastolicPressure);
        IntHeartRate = Integer.parseInt(StringHearRate);

        if ( IntDiastolicPressure <= 0 || IntSystolicPressure <= 0 || IntHeartRate <= 0){

            Toast.makeText(AddActivity.this,"Cannot set value <= 0",Toast.LENGTH_SHORT).show();
            return;
        }

        if (StringComment.length() > 20) {
            Toast.makeText(AddActivity.this,"Invalid comments",Toast.LENGTH_SHORT).show();
            return;
        }

        Measurement measurement = new Measurement(StringDate,StringTime,StringComment,IntSystolicPressure,IntHeartRate,IntDiastolicPressure);
        if(activity.equals("history")){
            MainActivity.DataList.remove(index);
            MainActivity.DataList.add(index,measurement);
        }else{
            MainActivity.DataList.add(measurement);
        }

        saveData("measurement");
        finish();

    }

    public void saveData(String key){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(MainActivity.DataList);
        editor.putString(key,json);
        editor.apply();
    }

    public void deleteMeasurement(View v){
        MainActivity.DataList.remove(index);
        saveData("measurement");
        finish();
    }

}


