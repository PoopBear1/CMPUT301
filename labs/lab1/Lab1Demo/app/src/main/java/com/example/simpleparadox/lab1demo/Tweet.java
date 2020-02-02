package com.example.simpleparadox.lab1demo;

import java.util.Date;

abstract public class Tweet implements Tweetable{
    private Date date;
    private String message;

    Tweet(String message){
        if(message.length()>140){
            this.message = message.substring(0,140);
        }
        else{
            this.message = message;
        }
        date = new Date();
    }
    Tweet(Date date, String message){
        this.date = date;
        if(message.length()>140){
            this.message = message.substring(0,140);
        }
        else{
            this.message = message;
        }
    }

    public Date getDate(){
        return this.date;
    }

    public String getMessage(){
        return this.message;
    }

    void setDate(Date date){
        this.date = date;
    }
    void setMessage(String message){
        this.message = message;
    }

    public abstract Boolean isImportant();
}
