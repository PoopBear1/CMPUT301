package com.example.simpleparadox.lab1demo;

import java.util.Date;

public class NormalTweet extends Tweet {

    NormalTweet(String message){
        super(message);
    }

    NormalTweet(Date date, String message){
        super(date, message);
    }


    @Override
    public Boolean isImportant() {
        return false;
    }
}
