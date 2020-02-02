package com.example.simpleparadox.lab1demo;

import java.util.Date;

public class ImportantTweet extends Tweet {

    ImportantTweet(String message){
        super(message);
    }

    ImportantTweet(Date date, String message){
        super(date, message);
    }
    @Override
    public Boolean isImportant() {
        return true;
    }
}
