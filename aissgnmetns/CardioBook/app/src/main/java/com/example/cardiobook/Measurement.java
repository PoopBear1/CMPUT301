package com.example.cardiobook;

public class Measurement {
    public String date;
    public String time;
    public String comments;
    public Integer SystolicPressure;
    public Integer HeartRate;
    public Integer DiastolicPressure;

    Measurement(String date,String time,String comments,Integer SystolicPressure, Integer HeartRate,Integer DiastolicPressure){
        this.setDate(date);
        this.setTime(time);
        this.setComments(comments);
        this.setSystolicPressure(SystolicPressure);
        this.setHeartRate(HeartRate);
        this.setDiastolicPressure(DiastolicPressure);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getSystolicPressure() {
        return SystolicPressure;
    }

    public void setSystolicPressure(Integer systolicPressure) {
        SystolicPressure = systolicPressure;
    }

    public Integer getHeartRate() {
        return HeartRate;
    }

    public void setHeartRate(Integer heartRate) {
        HeartRate = heartRate;
    }

    public Integer getDiastolicPressure() {
        return DiastolicPressure;
    }

    public void setDiastolicPressure(Integer diastolicPressure) {
        DiastolicPressure = diastolicPressure;
    }
}
