package com.example.cardiobook;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

        if (StringTime.length() <= 0 || StringDate.length() <= 0 || StringSystolicPressure.length() <= 0 || StringHearRate.length() <= 0
                || StringDiastolicPressure.length() <= 0) {
            Toast.makeText(AddActivity.this,"Invalid inputs",Toast.LENGTH_SHORT).show();
            return;
        }


        String datePattern = "^([12]\\d{3}-([0][1-9][1][0-2])-([3][01]|[12]\\d|[0][1-9]))$";
        Pattern pattern1 = Pattern.compile(datePattern);
        Matcher matcher1 = pattern1.matcher(StringTime);


        String timePattern = "^(([2][0-3]|[01]\\d):([0-5]\\d))$";
        Pattern pattern2 = Pattern.compile(timePattern);
        Matcher matcher2 = pattern2.matcher(StringTime);

        if (matcher1.matches() == false || matcher2.matches() == false ){
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
        MainActivity.DataList.add(measurement);
        finish();

    }

}


